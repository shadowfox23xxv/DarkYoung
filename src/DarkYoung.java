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
        //instantiate interface object 
        Interface userInterface = new Interface();
        	
//==================================================================================================
        //!!!!Beginning of actual code for splash screen menu!!!!!
        //!!!!!!!!!!!!!test again!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
        userInterface.runSplashScreen();
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
                        userInterface.runQuitScreen();
                        System.exit(0);
                    }
                    break;
                }
            } else { System.out.println("Try again...");}
        } while(exitMenuCondition == false);
        System.out.println("The journey begins...");
        userInterface.insertLineBreak(5);
        userInterface.insertDoubleLine();
//=================================================================================================
        
        
        Locations mapBuilder = new Locations();
        //generates debug map
        Locations[] map = Locations.generateDebugMap();
        Player player = new Player();
        player.changeLocation(map[0]); 
        //test code for items. Can be replaced/removed once inventory class is implemented
        Items inventory = null;
        
        userInterface.printLocationDescriptionGeneral(player.getLocation());
        boolean exitCondition = false;
        do{
            String[] userInput = theGame.validateCommand(userInterface.getInput(), userInterface, inventory);
            if (userInput[0] != null){
                switch (userInput[0]){
                case "look": { if (userInput[1].equals("around")){
                    userInterface.printLocationDescription(player.getLocation());
                    }
                }
                break;
                case "walk": {if (userInput[1].equals("north") || userInput[1].equals("n")){
                        if (player.getLocation().northExit != null){
                        player.changeLocation(player.getLocation().northExit);
                        userInterface.printLocationDescriptionGeneral(player.getLocation());
                        }else {userInterface.printWarning(3);}
                    } 
                    if (userInput[1].equals("east") || userInput[1].equals("e")){
                        if (player.getLocation().eastExit != null){
                        player.changeLocation(player.getLocation().eastExit);
                        userInterface.printLocationDescriptionGeneral(player.getLocation());
                        }else {userInterface.printWarning(3);}
                    }
                        if (userInput[1].equals("south") || userInput[1].equals("s")){
                            if (player.getLocation().southExit != null){
                            player.changeLocation(player.getLocation().southExit);
                            userInterface.printLocationDescriptionGeneral(player.getLocation());
                            }else {userInterface.printWarning(3);}
                        } 
                        if (userInput[1].equals("west") || userInput[1].equals("w")){
                            if (player.getLocation().westExit != null){
                            player.changeLocation(player.getLocation().westExit);
                            userInterface.printLocationDescriptionGeneral(player.getLocation());
                            }else {userInterface.printWarning(3);}
                        }
                    } 
                break; 
                case "north": {if (player.getLocation().northExit != null){
                    player.changeLocation(player.getLocation().northExit);
                    userInterface.printLocationDescriptionGeneral(player.getLocation());
                        }else {userInterface.printWarning(3);}
                    } 
                break;
                case "east": {if (player.getLocation().eastExit != null){
                    player.changeLocation(player.getLocation().eastExit);
                    userInterface.printLocationDescriptionGeneral(player.getLocation());
                        }else {userInterface.printWarning(3);}
                    } 
                break;
                case "south": {if (player.getLocation().southExit != null){
                    player.changeLocation(player.getLocation().southExit);
                    userInterface.printLocationDescriptionGeneral(player.getLocation());
                        }else {userInterface.printWarning(3);}
                    } 
                break;
                case "west": {if (player.getLocation().westExit != null){
                    player.changeLocation(player.getLocation().westExit);
                    userInterface.printLocationDescriptionGeneral(player.getLocation());
                        }else {userInterface.printWarning(3);}
                    } 
                break;
                case "n": {if (player.getLocation().northExit != null){
                    player.changeLocation(player.getLocation().northExit);
                    userInterface.printLocationDescriptionGeneral(player.getLocation());
                        }else {userInterface.printWarning(3);}
                    } 
                break;
                case "e": {if (player.getLocation().eastExit != null){
                    player.changeLocation(player.getLocation().eastExit);
                    userInterface.printLocationDescriptionGeneral(player.getLocation());
                        }else {userInterface.printWarning(3);}
                    } 
                break;
                case "s": {if (player.getLocation().southExit != null){
                    player.changeLocation(player.getLocation().southExit);
                    userInterface.printLocationDescriptionGeneral(player.getLocation());
                        }else {userInterface.printWarning(3);}
                    } 
                break;
                case "w": {if (player.getLocation().westExit != null){
                    player.changeLocation(player.getLocation().westExit);
                    userInterface.printLocationDescriptionGeneral(player.getLocation());
                        }else {userInterface.printWarning(3);}
                    } 
                break;
                case "examine": {userInterface.printItemDescription(inventory);}
                break;
                case "quit": { if (userInput.length == 1){
                    userInterface.runQuitScreen();
                    System.exit(0);
                        }
                    }   
                break;
                //debug mode commands
                case "myhealth": userInterface.showPlayerHealth(player);
                break;
                case "givenote": inventory = Items.generateNote();
                break;
                case "giveflashlight": inventory = Items.generateFlashLight();
                break;
                case "currentitem": if (inventory != null){
                    userInterface.showCurrentItem(theGame, inventory);
                } else {userInterface.printWarning(4);}
                break;
                default: userInterface.printWarning(1);
                }   
            }
        userInterface.insertLineBreak(1);
        } while(exitCondition == false);
    }           

//--------------------------------------------------------------------------------------------------
//--------------------------------------------------------------------------------------------------
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
            uI.printWarning(2);
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
                default: uI.printWarning(1);
            }
        }
        if (isValid){
            return strArray;
        } else {
            strArray[0] = null;
            return strArray;
        } 
           
    }
    
    String[] validateCommand(String str, Interface uI, Items inventory){
    String[] strArray = this.parseInput(str, uI);
        boolean isValid = false;
        if (strArray[0] != null){
            switch (strArray[0]){
                case "look": { if (strArray.length == 2 && strArray[1].equals("around")){
                    isValid = true;
                    }else {uI.printWarning(1);}
                }    
                break;
                case "quit": { if (strArray.length == 1){
                    isValid = true;
                    }else {uI.printWarning(1);}
                }
                break;
                case "walk": { if (strArray.length == 2){
                        if ( strArray[1].matches ("north|south|east|west|n|s|e|w")){
                            isValid = true;
                        }else {uI.printWarning(1);}  
                    }
                }
                break;
                case "north": { if (strArray.length == 1){
                        isValid = true;
                        } else {uI.printWarning(1);}
                }
                break;
                case "east": { if (strArray.length == 1){
                        isValid = true;
                        } else {uI.printWarning(1);}
                }
                break;
                case "south": { if (strArray.length == 1){
                        isValid = true;
                        } else {uI.printWarning(1);}
                }
                break;
                case "west": { if (strArray.length == 1){
                        isValid = true;
                        } else {uI.printWarning(1);}
                }
                break;
                case "n": { if (strArray.length == 1){
                        isValid = true;
                        } else {uI.printWarning(1);}
                }
                break;
                case "e": { if (strArray.length == 1){
                        isValid = true;
                        } else {uI.printWarning(1);}
                }
                break;
                case "s": { if (strArray.length == 1){
                        isValid = true;
                        } else {uI.printWarning(1);}
                }
                break;
                case "w": { if (strArray.length == 1){
                        isValid = true;
                        } else {uI.printWarning(1);}
                }
                break;
                //need to add verification that item is in inventory of player or room
                case "examine": { if (strArray.length ==2 && strArray[1].equals(inventory.getName())){
                       isValid = true;
                    }
                }
                break;
                //debug mode commands
                case "myhealth": { if (strArray.length == 1 && debugModeOn == true){
                        isValid = true;
                        }else {uI.printWarning(4);}
                    }
                break;
                case "givenote": { if (strArray.length == 1 && debugModeOn == true){
                        isValid = true;
                        }else {uI.printWarning(4);}
                    }
                break;
                case "giveflashlight": { if (strArray.length == 1 && debugModeOn == true){
                        isValid = true;
                        }else {uI.printWarning(4);}
                    }
                break;
                case "currentitem": { if (strArray.length == 1 && debugModeOn == true){
                        isValid = true;
                        }else {uI.printWarning(4);}
                    }
                break; 
                default: uI.printWarning(1);
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
