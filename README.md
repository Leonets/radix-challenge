# Radix Gateway Challenge

This application interacts with a Radix full node (toy-deployment setup) for getting out the token transfers.  

This system starts and then continuously exctracts all the submitted transactions to the network, 
then it detects every token transfer of any type to storing it in-memory 
and then serve it to clients who request it.

This system offers the following api to check for the transfers:

| Endpoint           | Medhod   | Description                                         |
|--------------------|----------|-----------------------------------------------------|
| /transfers         | GET      | List token transfers and amount transferred         |
| /transfers/:rri_id | GET      | Returns amounts transferred to token with ID rri_id |
| /transfers/address | GET      | Returns transfers to the monitored addresses        |
| /transfers/tokens  | GET      | Returns grouped amount transferred to tokens        |
| /monitor           | POST     | Adds a list of addresses to be monitored            |
| /monitor           | DELETE   | Deletes all addresses to be monitored               |


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

* package rdx.gateway.challenge
  * api: Controller 
  * config: Configs for Reactive Feign Client configuration
  * coreclient: Reactive Feign Client interface for Core API
  * coremodel: Model from the Core Api (build with openapi-generator)
  * exception: Exception manage for the Reactive Feign Client
  * model: Model for the exposed Api (build with openapi-generator)
  * service: Service for using the Api Client / Scheduler
  * mapper: Mapper from the returned data schema to the provided schema
  * challenge: Main Spring Boot Application (GatewayChallengeApplication)

* Dockerfile with OpenJDK image

How to build the image:
docker build -t gateway-challenge .

How to run the container:
docker run -dp 8086:8086 gateway-challenge

The unit testing contains:
* ControllerTest
* TransfersTest
* SchedulerTest
* MapperTest

The docs contains:
* yaml
* snapshot from Postman testing
* Postman collection 

Configuration:
no configuration is required apart from that of the parameter 
coreapi.api.url: http://localhost:3333 (host:ip of the core node api)

### Build & running & test 

The system can be started with the following command (mvn 3.8.6):
  - mvn clean package spring-boot:run

### Code Coverage

The target folder (target/site/index.html) contains the result of the code analisys, currently coverage is about 40% 

### Exception manage
* It is used and advice `GlobalExceptionHandler` for getting some kind of exception, `Exception` included
* When an exception rise from the Feign http client then a specific class `CustomErrorDecoderForFeign` will decode the error and 
then raise back again one of the following:
    * `RestApiClientException` 
    * `RestApiServerException`