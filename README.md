# spring-cloud-microservices

## To build 3 services with docker: 
 #### docker build -t config-service ./config-service/.
 #### docker build -t registry-service ./registry/.
 #### docker build -t account-service ./account-service/.

## To run in docker container:
#### docker run -p 8001:8001 config-service:latest
#### docker run -p 8761:8761 registry-service:latest
#### docker run -p 8081:8081 account-service:latest

## Test using Postman
#### Post request http://localhost:8081/accounts/
#### Body -> raw -> json:
#### 
	{
		"name" : "Lori",
		"email": "baxter@xyz.xy",
		"phone": "+39876543210",
		"bills": [
			5
		]
	} 
#### 

### Using H2 DB in account-service.yaml:

	spring:
	  h2:
	    console:
	      enabled: true
	      path: /h2-console
	  datasource:
	    url: jdbc:h2:~/test
	    driverClassName: org.h2.Driver
	#http://localhost:8081/accounts/h2-console/




