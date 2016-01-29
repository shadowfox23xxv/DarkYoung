/**
 * Dark Young - an interactive fiction horror game
 * Defines objects to represent individual location cells
 * @author bleakbriar
 */
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
//!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
//removed z and i coordinate realted code.  Unnecessary for debug map
//and complicating debug process.
//Needs to be re-added later
//!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
public class Locations{
    //member variables
    static final int NUMBER_OF_ROOMS = 9;
    static int totalNumberOfRooms = 0;
    //boolean flags to show is exit exists
    boolean hasNorthExit = false;
    boolean hasEastExit = false;
    boolean hasSouthExit = false;
    boolean hasWestExit = false;
    boolean hasInOutExit = false;
    boolean hasUpDownExit = false;
    //boolean flags to show if exit is inaccessible
    boolean northIsLocked = false;
    boolean eastIsLocked = false;
    boolean southIsLocked = false;
    boolean westIsLocked = false;
    boolean inOutIsLocked = false;
    boolean upDownIsLocked = false;
    //east/west coordinate
    int xCoordinate = 0;
    //north/south coordinate
    int yCoordinate = 0;
    
    //holds reference to location object in given direction
    Locations northExit = null;
    Locations eastExit = null;
    Locations southExit = null;
    Locations westExit = null;
 
    String roomGeneralDescription = "Blank";
    String roomDetailedDescription = "Blank";
    Inventory inventory;
    

    //member methods
    String getRoomGeneralDescription(){
        return this.roomGeneralDescription;
    }    
    
    String getRoomDetailedDescription(){
        return this.roomDetailedDescription;
    }
    
    //Constructor
    public Locations(boolean hne, boolean hee, boolean hse, boolean hwe, boolean nil, boolean eil, boolean sil, boolean wil, int x, int y, String rgd, String rdd){
        totalNumberOfRooms += 1;
        hasNorthExit = hne;
        hasEastExit = hee;
        hasSouthExit = hse;
        hasWestExit = hwe;
        northIsLocked = nil;
        eastIsLocked = eil;
        southIsLocked = sil;
        westIsLocked = wil;
        xCoordinate = x;    
        yCoordinate = y; 
        roomGeneralDescription = rgd;
        roomDetailedDescription = rdd;
        inventory = new Inventory();
    }
    
    //generates the Locations for debug map
   static private Locations[] generateDebugMapLocations(){
        Locations[] locationSet = new Locations[NUMBER_OF_ROOMS];
        try{
            File file = new File("src/debugMap.txt");
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            int iterator = 0;
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] splitter = line.split(" ");
                boolean hne = splitter[0].equals("true");
                boolean hee = splitter[1].equals("true");
                boolean hse = splitter[2].equals("true");
                boolean hwe = splitter[3].equals("true");
                boolean nil = splitter[4].equals("true");
                boolean eil = splitter[5].equals("true");
                boolean sil = splitter[6].equals("true");
                boolean wil = splitter[7].equals("true");   
                int x = Integer.parseInt(splitter[8]);
                int y = Integer.parseInt(splitter[9]);
                String rgd = bufferedReader.readLine();
                String rdd = bufferedReader.readLine();
                Locations newLocation = new Locations(hne, hee, hse, hwe, nil, eil, sil, wil, x, y, rgd, rdd); 
                locationSet[iterator] = newLocation;
                iterator += 1;
            }
            fileReader.close();
        } catch (IOException e) {
			e.printStackTrace();
        }
        return locationSet;
   }
    
    //build debug map by linking locations created by generateDebugMapLocations()
    static public Locations[] generateDebugMap(){
        Locations[] locArray = generateDebugMapLocations();
        int length = locArray.length;
        int iterator = 0;
        while (iterator < length){
            Locations check = locArray[iterator]; 
            if (check.hasNorthExit){
                boolean keepLooping = true;
                int internalIterator = 0;
                while (keepLooping && internalIterator < locArray.length){
                    Locations checkAgainst = locArray[internalIterator];
                    int y = checkAgainst.yCoordinate - 1;
                    if (check.xCoordinate == checkAgainst.xCoordinate && check.yCoordinate == y){
                        check.northExit = checkAgainst;
                        keepLooping = false;
                    }else {internalIterator += 1;}    
                }
                //prints to screen which locations are having issues in linking process
                if (internalIterator >= locArray.length){
                    System.out.println("Map generation failed at location " + iterator);
                }
            }
            if (check.hasEastExit){
                boolean keepLooping = true;
                int internalIterator = 0;
                while (keepLooping && internalIterator < locArray.length){
                    Locations checkAgainst = locArray[internalIterator];
                    int x = checkAgainst.xCoordinate - 1;
                    if (check.xCoordinate == x && check.yCoordinate == checkAgainst.yCoordinate){
                        check.eastExit = checkAgainst;
                        keepLooping = false;
                    }else {internalIterator += 1;}    
                }
                if (internalIterator >= locArray.length){
                    System.out.println("Map generation failed at location " + iterator);
                }
            }
            if (check.hasSouthExit){
                boolean keepLooping = true;
                int internalIterator = 0;
                while (keepLooping && internalIterator < locArray.length){
                    Locations checkAgainst = locArray[internalIterator];
                    int y = checkAgainst.yCoordinate + 1;
                    if (check.xCoordinate == checkAgainst.xCoordinate && check.yCoordinate == y){
                        check.southExit = checkAgainst;
                        keepLooping = false;
                    }else {internalIterator += 1;}    
                }
                if (internalIterator >= locArray.length){
                    System.out.println("Map generation failed at location " + iterator);
                }
            }    
            if (check.hasWestExit){
                boolean keepLooping = true;
                int internalIterator = 0;
                while (keepLooping && internalIterator < locArray.length){
                    Locations checkAgainst = locArray[internalIterator];
                    int x = checkAgainst.xCoordinate + 1;
                    if (check.xCoordinate == x && check.yCoordinate == checkAgainst.yCoordinate){
                        check.westExit = checkAgainst;
                        keepLooping = false;
                    }else {internalIterator += 1;}    
                }
                if (internalIterator >= locArray.length){
                    System.out.println("Map generation failed at location " + iterator);
                }
            }
            iterator += 1;
        }
        return locArray;
    }
    
    public static Locations getLocationAtXY(Locations[] map, int x, int y){
        int iterator = 0;
        while ( iterator < totalNumberOfRooms){
            if (map[iterator].xCoordinate == x && map[iterator].yCoordinate == y){
                return map[iterator];
            }
            iterator++;
        }
        return null;
    }
    
    public Locations(){
        totalNumberOfRooms++;
    }
}
