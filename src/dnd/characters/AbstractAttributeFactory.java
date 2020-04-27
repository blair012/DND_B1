/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dnd.characters;

import dnd.Roll;

/**
 *
 * @author gubotdev
 */
public abstract class AbstractAttributeFactory {
    public abstract int rollStrength();
    public abstract int rollDexterity();
    public abstract int rollConstitution();
    public abstract int rollIntelligence();
    public abstract int rollWisdom();
    public abstract int rollCharisma();
    
    public int rollAttribute(){
        int lowest = Roll.d6();
        int attScore = 0;
        for(int i = 0; i<3; i++){
            int roll = Roll.d6();
            if(roll < lowest){
                attScore+=lowest;
                lowest = roll;
            }else{
                attScore += roll;
            }
        }
        return attScore;
    }
}
