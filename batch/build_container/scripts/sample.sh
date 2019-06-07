#!/bin/bash

source ~/.bashrc

DATETIME=`date +"%Y-%m-%d-%I-%M-%S"`

APPLOG_FILENAME=/logs/app-$DATETIME.log
ERRORLOG_FILENAME=/logs/app-error-$DATETIME.log

touch $APPLOG_FILENAME
touch $ERRORLOG_FILENAME

java -jar /user/local/sample-spring-batch/batch/target/batch-0.0.1-SNAPSHOT.jar 1>> $APPLOG_FILENAME 2>> $ERRORLOG_FILENAME