pipeline {
    agent none
    environment {
        NODE_VER = '8.1.0'
    }
    stages {
        stage('Hello World') { agent any
        environment {
            NEW_VAR = 'Howdy'
        }
            steps {
                echo "hello world"
                echo "${env.NEW_VAR}"
            }

        }
        stage('Who Am I?') { agent any
            steps {
                echo "${env.NEW_VAR}"
                sh 'host -t TXT pgp.michaelholley.us |awk -F \'"\' \'{print $2}\''
            }
        }
    }
}