
/**
 * Dark Young - an interactive fiction horror game
 * @author bleakbriar
 */
import java.util.Scanner;

public class Interface {
    //instantiate a Script class object to access strings
    Script script = new Script();
	//instantiate a Scanner class object to gather user input
    Scanner user_input = new Scanner(System.in);
	
    //class methods
    public void insertLineBreak(int x){
		//method to insert line breaks for formatting purposes.
		//arguement passed determines how many breaks are inserted
		int end = x;
		int count = 0;
		while (count < end) {
			System.out.println(" ");
		count++;
		}
	}		


    public void insertLine(){
		System.out.println("-----------------------------------------------------------------------");
	}
	
    public String getInput(){
    //method to request and await player input
    //currently only showing waiting marker. Code for getting
    //input still needs to be added.
	System.out.printf(">?");
	String capturedInput;
	capturedInput = user_input.nextLine();
	return capturedInput;
    }

	public void warnTooManyWords(){
		System.out.println(script.getInputInvalid(1));
	}

	public String runSplashScreen(){
		System.out.println(script.getTitle(1));
		this.insertLineBreak(1);
		System.out.println(script.getSubTitle(1));
		this.insertLineBreak(3);
		this.insertLine();
		System.out.println(script.getSplashText(1));
		return this.getInput();
	}
}
