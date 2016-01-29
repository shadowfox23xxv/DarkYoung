
/**
 * Dark Young - an interactive fiction horror game
 * @author bleakbriar
 */
import java.util.Scanner;

public class Interface {
    //Objects--------------------------------------------------------------
    //instantiate a Script class object to access strings
    Script script = new Script();   
    //instantiate a Scanner class object to gather user input
    Scanner user_input = new Scanner(System.in);
    

    //formatting tools-----------------------------------------------------
    //Inserts line breaks for formatting purposes
    public void insertLineBreak(int x){
	//arguement passed determines how many breaks are inserted
	int end = x;
	int count = 0;
	while (count < end) {
            System.out.println(" ");
            count++;
        }
    }		

    //Inserts a line of hyphens for formatting purposes
    public void insertLine(){
        System.out.println("-----------------------------------------------------------------------");
    }
    
    //insert line of equal signs for formatting purposes
    public void insertDoubleLine(){
        System.out.println("=======================================================================");
    }

    //Input-----------------------------------------------------------------
    //Shows "waiting for input" marker and captures player input
    public String getInput(){
    	System.out.printf(">?  ");
	String capturedInput = user_input.nextLine();
	return capturedInput;
    }
    
    //Output-----------------------------------------------------------------
    public void printLocationDescriptionGeneral(Locations current){
        this.insertLineBreak(1);
        System.out.println(current.getRoomGeneralDescription());
    }    
    
     public void printLocationDescription(Locations current){
        System.out.println(current.getRoomDetailedDescription());
    }
    
    public void printItemDescriptionGeneral(Items item){
        System.out.println(item.getGeneralDescription());
    }
    
    public void printItemDescriptionDetailed(Items item){
        System.out.println(item.getDetailedDescription());
    }
     
    public void showPlayerHealth(Player player){
        System.out.println("Your health is " + player.getHealth() + "/" + player.getMaxHealth());
    }
    
    public void showCurrentItem(Items item){
        System.out.println("Current item is " + item.getName());
    }
    
    public void itemsInLocation(Items[] itemArray){
        System.out.println("Around you, you see:");
        for (Items item : itemArray){
            System.out.println("- " + item.getGeneralDescription());
        }
    }
    
    public void printItemList(String[] itemArray){
        for (String item : itemArray){
            System.out.println("- " + item);
        }
    }
    
    public void openBackPack(int x){
        System.out.println(script.openBackPack(x));
    }
    public void openContainer(String x){
        System.out.println(script.openContainer(0) + " " + x + " " + script.openContainer(1));
    }
    public void openContainerEmpty(){
        System.out.println(script.openContainer(2));
    }
    //Warnings-------------------------------------------------------------
   //singular warning method to replace warnTooManyWords and warnInvalid
    public void printWarning(int x){
        switch (x){
            case 1: System.out.println(script.unrecognizedCommandText(1));
            break;
            case 2: System.out.println(script.inputInvalidText(1));
            break;
            case 3: System.out.println(script.commandImpossibleText(1));
            break;
            case 4: System.out.println(script.unrecognizedDebugCommandText(1));
            break;    
            default: System.out.println("Warning option not available");
        }
    }
    
    public void noItemFound(String item, String loc){
        System.out.println(script.isNo() + " " + item + " " + loc);
    }
    public void droppedItem(String x){
        System.out.println(script.youDropped() + " " + x);
    }
    public void putItem(String x, String y){
        System.out.println(script.youPut() + " " + x + " in the " + y);
    }
    public void pickedUpItem(String x){
        System.out.println(script.youPickedUp() + " " + x);
    }
    
    //Warning to inform player that debug mode has been activated
    public void debugMode(int x){
        System.out.println(script.debug(x));
    }    

    //Formats---------------------------------------------------------------
    //defines and formatts splash screen at start of game
    public void runSplashScreen(){
        this.insertLineBreak(1);
        System.out.println(script.getTitle(1));
        System.out.println(script.getTitle(2));
        System.out.println(script.getTitle(3));
        System.out.println(script.getTitle(4));
        System.out.println(script.getTitle(5));
        System.out.println(script.getTitle(6));
        this.insertLineBreak(2);
        System.out.println(script.getSplashScreenText(1));
	this.insertLineBreak(1);
	System.out.println(script.getSplashScreenText(2));
	this.insertLineBreak(3);
	this.insertDoubleLine();
	System.out.println(script.getSplashScreenText(3));
        this.insertLineBreak(1);
        System.out.println(script.getSplashScreenText(4));
        
    }
    
    //Defines and formatts quite screen
    public void runQuitScreen(){
        this.insertDoubleLine();
        this.insertLineBreak(1);
        this.insertDoubleLine();
        this.insertLineBreak(2);
        System.out.println(script.quitTitle(1));
        this.insertLineBreak(1);
        System.out.println(script.quitText(1));
    }
    
}
