Classes: main, character(sub player, monster, NPC), location, item(sub container), event, scripting, interface, inventory

Main: main control of game, instantiating objects, verifying command validity, executing player input

Character: virtual parent class for player, NPC, and monster classes. Each creates objects for their respective type of character within the game world. Health, location, inventory, name,

Player: single object for player character, max inventory, weirdness(measure of past contact with hidden reality)

Location: objects represent locations that can be visited. Exits(act as pointers to other locations) number of exits, description, inventory(items placed in location), dropped(container to hold items left at location by player) events(3types, one time events that happen when the player first enters location, triggered events, and random events that may trigger when player enters location), visited(boolen to mark if player has been here before, used to determine trigger for one time events)

Item: objects repressenting in game objects. Pickupable, throwable, swingable, useable, on, weight, prop

Container: derived from item class. Adds inventory function to hold other items. Max capacity

Event: objects represent events that may occur. Repeatable, triggered, is triggered, effects, additional description,

Scripting: single object, functions that return strings to be printed, should only be accessed only by interface class

Interface: single object, responsible for managing user interface(info printed to screen and receiving commands from player)

Inventory: class containing an inventory liked list and methods for organizing, listing, adding, and removing items. Used by all character derived classes, location class and container class.

===================================================================

Version control scheme:

Major(full release number).Minor/phase(functional incrementation).release state(0alpha, 1beta, 3release candidate, 4release version).develpmental incrementation(working on functional incrementation)

Version 0.1
-goals: add main, interface, and script classes. Minimal functionality intended as a baseline for functional development.

Version 0.2
-goals: add basic parsing and command validation to main, add debug mode commands and command to set debug mode flag

Version 0.3
-goals: add location class and implement via basic room with description, add additional commands for interaction with room

Version 0.4
-goals:expand map to include mutliple locations.  add appropriate commands. 

Version 0.5
-goals:add character class. Add player class. Add appropriate commands 

Version 0.6
-goals: Add item class.

Version 0.7
-goals: add inventory class. Implement inventory class in player class and location class. add basic items to room and player inventory.Add appropriate commands

Version 0.8
-goals: add container sub-class to item class.  Add appropriate commands.

Version 0.9
-goals: populate rooms with items and containers

Version 0.10
-goals: add events class. Create event triggered by placed item.
