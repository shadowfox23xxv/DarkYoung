/**
 * Dark Young - An interactive fiction horror game
 * @author bleakbriar
 *
 * Handler - object acts as ac container to allow passing of/access to
 * multiple objects easily
 *
 */
 
class Handler {
//member objects
	Interface user_i;
	GameState menu_state;
	ScriptLoader s_loader;

//constructor
	public Handler(Interface user_i, GameState menu_state, ScriptLoader s_loader){
		this.user_i = user_i;
		user_i.addHandler(this);
		this.menu_state = menu_state;
		menu_state.addHandler(this);
		this.s_loader = s_loader;
		s_loader.addHandler(this);
	}	
}

