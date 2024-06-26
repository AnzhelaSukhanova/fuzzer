#!/bin/bash

run_jvm_compiler() {
	sleep 1m
	./gradlew JVMCompiler:run
}

send_request() {
	sleep 2m
	cd mutationRequests || exit
	curl -v -H "Content-Type: application/json" --data @test.json http://localhost:8888/mutation-problem
	cd ../
}

run_fuzzer() {
	./gradlew core:runCoordinator &
	run_jvm_compiler &
	send_request
}

kill_fuzzer() {
	# needs to be redone
	pkill -f /usr/lib/jvm/java-11-openjdk-amd64/bin/java
	pkill -f /usr/lib/jvm/java-21-openjdk-amd64/bin/java
}

run_fuzzer
sleep 2m
cd core || exit
echo
wc -l test.txt
cd ../
kill_fuzzer

