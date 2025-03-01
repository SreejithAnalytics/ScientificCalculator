pipeline {
    agent any

    environment {
        
        GITHUB_REPO_URL = 'https://github.com/SreejithAnalytics/ScientificCalculator.git'

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

        stage('Push Docker Images') {
            steps {
                script{
                    withCredentials([usernamePassword(credentialsId:"DockerHub",passwordVariable:"dockerpass",usernameVariable:"dockerhubuser")])
                    {
                        sh "  docker login -u ${env.dockerhubuser} -p ${env.dockerpass} "
                        echo 'login successful'
                        sh "  docker tag spe-calc-mini-project ${env.dockerhubuser}/spe-calc-mini-project:latest"
                        sh "  docker push ${env.dockerhubuser}/spe-calc-mini-project:latest"
                    }
                
                 }
            }
        }
    }
}

