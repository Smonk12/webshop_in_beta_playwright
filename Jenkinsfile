pipeline {
    agent any

    tools {
        jdk 'JDK21'
        maven 'Maven3'
    }

    stages {
        stage('Checkout') {
            steps {
                git url: 'https://github.com/Smonk12/webshop_in_beta_playwright.git', branch: 'master'
            }
        }

        stage('Build') {
            steps {
                bat 'mvn clean compile'
            }
        }

        stage('Install Playwright Browsers') {
            steps {
                bat 'mvn exec:java -e -Dexec.mainClass=com.microsoft.playwright.CLI -Dexec.args="install"'
            }
        }

        stage('Run Tests') {
            steps {
                bat 'mvn test'
            }
        }
    }

    post {
        always {
            // Publish JUnit results
            junit 'target/surefire-reports/*.xml'

            echo 'Build finished!'
        }

        success {
            echo 'All tests passed!'
        }

        failure {
            echo 'Some tests failed!'
        }
    }
}
