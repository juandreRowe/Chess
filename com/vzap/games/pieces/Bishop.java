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
public class Bishop extends Piece {
    
    public Bishop(boolean white){
        super('B', white);
    }
    
    @Override
    public boolean isValidMove(int oldRow, int oldCol, int newRow, int newCol){
        int rowDif = Math.abs(oldRow - newRow);
        int colDif = Math.abs(oldCol - newCol);
        return rowDif == colDif;
    }
}
