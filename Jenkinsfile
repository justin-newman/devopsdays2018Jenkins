@Library('shared-library') __

pipeline {
    agent none
    environment {
        NODE_VER = '8.1.0'
    }
    stages {
        stage('Hello World') { agent any
        environment {
            DEPLOY_VERSION = 'Stage'
        }
            steps {
                echo "${env.DEPLOY_VERSION}"
                echo "hello world"
            }

        }
        stage('Who Am I?') { agent any
        environment {
            DEPLOY_VERSION = 'Prod'
        }
            steps {
                echo "${env.DEPLOY_VERSION}"
                sh 'host -t TXT pgp.michaelholley.us |awk -F \'"\' \'{print $2}\''
            }
        }
        stage('Deploy to stage?') { agent none
            when {
                anyOf {
                    branch 'stage'
                    environment name: 'NODE_VER', value: '8.1.0'
                }
            }

            steps {  
                input 'Deploy to Stage?'
            }
        }

        stage('Parallel') {
            failFast true
            parallel {
                stage('Build 1') { agent any
                    steps{
                        echo "Build 1"
                        hello()
                    }
                }

                stage('Build 2') { agent any
                    steps{
                        echo "Build 2"
                    }
                }
            }
        }
    }
}