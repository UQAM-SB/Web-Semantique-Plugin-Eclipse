#!/bin/bash 

###################################################################
# Script Name   :
# Description   :
# Args          : 
# Author       	: Michel Héon	
# Email         : heon.michel@uqam.ca
###################################################################
SCRIPT_DIR="$( cd "$( dirname "${BASH_SOURCE[0]}" )" &> /dev/null && pwd )"
export PLUGIN_HOME=$(cd $SCRIPT_DIR/../../ ; pwd)
export PATH=$PLUGIN_HOME/tools/bin:$PATH
