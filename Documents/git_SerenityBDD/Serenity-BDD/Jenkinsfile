def version, mvnCmd = "mvn -s configuration/cicd-settings-nexus3.xml"
//def version, mvnCmd = "mvn"

pipeline {
  agent {
    label 'maven'
  }
  stages { 
    stage('Build App') {
      steps {
        sh "${mvnCmd} clean verify -DCucumber.options='--tags @regressiontest' serenity:aggregate -Dsaucelabs.target.platform=WINDOWS -Dwebdriver.driver=chrome -Dsaucelabs.url=http://karimuddinmd:f8191720-1b68-4c1c-ade1-8faf722f1968@ondemand.saucelabs.com:80/wd/hub -Dsaucelabs.access.key=f8191720-1b68-4c1c-ade1-8faf722f1968 -Dsaucelabs.user.id=karimuddinmd -Dmaven.test.failure.ignore=true"
      
      
        // publish html
        publishHTML target: [
            allowMissing: false,
            alwaysLinkToLastBuild: true,
            keepAll: true,
            reportDir: 'target/site/serenity/',
            reportFiles: 'index.html',
            reportName: 'TC HCI ODOS Report'
          ]
      
      
      }
    }
  }
}
