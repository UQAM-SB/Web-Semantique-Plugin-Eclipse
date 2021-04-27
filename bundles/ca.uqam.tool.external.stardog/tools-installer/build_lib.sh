#!/bin/bash 

###################################################################
# Script Name   :
# Description   :
# Args          : 
# Author       	: Michel Héon	
# Email         : heon.michel@uqam.ca
###################################################################
curl https://downloads.stardog.com/stardog/stardog-latest.zip --output stardog-latest.zip
cd ../tools
unzip ../tools-installer/stardog-latest.zip
find . -name '*.jar' -exec cp {} ./lib/ \;
