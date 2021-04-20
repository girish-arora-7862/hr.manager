pipeline {
    agent any
    triggers { pollSCM('* * * * *')}
    stages {
        stage('Build') { 
            steps {
                git url:"https://github.com/girish-arora-7862/hr.manager.git", branch:"main"
                bat 'mvnw.cmd clean package' 
            }
        }
    }
}