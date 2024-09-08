pipeline {
    agent any
    
    environment{
        NAME = 'OSAMA'
        LASTNAME = 'ALDALATI'
    }

    stages {
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
        
        stage('Clean') {
            steps {
                script {
                    withMaven(maven: 'maven') {
                        sh 'mvn clean'
                    }
                }
            }
        }
    }
}
