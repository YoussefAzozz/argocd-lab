def call(String tokenCredId, String serverCredId, String manifestPath = 'k8s/deployment.yml') {
    withCredentials([
        string(credentialsId: tokenCredId, variable: 'TOKEN'),
        string(credentialsId: serverCredId, variable: 'SERVER')
    ]) {
        sh """
            kubectl apply -f ${manifestPath} --server="$SERVER" --token="$TOKEN" --insecure-skip-tls-verify=true
        """
    }
}
