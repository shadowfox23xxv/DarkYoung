/**
 * Dark Young - an interactive fiction horror game
 * Defines objects to represent in game items
 * @author bleakbriar
 */

/*
Item: objects repressenting in game objects. 
Pickupable, throwable, swingable, useable, on, weight, prop
*/

public class Items{
    //class variables
    private String name;
    private boolean canPickUp;
    private boolean canThrow;
    private boolean canSwing;
    private boolean canUse;
    private boolean isOn = false;
    private boolean isProp;
    private int weight;
    private String description;
        
    //class methods
    boolean getCanPickUp(){
        return canPickUp;
    }
    boolean getCanThrow(){
        return canThrow;
    }
    boolean getCanSwing(){
        return canSwing;
    }
    boolean getCanUse(){
        return canUse;
    }
    boolean getIsOn(){
        return isOn;
    }
    boolean getIsProp(){
        return isProp;
    }
    int getWeight(){
        return weight;
    }
    String getName(){
        return name;
    }
    String getDescription(){
        return description;
    }
    
    //constructor
    public Items(String str, boolean pick, boolean throwable, boolean swing, boolean use, boolean prop, int w, String desc){
        name = str;
        canPickUp = pick;
        canThrow = throwable;
        canSwing = swing;
        canUse = use;
        isProp = prop;
        weight = w;
        description = desc;
    }
    //item generation-----------------------------------------------------------
    static Items generateNote(){
        Items note = new Items("note", true, false, false, false, false, 0, "A small piece of crumpled paper with some writting on it.  It's hard to read, but it appears to be some kind of warning...");
        return note;
    }
    static Items generateFlashLight(){
        Items flashLight = new Items("flashlight", true, true, true, true, false, 2, "A plan flashlight, with a black chrome finish.");
        return flashLight;
    }
}