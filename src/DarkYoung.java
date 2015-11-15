/**
 * Dark Young - an interactive fiction horror game
 * @author bleakbriar
 *
 *Controls flow of game, command parsing, and command validation
 */
public class DarkYoung {
    public static void main(String arg[]){
		//instantiate interface 
		Interface UI = new Interface();
		
		
		//display splash screen
		String[] test = parseInput(UI.splashScreen(), UI);
		System.out.println(test[0]);
    }


	static String[] parseInput(String x, Interface UI2){
		//seperates string from user into string array
		//Returns NULL in [0] if input doesn't meet parser
		//requirements(max length, no punctuation)
		String str = x;
		String[] strs = str.split(" ");
		if (strs.length > 5) {
			UI2.tooManyWords();
			String[] returnNull = new String[1];
			returnNull[0] = "NULL";
			return returnNull;
		}
		//add for loop to check for odd characters
		return strs;
	}
}
