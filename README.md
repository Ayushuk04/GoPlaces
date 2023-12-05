
# GoPlaces Trip Management API

This project provides a comprehensive set of RESTful APIs built with Spring Boot, specifically designed for travel agents to manage their trips efficiently. The APIs cover a range of functionalities, from creating and editing trips to managing users associated with each trip.


## API EndPoints
### User

#### Get all users

```http
  GET /users/
```


#### Get user by id

```http
  GET /users/{id}
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `id`      | `string` | **Required**. Id of item to fetch |

#### Create new user
```http
  POST /users/
```
| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `No Parameter`      |  | **Required**. Request body required. |

#### Edit user details

```http
  PUT /users/{id}
```
| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `id`      | `String` | **Required**. Request body required. |

#### Delete user by id

```http
  DELETE /users/{id}
```
| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `id`      | `String` | **Required**. Id of item to fetch. |

#### Search user by name

```http
  GET /users/search/{keyword}
```
| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `keyword`      | `String` | **Required**. name of user as keyword. |

### Trips

#### Get all trips

```http
  GET /trips/
```

#### Get trip by id

```http
  GET /trips/{id}
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `id`      | `string` | **Required**. Id of item to fetch |

#### Create new trip
```http
  POST /trips/
```
| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `No Parameter`      |  | **Required**. Request body required. |

#### Edit trip details

```http
  PUT /trips/{id}
```
| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `id`      | `String` | **Required**. Request body required. |

#### Delete trip by id

```http
  DELETE /trips/{id}
```
| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `id`      | `String` | **Required**. Id of item to fetch. |

#### Search trips by name

```http
  GET /trips/search/{keyword}
```
| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `keyword`      | `String` | **Required**. name of trip as keyword. |


#### Add user to a trip
```http
  PUT /trips/{tripId}/user/{userId}
```
| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `tripId`      | `String` | **Required**. Id of item to fetch. |
| `userId`      | `String` | **Required**. Id of item to fetch. |



#### Remove user from a trip
```http
  DELETE /trips/{tripId}/user/{userId}
```
| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `tripId`      | `String` | **Required**. Id of item to fetch. |
| `userId`      | `String` | **Required**. Id of item to fetch. |

#### List trip participants
```http
  GET /users/{tripId}/users
```
| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `tripId`      | `String` | **Required**. Id of item to fetch. |

#### list user's trip
```http
  GET /trips/{userId}/trips
  ```
  | Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `userId`      | `String` | **Required**. Id of item to fetch. |


## Getting Started

1.CLone the repository

```bash
  https://github.com/Ayushuk04/GoPlaces.git
```
2.Import sql dump into your database.

3.Configure application.propertiies.

4.Run the application using your preferred IDE.

4.Access the Swagger documentation at Swagger UI to interactively explore and test the APIs.
     
```bash
  https:/localhost:8080/swagger-ui/index.html
```

5.Import the Postman collection from repository to interactively explore and test the APIs.