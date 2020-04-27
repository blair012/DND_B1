/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dnd.characters;

import dnd.dnditems.DnDWeapon;
import dnd.dnditems.Fists;
import java.awt.Point;
import javax.swing.Icon;

/**
 *
 * @author gubotdev
 */
public class Actor {
    public final String name, actorType, actorRace;
    protected String weaponName;
    protected int hitPoints, speed, armorClass;
    public Point loc;
    public Icon pic;
    public DnDWeapon weapon;
    
    public Actor(String name, String actorType, String actorRace){
        this.name = name;
        this.actorType = actorType;
        this.actorRace = actorRace;
        this.weapon = new Fists();
    }
    
    public Actor(String name, String actorType, String actorRace, DnDWeapon weapon){
        this.name = name;
        this.actorType = actorType;
        this.actorRace = actorRace;
        this.weapon = weapon;
    }
    
    public String getActorString(){
        return actorType + ": " + actorRace +"\nName: " + name
            + "\nArmor Class: " + armorClass + "\nWeapon: " + weaponName
            + "\nHealth: " + hitPoints;
    }
    
    public void takeDamage(int damage){
        hitPoints -= damage;
    }
    
    public int getHitPoints(){
        return hitPoints;
    }
    
    public DnDWeapon getWeapon(){
        return weapon;
    }
    
}
