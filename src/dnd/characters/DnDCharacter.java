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
public class DnDCharacter extends Actor{
    private int strength;
    private int dexterity;
    private int constitution;
    private int intelligence;
    private int wisdom;
    private int charisma;
    
    public DnDCharacter(String name, String actorRace, AbstractAttributeFactory factory, DnDClass charClass){
        super(name, "Character", actorRace);
        initCharacter(factory, charClass);
    }
    
    
    
    public final void initCharacter(AbstractAttributeFactory factory, DnDClass charClass){
        strength = factory.rollStrength();
        dexterity = factory.rollDexterity();
        constitution = factory.rollConstitution();
        intelligence = factory.rollIntelligence();
        wisdom = factory.rollWisdom();
        charisma = factory.rollCharisma();
        
        hitPoints = charClass.determineHitPoints(calculateAbilityModifier(constitution));
        armorClass = 10 + calculateAbilityModifier(dexterity);
    }
    
    protected int calculateAbilityModifier(int ability){
        return (ability-10)/2;
    }
    
    public int getStrength(){
        return strength;
    }
    public int getDexterity(){
        return dexterity;
    }
    public int getConstitution(){
        return constitution;
    }
    public int getIntelligence(){
        return intelligence;
    }
    public int getWisdom(){
        return wisdom;
    }
    public int getCharisma(){
        return charisma;
    }
    public int getSpeed(){
        return speed;
    }
    public int getArmorClass(){
        return armorClass;
    }
}
