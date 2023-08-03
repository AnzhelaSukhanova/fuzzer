package com.stepanov.bbf.bugfinder.mutator.transformations

import com.stepanov.bbf.bugfinder.mutator.transformations.klib.*
import com.stepanov.bbf.bugfinder.server.messages.TransformationClass
import com.stepanov.bbf.util.WeightedList

object Constants {
    // TODO: all transformation classes should be here
    val allTransformations: WeightedList<TransformationClass> = WeightedList(listOf(
        AddDefaultValue::class to 100.0,
        RemoveDefaultValue::class to 100.0,
        AddImplToAbstract::class to 100.0,
        AddNewEntity::class to 150.0,
        AddAbstractFunction::class to 150.0,
        AddProperty::class to 100.0,
        AddValueParameter:: class to 100.0,
        AddValueParameterWithDefaultValue::class to 100.0,
//        ClassifierCompatibleTransformations::class to 100.0,
//        ClassifierIncompatibleChanges::class to 100.0,
//        FunctionCompatibleChanges::class to 100.0,
//        FunctionIncompatibleChanges::class to 100.0,
        MakeClassAbstract::class to 100.0,
        MakeEntityOpen::class to 100.0,
//        MakeVisibilityWeaker::class to 100.0,
//        MakeVisibilityStronger::class to 100.0,
//        PropertyCompatibleChanges::class to 100.0,
//        PropertyIncompatibleChanges::class to 100.0,
        AddImplementationOfMember::class to 100.0,
        RemoveDefaultImplementation::class to 100.0,
//        RemoveExistingEntity::class to 50.0,
        RemoveOpenModifier::class to 100.0,
//        RenameTypeParameter::class to 100.0,
        AddSupertype::class to 300.0,
//        RemoveSupertypes::class to 300.0,
    ).map { TransformationClass(it.first) to it.second })
//    val allTransformations: WeightedList<TransformationClass> = WeightedList(listOf(
//        AddArgumentToFunction::class to 100.0,
//        AddBlockToExpression::class to 150.0,
//        AddBracketsToExpression::class to 100.0,
////        AddCallableReference::class,
//        AddCasts::class to 100.0,
//        AddDefaultValueToArg::class to 100.0,
//        AddExpressionToLoop::class to 100.0,
//        AddFunInvocations::class to 100.0,
//        AddInheritance::class to 100.0,
//        AddLabels::class to 100.0,
//        AddLoop::class to 100.0,
//        AddMethodToClass::class to 100.0,
//        AddNotNullAssertions::class to 100.0,
//        AddNullabilityTransformer::class to 100.0,
//        AddPossibleModifiers::class to 100.0,
//        AddPropertiesToClass::class to 100.0,
//        AddRandomAnnotation::class to 100.0,
//        AddRandomClass::class to 100.0,
//        AddRandomComponent::class to 100.0,
//        AddRandomControlStatements::class to 30.0,
////        AddRandomDS::class,
////        AddRandomNode::class,
////        AddReificationToTypeParam::class,
////        AddSameFunctions::class,
////        AddTryExpression::class,
////        ChangeArgToAnotherValue::class,
//        ChangeConstants::class to 100.0,
////        ChangeModifiers::class,
//        ChangeOperators::class to 100.0,
////        ChangeOperatorsToFunInvocations::class,
//        ChangeRandomASTNodes::class to 100.0,
////        ChangeRandomASTNodesFromAnotherTrees::class,
////        ChangeRandomLines::class,
////        ChangeReturnValueToConstant::class,
////        ChangeSmthToExtension::class,
////        ChangeTypes::class,
////        ChangeVarToNull::class,
////        ExpressionObfuscator::class,
//        ExpressionReplacer::class to 100.0,
//        FilePartitionRandomDivision::class to 300.0,
//        LocalTCE::class to 300.0,
////        ReinitProperties::class,
////        RemoveRandomLines::class,
////        ReplaceDotExpression::class,
////        ShuffleFunctionArguments::class,
////        SkeletonEnumeration::class,
////        TCETransformation::class
//    ).map { TransformationClass(it.first) to it.second })
}
