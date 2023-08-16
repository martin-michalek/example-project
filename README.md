# Example App for see coding experience

## Simple app containing User table, CRUD operations, unit testing, Integration tests, docker setup
### Please feel free to use prepared bash script from bottom

## Detail
| Name                              | Value                                    | Description                                           |
|-----------------------------------|------------------------------------------|-------------------------------------------------------|
| Local:                            | localhost:8080                           | Docker compose build port                             |
| API path:                         | /v1                                      | API context path, all other paths are on this context |
| Users path:                       | /users/                                  | Get list of all users in DB                           |
| Get specific user:                | /users/{id}                              | Receive user by ID                                    |
| Get users by email:               | /users/email?email=                      | Receive user by email                                 |
| Get users by first and last name: | /users/firstLastName?firstName=&lastName | Receive user by first and last name                   |
| Save user:                        | /users/save                              | Save user                                             |
| Delete user:                      | /users/delete?id=                        | Delete user                                           |

## Useful commands

Build and run application with PostgreSQL (all next steps in one):
```bash
mvn clean install
docker build -t coding-example .
docker-compose -f docker-compose.yaml up
```

To build the application:
```bash
mvn clean install
```

To run unit tests:
```bash
mvn test -P unit-test
```

To build docker image:
```bash
docker build -t coding-example .
```

To run the application with PostgreSQL:
```bash
docker-compose -f docker-compose.yaml up
```

To run integration tests - need to have running app:
```bash
mvn test -P integration-test
```