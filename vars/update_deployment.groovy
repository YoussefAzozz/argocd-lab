def(){
  unstash 'deployment-yml'
  sh '''
  sed -i "s|image:.*|image: '$DOCKER_IMAGE:${BUILD_NUMBER}'|g" k8s/deployment.yml
  cat k8s/deployment.yml
  '''
}
