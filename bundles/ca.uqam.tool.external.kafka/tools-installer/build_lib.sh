#!/bin/bash 

###################################################################
# Script Name   :
# Description   :
# Args          : 
# Author       	: Michel Héon	
# Email         : heon.michel@uqam.ca
###################################################################
cd ../tools
./gradlew jar -PscalaVersion=2.13.5
mkdir libs
find . -name '*.jar' -exec cp {} ./libs/ \;
