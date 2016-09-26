 README
========

## Requisites
- Java (version 1.8.0_40)
- Gradle
- Preferred IDE/Text editor
- Internet connection

## Basic commands
- `$ ./gradlew test`: run tests
- `$ ./gradlew build`: builds the project
- `$  java -jar build/libs/sainsbury-tech-task-1.0.0.jar`: runs tool to scrape page

## Note
- Development was done with TDD/BDD
- BDD tests also serves the purpose of integration testing feature file is in src/test/resources
- Used Spring for dependency injection
- Used Jsoup to fetch webpages
- Used Jackson for Json generation

## Src tree
```
 src
    ├── main
    │   ├── java
    │   │   └── com
    │   │       └── sainsbury
    │   │           ├── AppRunner.java
    │   │           ├── config
    │   │           │   └── AppConfig.java
    │   │           ├── controller
    │   │           │   └── ScrapingController.java
    │   │           ├── model
    │   │           │   ├── ScrapeItem.java
    │   │           │   ├── ScrapeResult.java
    │   │           │   └── service
    │   │           │       ├── ripefruit
    │   │           │       │   ├── RipeFruitScrapeItem.java
    │   │           │       │   ├── RipeFruitScrapeResultFactory.java
    │   │           │       │   ├── RipeFruitScrapeResult.java
    │   │           │       │   └── RipeFruitScrapeService.java
    │   │           │       ├── ScrapeResultFactory.java
    │   │           │       └── ScrapeService.java
    │   │           └── view
    │   │               ├── JsonViewFactory.java
    │   │               └── ViewFactory.java
    │   └── resources
    │       └── application.properties
    └── test
        ├── groovy
        │   └── com
        │       └── sainsbury
        │           └── bdd
        │               └── ScrapingSteps.groovy
        ├── java
        │   └── com
        │       └── sainsbury
        │           ├── bdd
        │           │   └── RunCukesTest.java
        │           ├── controller
        │           │   └── ScrapingControllerTest.java
        │           ├── model
        │           │   └── service
        │           │       └── ripefruit
        │           │           ├── RipeFruitScrapeResultFactoryTest.java
        │           │           └── RipeFruitScrapeServiceTest.java
        │           └── view
        │               └── JsonViewFactoryTest.java
        └── resources
            └── com
                └── sainsbury
                    └── bdd
                        └── sainsbury_ripefruit_scraping.feature

```
