#!groovy

// dockerBuildEnv {
//     image = 'golang:1.5.0'
//     mainScript = '''
// go version
// go build -v hello-world.go
// '''
//     postScript = '''
// ls -l
// ./hello-world
// '''
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
	docker.image(config.image).inside {
	    sh config.mainScript
	}
	stage 'post'
	sh config.postScript
    }
}
