/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dnd.characters;

/**
 *
 * @author gubotdev
 */
public class Fighter extends DnDClass{

    @Override
    public int determineHitPoints(int modifier) {
        return ClassTraits.FIGHTER_BASE_HIT_POINTS + modifier;
    }
    
    
}
