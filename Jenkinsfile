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

          stage('SAST') {
            steps {
                script {
                    bat "mvn clean verify sonar:sonar -Dsonar.projectKey=test -Dsonar.host.url=http://localhost:9000 -Dsonar.login=sqp_75118c225eb2bc05608c357d5042c555b936cb0b"
                }

            }
          }

          

          stage('Build Image') {
            steps {
                bat 'mvn clean package'
                script {
                    def image = docker.build('neocode1/demo-service')
                }
            }
          }

          stage('push Image to dockerhub') {
            steps {
                bat 'docker push neocode1/demo-service'
            }
          }

          stage('Deploy Service') {
            steps {
                bat 'kubectl rollout restart deployment demo-service -n app'
            }
          }
     }

     post {
        always {
            cleanWs()
        }
     }

}