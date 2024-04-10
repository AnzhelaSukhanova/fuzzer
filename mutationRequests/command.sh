#!/bin/bash

curl  -v -H "Content-Type: application/json" --data @jvmAllRandom.json http://localhost:8888/mutation-problem
