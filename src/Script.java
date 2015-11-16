
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
    public String getSplashText(int x){
	switch (x){
            case 1: return ("There is more to the world than you can possibly know.  A hellish abyss lies underneath the thin venieer that you call reality. Can you handle peeking beneath the veil, to the nightmare beneath?  The Void is calling.  Will you answer?");
            //break statement removed as unreachable
            case 2: return ("Type Start to begin");
            default: return ("Splashtext option not available");
	}
    }
        
    //Command is not recognized
    public String invalidCommand(int x){
        switch (x){
            case 1: return("The Void does not understand.");
            //break statement removed as unreachable
            default: return ("Invalid Command option not available");
        }
    }
	
    //Input does not  meet parser requirements(too long, or symbols)
    public String getInputInvalid(int x){
	int option = x;
	switch (option){
            case 1: return ("Speak simply.  Too many words confuses the meaning.");
            //break statement removed as unreachable
            default: return ("Invalid input option not avaialable.");
	}
    }
}
