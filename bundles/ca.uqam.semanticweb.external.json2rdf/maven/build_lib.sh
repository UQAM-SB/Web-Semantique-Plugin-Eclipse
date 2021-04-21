#!/bin/bash 

###################################################################
# Script Name   : build_lib.sh
# Description   : Script de compilation des fichiers jar de Jena
#               : Java 8 et Maven doivent être installés
# Args          : 
# Author       	: Michel Héon	
# Email         : heon.michel@uqam.ca
###################################################################

 mvn clean package dependency:copy-dependencies -DskipTests