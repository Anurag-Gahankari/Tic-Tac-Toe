
# 🧠 Tic Tac Toe Backend (Spring Boot)

This is the **backend API** for the Tic Tac Toe game built using **Java Spring Boot**. It exposes RESTful endpoints to interact with the game logic and maintain the board state.

---

## ⚙️ API Endpoints

### ➕ Make a Move

```
POST /api/game/move?row={row}&col={col}
```

- **row**: integer (0–2)
- **col**: integer (0–2)
- **Returns**: A message such as:
    - `"X wins!"`
    - `"O wins!"`
    - `"Draw"`
    - `"In Progress"`

---

### 📄 Get Current Game State

```
GET /api/game
```

**Returns** a plain text response such as:

```
Current Player: X
X O X
- X O
- - O
```

---

### 🔄 Reset the Game

```
POST /api/game/reset
```

**Effect**: Resets the board to its initial empty state and sets current player to `'X'`.

---

## 🚀 Running the Backend

Make sure you have Java and Maven installed.

To run the Spring Boot backend locally:

```bash
./mvnw spring-boot:run
```

> The server runs by default on **http://localhost:8080**

---

## 🧪 Example curl Commands

You can test the API using `curl`:

```bash
# Make a move at row 0, column 1
curl -X POST "http://localhost:8080/api/game/move?row=0&col=1"

# Get the current board
curl http://localhost:8080/api/game

# Reset the game
curl -X POST http://localhost:8080/api/game/reset
```

---

## 📁 Project Structure

```
src/
└── main/
    └── java/
        └── com/
            └── example/
                └── tictactoe/
                    ├── controller/
                    │   └── GameController.java
                    ├── model/
                    │   └── Game.java
                    └── TicTacToeApplication.java
```

---

## 🛠️ Technologies Used

- Java 17+
- Spring Boot
- Maven
- REST APIs

---

## 🧠 Backend Logic Overview

### Game.java (Model)

- Manages the board (`char[3][3]`)
- Keeps track of the current player (`'X'` or `'O'`)
- Handles:
    - Valid move checking
    - Win condition checking
    - Draw condition

### GameController.java

- Exposes REST endpoints
- Handles API requests:
    - `/api/game` for getting board
    - `/api/game/move` for making moves
    - `/api/game/reset` for restarting the game

---

## 👤 Author

**Anurag Gahankari**  
GitHub: [Anurag-Gahankari](https://github.com/Anurag-Gahankari)

---

## 📝 License

This project is licensed under the **MIT License**.
