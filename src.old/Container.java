/**
 * Dark Young - an interactive fiction horror game
 * Defines objects to act as a self-contained inventory for other objects 
 * @author bleakbriar
 */

/*Sub class of Props to define objects in the environment that can store objects
such as boxes, cabinets, etc...
*/
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
public class Container extends Props{
    //static class methods
    public static Items[] generateContainerItems(){
        Items[] itemSet = new Items[TOTAL_ITEMS];
        try{
            File file = new File("src/containerItems.txt");
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
                Container newItem = new Container(i, n, g, d); 
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
    final static int TOTAL_ITEMS = 6;
    public Inventory inventory = new Inventory();
//class methods
public Container getCopy(){
        Container temp = new Container(this);
        return temp;
    }    
//constructor
    private Container(int i, String n, String g, String d){
    ID = i;
    name = n;
    generalDescription = g;
    detailedDescription =d;
    }
    
    //copy constructor
    public Container(Container item){
    this.ID = item.ID;
    this.name = item.name;
    this.generalDescription = item.generalDescription;
    this.detailedDescription = item.detailedDescription;
    }
}
