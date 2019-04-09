# TO DO Task List

This project is a simple TODO tasks project

### Prerequisites

* Java 8
* Maven 3
* Docker

### Installing and Deploying

How to run

1. Fork the project
2. Build: `mvn install` or run `mvn spring-boot:run`
3. Acess url http://localhost:9090/task

Or yet

1. Build with docker `mvn install dockerfile:build`
2. Run docker run -p 9090:9090 springtask/spring-task
3. Acess url http://localhost:9090/task

## Running the tests

Explain how to run the automated tests for this system

## Using

There are 2 defaults users

* Username: **test@gmail.com**
* Password: **12345**

* Username: **test2@gmail.com**
* Password: **12345**

You can create a new one in the register page

## Built With

* [Spring Boot](https://spring.io/projects/spring-boot) - The rest/ routing framework used
* [Spring Security](https://spring.io/projects/spring-security) - The security framework used
* [Spring MVC]( ) - The web framework used
* [Thymeleaf](https://www.thymeleaf.org/) - Web theme generator used
* [Docker]( ) - The container manager used
* [Maven](https://maven.apache.org/) - Dependency Management

## Contributing

This project is not open for contributors.

## Versioning

Using [Github](https://github.com) for versioning. 
For the versions available, see the [tags on this repository](point the repository tags here).

## Authors

* **Cesar Venancio** - *Initial work* - [gitProfile](git profile address here)

## License

This project is licensed under the MIT License - see the [LICENSE.md](LICENSE.md) file for details.

## Acknowledgments

* Kudos to anyone whose code was used (thank you guys, really).
* Inspiration
* etc