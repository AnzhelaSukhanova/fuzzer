#!/bin/bash

run_jvm_compiler() {
	sleep 1m
	./gradlew JVMCompiler:run
}

send_request() {
	sleep 2m
	cd mutationRequests
	curl -v -H "Content-Type: application/json" --data @jvmAllRegressions.json http://localhost:8888/mutation-problem
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
full_data=$(date '+%Y-%m-%d-%H-%M-%S')
dir="core/tmp/results/run-$full_data"
mkdir "$dir"

while true
do
	sleep 1h
	cur_time_s=$(date +%s)
	last_update_time_s=$(stat core/logs/coordinator.log -c %Y)
	time_from_last_update_s=$((cur_time_s-last_update_time_s))

	if [ $time_from_last_update_s -ge 1800 ]; then
		subdir="$dir/JVM-$full_data"
		mkdir "$subdir"
		cp -r core/logs "$subdir"/logs
		cp core/seedWeightsDump.txt "$subdir"/logs/
		if [ -n "$(ls -A "core/tmp/results/curBugs")" ]; then
			mv core/tmp/results/curBugs/* "$subdir"
		fi
		kill_fuzzer
		sleep 1m
		run_fuzzer
		full_data=$(date '+%Y-%m-%d-%H-%M-%S')
	fi
done

