
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
    

    //Warnings-------------------------------------------------------------
    //Warning to inform player that their input is too big
    public void warnTooManyWords(){
	System.out.println(script.getInputInvalid(1));
    }
        
    //Warning to inform player that their input is not a valid command
    public void warnInvalid(){
        System.out.println(script.invalidCommand(1));
    }
    
    //Warning to inform player that debug mode has been activated
    public void debugMode(int x){
        System.out.println(script.debug(x));
    }    

    //Formats---------------------------------------------------------------
    //defines and formatts splash screen at start of game
    public void runSplashScreen(){
        System.out.println(script.getTitle(1));
	this.insertLineBreak(1);
	System.out.println(script.getSubTitle(1));
	this.insertLineBreak(3);
	this.insertLine();
	System.out.println(script.getSplashText(1));
        this.insertLineBreak(1);
        System.out.println(script.getSplashText(2));
        
    }
    
    //Defines and formatts quite screen
    public void quitScreen(){
        this.insertLine();
        this.insertLineBreak(1);
        System.out.println(script.quitTitle(1));
        this.insertLineBreak(2);
        System.out.println(script.quitText(1));
    }
    
}
