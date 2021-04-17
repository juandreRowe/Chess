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
public class Pawn extends Piece {
    
    public Pawn(boolean white){
        super('P', white);
    }
    
    @Override
    public boolean isValidMove(int oldRow, int oldCol, int newRow, int newCol){
        if(this.isWhite()){
            return newRow == oldRow - 1 && oldCol == newCol;
        }
        return newRow == oldRow + 1 && oldCol == newCol;
    }
    
}
