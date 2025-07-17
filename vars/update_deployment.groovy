def call(String image_environment){
  unstash 'deployment-yml'
  sh '''
  sed -i "s|image:.*|image: '$DOCKER_IMAGE:${image_environment}${BUILD_NUMBER}'|g" k8s/deployment.yml
  cat k8s/deployment.yml
  '''
}
