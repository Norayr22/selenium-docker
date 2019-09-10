#!/bin/sh
# Environment Variables
# HUB_HOST
# BROWSER
# MODULE
echo "Checking if hub is ready - $HUB_HOST"
while [[ "$( curl -s http://$HUB_HOST:4444/wd/hub/status | jq -r .value.ready )" != "true" ]];
do
    sleep 2
done
java -cp selenium-docker.jar:selenium-docker-tests.jar:libs/* \
    -DHUB_HOST=$HUB_HOST \
    -DBROWSER=$BROWSER \
    org.testng.TestNG $MODULE
