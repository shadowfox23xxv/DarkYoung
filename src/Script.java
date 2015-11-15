
/**
 *Dark Young - an interactive fiction horror game
 * @author bleakbriar
 */
public class Script {
    //class methods
	
	public String getTitle(int x){
		int option = x;
		switch (option){
			case 1: return ("Dark Young");
			//break statement removed as unreachable
			default: return ("Title option not available");
		}
	
	}

	public String getSubTitle(int x){
		int option = x;
		switch (option){
			case 1: return ("An interactive fiction horror game");
			//break statement removed as unreachable
			default: return ("subtitle option not available");
		}	
		
	}
	
	public String getSplashText(int x){
		int option = x;
		switch (option){
			case 1: return ("There is more to the world than you can possibly know.  A hellish abyss lies underneath the thin venieer that you call reality. Can you handle peeking beneath the veil, to the nightmare beneath?  The Void is calling.  Will you answer?");
			//break statement removed as unreachable
			default: return ("Splashtext option not available");
		}
	}
	
	public String getInputInvalid(int x){
		int option = x;
		switch (option){
			case 1: return ("Speak simply.  Too many words confuses the meaning.");
			default: return ("Invalid input option not avaialable.");
		}
        }
}
