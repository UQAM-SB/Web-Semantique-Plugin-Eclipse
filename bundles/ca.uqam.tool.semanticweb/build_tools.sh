#!/bin/bash 

###################################################################
# Script Name   : build_tools.sh
# Description   : Script de création du répertoire tools à
# 				: partir des plugins du bundle
# Args          : 
# Author       	: Michel Héon	
# Email         : heon.michel@uqam.ca
###################################################################

cp -r ../ca.uqam.semanticweb.external.jena/tools .
cp -r ../ca.uqam.semanticweb.external.owlapi/tools .
cp -r ../ca.uqam.semanticweb.external.json2rdf/tools .

