/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dnd.characters;

import dnd.characters.AbstractAttributeFactory;

/**
 *
 * @author gubotdev
 */
public class HumanAttributeFactory extends AbstractAttributeFactory{
    @Override
    public int rollStrength() {
        return rollAttribute() + RaceTraits.HUMAN_STRENGTH_BONUS;
    }

    @Override
    public int rollDexterity() {
        return rollAttribute() + RaceTraits.HUMAN_DEXTERITY_BONUS;
    }

    @Override
    public int rollConstitution() {
        return rollAttribute() + RaceTraits.HUMAN_CONSTITUTION_BONUS;
    }

    @Override
    public int rollIntelligence() {
        return rollAttribute() + RaceTraits.HUMAN_INTELLIGENCE_BONUS;
    }

    @Override
    public int rollWisdom() {
        return rollAttribute() + RaceTraits.HUMAN_WISDOM_BONUS;
    }

    @Override
    public int rollCharisma() {
        return rollAttribute() + RaceTraits.HUMAN_CHARISMA_BONUS;
    }
}
