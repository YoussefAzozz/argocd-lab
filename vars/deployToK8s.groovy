def call(String tokenCredId, String serverCredId, String manifestPath = 'k8s/deployment.yml', String namespace) {
    withCredentials([
        string(credentialsId: tokenCredId, variable: 'TOKEN'),
        string(credentialsId: serverCredId, variable: 'SERVER')
    ]) {
        sh """
            kubectl apply -f ${manifestPath} --server="$SERVER" --token="$TOKEN" --namespace ${namespace} --insecure-skip-tls-verify=true
        """
    }
}
