pipeline {
    agent any

    tools {
        // Install the gradle version configured as "gradle" and add it to the path.
        gradle "gradle"
    }

    environment {
        artifactory_user     = credentials('artifactory_user')
        artifactory_password = credentials('artifactory_password')
    }

    stages {
        stage('Build') {
            steps {
                // Get some code from a GitHub repository
                git 'https://github.com/m41na/demo-db-access.git'
                // Run gradle on a Unix agent.
                sh "gradle clean build"
            }

            post {
                // If gradle was able to run the tests, even if some of the test
                // failed, record the test results and archive the jar file.
                success {
                    junit '**/build/libs/surefire-reports/TEST-*.xml'
                    archiveArtifacts 'build/libs/*.jar'
                }
            }
        }
    }
}
