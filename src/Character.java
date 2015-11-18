/**
 * Dark Young - an interactive fiction horror game
 * Defines objects to represent in game characters
 * @author bleakbriar
 */

public class Character{
    //class variables
    private int health = 0;
    private int maxHealth = 0;
    private String name = "Bob";
    private Locations currentLocation;
    //!!!!!!!!!!!!!!!!!!!add inventory
    
    //class methods
    int getHealth(){
        return health;
    }
    int getMaxHealth(){
        return maxHealth;
    }
    void changeHealth(int x){
        health = health + x;
    }
    
    String getName(){
        return name;
    }
    
    Locations getLocation(){
        return currentLocation;
    }
    
    void changeLocation(Locations loc){
        currentLocation = loc;
    }
    
    //!!!!!!!!!!!!!add methods related to inventory
}