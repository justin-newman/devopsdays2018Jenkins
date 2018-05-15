#!groovy
def call() {
    sh 'echo Hello World'

    def VAR = "Something Else"
    echo "${VAR}"   // THIS IS ONLY IN GROOVY
}