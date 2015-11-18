
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
   //singular warning method to replace warnTooManyWords and warnInvalid
    public void printWarning(int x){
        switch (x){
            case 1: System.out.println(script.unrecognizedCommandText(1));
            break;
            case 2: System.out.println(script.inputInvalidText(1));    
            break;
            default: System.out.println("Warning option not available");
        }
    }
    
    //Warning to inform player that debug mode has been activated
    public void debugMode(int x){
        System.out.println(script.debug(x));
    }    

    //Formats---------------------------------------------------------------
    //defines and formatts splash screen at start of game
    public void runSplashScreen(){
        System.out.println(script.getSplashScreenText(1));
	this.insertLineBreak(1);
	System.out.println(script.getSplashScreenText(2));
	this.insertLineBreak(3);
	this.insertLine();
	System.out.println(script.getSplashScreenText(3));
        this.insertLineBreak(1);
        System.out.println(script.getSplashScreenText(4));
        
    }
    
    //Defines and formatts quite screen
    public void runQuitScreen(){
        this.insertLine();
        this.insertLineBreak(1);
        System.out.println(script.quitTitle(1));
        this.insertLineBreak(2);
        System.out.println(script.quitText(1));
    }
    
}
