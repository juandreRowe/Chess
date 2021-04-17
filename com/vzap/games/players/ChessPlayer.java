/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vzap.games.players;

/**
 *
 * @author juandre
 */
public class ChessPlayer extends Person {
    
    private int score;
    private final boolean whitePieceColor;
    
    public ChessPlayer(String name, boolean whitePieceColor){
        super(name);
        this.setScore(0);
        this.whitePieceColor = whitePieceColor;
    }
    
    public final boolean isWhitePieceColor(){
        return this.whitePieceColor;
    }
    
    public final int getScore(){
        return this.score;
    }
    
    public final void setScore(int score){
        if(score < 0){
            score = 0;
        }
        this.score = score;
    }
    
    public void play(){
        System.out.println(this.getName() + " is thinking...");
    }
    
    @Override 
    public String toString(){
        return super.toString() + ", score: " + this.score + ", white: " + this.whitePieceColor;
    }
}