package com.example.tictactoe.controller;

import com.example.tictactoe.model.Game;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/game")

public class GameController {
    private Game game = new Game();

    @GetMapping
    public String getBoard() {
        StringBuilder sb = new StringBuilder();
        sb.append("Current Player: ").append(game.getCurrentPlayer()).append("\n");

        char[][] board = game.getBoard();
        for(int i=0;i<board.length;i++){
            for(int j=0;j< board.length;j++){
                sb.append(board[i][j]);
                if (j < board[i].length - 1) sb.append(" ");
            }
            if (i < board.length - 1) sb.append("\n");
        }
        return sb.toString();
    }


    @PostMapping("/move")
    public String maekMove(@RequestParam int row, @RequestParam int col) {
        boolean valid = game.makeMove(row, col);
        if (!valid) return "Invalid Move!";
        String result = game.checkWinner();
        if (result.equals("In Progress")){
            game.switchPlayer();
        }
        return result;
    }

    @PostMapping("/reset")
    public String resetGame(){
        game.resetboard();
        return "Game Reset!! New Game Starting!";
    }
}
