
# Tic Tac Toe - Full Stack Web Application

A simple yet complete **Tic Tac Toe** game built using:

- 🧠 **Java Spring Boot** for the backend API  
- 🎨 **React (Vite)** for the frontend UI

This project is designed for beginner-friendly learning and is well-documented to help you understand the structure and flow.

---

## 🔧 Features

- Playable Tic Tac Toe game between two players
- Game state management via REST API
- Current player tracking
- Win/draw detection and reset option
- Responsive UI built with React

---

## 📁 Project Structure

```
tic-tac-toe-project/
├── backend/                # Java Spring Boot Application
│   └── src/
│       └── main/
│           ├── java/com/example/tictactoe/
│           │   ├── controller/GameController.java
│           │   ├── model/Game.java
│           │   └── TicTacToeApplication.java
│           └── resources/
│               └── application.properties
├── frontend/               # React Vite Application
│   ├── src/
│   │   ├── App.jsx
│   │   └── App.css
│   └── index.html
└── README.md
```

---

## 🚀 Getting Started

### Backend (Spring Boot)

#### 🔨 Requirements

- Java 17+
- Maven

#### ▶️ Run the Server

```bash
cd backend
./mvnw spring-boot:run
```

Or open the project in **IntelliJ IDEA**, and run the main class:
```
com.example.tictactoe.TicTacToeApplication
```

#### 🔗 API Endpoints

- `GET /api/game` → Returns current player and board state
- `POST /api/game/move?row={row}&col={col}` → Make a move
- `POST /api/game/reset` → Reset the game

---

### Frontend (React + Vite)

#### ⚙️ Requirements

- Node.js 18+
- npm or yarn

#### ▶️ Run the Frontend

```bash
cd frontend
npm install
npm run dev
```

Visit [http://localhost:5173](http://localhost:5173)

---

## 📷 Sample Screenshots

**Board View:**

```
X O X
O X O
X - -
```

**Winner Message:**
```
X wins
```

---

## 🌐 CORS Setup (for development)

In `GameController.java`, you can temporarily allow frontend requests using:

```java
@CrossOrigin(origins = "http://localhost:5173")
```

Or configure it globally in a config class.

---

## 🧪 Testing with Postman (Optional)

You can test backend endpoints like:

- `POST http://localhost:8080/api/game/move?row=0&col=0`
- `POST http://localhost:8080/api/game/reset`

---

## 🐙 Git & GitHub Setup

```bash
git init
git add .
git commit -m "Initial commit"
git remote add origin https://github.com/yourusername/tic-tac-toe.git
git push -u origin main
```

---

## 🧑‍💻 Author

Made with ❤️ by [Your Name]

---

## 📜 License

MIT License
