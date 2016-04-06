#!groovy

import hudson.util.*;
import jenkins.model.*;
import jenkins.install.*;

j = Jenkins.getInstance()
uw = j.getInjector().getInstance(UpgradeWizard.class)
uw.setCurrentLevel(new VersionNumber("2.0"))
j.setInstallState(InstallState.INITIAL_SETUP_COMPLETED)
