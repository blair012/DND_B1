/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dnd;

import dnd.characters.DnDCharacter;

/**
 *
 * @author gubotdev
 */
public class DnDBulletin {
    
    private DnDGUI gui;
    private DungeonMaster dm;
    private DnDCharacter current;
    
    public DnDBulletin(){
        gui = new DnDGUI(this);
        dm = new DungeonMaster(this);
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                gui.start();
            }
        });
    }
    
    public DnDCharacter getCurrent(){
        return current;
    }
    
    public void setCurrent(DnDCharacter curr){
        current = curr;
        //gui.setCurrent(curr, message);
    }
    
    public void startGUI(){
        gui.start();
    }
    
}
