/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dungeonmaps;

import java.awt.Color;

/**
 *
 * @author gubotdev
 */
public class WallSquare extends MapSquare{
    
    public WallSquare(int row, int column) {
        super(null, row, column, false);
        this.setBackground(Color.darkGray);
        this.message= "An old stone wall, obviously been here a while.";
    }
    
}
