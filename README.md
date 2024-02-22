# Petstore Testing

### Requirements to run the project

Have installed:
 
- Java > v17
- Maven

**Recommendation**: Use [SDKMan!](https://sdkman.io) to install Java and Maven

### To run Server
Open a new terminal
To run the server, run this task:

```
mvn package jetty:run
```

This will start Jetty embedded on port 8080.

### To run (via Docker)

Expose port 8080 from the image and access petstore via the exposed port. You can then add and delete pets as you see fit.


*Example*:

```
docker build -t swaggerapi/petstore3:unstable .
```

```
docker pull swaggerapi/petstore3:unstable
docker run  --name swaggerapi-petstore3 -d -p 8080:8080 swaggerapi/petstore3:unstable
```


### Running Tests

In a new terminal run:

- Profile `dev` To run tests using local server

    ```shell
    mvn verify -Pdev
    ```

- Profile `prod` to run tests using prd version

  ```shell
  mvn verify -Pprod
  ```
  
## Tests Design

To test `pets/findByTag` endpoint I have decided to run functional tests to cover major cases.
In the table below you will find each covered case. 
The objective is to consider every possible case for the specified endpoint. And with the same 
mindset, we can cover each endpoint.

| Endpoint  | Test |
|-----------|------|
| `pet/fetchById` | 


## Extras
To smoothly run the tests I worked in the following extra things:

1. Added missing dependencies to make work put and post actions locally

1. Removed duplicated dependency jars that generated Warnings on Jetty start

1. Added Prettier to format code

1. Added `dev` and `prod` variables to maven profile