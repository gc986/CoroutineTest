#!/bin/bash

mvn clean install

echo -en "\033[1;36m"
echo ""
echo "----=== try to RUN application..."
echo "build and run spark web server. port 9869"

echo -en "\e[0m\e[K"

java -jar target/Hellohabrahabr-1.0-SNAPSHOT-jar-with-dependencies.jar 9869