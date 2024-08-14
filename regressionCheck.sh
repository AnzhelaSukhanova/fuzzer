#!/bin/bash

version="1.8.0"
destination="${HOME}fuzzer/JVMCompiler/projectTmp/test/"
classpath=$(head -n 1 ${HOME}fuzzer/classpath.txt)

echo $version > ${HOME}fuzzer/1.txt

for filename in ${HOME}fuzzer/core/tmp/arrays/test/*.kt; do
    sh commandLineCompilerWithoutArgs.sh $version $filename
    echo $? $filename >> ${HOME}fuzzer/1.txt
    
    sh commandLineCompiler.sh $version "-d $destination" "-cp $classpath" $filename
    echo $? $filename "\n" >> ${HOME}fuzzer/1.txt
done


