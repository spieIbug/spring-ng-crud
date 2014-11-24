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

Launch your SQL admin interface, create your employedb database
and launch this scirpt:
```sh
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
