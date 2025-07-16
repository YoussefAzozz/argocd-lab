def call(String imageName, String credentialsId) {
    withCredentials([usernamePassword(credentialsId: credentialsId, usernameVariable: 'DOCKER_USER', passwordVariable: 'DOCKER_PASS')]) {
        sh """
            docker build -t ${imageName}:${BUILD_NUMBER} .
            trivy clean --java-db
            trivy image --timeout 10m --exit-code 1 --severity CRITICAL,HIGH ${imageName}:${BUILD_NUMBER}
            echo "$DOCKER_PASS" | docker login -u "$DOCKER_USER" --password-stdin
            docker push ${imageName}:${BUILD_NUMBER}
        """
    }
}
