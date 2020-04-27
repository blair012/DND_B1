/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dnd;

/**
 *
 * @author gubotdev
 */
public class Roll {
    
    public static int d4(){
        return (int)(Math.random()*4) +1;
    }
    
    public static int d6(){
        return (int)(Math.random()*6) +1;
    }
    
    public static int d8(){
        return (int)(Math.random()*8) +1;
    }
    
    public static int d10(){
        return (int)(Math.random()*10) +1;
    }
    
    public static int d12(){
        return (int)(Math.random()*12) +1;
    }
    
    public static int d20(){
        return (int)(Math.random()*20) +1;
    }
}
