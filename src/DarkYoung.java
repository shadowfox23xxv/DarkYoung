/**
 * Dark Young - an interactive fiction horror game
 * Controls flow of game, command parsing, and command validation
 * @author bleakbriar
 */
public class DarkYoung {
    static final int MAX_INPUT = 5;
    public boolean debugModeOn = false;
    
    public static void main(String arg[]){
        //instantiate game object
        DarkYoung theGame = new DarkYoung();
        //instantiate interface 
        Interface userInterface = new Interface();
		
	/*display splash screen using temporary test variable
        !!!!!!!!this is temp code for testing purposes!!!!!!!!!!!
        !!!!!!!!!!remove once testing is complete!!!!!!!!!!!!!!!!
        */ 
        userInterface.runSplashScreen();
        /*String[] test = theGame.validateCommandMenu(userInterface.getInput(), userInterface);
        if (test[0] != null){
            System.out.println("You entered " + test[0] + "!" );
        } else {
            System.out.println("Ah ah ah! You didn't say the magic word!");
        }*/
        //!!!!Beginning of actual code for splash screen menu!!!!!
        //!!!!!!!!!!!!!test again!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
        boolean exitMenuCondition = false;
        do {
            String[] testInputMenu = theGame.validateCommandMenu(userInterface.getInput(), userInterface);
            if (testInputMenu[0] != null){
                switch (testInputMenu[0]){
                    case "start": exitMenuCondition = true;
                    break;
                    case "debug": {if (theGame.debugModeOn == true){
                        theGame.debugModeOn = false;
                        userInterface.debugMode(2);
                        } else {
                        theGame.debugModeOn = true;
                        userInterface.debugMode(1);
                        }
                    }
                    break;
                    case "quit": {
                        userInterface.quitScreen();
                        System.exit(0);
                    }
                    break;
                
                    
                }
            } else { System.out.println("Try again...");}
            
        } while(exitMenuCondition == false);
        System.out.println("The journey begins...");
    }           


    String[] parseInput(String str, Interface uI){
	/**Separates string from user into string array
        * Returns NULL in [0] if input doesn't meet parser
        * requirements(max length, no punctuation)
        */
        //eliminates non-alphanumeric characters from str
        str = str.replaceAll("[^a-zA-Z0-9 ]", "");
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
        
    String[] validateCommandMenu(String str, Interface uI){
        String[] strArray = this.parseInput(str, uI);
        boolean isValid = false;
        if (strArray[0] != null){
            switch (strArray[0]){
                case "start": isValid = true;
                break;
                case "quit": isValid = true;
                break;
                case "debug": isValid = true;
                break;
                default: uI.warnInvalid();
            }
        }
        if (isValid){
            return strArray;
        } else {
            strArray[0] = null;
            return strArray;
        } 
           
    }
            
}
