/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dungeonmaps;

import dnd.characters.Monster;
import dnd.dnditems.DnDItem;
import dnd.dnditems.RustySword;
import dungeonmaps.DnDMap;
import java.awt.Point;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author gubotdev
 */
public class MarksMap extends DnDMap{
    
    public MarksMap() {
        super("MarksMap");
        this.setWallSquares();
        this.getMonsters();
        
        try {
            this.getDirtFloor();
            this.getTraps();
            this.setMisc();
        } catch (IOException ex) {
            Logger.getLogger(MarksMap.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void setWallSquares() {
        WallSquare[] walls = {
            //outside walls
            ////north wall
            new WallSquare(0,0),
            new WallSquare(0,1),
            new WallSquare(0,2),
            new WallSquare(0,3),
            new WallSquare(0,4),
            new WallSquare(0,5),
            new WallSquare(0,6),
            new WallSquare(0,7),
            new WallSquare(0,8),
            new WallSquare(0,9),
            new WallSquare(0,10),
            ////exit
            //new WallSquare(0,11),
            //new WallSquare(0,12),
            ////end exit
            new WallSquare(0,13),
            new WallSquare(0,14),
            new WallSquare(0,15),
            new WallSquare(0,16),
            new WallSquare(0,17),
            new WallSquare(0,18),
            new WallSquare(0,19),
            ////east wall
            new WallSquare(1,19),
            new WallSquare(2,19),
            new WallSquare(3,19),
            new WallSquare(4,19),
            new WallSquare(5,19),
            new WallSquare(6,19),
            new WallSquare(7,19),
            new WallSquare(8,19),
            new WallSquare(9,19),
            new WallSquare(10,19),
            new WallSquare(11,19),
            new WallSquare(12,19),
            new WallSquare(13,19),
            new WallSquare(14,19),
            new WallSquare(15,19),
            new WallSquare(16,19),
            new WallSquare(17,19),
            ////entrance
            //new WallSquare(18,19),
            //new WallSquare(19,19),
            ////end east wall
            
            ////south wall
            new WallSquare(19,0),
            new WallSquare(19,1),
            new WallSquare(19,2),
            new WallSquare(19,3),
            new WallSquare(19,4),
            new WallSquare(19,5),
            new WallSquare(19,6),
            new WallSquare(19,7),
            new WallSquare(19,8),
            new WallSquare(19,9),
            //entrance cliff on the side of mountain
            /*
            new WallSquare(19,10),
            new WallSquare(19,11),
            new WallSquare(19,12),
            new WallSquare(19,13),
            new WallSquare(19,14),
            new WallSquare(19,15),
            new WallSquare(19,16),
            new WallSquare(19,17),
            new WallSquare(19,18),
            new WallSquare(19,19),
            */
            ////end south wall
            
            ////weast wall
            new WallSquare(1,0),
            new WallSquare(2,0),
            new WallSquare(3,0),
            new WallSquare(4,0),
            new WallSquare(5,0),
            new WallSquare(6,0),
            new WallSquare(7,0),
            new WallSquare(8,0),
            new WallSquare(9,0),
            new WallSquare(10,0),
            new WallSquare(11,0),
            new WallSquare(12,0),
            new WallSquare(13,0),
            new WallSquare(14,0),
            new WallSquare(15,0),
            new WallSquare(16,0),
            new WallSquare(17,0),
            new WallSquare(18,0),
            
            ////end west wall
            
            new WallSquare(1,13),
            new WallSquare(2,13),
            new WallSquare(3,6),
            new WallSquare(3,7),
            new WallSquare(3,8),
            new WallSquare(3,9),
            new WallSquare(3,10),
            new WallSquare(3,11),
            new WallSquare(3,12),
            new WallSquare(3,13),
            new WallSquare(3,16),
            new WallSquare(3,17),
            new WallSquare(3,18),
            new WallSquare(4,6),
            new WallSquare(5,6),
            new WallSquare(6,6),
            new WallSquare(7,6),
            new WallSquare(7,9),
            new WallSquare(7,10),
            new WallSquare(7,11),
            new WallSquare(7,12),
            new WallSquare(7,13),
            new WallSquare(7,14),
            new WallSquare(7,15),
            new WallSquare(7,16),
            new WallSquare(8,3),
            new WallSquare(8,4),
            new WallSquare(8,5),
            new WallSquare(8,6),
            new WallSquare(8,9),
            new WallSquare(9,9),
            new WallSquare(10,9),
            new WallSquare(10,12),
            new WallSquare(10,13),
            new WallSquare(10,14),
            new WallSquare(10,15),
            new WallSquare(10,16),
            new WallSquare(10,17),
            new WallSquare(10,18),
            new WallSquare(11,1),
            new WallSquare(11,2),
            new WallSquare(11,3),
            new WallSquare(11,4),
            new WallSquare(11,5),
            new WallSquare(11,6),
            new WallSquare(11,9),
            new WallSquare(12,9),
            new WallSquare(13,9),
            new WallSquare(13,12),
            new WallSquare(13,13),
            new WallSquare(13,14),
            new WallSquare(13,15),
            new WallSquare(13,18),
            new WallSquare(14,9),
            new WallSquare(14,12),
            new WallSquare(15,9),
            new WallSquare(15,12),
            new WallSquare(16,9),
            new WallSquare(16,12),
            new WallSquare(17,9),
            new WallSquare(17,12),
            new WallSquare(17,13),
            new WallSquare(17,14),
            new WallSquare(17,15),
            new WallSquare(17,16),
            new WallSquare(17,17),
            new WallSquare(17,18),
            new WallSquare(18,9)
            
        };
        wallSquares = walls;
    }
    
    public void getMonsters() {
        Monster[] monsters = {};
        this.monsters = monsters;
    }
    
    public void getTraps() throws IOException{
        FloorTrapSquare[] traps = {
            new SpikeTrapSquare(9,6),
            new SpikeTrapSquare(6,16),
            new SpikeTrapSquare(4,13),
            new SpikeTrapSquare(3,4),
            new SpikeTrapSquare(2,16),
            new SpikeTrapSquare(1,16)
        };
        this.traps = traps;
    }
    
    public void getDirtFloor() throws IOException{
        DirtFloorSquare[] dirtFloor = {
            new DirtFloorSquare(0,11),
            new DirtFloorSquare(0,12),
            new DirtFloorSquare(17,10),
            new DirtFloorSquare(17,11),
            new DirtFloorSquare(18,10),
            new DirtFloorSquare(19,10),
            new DirtFloorSquare(18,11),
            new DirtFloorSquare(19,11),
            new DirtFloorSquare(18,12),
            new DirtFloorSquare(19,12),
            new DirtFloorSquare(18,13),
            new DirtFloorSquare(19,13),
            new DirtFloorSquare(18,14),
            new DirtFloorSquare(19,14),
            new DirtFloorSquare(18,15),
            new DirtFloorSquare(19,15),
            new DirtFloorSquare(18,16),
            new DirtFloorSquare(19,16),
            new DirtFloorSquare(18,17),
            new DirtFloorSquare(19,17),
            new DirtFloorSquare(18,18),
            new DirtFloorSquare(19,18),
            new DirtFloorSquare(18,19),
            new DirtFloorSquare(19,19),
            
        };
        this.dirtFloor = dirtFloor;
    }
    
    public void setMisc() throws IOException{
        ChestSquare myChest = new ChestSquare(15,17);
        myChest.inventory = new DnDItem[1];
        myChest.inventory[0] = new RustySword();
        MapSquare[] misc = {
            myChest
        };
        this.misc = misc;
    } 
    
    
    
}
