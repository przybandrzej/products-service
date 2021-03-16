# products-service
  
## Description  
Simple Spring Boot app for managing database of products. Each `Product` is a property of some `Brand` and can appear in some `Shops`. 
Products can have `Categories` (multiple). A `Category` can have `Attributes` for products specific to this category. 
`AttributeEntry` is an occurance with value of `Attribute` in a `Product`. `Attribute` tells what should be the name of the attribute and type of value of the `AttributeEntry`.

## Build  
Application uses Gradle. The default task is `bootRun` and the default Spring Profile is `dev`.  
To run `dev` version simply use one of the following commands:  
  `gradlew`  
  `gradlew bootRun`  
  `gradlew bootRun -Pdev`  
  `gradlew -Pdev`  
To build the app use the `build` task:  
  `gradlew build`  
  `gradlew build -Pdev`  
If you want to add other profiles like `prod`, add `application-prod.yml` to `resources` directory and use the `-Pprod` flag.

There is a `PostgreSQL` DB needed to run this application. The `dev` version uses ***locations_service*** db with the same user and password.  
The app uses `Flyway` migration tool to create DB schema and tables at app start, so there is no need to configure it. Just run the app, tables will be create automaticly.
