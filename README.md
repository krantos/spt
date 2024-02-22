# Petstore Testing

### Tools used

- Serenity
- Rest Assured
- Maven (because the original petstore project uses maven)

### Requirements to run the project

Have installed in your machine:

- Java > v17
- Maven

**Recommendation**: Use [SDKMan!](https://sdkman.io) to install Java and Maven

### To run tests

Integration tests includes `pre-integration-test` to start `jetty` server and `post-integration-test` to stop it.

In a new terminal run:

- Profile `dev` To run tests using local server

    ```shell
    mvn verify -Pdev
    ```

- Profile `prod` to run tests using prd version

  ```shell
  mvn verify -Pprod
  ```
  
## Test Report

Open the Serenity report [here](./spt/target/site/serenity/index.html)

## Tests Design

To test `pets/findByTag` endpoint I have decided to run functional tests to cover major cases.
In the table below you will find each covered case.
The objective is to consider every possible case for the specified endpoint. And with the same
mindset, we can cover each endpoint.

| Endpoint        | Tests                                                                                  |
|-----------------|----------------------------------------------------------------------------------------|
| `pet/fetchById` | Validate that fetching pets with `tag` should return pets that include the same `tag`. |
|                 | Validate that pets include at least one tag on a multiple tag request                  |
|                 | Validate empty collection response for an unknown tag                                  |
|                 | Validate error message for empty tag                                                   |
|                 | Validate JSON Schema response                                                          |

## Acceptance Test

Given a specific user flow a test is created to validate a common scenario.
This user flow will include the next endpoints

- `/user/login` with a `get` action that includes auth data
- `/pet` with `post` action to create a new pet (includes sessionId from previous call)
- `/pet` with `get` action to retrieve information
- body validation agains prior data.

```gherkin
Given I am authenticated
And I add my new pet Sun
When I ask for a pet with Sun's id
Then I get Sun data as result
```

## Extras and faced challenges

To smoothly run the tests I worked in the following extra things:

1. Added missing dependencies to make work put and post actions locally

1. Removed duplicated dependency jars that generated Warnings on Jetty start

1. Added Prettier to format code

1. Added `dev` and `prod` variables to maven profile