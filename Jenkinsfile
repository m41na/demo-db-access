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
                sh 'gradle -Partifactory_user=$artifactory_user -Partifactory_password=$artifactory_password clean build artifactoryPublish'
            }

            post {
                // If gradle was able to run the tests, even if some of the test
                // failed, record the test results and archive the jar file.
                success {
                    junit '**/build/test-results/test/TEST-*.xml'
                    archiveArtifacts 'build/libs/*.jar'
                }
            }
        }
    }
}
