/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dnd;

import dnd.characters.DnDCharGUI;
import dnd.characters.DnDCharacter;
import java.util.ArrayList;

/**
 *
 * @author gubotdev
 */
public class DungeonMaster {
    private final DnDBulletin bulletin;
    
    private ArrayList<DnDCharacter> party = new ArrayList();
    private int next = 0;
    public DungeonMaster(DnDBulletin bulletin){
        this.bulletin = bulletin;
        createParty();
    }
    
    public void createParty(){
        DnDCharGUI.createAndShowGUI("GameSetup", party);
    }
    
    private void rollInitiative(){
        
    }
    
    public DnDCharacter getNextCharacter(){
        if(next >= party.size()){
            rollInitiative();
            next = 0;
        }
        return party.get(next);
    }
    
    public void killCharacter(DnDCharacter fallen){
        party.remove(fallen);
    }
}
