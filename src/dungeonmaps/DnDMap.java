/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dungeonmaps;

import dnd.characters.Monster;
import java.awt.Point;
import java.util.ArrayList;

/**
 *
 * @author gubotdev
 */
public class DnDMap {
    public final String title;
    public static ArrayList<String>mapNames; 
    public static ArrayList<DnDMap> maps;
    public WallSquare[] wallSquares;
    public FloorTrapSquare[] traps;
    public Monster[] monsters;
    public DirtFloorSquare[] dirtFloor;
    public MapSquare[] misc;
    public DnDMap(String title){
        this.title = title;
        if(mapNames == null){
            mapNames = new ArrayList();
        }
        mapNames.add(title);
        if(maps == null){
            maps = new ArrayList();
        }
        maps.add(this);
    }
}
