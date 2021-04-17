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
public class Rook extends Piece {
    
    public Rook(boolean white){
        super('R', white);
    }
    
    @Override
    public boolean isValidMove(int oldRow, int oldCol, int newRow, int newCol){
        return (oldRow != newRow && oldCol == newCol) || (oldRow == newRow && oldCol != newCol);
    }
    
}
