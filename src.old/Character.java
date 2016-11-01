/**
 * Dark Young - an interactive fiction horror game
 * Defines objects to represent in game characters
 * @author bleakbriar
 */

public class Character{
    //class variables
    protected int health = 0;
    protected int maxHealth = 0;
    protected String name = "Bob";
    protected Locations currentLocation;
    public Inventory inventory;
    
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
    void setName(String newName){
        name = newName;
    }
    
    Locations getLocation(){
        return currentLocation;
    }
    
    void changeLocation(Locations loc){
        currentLocation = loc;
    }
    
}