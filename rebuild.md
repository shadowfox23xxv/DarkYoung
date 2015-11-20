Dark Young - an interactive fiction horror game
version 0.6-intervening phase

Goals: Before progressing into phase 7, the decision has been made to review and rewrite sections of the existing code to make future development easier, as well as to bring the handling of the game more under the object-oriented programming paradigm, where-as it now more resembles OO/functinal programming hybrid. The following changes will be made before further work on developing the game commences:

-REBUILD OF ITEM HANDLING
---Items class will be rewritten as a possibly virtual super class.
---subclasses will be created for collectible items, props(furniture, ect...), containers,
---add int ID field for each item.  This allows items with the same name to have different information.  Example: keys.  Shows as key, but has different descpriptions and uses.
---add menu to Interface should a command be entered for items with same name. Example: examine key while in player inventory.  Displays numbered basic description of each key and asks player to select which key they wish to examine(show detailed description)
---add general and detailed description of each item.  General description can be used in above menu, as well as describing item when it is in a location. Detailed description given when examine command is used.
---a static method in each subclass is required to read from it's associated file and generate an instance of all in game objects
---Addition of an Items type array in DarkYoung class to hold an instance of all in game objects.  Will be replaced in phase seven with an inventory object.
---Addition of method in Darkyoung to call generation method of each Items subclass and add returned array of object references to inventory stand in
-REBUILD OF LOCATION HANDLING
---replace numberOfExits with boolean hasXExit where x is each possible direction
---Add x,y,z,i coordinates to each location in file
---add XisLocked boolean and XLockedCondition method,where x is each possible direction. If player attempts to go in a locked directions, call XLockedCondition method. For a locked door, method checks to see if player has appropriate key.  For a puzzle, method calls event start method for that puzzle.
---rewrite map generation to read from file. File will contain all info to initalize location except exit pointers and items
---add method to connect all locations based on xyzi coordinates and hasXExit flags(example, if x=10, y=10 [z and i irrelevant, used for up/down and in/out] and location has hasNorthExit = true, then method searches master location list for a location with x=10 y=11 and sets northExit equal to this new location
---Add method for populating locations from file. File contains xyzi coordinates, number of items to add, and names of all items to add to that location.
XXX-REBUILD OF SCRIPT HANDLING-XXX
xxx-add String objects to hold text 
xxx-add method to read from file line by line and set each line to a string
xxx-modify methods to return String holding the required text. 
