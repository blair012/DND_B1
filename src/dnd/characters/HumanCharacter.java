/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dnd.characters;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;


/**
 *
 * @author gubotdev
 */
public class HumanCharacter extends DnDCharacter{
    
    public HumanCharacter(String name, DnDClass charClass) {
        super(name, "Human", new HumanAttributeFactory(), charClass);
        speed = 30;
        try {
            pic = new ImageIcon(ImageIO.read(new File("img//shrek.png")));
        } catch (IOException ex) {
            Logger.getLogger(HumanCharacter.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
