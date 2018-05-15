pipeline {
    agent none
    stages {
        stage('Hello World') { agent any
            steps {
                echo "hello world"
            }

        }
        stage('Who Am I?') { agent any
            steps {
                sh 'host -t TXT pgp.michaelholley.us |awk -F \'"\' \'{print $2}\''
            }
        }
    }
}