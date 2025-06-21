import { useEffect, useState } from 'react';
import axios from 'axios';
import './App.css';

function App() {
  const [board, setBoard] = useState([['-', '-', '-'], ['-', '-', '-'], ['-', '-', '-']]);
  const [currentPlayer, setCurrentPlayer] = useState('X');
  const [message, setMessage] = useState('');
  const [gameOver, setGameOver] = useState(false);


  // Fetch the game state on load and after every move
  const fetchGame = async () => {
    const res = await axios.get('http://localhost:8080/api/game');
    const lines = res.data.split('\n');
    setCurrentPlayer(lines[0].split(': ')[1]);
    const newBoard = lines.slice(1).map(row => row.trim().split(' '));
    setBoard(newBoard);
  };

  const makeMove = async (row, col) => {
  try {
    const res = await axios.post(`http://localhost:8080/api/game/move?row=${row}&col=${col}`);
    const msg = res.data;
    setMessage(msg);
    await fetchGame();

    // Auto-reset if game is over
    if (msg.includes("Wins") || msg.includes("Draw")) {
      setTimeout(() => {
        resetGame();
      }, 2000); // 2 second delay before resetting
    }
  } catch (err) {
    setMessage("Invalid move!");
  }
};


  const resetGame = async () => {
  await axios.post('http://localhost:8080/api/game/reset');
  setMessage('');
  setGameOver(false);
  fetchGame();
};


  useEffect(() => {
    fetchGame();
  }, []);

  return (
    <div className="App">
      <h1>Tic Tac Toe</h1>
      <h2>Current Player: {currentPlayer}</h2>
      <div className="board">
        {board.map((row, rowIndex) => (
          <div key={rowIndex} className="board-row">
            {row.map((cell, colIndex) => (
              <button
                key={colIndex}
                className="cell"
                onClick={() => makeMove(rowIndex, colIndex)}
                disabled={cell !== '-'}
              >
                {cell === '-' ? '' : cell}
              </button>
            ))}
          </div>
        ))}
      </div>
      <p>{message}</p>
      <button className="reset-btn" onClick={resetGame}>Reset Game</button>
      
    </div>
  );
}

export default App;
