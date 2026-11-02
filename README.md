# Scotland Yard API

A REST API backend for a digital version of the board game **Scotland Yard**. Detectives try to catch a thief who moves between locations on a map. The API handles players, game maps, game sessions, moves, clues and catch attempts.

Built with **Java 25**, **Spring Boot 3.5**, **Spring Data JPA** and **MySQL**.

## Features

- **Game lifecycle:** create a game on a map, let players join, and start the game (`waiting` → `active`).
- **Player count suggestion:** the API suggests how many players a game needs, based on the map's grid size.
- **Join rules:** players cannot join a game that has already started, NPCs cannot join, and the same player cannot join twice.
- **Moves:** players move between locations by foot, vehicle or subway, with turn numbers.
- **Catch attempts:** a detective catches the thief if both players' latest moves end on the requested location. Duplicate attempts are rejected.
- **Clues, routes and player statistics:** CRUD endpoints for clues, routes between locations, and stats such as games played, games won and times caught.

## Tech stack

| Area | Technology |
|---|---|
| Language | Java 25 |
| Framework | Spring Boot 3.5 (Spring Web, Spring Data JPA) |
| Database | MySQL |
| Build | Maven (Maven Wrapper included) |
| Other | Lombok, DTOs for requests and responses |

## Architecture

The project follows a layered architecture:

```
controller/   REST endpoints
service/      Business logic (game rules, join rules, catch logic)
repository/   Spring Data JPA repositories
entity/       JPA entities (Game, Player, GameMap, Location, Move, ...)
dto/          Request and response objects
enoms/        Enums: GameStatus, PlayerRole, Transport, LocationType, WinnerRole
```

## Data model

- **Player** has a role: `detective`, `thief` or `npc`.
- **GameMap** has a grid size, and **Location** belongs to a map (`street`, `building`, `hideout`, `checkpoint`).
- **Route** connects two locations.
- **Game** belongs to a map and a host player, with status `waiting`, `active`, `completed` or `abandoned`.
- **GamePlayer** links players to a game.
- **Move**, **Clue** and **CatchAttempt** belong to a game.
- **PlayerStats** stores each player's statistics.

## API endpoints

### Games

| Method | Endpoint | Description |
|---|---|---|
| GET | `/games` | List all games |
| POST | `/games` | Create a game |
| PUT | `/games` | Start a game |
| POST | `/games/join` | Join a game |
| DELETE | `/games/{id}` | Delete a game |

### Gameplay

| Method | Endpoint | Description |
|---|---|---|
| GET / POST | `/moves` | List moves / make a move |
| GET / POST | `/catchAttempts` | List attempts / try to catch the thief |
| GET / POST | `/clues` | List / create clues |

### Setup data

| Method | Endpoint | Description |
|---|---|---|
| GET / POST / PUT / DELETE | `/gameMaps` | Manage game maps |
| GET / POST / PUT / DELETE | `/routes` | Manage routes between locations |
| GET | `/locations` | List locations |
| GET / POST / PUT / DELETE | `/gamePlayers` | Manage players in games |
| GET | `/players` | List players |
| GET / POST | `/playerStats` | Player statistics |

### Example: create a game

```http
POST /games
Content-Type: application/json

{
  "mapId": 1,
  "hostPlayerId": 1
}
```

### Example: catch attempt

```http
POST /catchAttempts
Content-Type: application/json

{
  "gameId": 1,
  "detectiveId": 2,
  "thiefId": 3,
  "locationId": 5
}
```

Response:

```json
{
  "gameId": 1,
  "mapName": "London",
  "successful": true,
  "message": "Detective successfully caught the thief"
}
```

## Getting started

### Requirements

- Java 25
- MySQL running locally

### 1. Create the database

```sql
CREATE DATABASE scotland_yard;
```

### 2. Configure the connection

Update `src/main/resources/application.yaml` with your MySQL username and password:

```yaml
spring:
  datasource:
    url: jdbc:mysql://localhost:3306/scotland_yard
    username: <your-username>
    password: <your-password>
```

Tables are created automatically by Hibernate (`ddl-auto: update`).

### 3. Run the application

```bash
./mvnw spring-boot:run
```

On Windows:

```bash
mvnw.cmd spring-boot:run
```

The API runs on `http://localhost:8080`.

## My contribution

This is an individual project, built entirely by me as part of my software developer education (YH) at Folkuniversitetet. I designed the data model, built all entities, repositories, services and REST endpoints, and implemented the game logic: creating, joining and starting games, suggesting the number of players, and checking catch attempts.

## Possible improvements

- Global exception handling with `@ControllerAdvice` and correct HTTP status codes
- Input validation with `@Valid`
- Unit and integration tests
- CI pipeline with GitHub Actions
- Environment variables for database credentials
