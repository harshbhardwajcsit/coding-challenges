# Request Proxy Service

The System has be been built using Spring boot framework, with an exposed endpoint/REST API  
* host/api/v1/reply, where host is the server where the system has been deployed or running, v1 is for the versioning of the API
* for local testing or postman testing : use localhost:8090/api/v1/reply 

## Requirements

* Java 1.8
* Gradle 4.10.3

## How to run it?
Do :> gradle bootRun

## For running unit test and integration test

Do:> gradle test

## For running unit test and integration test with additional information

Do:> gradle test -info or gradle test -i

## Improvement to be covered

* More Error handling can be done around the URL execution

* More Integration test can be covered under failure cases like, request limit exceeds, 
  connection refused, server not found.

* For Recording client activities making request to the service distributed caching can used, 
  currently a simple TransactionService has been created to do the same.  
  
  
  
  

