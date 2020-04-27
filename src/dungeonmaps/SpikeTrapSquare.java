/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dungeonmaps;

import java.io.IOException;

/**
 *
 * @author gubotdev
 */
public class SpikeTrapSquare extends FloorTrapSquare{
    
    public SpikeTrapSquare(int r, int c) throws IOException {
        super(1, r, c);
        this.message = "You stepped on a spike trap... it hurts!";
    }
    
}
