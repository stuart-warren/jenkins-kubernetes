# Jenkins Master in Docker

Run Jenkins 2.0 master in Docker with kubernetes plugin

## Build

``docker build -t stuartwarren/jenkins-kubernetes:latest .``

## Run

``docker run -ti -p 8080:8080 -p 50000:50000 -e 'GITHUB_USER=YOUR_USER' -e 'GITHUB_PASS=YOUR_PASSWORD' -e 'KUBEAPI_USER=YOURUSER' -e 'KUBEAPI_PASS=YOUR_PASS' stuartwarren/jenkins-kubernetes:latest``
