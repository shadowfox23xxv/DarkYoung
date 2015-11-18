
/**
 *Dark Young - an interactive fiction horror game
 * @author bleakbriar
 */
public class Script {
    //Game title
    public String getTitle(int x){
        int option = x;
            switch (option){
		case 1: return ("Dark Young");
		//break statement removed as unreachable
		default: return ("Title option not available");
            }
	
    }

    //Game subtitle
    public String getSubTitle(int x){
	int option = x;
	switch (option){
            case 1: return ("An interactive fiction horror game");
            //break statement removed as unreachable
            default: return ("subtitle option not available");
	}	
		
    }
	
    //Additional text to display in splash screen
    public String getSplashScreenText(int x){
	switch (x){
            case 1: return ("Dark Young");
            //break statement removed as unreachable
            case 2: return ("An interactive fiction horror game");
            //break statement removed as unreachable
            case 3: return ("There is more to the world than you can possibly know.  A hellish abyss lies underneath the thin venieer that you call reality. Can you handle peeking beneath the veil, to the nightmare beneath?  The Void is calling.  Will you answer?");
            //break statement removed as unreachable
            case 4: return ("Type Start to begin, or quit to leave. No one would blame you...");
            //break statement removed as unreachable
            default: return ("Splash screen text option not available");
	}
    }
        
    //Command is not recognized
    public String unrecognizedCommandText(int x){
        switch (x){
            case 1: return("The Void does not understand.");
            //break statement removed as unreachable
            default: return ("Invalid Command option not available");
        }
    }
	
    //Input does not  meet parser requirements(too long, or symbols)
    public String inputInvalidText(int x){
	switch (x){
            case 1: return ("Speak simply and clearly.  Words may confuse the meaning.");
            //break statement removed as unreachable
            default: return ("Invalid input option not avaialable.");
	}
    }
    
    //command is valid but can't be accomplished
    public String commandImpossibleText(int x){
        switch (x){
            case 1: return ("You can't do that");
            //break statement removed as unreachable
            default: return ("Command impossible option not available");
        }
    }    
    
    //Title for quit screen
    public String quitTitle(int x){
        switch (x){
            case 1: return("Goodbye, wanderer in the dark...");
            //break statement removed as unreachable
            default: return("Quit title not available");
        }
    }
    
    //additional text for quit Screen
    public String quitText(int x){
        switch (x){
            case 1: return("But remember the Void does not forget, and neither will you...");
            //break statement removed as unreachable
            default: return("Quit text option not available");
        }
    }
    //debug mode on/off message
    public String debug(int x){
        switch (x){
            case 1: return ("Debug mode on...");
            //break statement removed as unreachable
            case 2: return ("Debug mode off...");
            //break statement removed as unreachable
            default: return ("Debug mode option not available");
        }   
    }
    
       
}
