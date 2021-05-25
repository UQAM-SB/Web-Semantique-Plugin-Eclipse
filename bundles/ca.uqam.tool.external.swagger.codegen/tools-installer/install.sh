#!/bin/bash 

###################################################################
# Script Name   : install.sh
# Description   : Ce script importe - extrait - et installe les 
#                : libraries dans Swagger dans tools/lib
# Args          : 
# Author       	: Michel Héon	
# Email         : heon.michel@uqam.ca
###################################################################

SCRIPT_DIR="$( cd "$( dirname "${BASH_SOURCE[0]}" )" &> /dev/null && pwd )"
PLUGIN_HOME=$(cd ../ ; pwd)
cd $PLUGIN_HOME/archive
wget https://github.com/swagger-api/swagger-codegen/archive/refs/heads/master.zip
unzip -q master.zip
cd swagger-codegen-master/
mvn -T1.5C clean package -DskipTests=true
# mvn dependency:copy-dependencies -DoutputDirectory=$PLUGIN_HOME/tools/lib
cp modules/swagger-codegen-cli/target/swagger-codegen-cli.jar $PLUGIN_HOME/tools/lib
cp -r samples $PLUGIN_HOME/tools/