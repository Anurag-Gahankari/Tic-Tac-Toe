# Tic Tac Toe Frontend

This is a React-based frontend for a Tic Tac Toe game, built with [Vite](https://vitejs.dev/) for fast development and hot module replacement.

## Features

- Interactive Tic Tac Toe board
- Displays current player
- Handles moves and game state via backend API
- Shows win/draw messages and auto-resets after game over
- Manual reset button

## Getting Started

### Prerequisites

- Node.js (v18 or newer recommended)
- Backend Tic Tac Toe API running at `http://localhost:8080`

### Installation

```sh
npm install
```

### Running the App

Start the development server:

```sh
npm run dev
```

Open [http://localhost:5173](http://localhost:5173) in your browser.

### Build for Production

```sh
npm run build
```

### Linting

```sh
npm run lint
```

## Project Structure

- `src/App.jsx`: Main React component for the game UI
- `src/main.jsx`: Entry point
- `src/App.css`: App-specific styles
- `src/index.css`: Global styles

## API Endpoints Used

- `GET http://localhost:8080/api/game` – Fetch current game state
- `POST http://localhost:8080/api/game/move?row={row}&col={col}` – Make a move
- `POST http://localhost:8080/api/game/reset` – Reset the game
