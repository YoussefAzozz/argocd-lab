def call() {
    stash name: 'deployment-yml', includes: 'k8s/deployment.yml'
}
