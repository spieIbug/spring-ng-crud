Author : Maamar Yacine MEDDAH
# Maven Hibernate Spring Bootstrap Angular JQuery CRUD Tutorial using TDD/BDD
=============================================================================

## A CRUD ( Create, Read, Update, Delete) Tutorial using
- Hibernate
- Spring
- Maven
- First version with JSP 
- Second one with AngularJS Bootstrap and JQuery
- TDD (Test Driven Development) and BDD (Behavior Driven Development) using TestNG and Mockito

## Architecture
```sh
Page
Controller
Service
Dao
Model
Database
```

## Recommendations

For better user of this tutorial, we recommand installation of the 
- JDK1.8
- Apache Tomcat v7.0.56 
- maven 3
- MySQL you can install wamp or EasyPHP they contains (Apache and MySQL) servers.
## Environment configuration
### Maven installation
```sh
- Download Maven from http://maven.apache.org/download.cgi
- Extract it
- You can view or modify the environment variables by selecting System from the Control Panel, selecting Advanced system settings, and clicking Environment Variables.
- Add environment variable : M3_HOME and set its value for the folder containing the maven unzipped package (Ex:C:\apache-maven-3.2.2-bin)
- Add another variable : M3 , and set its value : %M3_HOME%\bin
- Now edit your PATH Variable (where you have your JDK conf), add in values this : %M3% don't forget to separate items by ";"
- Optional : You can also add MAVEN_OPTS variable to set your JVM allowed memory, for example :  -Xms256m -Xmx512m
- Make sure that your environment variable "JAVA_HOME" contains your JDK installation folder, and "%JAVA_HOME%\bin" is presents in the PATH variable.
- For french version your can refer to this link http://www.objis.com/formation-java/tutoriel-maven-installation-phases.html
```
### Launching the project
- Download the zip of the project
- Once, it's done extract it
- After configuring your maven (you can check your conf, by typing in the command prompt : mvn --version )it'll display your JDK and Maven versions.
- You can launch the project compile using : mvn clean install , it'll also launch tests that you can skip by adding -DskipTests
- Now launch your project using : mvn jetty:run , once your server launched, access on your browser this URL : localhost:8080

```sh
Launch your SQL admin interface, create your employedb database
and launch this scirpt:
CREATE TABLE IF NOT EXISTS `employe` (
  `employeId` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `firstName` varchar(45) NOT NULL DEFAULT '',
  `lastName` varchar(45) NOT NULL DEFAULT '',
  `experience` int(10) unsigned NOT NULL DEFAULT '0',
  PRIMARY KEY (`employeId`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=35 ;
```

## Some usefull commands

```sh
mvn clean install > this allows your to clean install and launch your test with maven
mvn test > launch your tests
mvn clean install -DskipTests > this allows your to clean install and skip tests
mvn jetty:run > run jetty server plugin you can visualize your app on localhost:8080 not the same as tomcat where you must specify the application name in the url
for debug you can use -X
```
