#!/bin/bash 

###################################################################
# Script Name   :
# Description   :
# Args          : yaml_fileName outDir
# Author       	: Michel Héon	
# Email         : heon.michel@uqam.ca
###################################################################

java -jar $PLUGIN_HOME/tools/lib/swagger-codegen-cli.jar generate -i $1 -l bash -o $2

