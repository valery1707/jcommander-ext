### Code coverage

`mvn clean test jacoco:report`

### Deploy to Maven Central

1. [Read rules](http://central.sonatype.org/pages/apache-maven.html)
1. [Register](https://issues.sonatype.org/login.jsp) on Sonatype OSSRH
1. Provide project details for Sonatype OSSRH
  1. [Create tiket for project](https://issues.sonatype.org/secure/CreateIssue.jspa?issuetype=21&pid=10134)
    * `Summary`: I want to publish artifact of my project to Maven Central
    * `Description`: I own domain `valery1707.name`
    * `Group ID`: name.valery1707
    * `Project URL`: https://github.com/valery1707/jcommander-ext
    * `SCM URL`: https://github.com/valery1707/jcommander-ext.git
    * `Already Synced to Central`: `No`
  1. Wait for ticket resolution
1. Add credentials for Sonatype OSSRH into maven
  1. Detect maven HOME: `mvn --version | grep 'Maven home'`
  1. Edit `conf/setting.xml` from maven home
  1. Inside `servers` add new `server`
    * `id`: `ossrh`
    * `username`: your-jira-id
    * `password`: your-jira-pwd
1. Install GPG
  1. Check sign: `mvn clean package verify -P release -Dgpg.passphrase=real-gpg-passphrase`
1. Commit and deploy artifact to Sonatype OSSRH
  1. `mvn versions:set -DnewVersion=0.1.0`
  1. `git commit -m 'Release version 0.1.0' pom.xml */pom.xml`
  1. `mvn clean deploy -P release -Dgpg.passphrase=real-gpg-passphrase`
  1. `mvn versions:set -DnewVersion=0.1.0-SNAPSHOT`
  1. `git commit -m 'Prepare for next development iteration' pom.xml */pom.xml`
1. Promote artifacts to Maven Central
  1. Login into [Sonatype OSSRH](https://oss.sonatype.org/)
  1. Find staging repository with name `namevalery1707-`
  1. `Close` it
  1. Wait some time, refresh page
  1. `Release`
  1. After some time (about 10 minutes) artifact will be published into Maven Cenral
  1. After more time (about 2 hours) new release will be accessible on [search](http://search.maven.org/)
1. Release on Github
  1. `git tag -u 'valery1707@gmail.com' -m 'Release version 0.1.0' v0.1.0 HEAD~1`
  1. `git push`
  1. `git push --tags`
