pipeline {
    agent any

    environment {
        
        GITHUB_REPO_URL = 'https://github.com/jainishParmar/spe-mini-project.git'

    }

     stages {
        stage('Checkout') {
            steps {
                script {
                    git branch: 'main', url: "${GITHUB_REPO_URL}"
                }
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

