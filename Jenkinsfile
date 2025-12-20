pipeline {
    agent any

    tools {
        // We use the exact name found in Jenkins
        maven 'Maven_Home'
    }

    stages {
        stage('Checkout') {
            steps {
                checkout scm
            }
        }

        stage('Test Execution') {
            steps {
                bat 'mvn clean install'
            }
        }
    }

    post {
        always {
            allure includeProperties: false, jdk: '', results: [[path: 'target/allure-results']]
        }
    }
}