/**
 * Dark Young - an interactive fiction horror game
 * Controls flow of game, command parsing, and command validation
 * @author bleakbriar
 */
public class DarkYoung {
    //class fields
    static final int MAX_INPUT = 5;
    public boolean debugModeOn = false;
    Interface userInterface;
    Inventory masterInventory;
    Player player;
    Locations[] map;
    public static void main(String arg[]){
        //instantiate game object
        DarkYoung theGame = new DarkYoung();
        
        	
//==================================================================================================
        //Splash screen loop
        theGame.userInterface.runSplashScreen();
        boolean exitMenuCondition = false;
        do {
            String[] testInputMenu = theGame.validateCommandMenu(theGame.userInterface.getInput());
            if (testInputMenu[0] != null){
                switch (testInputMenu[0]){
                    case "start": exitMenuCondition = true;
                    break;
                    case "debug": {if (theGame.debugModeOn == true){
                        theGame.debugModeOn = false;
                        theGame.userInterface.debugMode(2);
                        } else {
                        theGame.debugModeOn = true;
                        theGame.userInterface.debugMode(1);
                        }
                    }
                    break;
                    case "quit": {
                        theGame.userInterface.runQuitScreen();
                        System.exit(0);
                    }
                    break;
                }
            } else { System.out.println("Try again...");}
        } while(exitMenuCondition == false);
        System.out.println("The journey begins...");
        theGame.userInterface.insertLineBreak(5);
        theGame.userInterface.insertDoubleLine();
//=================================================================================================
        //Game loop
        theGame.userInterface.printLocationDescriptionGeneral(theGame.player.getLocation());
        boolean exitCondition = false;
        do{
            String[] userInput = theGame.validateCommand();
            if (userInput[0] != null){
                theGame.processCommand(userInput);
                theGame.userInterface.insertLineBreak(1);
            }
        } while(exitCondition == false);
    }


//--------------------------------------------------------------------------------------------------
//--------------------------------------------------------------------------------------------------
    //class methods
    String[] parseInput(String str){
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
            userInterface.printWarning(2);
            String[] returnNull = new String[1];
            returnNull[0] = null;
            return returnNull;
	}
	return strArray;
    }
        
    String[] validateCommandMenu(String str){
        String[] strArray = this.parseInput(str);
        boolean isValid = false;
        if (strArray[0] != null){
            switch (strArray[0]){
                case "start": isValid = true;
                break;
                case "quit": isValid = true;
                break;
                case "debug": isValid = true;
                break;
                default: userInterface.printWarning(1);
            }
        }
        if (isValid){
            return strArray;
        } else {
            strArray[0] = null;
            return strArray;
        } 
           
    }
    
    String[] validateCommand(){
    String[] strArray = this.parseInput(userInterface.getInput());
        boolean isValid = false;
        if (strArray[0] != null){
            switch (strArray[0]){
                case "look": { if (strArray.length == 2 && strArray[1].equals("around")){
                    isValid = true;
                    }else {userInterface.printWarning(1);}
                }    
                break;
                case "quit": { if (strArray.length == 1){
                    isValid = true;
                    }else {userInterface.printWarning(1);}
                }
                break;
                case "walk": { if (strArray.length == 2){
                        if ( strArray[1].matches ("north|south|east|west|n|s|e|w")){
                            isValid = true;
                        }else {userInterface.printWarning(1);}  
                    }
                }
                break;
                case "go": { if (strArray.length == 2){
                        if ( strArray[1].matches ("north|south|east|west|n|s|e|w")){
                            isValid = true;
                        }else {userInterface.printWarning(1);}  
                    }
                }
                break;
                case "north": { if (strArray.length == 1){
                        isValid = true;
                        } else {userInterface.printWarning(1);}
                }
                break;
                case "east": { if (strArray.length == 1){
                        isValid = true;
                        } else {userInterface.printWarning(1);}
                }
                break;
                case "south": { if (strArray.length == 1){
                        isValid = true;
                        } else {userInterface.printWarning(1);}
                }
                break;
                case "west": { if (strArray.length == 1){
                        isValid = true;
                        } else {userInterface.printWarning(1);}
                }
                break;
                case "n": { if (strArray.length == 1){
                        isValid = true;
                        } else {userInterface.printWarning(1);}
                }
                break;
                case "e": { if (strArray.length == 1){
                        isValid = true;
                        } else {userInterface.printWarning(1);}
                }
                break;
                case "s": { if (strArray.length == 1){
                        isValid = true;
                        } else {userInterface.printWarning(1);}
                }
                break;
                case "w": { if (strArray.length == 1){
                        isValid = true;
                        } else {userInterface.printWarning(1);}
                }
                break;
                //need to add verification that item is in inventory of player or room
                case "examine": { if (strArray.length == 2 ){
                       isValid = true;
                    }
                }
                break;
                case "open": { if (strArray.length == 2) {
                        isValid = true;
                    }
                }
                break;
                case "drop":{if (strArray.length == 2) {
                        isValid = true;
                    }
                }
                break;
                case "take" : { if (strArray.length == 2){
                        isValid = true;
                    }
                }
                break;
                
                //debug mode commands
                case "myhealth": { if (strArray.length == 1 && debugModeOn == true){
                        isValid = true;
                        }else {userInterface.printWarning(4);}
                    }
                break;
                
                
                case "locationinventory": { if (strArray.length == 1 && debugModeOn == true){
                        isValid = true;
                        }else {userInterface.printWarning(4);}
                }
                break;
                case "add" : {if (strArray.length == 2 && debugModeOn == true){
                        isValid = true;
                        }else {userInterface.printWarning(4);}
                }
                break;
                default: userInterface.printWarning(1);
            }
        }
        if (isValid){
            return strArray;
        } else {
            strArray[0] = null;
            return strArray;
        } 
    }  
    
    
    
    public void processCommand(String[] userInput){
        switch (userInput[0]){
//Look command------------------------------------------------------------------            
                case "look": { if (userInput[1].equals("around")){
                    userInterface.printLocationDescription(player.getLocation());
                    player.setSOV(player.getLocation());
                    if (!(player.getLocation()).inventory.empty()){
                        userInterface.itemsInLocation((player.getLocation()).inventory.itemsInInventory());
                        }
                    }
                }
                break;
//Movement commands=============================================================
//Walk command------------------------------------------------------------------                
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
//Go command--------------------------------------------------------------------                
                case "go": {if (userInput[1].equals("north") || userInput[1].equals("n")){
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
//Direction name commands-------------------------------------------------------                
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
//Item Commands=================================================================
//Examine command---------------------------------------------------------------                
                case "examine": {
                    if (player.getSOV() == player.getLocation()){
                        //code to check location inventory and equiped for userInput[1]
                        if((player.getLocation()).inventory.contains(userInput[1])){
                            userInterface.printItemDescriptionDetailed((player.getLocation()).inventory.getItemReference(userInput[1]));
                            userInterface.printItemDescriptionDetailed((player.getLocation()).inventory.getItemReference(userInput[1]));
                        }else {userInterface.noItemFound(userInput[1], "around you...");}
                    }else if(player.getSOV() == player){
                        //code to check player.inventory for userInput[1]
                        if (player.inventory.contains(userInput[1])){
                            userInterface.printItemDescriptionDetailed(player.inventory.getItemReference(userInput[1]));
                        }else {userInterface.noItemFound(userInput[1], "in your pack...");}
                        
                    }//else(){} add code to check if SOV is set to a container, then 
                    //check if container inventory contains item.  If so, print
                    //description.  If not, print warning
                    //then add last else to print SOV error warning
                    
                }
                break;
                case "open": {
                    //code to check if userInput[1] is 'backpack' or 'inventory' or 'bag'
                    if (userInput[1].equals("backpack") || userInput[1].equals("inventory") || userInput[1].equals("bag")){
                        player.setSOV(player);
                        if (player.inventory.empty() != true){//!!!!!!!!!!!!!!!!
                            //throwing null pointer exception
                            //may be related to inventory object within
                            //player. Possibly not inheriting right
                            String[] inventoryList = player.inventory.listItems();
                            userInterface.openBackPack(1);
                            userInterface.printItemList(inventoryList);
                        }else {userInterface.openBackPack(0);}
                    }else{userInterface.printWarning(3);}
                       
                    //code to check userInput[1] against containers in room
                        //change scopeOfView to container
                        //if match found, print content of conatiner.inventory
                    
                }
                break;
                case ("take"):{
                    if (player.getSOV() == player.getLocation()){
                        //code to check location inventory and equiped for userInput[1]
                        if ((player.getLocation()).inventory.contains(userInput[1])){
                            player.inventory.addItem((player.getLocation()).inventory.takeItem(userInput[1]));
                            userInterface.pickedUpItem(userInput[1]);
                        }else {userInterface.printWarning(3);}
                    }
                    //else(){} add code to check if SOV is set to a container, then 
                    //check if container inventory contains item.  If so, remove
                    //item from conatiner and add to player.inventory  
                    //If not, print warning
                    //then add last else to print warning
                }
                break;
                case ("drop"):{
                    //code to chancge SOV to location
                    player.setSOV(player.getLocation());
                    if (masterInventory.contains(userInput[1])){//verifies item exist in game world
                        //code to remove item from player.inventory and add to location inventory
                        (player.getLocation()).inventory.addItem(player.inventory.takeItem(userInput[1]));
                        
                        userInterface.droppedItem(userInput[1]);
                    }else{userInterface.printWarning(3);}
                }
                break;
                case ("put"):{
                    //add code to confirm SOV is a container
                        //if so, remove item from player.inventory and add to container's
                    //if not, print warning
                }
                break;
                case ("place"):{
                    //same as put
                }
                break;
                
                case "quit": { if (userInput.length == 1){
                    userInterface.runQuitScreen();
                    System.exit(0);
                        }
                    }   
                break;
//debug mode commands===========================================================
                case "myhealth": userInterface.showPlayerHealth(player);
                break;
                case "locationinventory": {String[] inventoryList = (player.getLocation()).inventory.listItems();
                         userInterface.printItemList(inventoryList);
                }
                break;
                case "add": {if (masterInventory.contains(userInput[1])){
                    
                        
                        player.inventory.addItem((masterInventory.getItemReference(userInput[1])).getCopy());
                        System.out.println("added " + userInput[1]);
                    }else{userInterface.printWarning(1);}
                }
                break;
                default: userInterface.printWarning(1);
                }   
            }
    
    public Items[] addInventoryArrays(Items[] a, Items[] b){
        int aLen = a.length;
        int bLen = b.length;
        Items[] c= new Items[aLen+bLen];
        System.arraycopy(a, 0, c, 0, aLen);
        System.arraycopy(b, 0, c, aLen, bLen);
        return c;
    }
    
    
    
    
    
    private void setMasterInventory(){
        Items[] tempInventoryArray = addInventoryArrays(Collectible.generateCollectibleItems(), Props.generatePropItems());
        int loops = tempInventoryArray.length;
        int iterator = 0;
        while ( iterator < loops){
            Items tempItem = tempInventoryArray[iterator];
            masterInventory.addItem(tempItem);
            iterator += 1;
        }
    } 
    
    private void populateItemsToDebugMap(){
        (Locations.getLocationAtXY(map, 1, 3)).inventory.addItem((masterInventory.getItemReference(100001)).getCopy());
        (Locations.getLocationAtXY(map, 2, 1)).inventory.addItem((masterInventory.getItemReference(100101)).getCopy());
        
    }
    
    //constructor
    public DarkYoung(){
        userInterface = new Interface();
        player = new Player();
        masterInventory = new Inventory();
        setMasterInventory();
        map = Locations.generateDebugMap();
        populateItemsToDebugMap();
        player.changeLocation(map[0]);
        
    }
    
}
        
