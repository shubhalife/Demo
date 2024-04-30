pipeline {
     agent any
         tools {
             maven 'maven_home'
         }
         //each branch has 1 job running at a time
             options {
                 disableConcurrentBuilds()
             }
     stages {
          stage("Hello") {
               steps {
                    echo 'Hello World!!!!!!'
               }
          }
          stage('Compile') {
            steps {
                script {
                    bat 'mvn  compile '
                }
            }
          }

          stage('Unit Testing') {
            steps {
                script {
                    bat "mvn clean test"
                }

            }
          }

          stage('Build Images') {
            steps {
                bat 'mvn clean package'
                script {
                    def image = docker.build('neocode1/demo-service')
                }
            }
          }
     }

     post {
        always {
            cleanWs()
        }
     }

}