pipeline{
  agent any
    environment{
  notifyEmail = "abhishekpancholi22@gmail.com"
}
  tools{
    maven 'maven_home'
  }
  triggers{
    cron('0 06 * * *')
  }
  stages{
    stage("code checkout"){
      steps{
        bat "echo helloo"
      }
    }
    stage("code build"){
      steps{
        bat "mvn clean"
      }
    }
    stage("unit test"){
      steps{
        bat "mvn test"
      }
    }
}
post{
  success{
    bat "echo success"
    }
  }
}
