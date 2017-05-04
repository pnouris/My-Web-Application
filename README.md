# Web App Assignment


Philippos Nouris

This assignment is a web application providing a REST API and angular front-end to allow CRUD operations on workers entities.

 __Tech Used__: Spring Boot, AngularJS, Keycloak (Authenticator), lombok.jar, MySQL Community Service, MySQL Workbench
 
 ## How to run the application:

* Download and Install Lombok.jar to eclipse

* Import the Realm master-realm.json in to Keyclaok ( bin/standalone.bat -Dkeycloak.migration.action=import -Dkeycloak.migration.provider=singleFile -Dkeycloak.migration.file=master-realm.json -Dkeycloak.migration.strategy=OVERWRITE_EXISTING)

* Start Keycloak on port 8080

* Using Eclipse Import folder Philip as an existing maven project

* Install MySQL Workbench, create a new database and add its configurations where it says spring.datasource. in the src/main/resources/application.properties file 

* Run application as Maven Build (write in Goals: spring-boot:run)

* Access the application at http://localhost:8000/

* Login (username: admin pass:admin)





##### Reference:
http://slackspace.de/articles/authentication-with-spring-boot-angularjs-and-keycloak/

##### Screenshots of the web application are provided in the images folder
