/**
 * Dark Young - an interactive fiction horror game
 * Defines objects to act as a self-contained inventory for other objects 
 * @author bleakbriar
 */
import java.util.HashMap;
import java.util.Map;
import java.util.Iterator;
import java.util.Arrays;

public class Inventory{
    //Class fields
    private Map<Integer, Items> storage; //hashmap to actual store Items objects using ID as the key
    private Map<String, Integer> keyStorage;//hashmap that links an Items object's name to it's ID for retreival
    
    //Class methods-------------------------------------------------------------
    //accepts item name and returns item key
    private int getKey(String name){
        if (keyStorage.containsKey(name)){
            return keyStorage.get(name);
        }else {return 0;}
    }

    //passes an item object to add it to the current inventory
    public void addItem(Items x){
        int ID = x.getID();
        String name = x.getName();
        storage.put(ID, x);
        keyStorage.put(name, ID);
    }
    /*
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
    }*/
    /*
    //remove item by passing item name
    public void removeItem(String name){
        int ID;
        if (keyStorage.containsKey(name)){
            ID = keyStorage.get(name);
            keyStorage.remove(name);
            storage.remove(ID);
        }
    }*/
    //takes item ID and removes that item from the inventory
    public void removeItem(int id){
        if (storage.containsKey(id)){
            Items item = storage.get(id);
            storage.remove(id);
            keyStorage.remove(item.getName());
            
        }
    }
    /*
    //removes item from inventory and returns reference to the pulled item
    public Items getItem(String name){
        int ID;
        //Object returnItem;//commented out to test change of storage to <Integer, Items>
        Items returnItem;
        if (keyStorage.containsKey(name)){
            ID = keyStorage.get(name);
            returnItem = storage.get(ID);
            this.removeItem(name);
            //return ((Items)returnItem);//commented out to test change of storage to <Integer, Items>
            return returnItem;
        }else {return null;}
    }*/
    //accepts item ID, and if that item is in inventory, removes it and returns the object
    public Items takeItem(int id){
        Items returnItem;
        if (storage.containsKey(id)){
            returnItem = storage.get(id);
            this.removeItem(id);
            return returnItem;
        }else {return null;}
    }
    public Items takeItem(String name){
        return this.takeItem(this.getKey(name));
    }
        
    
    //returns reference to item in inventory by name
    public Items getItemReference(String name){
        return this.getItemReference(this.getKey(name));
    }
    
   //returns reference to item in inventory by ID
    public Items getItemReference(int id){
        Items returnItem;
        if (storage.containsKey(id)){
            returnItem = storage.get(id);
            return returnItem;
        }else {return null;}
        
    }
    public String[] listItems(){//returns an array containing the names of all items in inventory
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
    
    public Items[] itemsInInventory(){//returns array containing object reference to all items in inventory
        Items[] returnArray = new Items[storage.size()];
        Iterator entries = storage.entrySet().iterator();
        int i = 0;
        while(entries.hasNext()){
            Map.Entry entry = (Map.Entry) entries.next();
            Items value = (Items)entry.getValue();
            returnArray[i] = value;
            i ++;
        }
        return returnArray;
    }
 
     
   
    
    public boolean contains(String str){
        boolean doesItContain = Arrays.asList(listItems()).contains(str);
        return doesItContain;
    }
    
    public boolean empty(){
        return storage.isEmpty();
    }
    
    //constructor
    public Inventory(){
        storage = new HashMap();
        keyStorage = new HashMap();
        }
    
}