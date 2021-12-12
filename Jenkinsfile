pipeline {
    agent any

    tools {
        // Install the Maven version configured as "M3" and add it to the path.
        maven "M3"
    }
    parameters {
        gitParameter branchFilter: 'origin/(.*)', defaultValue: 'master', name: 'BRANCH', type:
        'PT_BRANCH'
    }

    stages {
        stage('Build') {
            steps {
                // Get some code from a GitHub repository
                git branch: "${params.BRANCH}", url: 'https://github.com/Agiswest/TestRail'

                // Run Maven on a Unix agent.
                sh "mvn clean test"

                // To run Maven on a Windows agent, use
                // bat "mvn clean test -Dheadless=${HEADLESS}"
            }

            post {
                success {
                    junit '**/target/surefire-reports/TEST-*.xml'
                }
                always {
                    script {
                        allure([
                                includeProperties: false,
                                jdk: '',
                                properties: [],
                                reportBuildPolicy: 'ALWAYS',
                                results: [[path: 'target/allure-results']]
                        ])
                    }
                }
            }
        }
    }
}