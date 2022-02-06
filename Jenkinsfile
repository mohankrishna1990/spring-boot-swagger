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
                    script{
                       sh "mvn clean verify sonar:sonar -Dsonar.projectKey=spring-boot-swagger -Dsonar.host.url=http://localhost:9000 -Dsonar.login=34f972b80e1014f2199d4afb8be72558c522b002"
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
