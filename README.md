# Swagger Petstore Sample


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

- Use Profile `dev` To run tests using local server

    Open a new terminal and run

    ```shell
    mvn clean verify -Pdev
    ```

- Use Profile `prod` to run tests using prd version

  ```shell
  mvn clean verify -Pprod
  ```