pipeline{
    description("This is a test Jenkins Job")
    agent any
    stages {
        stage('checkout') {
            steps
            {
                scm
                {
                    git("https://github.com/OSALD2000/DI.git", "master")
                }
            }
        }
        stage('clean') {
            steps
            {
                maven
                {
                    mavenInstallation('maven')
                    goals("clean")
                }
            }
        }
        stage('build') {
            steps
            {
                maven
                {
                    mavenInstallation('maven')
                    goals("package")
                }
            }
        }
        stage('test') {
            steps {
                echo 'No Test avalible'
            }
        }
        stage('run') {
            retry(4)
            {
                steps
                {
                    maven
                    {
                        mavenInstallation('maven')
                        goals("exec:java")
                    }
                }
            }
        }
    }
}
