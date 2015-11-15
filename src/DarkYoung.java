/**
 * Dark Young - an interactive fiction horror game
 * Controls flow of game, command parsing, and command validation
 * @author bleakbriar
 */
public class DarkYoung {
    public static void main(String arg[]){
		//instantiate interface 
		Interface userInterface = new Interface();
		
		
		//display splash screen using temporary test variable 
		String[] test = parseInput(userInterface.runSplashScreen(), userInterface);
		System.out.println(test[0]);
    }


	static String[] parseInput(String str, Interface uI){
		/**Separates string from user into string array
                * Returns NULL in [0] if input doesn't meet parser
                * requirements(max length, no punctuation)
                */
                //eliminates non-alphanumeric characters from str
                str =str.replaceAll("[^a-zA-Z0-9]", "");
                //create string array and divide str into array
		String[] strArray = str.split(" ");
                /*if the entered string is more than 5 words, return null
                and make method call to inform player
                */
		if (strArray.length > 5) {
			uI.warnTooManyWords();
			String[] returnNull = new String[1];
			returnNull[0] = "NULL";
			return returnNull;
		}
		return strArray;
	}
}
