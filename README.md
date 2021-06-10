# CSA-CanyonBomber

Game:
We’ll be making a Canyon Bomber game. 
Two players fly blimps over a canyon filled with rocks and try to drop bombs on the rocks to gain points. 
The rocks are arranged in layers of different colors, with each color associated with a different point value. 
Once all the rocks are gone or one of the players misses a rock five times, the game is over.

Project Description:
Most of the game is run through the CanyonBomber class. 
Main and GameRunner initialize a new CanyonBomber object to play the game. 
CanyonBomber contains multiple objects of other classes, including RockPile, Blimp, Score, SLives, and BombSupply. 
These objects make up what is seen in the game when it is played, fulfilling the graphical component of the project. 

The classes Rock, Bomb/Blimp, and Score/SLives inherit from the abstract classes Block, MovingThing, and SBoard, respectively. 
These classes provide an appropriate abstraction for the program as the functions carried out by these objects’ methods need to be called multiple times when the game is run. 
Block, MovingThing, and SBoard all declare certain private variables that pertain to the objects’ functionalities and provide getter/setter methods to access these variables, demonstrating encapsulation. 
Polymorphism was performed by overriding methods like move and draw in the Blimp and Bomb class, as well as overloading constructors and establishing multiple IS-A relationships for the objects in the game.

The persistence component of the project is met through the highScore class and the scores.txt file. 
Whenever a game is won by the player, their score is written down on a new line in the txt file. 
Each time after the game ends, the scores file is read line-by-line to determine the highest score value and is displayed when the game ends.

