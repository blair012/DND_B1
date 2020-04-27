/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dnd;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author gubotdev
 */
public class DnD {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        try {
            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
            Logger.getLogger(DnD.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        DnDBulletin bulletin = new DnDBulletin();
    }
    
}
