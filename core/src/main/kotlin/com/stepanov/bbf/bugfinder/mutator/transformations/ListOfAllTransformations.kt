package com.stepanov.bbf.bugfinder.mutator.transformations

import kotlin.reflect.KClass

object Constants {
    // TODO: all transformation classes should be here
    val allTransformations: List<KClass<out Transformation>> = listOf(
        AddArgumentToFunction::class,
//        AddBlockToExpression::class,
        AddBracketsToExpression::class,
//        AddCallableReference::class,
//        AddCasts::class,
//        AddDefaultValueToArg::class,
//        AddExpressionToLoop::class,
//        AddFunInvocations::class,
//        AddInheritance::class,
//        AddLabels::class,
//        AddLoop::class,
//        AddMethodToClass::class,
//        AddNotNullAssertions::class,
//        AddNullabilityTransformer::class,
//        AddPossibleModifiers::class,
//        AddPropertiesToClass::class,
//        AddRandomAnnotation::class,
//        AddRandomClass::class,
//        AddRandomComponent::class,
//        AddRandomControlStatements::class,
//        AddRandomDS::class,
//        AddRandomNode::class,
//        AddReificationToTypeParam::class,
//        AddSameFunctions::class,
//        AddTryExpression::class,
//        ChangeArgToAnotherValue::class,
//        ChangeConstants::class,
//        ChangeModifiers::class,
//        ChangeOperators::class,
//        ChangeOperatorsToFunInvocations::class,
//        ChangeRandomASTNodes::class,
//        ChangeRandomASTNodesFromAnotherTrees::class,
//        ChangeRandomLines::class,
//        ChangeReturnValueToConstant::class,
//        ChangeSmthToExtension::class,
//        ChangeTypes::class,
//        ChangeVarToNull::class,
//        ExpressionObfuscator::class,
//        ExpressionReplacer::class,
//        LocalTCE::class,
//        ReinitProperties::class,
//        RemoveRandomLines::class,
//        ReplaceDotExpression::class,
//        ShuffleFunctionArguments::class,
//        SkeletonEnumeration::class,
//        TCETransformation::class
    )
}
