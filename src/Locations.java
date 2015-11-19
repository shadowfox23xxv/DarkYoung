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
    
    //default constuctor
    public Locations(){
        totalNumberOfRooms += 1;
    }
    
    //generates the given number of Locations obejcts, with pointers stored in a returned 
    //array.
    Locations[] createLocations(int x){
        int iterate = 0;
        int loopMax = x;
        Locations[] arrayOfLocations = new Locations[x];
        while (iterate < loopMax){
            int index = iterate;
            arrayOfLocations[index] = new Locations();
            iterate += 1;
        }
        return arrayOfLocations;
    }
    
    //build debug map
    public Locations[] generateDebugMap(){
        Locations[] map = createLocations(4);
        map[0].numberOfExits = 1;
        map[0].roomGeneralDescription = "You are standing in a small, dimly lit bedroom, with one door to the south, and a window to the north.";
        map[0].roomDescription = "The room is dirty. Dust covers the bed and small dresser inside.  The only light comes from the moon outside, shining through a tattered curtain hung over the window.  There is a single door to the south.";
        map[0].southExit = map[1];
        map[1].numberOfExits = 2;
        map[1].roomGeneralDescription = "You enter a darkened hallway that extends to the east. There is a door to the north.";
        map[1].roomDescription = "You are standing in a darkend hallway that extends to the east. There is a door to the north.";
        map[1].northExit = map[0];
        map[1].eastExit = map[2];
        map[2].numberOfExits = 2;
        map[2].roomGeneralDescription = "You enter a dim hallway that extends to the west. There is a door to the south.";
        map[2].roomDescription = "You are standing in a dim hallway that extends to the west. Set at the near end of the hallway is a small, dirty window. There is a door to the south.";
        map[2].westExit = map[1];
        map[2].southExit = map[3];
        map[3].numberOfExits = 1;
        map[3].roomGeneralDescription = "You enter a den, with simple furniture.  A couch, an endtable, and a fireplace. There is a door to the north, and a thicker, heavier door to the south.";
        map[3].roomDescription = "It's a simple room, dusty and sprinkled with cobwebs.  The couch and endtable looks like it hasn't been used in ages.  The fireplace is dark, and the southern door is heavily boarded.";
        map[3].northExit = map[2];
        return map;
    }    
}
