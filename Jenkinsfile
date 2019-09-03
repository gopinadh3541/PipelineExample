node{
	
	
	stage('Checkout1')
	{
		checkout 'https://github.com/gopinadh3541/Example.git'
	}
	
   stage('Checkout')
    {
        checkout scm
    }
	
	
	 stage('Clean')
    {
		
		
		bat "mvn -f Pipeline_test/pom.xml clean"
		
    }
  
    stage('Unit Test')
    {
		
		
		bat "mvn -f Pipeline_test/pom.xml test"
		
    }
   
   
    stage('Packaging')
    {
        
		bat "mvn -f Pipeline_test/pom.xml install"
		
    }
	stage('Publish')
	{
	
		
			//bat "mvn -f Pipeline_test/pom.xml clean deploy"
		
		//nexusArtifactUploader artifacts: [[artifactId: 'BankExample', classifier: '', file: './Java-Pipeline-test/Pipeline_test/target/BankExample.war', type: 'war']], credentialsId: '', groupId: 'com.aep.testdemo', nexusUrl: 'abci-prod:8082/nexus', nexusVersion: 'nexus2', protocol: 'http', repository: 'http://abci-prod:8082/nexus', version: '1.0'
		
	}
stage('Download')
	{

	}
   
  
   
   stage('Deploy?')
    {
       input 'Proceed to Deploy?'
    }
   
   stage('Deploy')
   {
   
		
	//bat "mvn -f Pipeline_test/pom.xml package -Ddeploy.to.weblogic -Ddeploy.for.weblogic"
	


   }
 
	stage('Selenium Testing')
	{
	
	
		bat "mvn -f SeleniumTest/pom.xml test"
		
	
	}
	
	stage(' Sending for Scan ')
	{
		build 'Appl_Web'
	}
 
   
}

    
 
