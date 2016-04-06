FROM jenkinsci/jenkins:2.0-beta-2

COPY version /usr/share/jenkins/ref/upgraded
COPY version /usr/share/jenkins/ref/.last_exec_version
COPY plugins.txt /usr/share/jenkins/plugins.txt
RUN /usr/local/bin/plugins.sh /usr/share/jenkins/plugins.txt
RUN curl -o /usr/share/jenkins/ref/plugins/kubernetes.hpi \
    https://jenkins.ci.cloudbees.com/job/plugins/job/kubernetes-plugin/130/org.csanchez.jenkins.plugins$kubernetes/artifact/org.csanchez.jenkins.plugins/kubernetes/0.6-SNAPSHOT/kubernetes-0.6-SNAPSHOT.hpi

# add files
COPY groovy/*.groovy /usr/share/jenkins/ref/init.groovy.d/
COPY workflow/vars/*.groovy /usr/share/jenkins/ref/workflow-libs/vars/

# ENV JAVA_OPTS="-Djava.util.logging.config.file=/var/jenkins_home/log.properties"
