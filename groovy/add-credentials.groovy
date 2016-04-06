#!groovy

import jenkins.model.*
import com.cloudbees.plugins.credentials.*
import com.cloudbees.plugins.credentials.common.*
import com.cloudbees.plugins.credentials.domains.*
import com.cloudbees.plugins.credentials.impl.*

def env = System.getenv()
domain = Domain.global()
store = Jenkins.instance.getExtensionList('com.cloudbees.plugins.credentials.SystemCredentialsProvider')[0].getStore()

github = new UsernamePasswordCredentialsImpl(
  CredentialsScope.GLOBAL,
  "jenkins-slave-password", "Github",
  env["GITHUB_USER"],
  env["GITHUB_PASS"]
)

kubeapi = new UsernamePasswordCredentialsImpl(
  CredentialsScope.GLOBAL,
  "jenkins-slave-password", "KubeApi",
  env["KUBEAPI_USER"],
  env["KUBEAPI_PASS"]
)

store.addCredentials(domain, github)
store.addCredentials(domain, kubeapi)
