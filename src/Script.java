
/**
 *Dark Young - an interactive fiction horror game
 * @author bleakbriar
 */
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Script {
    private String title1;
    private String title2;
    private String title3;
    private String title4;
    private String title5;
    private String title6;
    private String subTitle1;
    private String splashScreen1;
    private String splashScreen2;
    private String splashScreen3;
    private String splashScreen4;
    private String unrecognizedCommand1;
    private String unrecognizedDebugCommand1;
    private String inputInvalid1;
    private String commandImpossible1;
    private String quitTitle1;
    private String quit1;
    private String debug1;
    private String debug2;
    
    public Script(){
	String[] reader = new String[50];
        try {
            File file = new File("src/script.txt");
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            int iterator = 0;
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                reader[iterator] = line;
                iterator += 1;
            }
            fileReader.close();
            } catch (IOException e) {
			e.printStackTrace();
            }
    title1 = reader[0];
    title2 = reader[1];
    title3 = reader[2];
    title4 = reader[3];
    title5 = reader[4];
    title6 = reader[5];
    subTitle1 = reader[6];
    splashScreen1 = reader[7];
    splashScreen2 = reader[8];
    splashScreen3 = reader[9];
    splashScreen4 = reader[10];
    unrecognizedCommand1 = reader[11];
    unrecognizedDebugCommand1 = reader[12];
    inputInvalid1 = reader[13];
    commandImpossible1 = reader[14];
    quitTitle1 = reader[15];
    quit1 = reader[16];
    debug1 = reader[17];
    debug2 = reader[18];
    }    
    
    //Game title
    public String getTitle(int x){
        int option = x;
            switch (option){
                case 1: return title1;
                case 2: return title2;
                case 3: return title3;
                case 4: return title4;
                case 5: return title5;
                case 6: return title6;
		default: return ("Title option not available");
            }
	
    }

    //Game subtitle
    public String getSubTitle(int x){
	int option = x;
	switch (option){
            case 1: return subTitle1;
            //break statement removed as unreachable
            default: return ("subtitle option not available");
	}	
		
    }
	
    //Additional text to display in splash screen
    public String getSplashScreenText(int x){
	switch (x){
            case 1: return splashScreen1;
            //break statement removed as unreachable
            case 2: return splashScreen2;
            //break statement removed as unreachable
            case 3: return splashScreen3;
            //break statement removed as unreachable
            case 4: return splashScreen4;
            //break statement removed as unreachable
            default: return ("Splash screen text option not available");
	}
    }
        
    //Command is not recognized
    public String unrecognizedCommandText(int x){
        switch (x){
            case 1: return unrecognizedCommand1;
            //break statement removed as unreachable
            default: return ("Invalid Command option not available");
        }
    }
    
    //debug command is not recognized
    public String unrecognizedDebugCommandText(int x){
        switch (x){
            case 1: return unrecognizedDebugCommand1;
            //break statement removed as unreachable
            default: return ("Invalid debug command option not available");
        }
    }
	
    //Input does not  meet parser requirements(too long, or symbols)
    public String inputInvalidText(int x){
	switch (x){
            case 1: return inputInvalid1;
            //break statement removed as unreachable
            default: return ("Invalid input option not avaialable.");
	}
    }
    
    //command is valid but can't be accomplished
    public String commandImpossibleText(int x){
        switch (x){
            case 1: return commandImpossible1;
            //break statement removed as unreachable
            default: return ("Command impossible option not available");
        }
    } 
    
    
    
    //Title for quit screen
    public String quitTitle(int x){
        switch (x){
            case 1: return quitTitle1;
            //break statement removed as unreachable
            default: return("Quit title not available");
        }
    }
    
    //additional text for quit Screen
    public String quitText(int x){
        switch (x){
            case 1: return quit1;
            //break statement removed as unreachable
            default: return("Quit text option not available");
        }
    }
    //debug mode on/off message
    public String debug(int x){
        switch (x){
            case 1: return debug1;
            //break statement removed as unreachable
            case 2: return debug2;
            //break statement removed as unreachable
            default: return ("Debug mode option not available");
        }   
    }
    
       
}
