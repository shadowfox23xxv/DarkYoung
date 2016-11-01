/**
 * Dark Young - an interactive fiction horror game
 * @author bleakbriar
 *
 * Main domain
 *-initializes objects
 *-controls flow of game through game mode objects
 */

public class DarkYoung {

	Interface user_i;
	GameState menu_state;
	ScriptLoader s_loader;
	Handler handler;


	public static void main(String[] args){
		
		DarkYoung theGame = new DarkYoung;
		runGameLoop(0);			
	}
	
	private runGameLoop(int i) {

		int stateTracker = i;
		int exitCondition = 0;
		do {
			switch(stateTracker) {
				case 0: //code to start menu_state
					break;
			default: System.out.println("An unexpected error has occued.");
				return 1;
		} while (exitCondition == 0)
	
	}

	public DarkYoung() {
		user_i = new Interface();
		menu_state = new GameState();
		s_loader = new ScriptLoader();
		handler = new Handler();
	}


}
/**
 * Development notes:
 * [=] Structure:
 * [==] initialize objects
 * [===] interface
 * [===] gamemode
 * [===] scriptloader
 * [===] handler
 * [==] enter game state loop
 */

