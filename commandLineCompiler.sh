#!/bin/bash

kotlinc -language-version $1 \
	-jvm-target 1.8 \
	-opt-in kotlin.ExperimentalStdlibApi \
	-opt-in kotlin.ExperimentalStdlibApi \
	-nowarn \
	-no-stdlib \
	-no-reflect \
	$2 \
	$3 \
	$4
