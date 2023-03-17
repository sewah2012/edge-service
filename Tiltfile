# Build
custom_build(
    # Name of the container image
    'catalog-service',

    # Command to build the container image
    'gradlew bootBuildImage',

    tag = 'latest',

    # Files to watch that trigger a new build
    deps = ['build.gradle', 'src']
)

# Deploy
#k8s_yaml(['k8s/deployment.yml', 'k8s/service.yml'])
k8s_yaml(kustomize('k8s')

# Manage
k8s_resource('edge-service', port_forwards=['8000'])
