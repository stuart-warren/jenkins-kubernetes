#!groovy

// buildDockerfile {
//     image = 'myimage:latest'
//     path = '.'
//     push = true
// }

def call(body) {
    def config = [:]
    body.resolveStrategy = Closure.DELEGATE_FIRST
    body.delegate = config
    body()
    stage 'checkout'
    node('docker') {
    	checkout scm
	stage 'main'
	def img = docker.build(config.image, config.path)
	if (config.push && config.push==true) {
	    img.push()
	}
    }
}
