/**
 * Dark Young - an interactive fiction horror game
 * Defines objects to represent in game items
 * @author bleakbriar
 */

/*
Super class for all in game items.
*/

abstract public class Items{
    //class fields
    protected int ID;
    protected String name;
    protected String generalDescription;
    protected String detailedDescription;
    
    //class methods
    public int getID(){
        return this.ID;
    }
    
    public String getName(){
        return this.name;
    }
    
    public String getGeneralDescription(){
        return this.generalDescription;
    }
    
    public String getDetailedDescription(){
        return this.detailedDescription;
    }
    //abstract method. Implementation should return a copy of the Object calling it
    abstract Items getCopy(); 
    //default constructor
    public Items(){
    }
    //copy constructor
    public Items(Items item){
    this.ID = item.ID;
    this.name = item.name;
    this.generalDescription = item.generalDescription;
    this.detailedDescription = item.detailedDescription;
    }
}