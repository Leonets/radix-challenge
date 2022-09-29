# Radix Gateway Challenge

This application interacts with a Radix full node (toy-deployment setup) for getting out the token transfers.  

This system starts then continuously pulling all the submitted transactions to the network, 
then it detects every token transfer of any type for storing it in-memory.

This system offers the following api to check for the transfers:

| Endpoint           | Medhod   | Description                                                           |
|--------------------|----------|-----------------------------------------------------------------------|
| /transfers         | GET      | List tokens and amount transferred                                    |
| /transfers/:rri_id | GET      | Returns amounts transferred to token with ID rri_id                   |
| /transfers/address | GET      | Returns transfers to the monitored addresses                          |
| /monitor           | POST     | Adds a list of addresses to be monitored (See example payload below)  |
| /monitor           | DELETE   | Deletes all addresses to be monitored                                 |


This application uses:
 - Spring Boot 2.7.4
 - MapStruct
 - WireMock
 - JDK17
 - Reactive Feign
 - Maven 3.8.6

It has been tested on Ubuntu 20.04

## Application

The application contains:

* package rdx.gateway.challenge.api: Controller 
* package rdx.gateway.challenge.config: Configs for Reactive Feign Client configuration
* package rdx.gateway.challenge.coreclient: Reactive Feign Client interface for Core API
* package rdx.gateway.challenge.coremodel: Model from the Core Api (build with openapi-generator)
* package rdx.gateway.challenge.exception: Exception manage for the Reactive Feign Client
* package rdx.gateway.challenge.model: Model for the exposed Api (build with openapi-generator)
* package rdx.gateway.challenge.service: Service for using the Api Client / Scheduler
* package rdx.gateway.challenge.mapper: Mapper from the returned data schema to the provided schema
* package rdx.gateway.challenge: Main Spring Boot Application (GatewayChallengeApplication)

* Dockerfile with OpenJDK image

The unit testing contains:
* ControllerTest
* TransfersTest
* SchedulerTest
* MapperTest

The docs contains:
* yaml
* snapshot from Postman testing

### Build & test 

The system can be started with the following command (mvn 3.8.6):
  - mvn clean package -DskipTests=true spring-boot:run

### Code Coverage

The target folder (target/site/index.html) contains the result of the code analisys, currently coverage is about 40% 

# Exception manage
* It is used and advice `GlobalExceptionHandler` for getting some kind of exception, `Exception` included
* When an exception rise from the Feign http client then a specific class `CustomErrorDecoderForFeign` will decode the error and then raise back again one of the following:
    * `RestApiClientException` 
    * `RestApiServerException`