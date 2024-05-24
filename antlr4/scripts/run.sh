#!/bin/bash

input="{1,2,3}"

current_dir=$(pwd)

project_root_dir="../.."

cd "$project_root_dir"

echo "$input" | ./gradlew :antlr4:runMain

cd "$current_dir"
