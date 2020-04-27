/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dnd.dnditems;

/**
 *
 * @author gubotdev
 */
public abstract class DnDWeapon extends DnDItem{
    
    protected int damageBonus = 0;
    protected int rangeBonus = 0;
    public final String name;
    public final int range;
    public final String weaponType;
    
    public DnDWeapon(String name, String weaponType, int range){
        this.name = name;
        this.range = range;
        this.weaponType = weaponType;
    }
    
    public abstract int rollDamage();
    
    public int getRangeBonus(){
        return rangeBonus;
    }
    
    public int getDamageBonus(){
        return damageBonus;
    }
    
    public void setRangeBonus(int bonus){
        rangeBonus = bonus;
    }
    
    public void setDamageBonus(int bonus){
        damageBonus = bonus;
    }
}
