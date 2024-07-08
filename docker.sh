#!/bin/bash

dir=$(date '+%Y-%m-%d-%H-%M-%S')
mkdir $dir $dir/workdir $dir/logs

sudo docker build . -t fuzzer \
	--progress=plain
	#--build-arg REQUEST=test.json
	
sudo docker run \
	--volume "$PWD/$dir/workdir":/root/fuzzer/core/tmp/results \
	--volume "$PWD/$dir/logs":/root/fuzzer/core/logs \
	fuzzer
