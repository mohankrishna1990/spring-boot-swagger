pipeline {
  agent any
  tools { 
        maven 'Maven' 
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
                       sh "mvn clean verify sonar:sonar -Dsonar.projectKey=spring-boot-swagger -Dsonar.host.url=http://localhost:9000 -Dsonar.login=4ffa28adba2703a8e16152cbc3868836ebf6995d"
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
