#!/bin/bash 

###################################################################
# Script Name   : build_lib.sh
# Description   : Script de compilation des fichiers jar de l'OWlAPI
#               : Java 8 et Maven doivent être installés
# Args          : 
# Author       	: Michel Héon	
# Email         : heon.michel@uqam.ca
###################################################################

mvn -T1.5C clean install -DskipTests
