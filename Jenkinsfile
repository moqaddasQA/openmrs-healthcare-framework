pipeline {
    agent any

    // BEST PRACTICE: Define the trigger in code, not the UI.
    // This tells Jenkins to check GitHub every 2 minutes.
    triggers {
        pollSCM 'H/2 * * * *'
    }

    tools {
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
                // Windows uses 'bat', Mac/Linux uses 'sh'
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