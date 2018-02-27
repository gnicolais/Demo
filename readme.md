The reason I have setup this is for testing the de-coupling of the controller interface from the implementation.

Consul and other configurations are not part of the purpose of this demo.

Install welcome and greetings interfaces jars running

- mvn clean install

pull consul image from docker and run it with default settings

run both services and check that they have been correctly registered on consul 
- http://localhost:8500/

run welcome and greetings services 

greetings endpoint (GET)

```http://localhost:8081/greetings/english/<name>```

return the message

```Hello, <name>!```

greetings endpoint (POST)

```curl -d '{"name":"Giuseppe", "language":"english"}' -H "Content-Type: application/json" -X POST http://localhost:8081/greetings/```

returns

```
{ 
  "name": "Giuseppe",
  "language": "english",
  "message" : "Hello, Giuseppe"
}
```

```curl http://localhost:8080/welcome```

return the messsage

```Hello, Stranger, welcome to the world!```


**welcome-service** consumes **greetings-service** */greetings/{language}/{name}* endpoint via feign client

--

Each service interface jar contains only the interface (no dto)
The feign consumer (welcome-service) and the greetings-service controller implementation have two different dto classes 
based on their needs

--