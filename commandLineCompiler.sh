#!/bin/bash

kotlinc -language-version $1 -jvm-target 1.8 -opt-in kotlin.ExperimentalStdlibApi -opt-in kotlin.ExperimentalStdlibApi -nowarn $2 $3
