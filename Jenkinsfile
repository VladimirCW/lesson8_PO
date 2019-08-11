pipeline {
    node {
       stage('Preparation') {
           git 'https://github.com/VladimirCW/lesson8_PO.git'
       }
       stage('Unit tests') {
           bat(/mvn clean -DsuiteXml=unit.xml test/)
       }
       stage('UI test') {
           bat(/mvn clean -DsuiteXml=testng.xml test/)
       }
    }
}