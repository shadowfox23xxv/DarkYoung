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
    
    //constructor
    public Items(String str, boolean pick, boolean throwable, boolean swing, boolean use, boolean prop, int w){
        name = str;
        canPickUp = pick;
        canThrow = throwable;
        canSwing = swing;
        canUse = use;
        isProp = prop;
        weight = w;
    }
    //item generation-----------------------------------------------------------
    static Items generateNote(){
        Items note = new Items("Note", true, false, false, false, false, 0);
        return note;
    }
    static Items generateFlashLight(){
        Items flashLight = new Items("Flash light", true, true, true, true, false, 2);
        return flashLight;
    }
}