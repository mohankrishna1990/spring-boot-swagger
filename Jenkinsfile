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
                      
                      bat "mvn clean verify sonar:sonar -Dsonar.projectKey=spring-boot-swagger -Dsonar.host.url=http://localhost:9000 -Dsonar.login=ff3028be64aabde773654012f17e33ed0eb620c0"
                }
              }
             }
            }
           }
