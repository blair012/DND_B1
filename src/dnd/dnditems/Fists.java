/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dnd.dnditems;

import dnd.Roll;

/**
 *
 * @author gubotdev
 */
public class Fists extends DnDWeapon{

    public Fists() {
        super("Fists", ItemTypes.FISTS, 1);
    }

    @Override
    public int rollDamage() {
         return Roll.d4();
    }
    
}
