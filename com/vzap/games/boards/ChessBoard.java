/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vzap.games.boards;

import com.vzap.games.pieces.King;
import com.vzap.games.pieces.Knight;
import com.vzap.games.pieces.Piece;
import com.vzap.games.pieces.Pawn;
import com.vzap.games.pieces.Queen;
import com.vzap.games.pieces.Rook;
import com.vzap.games.pieces.Bishop;

/**
 *
 * @author juandre
 */
public final class ChessBoard {

    private final String ANSI_RESET = "\u001B[0m";
    private final String ANSI_RED = "\u001B[36m";
    private final String ANSI_CYAN = "\u001B[32m";
    private final int ROWS;
    private final int COLS;
    private Piece[][] board;
    private int turns;

    public ChessBoard() {
        ROWS = 8;
        COLS = 8;
        resetBoard();
    }
    
    public boolean isWinner(){
        return false;
    }
    
    public boolean hasPiece(int r, int c){
        if(!isInRange(r, c)){
            return false;
        }
        return board[r][c] != null;
    }
    
    public boolean isInRange(int r, int c){
        return r >= 0 && r < ROWS && c >= 0 && c < COLS;
    }
    
    public Piece getPiece(int r, int c){
        if(this.hasPiece(r, c)){
            return board[r][c];
        }
        return null;
    }
    
    public void movePiece(int r, int c, int newR, int newC){
        board[newR][newC] = board[r][c];
        board[r][c] = null;
        turns++;
    }

    public int getTurns() {
        return this.turns;
    }

    public void setTurns(int turns) {
        this.turns = turns;
    }

    public void resetBoard() {
        board = new Piece[ROWS][COLS];
        this.setTurns(0);
        for (Piece[] row : board) {
            for (int x = 0; x < row.length; x++) {
                row[x] = null;
            }
        }
        placePieces();
    }

    private void placePieces() {
        //Fill pawns for both sides
        int row = ROWS - 2;
        for (int x = 0; x < COLS; x++) {
            board[row][x] = new Pawn(true);
        }
        row = 1;
        for (int x = 0; x < COLS; x++) {
            board[row][x] = new Pawn(false);
        }

        //Place kings
        board[7][4] = new King(true);
        board[0][3] = new King(false);

        //Place Queens
        board[7][3] = new Queen(true);
        board[0][4] = new Queen(false);

        //Place Rooks
        board[0][0] = new Rook(false);
        board[0][COLS - 1] = new Rook(false);
        board[ROWS - 1][0] = new Rook(true);
        board[ROWS - 1][COLS - 1] = new Rook(true);
        
        //Place knights
        board[0][1] = new Knight(false);
        board[0][COLS - 2] = new Knight(false);
        board[ROWS - 1][1] = new Knight(true);
        board[ROWS - 1][COLS - 2] = new Knight(true);
        
        //Place bishops
        board[0][2] = new Bishop(false);
        board[0][COLS - 3] = new Bishop(false);
        board[ROWS - 1][2] = new Bishop(true);
        board[ROWS - 1][COLS - 3] = new Bishop(true);
    }

    public void printBoard() {
        System.out.print("   ");
        for (int x = 0; x < ROWS; x++) {
            System.out.print(x + "  ");
        }
        System.out.println("");
        for (int y = 0; y < ROWS; y++) {
            System.out.print(y + "  ");
            for (Piece p : board[y]) {
                if (p != null) {
                    String color = (p.isWhite()) ? ANSI_CYAN : ANSI_RED;
                    System.out.print(color + p.getMark() + "  " + ANSI_RESET);
                } else {
                    System.out.print("-  ");
                }
            }
            System.out.println("\n");
        }
    }
}
