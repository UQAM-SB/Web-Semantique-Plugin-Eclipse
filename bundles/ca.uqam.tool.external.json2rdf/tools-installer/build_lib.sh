#!/bin/bash 

###################################################################
# Script Name   : build_lib.sh
# Description   : Script de compilation des fichiers jar
# Args          : 
# Author       	: Michel Héon	
# Email         : heon.michel@uqam.ca
###################################################################
export JAVA_HOME=/opt/jdk-11.0.9
export PATH=$JAVA_HOME/bin:$NS_HOME/bin:$PATH
mvn clean package dependency:copy-dependencies -DskipTests