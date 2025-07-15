def call() {
    git branch: 'main', url: 'https://github.com/YoussefAzozz/jenkins_lab1.git'
    sh 'mvn test'
}
