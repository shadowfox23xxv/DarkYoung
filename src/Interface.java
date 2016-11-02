/**
 * Dark Young - an interactive fiction horror game
 * @author bleakbriar
 *
 * Interface object responsible for handling I/O between game and player
 *
 */

public class Interface{
	
	Handler handler;	
	private static final int WIDTH = 40;	

	public Interface(){}
	
	public adHandler(Handler handler){
		this.handler = handler;
	}

	//functions for single line formatting
	public void asteriskLine(){
	//prints a line of *
		for ( i = 0; i < WIDTH; i++){
			System.out.print("*");
			if (i = WIDTH) {System.out.Println("");}
		}
	}

	public void dashLine(){
	//prints a line of -
		for ( i = 0; i < WIDTH; i++ ){
			System.outPrint("-");
			if ( i = WIDTH) {System.out.Println("");}
		}
	}

	public void plusLine(){
		for ( i = 0; i < WIDTH; i++) {
			System.out.Print("+");
			if (i = WIDTH) {System.out.Println("");}
		}

	}

	//functions for full formatting
	
}

/**
 * Notes:
 * Location header
 *  *********************************
 *  *            Name               *
 *  ---------------------------------
 *  Description text goes here
 *
 *  Input indicator
 *  ->_
 *
 * respnse
 * [*] response from game [*]
 *
 * inventory list
 * inventory list description: (inside you find: etc)
 * [+] item one
 * [+] item two
 *
 * warning(can't)
 * [!] warning text [!]
 *
 * [!?!] I don't understand [?!?]
 *
 * take/drop notice
 * [-] Item: taken/dropped
 *
 * ask for info
 * [?] whatever the player is being asked [?]
 * [+] option 1
 * [+] option 2 
 *
 * [?]_ <prompt for answer>;
 *
 * conversation 
 * [#] "text being spoken [#]
 * [+] response option 1
 * [+] response option 2
 * [?]_ freeform response slug
 * -------------------------------------------
 * ________________________
 *        TITLE TEXT      
 * =========================
 * Question:
 * -------------------------
 *  > Option 1
 *  > Option 2
 *  > Option 3
 *
 *  >\ space for user to write
 *
 *
 */

