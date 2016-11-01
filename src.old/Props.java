/**
 * Dark Young - an interactive fiction horror game
 * Defines objects to represent in game items
 * @author bleakbriar
 */

/*
Sub class of Items to define items that cannot be picked up by player
such as furniture 
*/
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Props extends Items{
//static class methods
    public static Items[] generatePropItems(){
        Items[] itemSet = new Items[TOTAL_ITEMS];
        try{
            File file = new File("src/propItems.txt");
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            int iterator = 0;
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] splitter = line.split(" ");
                int i = Integer.parseInt(splitter[0]);
                String n = splitter[1];
                String g = bufferedReader.readLine();
                String d = bufferedReader.readLine();                
                Props newItem = new Props(i, n, g, d); 
                itemSet[iterator] = newItem;
                iterator += 1;
            }
            fileReader.close();
        } catch (IOException e) {
			e.printStackTrace();
        }
        return itemSet;
    }
//class fields
    final static int TOTAL_ITEMS = 12;
//class methods
public Props getCopy(){
        Props temp = new Props(this);
        return temp;
    }    
//constructor
    private Props(int i, String n, String g, String d){
    ID = i;
    name = n;
    generalDescription = g;
    detailedDescription =d;
    }
//default constructor
     public Props(){
    }
    
    //copy constructor
    public Props(Props item){
    this.ID = item.ID;
    this.name = item.name;
    this.generalDescription = item.generalDescription;
    this.detailedDescription = item.detailedDescription;
    }
    
}