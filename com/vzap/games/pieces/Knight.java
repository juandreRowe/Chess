/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vzap.games.pieces;

/**
 *
 * @author juandre
 */
public class Knight extends Piece {
    
    public Knight(boolean white){
        super('h', white);
    }
    
    
    @Override
    public boolean isValidMove(int oldRow, int oldCol, int newRow, int newCol){
        int rowDiff = Math.abs(oldRow - newRow);
        int colDiff = Math.abs(oldCol - newCol);
        return (rowDiff == 2 && colDiff == 1) || (rowDiff == 1 && colDiff == 2);
    }
}
