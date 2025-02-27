pipeline {
    agent any

    stages {
        stage('Clone Repository') {
            steps {
                git 'https://github.com/SreejithAnalytics/ScientificCalculator.git'
            }
        }

        stage('Build') {
            steps {
                sh 'mvn compile'
            }
        }

        stage('Test') {
            steps {
                sh 'mvn test'
            }
        }

        stage('Docker Build & Push') {
            when {
                expression { currentBuild.resultIsBetterOrEqualTo('SUCCESS') } // Runs only if tests pass
            }
            steps {
                sh 'docker build -t your-dockerhub-username/scientific-calculator .'
                sh 'docker push your-dockerhub-username/scientific-calculator'
            }
        }
    }
}

