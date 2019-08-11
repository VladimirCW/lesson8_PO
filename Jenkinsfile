pipeline {
    agent any

    stages{
        stage('Preparation') {
            steps {
                git 'https://github.com/VladimirCW/lesson8_PO.git'
            }
        }
        stage('Unit tests') {
            steps{
                bat 'mvn clean -DsuiteXml=unit.xml test'
            }
        }
        stage('UI tests') {
            steps{
                bat 'mvn clean -DsuiteXml=testng.xml test'
            }
        }
    }
    //node {
    //   stage('Preparation') {
    //       git 'https://github.com/VladimirCW/lesson8_PO.git'
    //   }
    //   stage('Unit tests') {
    //       bat(/mvn clean -DsuiteXml=unit.xml test/)
    //   }
    //   stage('UI test') {
    //       bat(/mvn clean -DsuiteXml=testng.xml test/)
    //   }
    //}
}