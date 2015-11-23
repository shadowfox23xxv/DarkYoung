/**
 * Dark Young - an interactive fiction horror game
 * Defines objects to act as a self-contained inventory for other objects 
 * @author bleakbriar
 */
import java.util.HashMap;
import java.util.Map;
import java.util.Iterator;

public class Inventory{
    //Class fields
    Map<Integer, Object> storage; //hashmap to actual store Items objects using ID as the key
    Map<String, Integer> keyStorage;//hashmap that links an Items object's name to it's ID for retreival
    
    //Class methods
    public void addItem(Items x){
        int ID = x.getID();
        String name = x.getName();
        storage.put(ID, x);
        keyStorage.put(name, ID);
    }
    //remove item by passing object reference
    public void removeItem(Items x){
        int ID = x.getID();
        String name = x.getName();
        if(storage.containsKey(ID)){
            storage.remove(ID);
        }
        if (keyStorage.containsKey(name)){
            keyStorage.remove(name);
        }
    }
    //remove item by passing item name
    public void removeItem(String name){
        int ID;
        if (keyStorage.containsKey(name)){
            ID = keyStorage.get(name);
            keyStorage.remove(name);
            storage.remove(ID);
        }
    }
    //pulls item from inventory and returns reference to the pulled item
    public Items getItem(String name){
        int ID;
        Object returnItem;
        if (keyStorage.containsKey(name)){
            ID = keyStorage.get(name);
            returnItem = storage.get(ID);
            this.removeItem(name);
            return ((Items)returnItem);
        }else {return null;}
    }
    //returns reference to item
    public Items copyItem(String name){
        int ID;
        Object returnItem;
        if (keyStorage.containsKey(name)){
            ID = keyStorage.get(name);
            returnItem = storage.get(ID);
            return ((Items)returnItem);
        }else {return null;}
    }
    
    public String[] listItems(){
        String[] returnArray = new String[keyStorage.size()];
        Iterator entries = keyStorage.entrySet().iterator();
        int i = 0;
        while(entries.hasNext()){
            Map.Entry entry = (Map.Entry) entries.next();
            String key = (String)entry.getKey();
            returnArray[i] = key;
            i ++;
        }
        return returnArray;
    }
     
    
    //constructor
    public Inventory(){
        storage = new HashMap();
        keyStorage = new HashMap();
        }
    
}