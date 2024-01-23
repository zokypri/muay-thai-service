# muay-thai-service
Service for the martial art of muay thai thee Thailand national sport

# Running the service
To run the service locally it is required to have mysql installed and create a database named SPORTS_DATA
The rest will be taken care of by liquibase when starting the server
Swagger is one way to make calls to the service 

# Swagger link locally
http://localhost:8088/muay-thai-service/swagger-ui/index.html#/

# Improvements
The service is still under development and there are quite a few things that need to be improved

    1: Unit and Component tests
    2: Add a kafka connector to listen to the DB table fighter and publish an event when a new fighter is added
    3: MDC configurations for Log Id tracebality
    4: Configuring Spring Security for auth with JWT

# Dockerized
The service is still a standalone service but there are plans to include it in the kafka-docker docker compose project
By dockerizing the service will be a part of a multi-container microservice architecture 

The Dockerized project can be found here but as I mentioned muay-thai-service is not yet part of that project

https://github.com/zokypri/kafka-docker

