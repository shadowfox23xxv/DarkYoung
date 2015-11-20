/**
 * Dark Young - an interactive fiction horror game
 * Defines objects to represent in game items
 * @author bleakbriar
 */
/*
Sub class of Items to define items that can be picked up by player
*/
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Collectible extends Items{
    //class static methods
    public static Items[] generateCollectibleItems(){
        Items[] itemSet = new Items[TOTAL_ITEMS];
        try{
            File file = new File("src/collectibleItems.txt");
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            int iterator = 0;
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] splitter = line.split(" ");
                int i = Integer.parseInt(splitter[0]);
                String n = splitter [1];
                boolean s;
                if (splitter[2].equals("true")){
                    s = true;
                }else {s = false;}
                boolean t;
                if (splitter[3].equals("true")){
                    t = true;
                }else {t = false;}
                boolean u;
                if (splitter[4].equals("true")){
                    u = true;
                }else {u = false;}
                boolean o;
                if (splitter[5].equals("true")){
                    o = true;
                }else {o = false;}
                int w = Integer.parseInt(splitter[6]);
                String g = bufferedReader.readLine();
                String d = bufferedReader.readLine();
                Collectible newItem = new Collectible(i, n, s, t, u, o, w, g, d); 
                itemSet[iterator] = newItem;
            }
            fileReader.close();
        } catch (IOException e) {
			e.printStackTrace();
        }
        return itemSet;
    }
    
    //class fields
    private boolean canSwing;
    private boolean canThrow;
    private boolean canUse;
    private boolean isOn;
    private int weight;
    final static int TOTAL_ITEMS = 1;
    
    //class methods
    public boolean canBeSwung(){
        return canSwing;
    }
    
    public boolean canBeThrown(){
        return canThrow;
    }
    
    public boolean canBeUsed(){
        return canUse;
    }
    
    public boolean isOn(){
        return isOn;
    }
    
    public int getWeight(){
        return weight;
    }
    
    public Collectible getCopy(){
        Collectible temp = new Collectible(this);
        return temp;
    }
    
    //constructor
    public Collectible (int i, String n, boolean s, boolean t, boolean u, boolean o, int w, String g, String d){
        ID = i;
        name = n;
        canSwing = s;
        canThrow = t;
        canUse = u;
        isOn = o;
        weight = w;
        generalDescription = g;
        detailedDescription = d;
        
    }
    
    //copy constructor
    public Collectible(Collectible item){
        this.ID = item.ID;
        this.name = item.name;
        this.canSwing = item.canSwing;
        this.canThrow = item.canThrow;
        this.canUse = item.canUse;
        this.isOn = item.isOn;
        this.weight = item.weight;
        this.generalDescription = item.generalDescription;
        this.detailedDescription = item.detailedDescription;
    }
}