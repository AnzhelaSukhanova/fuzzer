package com.stepanov.bbf.reduktor.parser

import com.intellij.lang.java.JavaLanguage
import com.intellij.openapi.extensions.ExtensionPoint
import com.intellij.openapi.extensions.Extensions
import com.intellij.openapi.project.Project
import com.intellij.psi.PsiFile
import com.intellij.psi.PsiFileFactory
import com.intellij.psi.impl.source.tree.TreeCopyHandler
import com.stepanov.bbf.bugfinder.executor.CompilerArgs
import com.stepanov.bbf.bugfinder.mutator.transformations.Factory
import com.stepanov.bbf.kootstrap.FooBarCompiler.setupMyCfg
import com.stepanov.bbf.kootstrap.FooBarCompiler.setupMyEnv
import com.stepanov.bbf.kootstrap.util.opt
import org.jetbrains.kotlin.analyzer.AnalysisResult
import org.jetbrains.kotlin.cli.common.config.addKotlinSourceRoots
import org.jetbrains.kotlin.cli.jvm.compiler.*
import org.jetbrains.kotlin.cli.jvm.config.addJavaSourceRoots
import org.jetbrains.kotlin.cli.jvm.config.addJvmClasspathRoots
import org.jetbrains.kotlin.config.CommonConfigurationKeys
import org.jetbrains.kotlin.config.CompilerConfiguration
import org.jetbrains.kotlin.config.JVMConfigurationKeys
import org.jetbrains.kotlin.psi.KtFile
import org.jetbrains.kotlin.psi.KtPsiFactory
import org.jetbrains.kotlin.resolve.BindingContext
import org.jetbrains.kotlin.resolve.lazy.JvmResolveUtil
import java.io.File


@Suppress("DEPRECATION")
object PSICreator {

    private var targetFiles: List<KtFile> = listOf()
    private lateinit var cfg: CompilerConfiguration
    private lateinit var env: KotlinCoreEnvironment
    var curProject: com.stepanov.bbf.bugfinder.executor.project.Project? = null

    fun getPsiForJava(text: String, proj: Project = Factory.file.project) =
        PsiFileFactory.getInstance(proj).createFileFromText(JavaLanguage.INSTANCE, text)

    fun getPSIForText(text: String, generateCtx: Boolean = true): KtFile {
        //Save to tmp
        val path = "tmp/tmp.kt"
        File(path).writeText(text)
        return getPSIForFile(path)
    }

    fun getPsiForTextWithName(text: String, fileName: String): KtFile {
        val path = "tmp/$fileName"
        File(path).writeText(text)
        return getPSIForFile(path)
    }

    fun getPSIForFile(path: String): KtFile {
        val newArgs = arrayOf("-t", path)

        val cmd = opt.parse(newArgs)

        cfg = setupMyCfg(cmd)
        env = setupMyEnv(cfg)

        if (!Extensions.getRootArea().hasExtensionPoint(TreeCopyHandler.EP_NAME.name)) {
            Extensions.getRootArea().registerExtensionPoint(
                TreeCopyHandler.EP_NAME.name,
                TreeCopyHandler::class.java.canonicalName,
                ExtensionPoint.Kind.INTERFACE
            )
        }

        targetFiles = env.getSourceFiles().map {
            val f = KtPsiFactory(it).createFile(it.virtualFile.path, it.text)
            f.originalFile = it
            f
        }

        return targetFiles.first()
    }

    fun analyze(psiFile: PsiFile): BindingContext? = analyze(psiFile, curProject)

    fun analyzeAndGetModuleDescriptor(psiFile: PsiFile) = getAnalysisResult(psiFile, curProject)?.moduleDescriptor

    fun analyze(psiFile: PsiFile, project: com.stepanov.bbf.bugfinder.executor.project.Project?): BindingContext? =
        getAnalysisResult(psiFile, project)?.bindingContext

    private fun getAnalysisResult(
        psiFile: PsiFile,
        project: com.stepanov.bbf.bugfinder.executor.project.Project?
    ): AnalysisResult? {
        //if (psiFile !is KtFile) return null
        project?.saveOrRemoveToTmp(true)
        val cmd = opt.parse(arrayOf())
        val cfg = setupMyCfg(cmd)

        cfg.put(JVMConfigurationKeys.INCLUDE_RUNTIME, true)
        cfg.put(JVMConfigurationKeys.JDK_HOME, File(System.getProperty("java.home")))
        cfg.addJvmClasspathRoots(
            listOf(
                CompilerArgs.getStdLibPath("kotlin-test"),
                CompilerArgs.getStdLibPath("kotlin-test-common"),
                CompilerArgs.getStdLibPath("kotlin-test-annotations-common"),
                //CompilerArgs.getStdLibPath("kotlin-test-junit"),
                CompilerArgs.getStdLibPath("kotlin-reflect"),
                CompilerArgs.getStdLibPath("kotlin-stdlib-common"),
                CompilerArgs.getStdLibPath("kotlin-stdlib"),
                CompilerArgs.getStdLibPath("kotlin-stdlib-jdk8")
            ).map { File(it) }
        )

        project?.files?.map { it.name }?.let { fileNames ->
            val kotlinSources = fileNames.filter { it.endsWith(".kt") }
            val javaSources = fileNames.filter { it.endsWith(".java") }
            cfg.addJavaSourceRoots(javaSources.map { File(it) })
            cfg.addKotlinSourceRoots(kotlinSources)
        }

        val env = setupMyEnv(cfg)
        val configuration = env.configuration.copy()
        configuration.put(CommonConfigurationKeys.MODULE_NAME, "root")
        return try {
            if (psiFile is KtFile) {
                JvmResolveUtil.analyze(listOf(psiFile), env, configuration)
            } else {
                JvmResolveUtil.analyze(env)
            }
        } catch (e: Exception) {
            e.printStackTrace()
//            println(e)
            null
        } catch (e: Error) {
            null
        } finally {
            //project?.saveOrRemoveToTmp(false)
        }
    }
}