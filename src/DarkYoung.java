/**
 * Dark Young - an interactive fiction horror game
 * Controls flow of game, command parsing, and command validation
 * @author bleakbriar
 */
public class DarkYoung {
    static final int MAX_INPUT = 1;
    
    public static void main(String arg[]){
		//instantiate game object
                DarkYoung theGame = new DarkYoung();
                //instantiate interface 
                Interface userInterface = new Interface();
		
		
		/*display splash screen using temporary test variable
                !!!!!!!!this is temp code for testing purposes!!!!!!!!!!!
                !!!!!!!!!!remove once testing is complete!!!!!!!!!!!!!!!!
                */ 
		/*
                boolean exitGame = false;
                do {
                    String[] test = parseInput(userInterface.runSplashScreen(), userInterface);
                    if (test[0] != null){
                        if (getCommandValid(test, 1, userInterface)){
                            System.out.println("It's time to begin!");
                        }
                    if (test[0] == "quit"){exitGame = true;}
                    }
                } while (exitGame == false);
                */
                
                
             
                userInterface.runSplashScreen();
                boolean exitGame = false;
                do {
                    String[] test = theGame.parseInput(userInterface.getInput(), userInterface);
                    if (test[0] != null){
                        if (theGame.getCommandValid(test, 1, userInterface)){
                            System.out.println("It's time to begin!");
                        }
                    //!!!!won't trigger to exit loop!!!!unsure why    
                    if (test[0] == "quit"){exitGame = true;}
                    }
                } while (exitGame == false);
    }           


	String[] parseInput(String str, Interface uI){
		/**Separates string from user into string array
                * Returns NULL in [0] if input doesn't meet parser
                * requirements(max length, no punctuation)
                */
                //eliminates non-alphanumeric characters from str
                str =str.replaceAll("[^a-zA-Z0-9 ]", "");
                //create string array and divide str into array
		String[] strArray = str.split(" ");
                /*if the entered string is more than 5 words, return null
                and make method call to inform player
                */
		if (strArray.length > MAX_INPUT) {
			uI.warnTooManyWords();
			String[] returnNull = new String[1];
			returnNull[0] = null;
			return returnNull;
		}
		return strArray;
	}
        
         boolean getCommandValid(String[] strArray, int level, Interface uI){
            boolean isValid = false;
            /*level 1 denotes splash screen and start menu commands are being 
            validated.
            */
            if (level == 1){
                switch (strArray[0]){
                    case "start": if (strArray.length == 1){isValid = true;}
                    break;
                    case "help": isValid = true;
                    break;
                    case "quit": isValid = true;
                    break;
                    default: uI.warnCant();
                }
            }
            return isValid;
        }
            
}
