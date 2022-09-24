# Vending Machine Application
A starter application in spring boot & angular.


## Feature:
- Display Products Available
- Lets User Add new Products
- Enables User to Update Existing Products
- Enables Users to View Products
- Enables Users to Make Payment


## Setting up the spring project
* First we have to install java-8 and make sure that it has the needed policy files
    * A property file of our application , it is application.properties file
    * As we are using in memory database h2 , we have a InsertProduct.sql script added in the repo so that we will run this script on application startup
      http://localhost:8080/h2-console/
    * Now you should be ready to start working :) .

## Commands for maven/Spring
- `mvn clean install`: clean the generated build dir
- `right click run the VendingMachineApplication.java`: this will start the embedded tomcat locally on localhost:8080/products instance.
- To view Api documentation , implemented swagger to access it please click on http://localhost:8080/swagger-ui.html#/ when the server is started.
- Added Postman Collection for the api endpoints testing please import using postman (added in repo)
## Running scripts for Angular
(You have to run these commands from the /vending-machine-app-frontend folder)
- `npm -version` to check the npm version , if not installed then we have to do npm install to install npm
- `node -version` to check the node version  , if not installed then we have to install node from https://nodejs.org/en/download/
- `npm install` to create a build and load all the dependencies which are used in package.json
- `ng serve` to start the angular application
- Angular application will be up on http://localhost:4200/products
