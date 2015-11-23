/**
 * Dark Young - an interactive fiction horror game
 * Defines objects to represent in game characters
 * @author bleakbriar
 */

public class Player extends Character{
    //class variables
    private int maxInventory;
    private Items equiped = null;
    
    //class methods
    int getMaxInventory(){
        return maxInventory;
    }
    
    Items getEquipedItem(){
        return equiped;
    }
    
    void equipItem(Items item){
        equiped = item;
    }
    
}