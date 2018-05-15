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
            step {  
                input 'Deploy to Stage?'
            }
        }
    }
}