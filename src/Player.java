/**
 * Dark Young - an interactive fiction horror game
 * Defines objects to represent in game characters
 * @author bleakbriar
 */

public class Player extends Character{
    //class variables
    private int maxInventory;
   
    private Object scopeOfView; //holds reference to either Locations or Items.Props.Container class item
    public Inventory inventory = new Inventory();
    //class methods
    void changeLocation(Locations loc){
        currentLocation = loc;
        setSOV(loc);
    }
    
    int getMaxInventory(){
        return maxInventory;
    }
    
  
    
    Object getSOV(){
        return scopeOfView;
    }
    
    boolean isSOVLocation(){
        if (scopeOfView instanceof Locations){
            return true;
        }else {return false;}
    }
    
    void setSOV(Object x){
        scopeOfView = x;
    }
   /*!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
    uncomment once Conatainer class is created
     
    void setSOV(Container x){
        scopeOfView = x;
    }*/
    boolean inventoryEmpty(){
        return inventory.empty();
    }
    
    public void Player(){
        
    }
}