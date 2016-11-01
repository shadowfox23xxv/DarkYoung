Dark Young - an interactive fiction horror game

After hitting a few issues with building the game, the decision has been made to start from scratch, rebuilding everything utilizing a new code architecture.  The reason for this decision stems from flaws in the original design process.  These flaws have resulted in a code architecture that makes continued development and implementation of the games inteded features difficult. 

In order to produce an efficient game that can be developed and maintained properly, developement will start back from the beginning, utilizing an Entity Component System based architecture.  This should allow the implementation of all the desired features of the game in a way that is faster and more effecient to develope, maintain, and add to in the future. 

Although development will be starting from scratch, version control will continue as is, so all steps from this point on will begin with v0.10. 

[=]v0.10 - Basic splash screen 
[+]DarkYoung.java - game loop
[+]Interface.java - user interface, handles formatting, printing, and input
[+]GameMode.java - objects that link parser, standard messages, etc...
[+]ScriptLoader.java - object that loads script files and returns an array, can load as either 2 dimensional array for various values(object creation, ect...) or 1D array for lines of text
[+]Handler.java - handler object to pass access to methods between objects

 


Components:

[+] player
[+] room
[+] collectible 
[+] position
[+] inventory
[+] name/id
[+] health
[+] throw
[+] swing
[+] on/off
[+] usabel
[+] weight
[+] description
[+] exits
[+] locked
[+] scopeofview

  
