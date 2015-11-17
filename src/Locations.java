/**
 * Dark Young - an interactive fiction horror game
 * Defines objects to represent individual location cells
 * @author bleakbriar
 */

public class Locations{
    //member variables
    static int totalNumberOfRooms = 0;
    int numberOfExits;
    Locations northExit = null;
    Locations eastExit = null;
    Locations southExit = null;
    Locations westExit = null;
    Locations upExit = null;
    Locations downExit = null;
    String roomGeneralDescription = "Blank";
    String roomDescription = "Blank";
    

    //member methods
    String getRoomGeneralDescription(){
        return this.roomGeneralDescription;
    }    
    
    String getRoomDescription(){
        return this.roomDescription;
    }
    
    //constructor to more easily create objects
    public Locations(int exit, String description, String generalDescription){
    totalNumberOfRooms += 1;
    numberOfExits = exit;
    roomDescription = description;
    roomGeneralDescription = generalDescription;
    }
    //default constuctor
    public Locations(){
        totalNumberOfRooms += 1;
    }
    
    //generates the given number of Locations obejcts, with pointers stored in a returned 
    //array.
    Locations[] createLocations(int x){
        int iterate = 0;
        int loopMax = x;
        Locations[] arrayOfLocations = new Locations[x -1];
        while (iterate <= loopMax){
            int index = iterate -1;
            arrayOfLocations[index] = new Locations();
            iterate += 1;
        }
        return arrayOfLocations;
    }
    
    //build debug map
    public Locations[] generateDebugMap(){
        Locations[] map = createLocations(1);
        map[0].numberOfExits = 0;
        map[0].roomGeneralDescription = "You are standing in a small, dimly lit bedroom, with one door to the south, and a window to the north.";
        map[0].roomDescription = "The room is dirty. Dust covers the bed and small dresser inside.  The only light comes from the moon outside, shining through a tattered curtain hung over the window.  There is a single door to the south.";
        return map;
    }    
}
