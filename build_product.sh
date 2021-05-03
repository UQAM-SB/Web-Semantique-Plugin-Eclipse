#!/bin/bash 

###################################################################
# Script Name   : build_lib.sh
# Description   : Script de compilation des fichiers jar de l'OWlAPI
#               : Java 8 et Maven doivent être installés
# Args          : 
# Author       	: Michel Héon	
# Email         : heon.michel@uqam.ca
###################################################################

export JAVA_HOME=/opt/jdk-11.0.9
export NS_HOME=/opt/node-v14.15.0-linux-x64
export PATH=$JAVA_HOME/bin:$NS_HOME/bin:$PATH

# (cd bundles/ca.uqam.semanticweb.external.jena/maven/ ; ./build_lib.sh)
# (cd bundles/ca.uqam.semanticweb.external.owlapi/maven/ ; ./build_lib.sh)
# (cd bundles/ca.uqam.semanticweb.external.json2rdf/maven/ ; ./build_lib.sh)
# (cd bundles/ca.uqam.semanticweb.external.tomcat/maven/ ; ./build_lib.sh)
# (cd bundles/ca.uqam.semanticweb.external.tools ; ./build_tools.sh)
mvn -T1.5C clean verify  -DskipTests
