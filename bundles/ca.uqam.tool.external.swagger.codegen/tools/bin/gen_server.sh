#!/bin/bash 

###################################################################
# Script Name   :
# Description   :
# Args          : yaml_fileName outDir
# Author       	: Michel Héon	
# Email         : heon.michel@uqam.ca
# Example usage : gen_server.sh resource/vivo-proxy.yaml server-src
###################################################################

java -jar $PLUGIN_HOME/tools/lib/swagger-codegen-cli.jar generate -i $1 -l jaxrs -o $2

