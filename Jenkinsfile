node{
   stage('Checkout')
    {
        checkout scm
    }
	 stage('Clean')
    {
		withMaven(maven: 'ECD Maven 3.3.9 Linux')
		{
		sh "mvn -f Pipeline_test/pom.xml clean"
		}
    }
  
    stage('Unit Test')
    {
		withMaven(maven: 'ECD Maven 3.3.9 Linux')
		{
		sh "mvn -f Pipeline_test/pom.xml test"
		}
    }
   
   
    stage('Packaging')
    {
        withMaven(maven: 'ECD Maven 3.3.9 Linux')
		{
		sh "mvn -f Pipeline_test/pom.xml install"
		}
    }
	stage('Publish')
	{
	
		withMaven(maven: 'ECD Maven 3.3.9 Linux')
		{
			sh "mvn -f Pipeline_test/pom.xml clean deploy"
		}
		//nexusArtifactUploader artifacts: [[artifactId: 'BankExample', classifier: '', file: './Java-Pipeline-test/Pipeline_test/target/BankExample.war', type: 'war']], credentialsId: '', groupId: 'com.aep.testdemo', nexusUrl: 'abci-prod:8082/nexus', nexusVersion: 'nexus2', protocol: 'http', repository: 'http://abci-prod:8082/nexus', version: '1.0'
		
	}
	stage('Download')
	{
		sh '''#!/bin/sh

cd /var/lib/jenkins

if [  $# -gt 0 ]; then
  # use provided URL
  wget $1
  ln -sf ${1##*/} BankExample.war
else 
  # default to current trunk build
  # get the latest BankExample-single artifact\'s Version by parsing maven-metadata.xml in Nexus
  function Version(){
curl -s \'http://vmnaldcas138:8084/nexus/content/repositories/snapshots/com/aep/testdemo/BankExample/0.0.1-SNAPSHOT/maven-metadata.xml\' | grep \'<value>\' | head -1 | sed "s/.*<value>\\([^<]*\\)<\\/value>.*/\\1/"
}
echo $(Version)
# get the latest swami-batch-single artifact and store in /appl/swami
curl http://vmnaldcas138:8084/nexus/content/repositories/snapshots/com/aep/testdemo/BankExample/0.0.1-SNAPSHOT/BankExample-$(Version).war --create-dirs -o /var/lib/jenkins/BankExample-$(Version).war
mv /var/lib/jenkins/BankExample-$(Version).war /var/lib/jenkins/BankExample.war 
#wget -O /appl/swami/ "http://vmnaldcas138:8084/nexus/content/repositories/snapshots/com/aep/gridsmart/swami-batch/1.17-SNAPSHOT/swami-batch-$(Version).jar"
echo "http://vmnaldcas138:8084/nexus/content/repositories/snapshots/com/aep/testdemo/BankExample/0.0.1-SNAPSHOT/BankExample-$(Version).war"
# create softlink/shortcut  
ln -sf BankExamle-$(Version)-single.war BankExample-single.war 
fi
'''

	}
   
  
   
   stage('Deploy?')
    {
       input 'Proceed to Deploy?'
    }
   
   stage('Deploy')
   {
   
    withMaven(maven: 'ECD Maven 3.3.9 Linux')
	{
		//sh "mvn -f Pipeline_test/pom.xml deploy"
		
	sh "mvn -f Pipeline_test/pom.xml package -Ddeploy.to.weblogic -Ddeploy.for.weblogic"
	

}
   }
 
	stage('Selenium Testing')
	{
	
	withMaven(maven: 'ECD Maven 3.3.9 Linux')
		{
		sh "mvn -f SeleniumTest/pom.xml test"
		}
	
	}
	
	stage(' Sending for Scan ')
	{
		build 'Test_IBMScan'
	}
 
   
}

    
 
