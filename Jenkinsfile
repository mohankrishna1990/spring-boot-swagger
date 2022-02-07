pipeline {
  agent any
  tools { 
        maven 'MAVEN_HOME' 
        jdk 'jdk11.0' 
    }
  		stages {
        	stage('Clone sources') {
              steps {
                     git branch: 'main',
                     credentialsId: 'Github-username-password',
                     url: 'https://github.com/mohankrishna1990/spring-boot-swagger.git'
                  }
                }
        	stage('SonarQube'){
            	steps {
                withSonarQubeEnv('SonarQube analysis'){
                      
                      bat "mvn clean verify sonar:sonar -Dsonar.projectKeyspring-boot-s=wagger -Dsonar.host.url=http://localhost:9000 -Dsonar.login=bc2cf0be1a013650fea424af7580f66801138e34"
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
