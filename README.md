# spring-cloud-microservices

Run services in the following order:
1. config-service
2. registry
3. gateway
4. account-service
5. bill-service
6. notification-service
7. deposit-service


# RabbitMQ run command:
docker run -p 15672:15672 -p 5672:5672 rabbitmq:3-management

You can then go to http://localhost:15672/ with the default username and password of guest / guest
