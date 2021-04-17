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
public class Person {
    private String name;
    
    public Person(String name){
        this.setName(name);
    }
    
    public final String getName(){
        return this.name;
    }
    
    public final void setName(String name){
        this.name = name;
    }
    
    @Override
    public String toString(){
        return "Name: " + this.name;
    }
}