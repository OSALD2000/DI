pipeline {
    agent any
    
    environment{
        NAME = 'OSAMA'
        LASTNAME = 'ALDALATI'
    }

    stages {
        stage('Checkout') {
            steps {
                sh 'echo This Pipeline is started by $NAME $LASTNAME'
                checkout scm
            }
        }
        stage('Clean') {
            steps {
                script {
                    withMaven(maven: 'maven') {
                        sh 'mvn clean'
                    }
                }
            }
        }
        stage('Build') {
            steps {
                script {
                    withMaven(maven: 'maven') {
                        sh 'mvn package'
                    }
                }
            }
        }
        stage('Test') {
            steps {
                echo 'No tests available'
            }
        }
        stage('Run') {
            steps {
                retry(4) {
                    script {
                        withMaven(maven: 'maven') {
                            sh 'mvn exec:java'
                        }
                    }
                }
            }
        }
    }
}
