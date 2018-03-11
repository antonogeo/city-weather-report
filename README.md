## Synopsis

Simple application that prints the weather report of a specific city and date, according to the [WunderGround API](https://www.wunderground.com/weather/api/d/docs).

## Technologies Used

* Java 8
* Spring Boot
* Maven

## Overview

The application performs two basic functions, a rest call and a file creation. The structure follows that logic by dividing the service package into the export and the rest services.

### Rest Service
The implementation in the rest package intents to the problem solution and to possible future expansion. Each rest service extends the abstract `RestService` class which provides three
methods. Two of them use the same functionality in all the children classes, so they are implemented in the parent class. The third method is needed by each child
but with different implementation and return type, so it is declared as abstract and is implemented in every child separately. Each service has its own Interface.

### Export Service
The export service implementation is simple but extendable. The `exportTxt()` is a generic method that will be called by every future method that prints a txt. Also it takes the file name
as argument in order to make the multiple file creation possible.

## Build and Run
Navigate to the project folder and run :
```
mvn clean package && java -jar target/wunderground-weather-1.0-SNAPSHOT.jar
```