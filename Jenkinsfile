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
                step([$class: 'Publisher', reportFilenamePattern: '**/testng-results.xml'])
            }
          }

          stage('Build Images') {
            steps {
                bat 'mvn clean package'
                script {
                    def image = docker.build('demo-service')
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