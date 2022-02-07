pipeline {
  agent any
  tools { 
        maven 'MAVEN_HOME' 
        jdk 'jdk8' 
    }
  		stages {
        	stage('Clone sources') {
              steps {
                     git branch: 'main',
                     credentialsId: 'Github-username-password',
                     url: 'https://github.com/mohankrishna1990/spring-boot-swagger.git'
                  }
                }
        	stage('SonarQube analysis'){
            	steps {
                withSonarQubeEnv('SonarQube'){
                      script{
                       sh "mvn clean verify sonar:sonar -Dsonar.projectKey=spring-boot-swagger -Dsonar.host.url=http://localhost:9000 -Dsonar.login=8636a742d3ecbc9747361cf3c3efa40f1d7df961"
                    }
                }
            }
          }
            stage("Quality gate") {
                steps {
                    waitForQualityGate abortPipeline: true
                      }
                    }
                }
            }
