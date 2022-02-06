pipeline {
  agent any
  tools { 
        maven 'Maven 3.8.4' 
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
                    script{
                        withSonarQubeEnv('SonarQube'){
                                sh "mvn clean verify sonar:sonar -Dsonar.projectKey=Springboot-hello"
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
