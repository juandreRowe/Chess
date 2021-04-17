/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chess;

import com.vzap.games.boards.ChessBoard;
import com.vzap.games.pieces.Pawn;
import com.vzap.games.pieces.Piece;
import com.vzap.games.players.ChessPlayer;

/**
 *
 * @author juandre
 */
public class Game {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        new Game().run();
    }
    
    public void run(){
        //Game flow
        EasyIn input = new EasyIn();
        
        //Get players name and create players array
        ChessPlayer[] players = new ChessPlayer[2];
        for(int x = 0; x < players.length; x++){
            System.out.println("Enter player name");
            players[x] = new ChessPlayer(input.readString(), x % 2 == 0);
        }
        
        ChessBoard board = new ChessBoard();
        
        while(!board.isWinner()){
            boolean playerWhite = players[board.getTurns() % 2].isWhitePieceColor();
            System.out.println("White: " + playerWhite);
            players[board.getTurns() % 2].play();
            board.printBoard();
            //location of piece to move
            int row = -1;
            int col = -1;
            //check if location is valid
            while(!board.hasPiece(row, col)){
                System.out.println("Enter row of piece");
                row = input.readInt();
                System.out.println("Enter col of piece");
                col = input.readInt();
            }
            
            int newRow = -1;
            int newCol = -1;
            //location to where the piece must be move to
            while(!board.isInRange(newRow, newCol)){
                System.out.println("Enter row to move to");
                newRow = input.readInt();
                System.out.println("Enter col to move to");
                newCol = input.readInt();
            }
            
            Piece p = board.getPiece(row, col);
            
            //Only Pawn is not allowed to go backwards
            if(p instanceof Pawn){
                //TODO: prevent going backwards
                System.out.println("Pawn is moved");
            }
            if(board.getPiece(newRow, newCol) != null && board.getPiece(newRow, newCol).isWhite() == playerWhite){
                //Can't eat own piece
                System.out.println("Invalid move");
                continue;
            }
            if(p.isValidMove(row, col, newRow, newCol) && (p.isWhite() == playerWhite)){
                board.movePiece(row, col, newRow, newCol);
            }
        }
        
    }
}
