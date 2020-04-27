/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dungeonmaps;

import dnd.characters.Actor;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.JButton;

/**
 *
 * @author gubotdev
 */
public class MapSquare extends JButton{
    public String message;
    public final int row;
    public final int col;
    public boolean isOccuppied = false;
    public final boolean passable;
    public Actor occupant = null;
    private Icon img;
    public MapSquare(Icon img,int r, int c, boolean pass){
        super(img);
        this.img = img;
        row = r;
        col = c;
        passable = pass;
        this.setPreferredSize(new Dimension(35,35));
        this.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black));
    }
    
    public void resetIcon(){
        this.setIcon(img);
    }
    
}
