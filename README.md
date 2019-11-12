# Wingspan
by Brian Deitchman(briandeutchman1), Madison Schiller(madischiller) and Simon Wand(Similly)


## October 25th submission

* There is only one kind of food and eggs yet
* Each player gets 10 food tokens, 10 eggs and 3 bird cards
* There are 9 different birds in the game
* Three of the four possible moves have been implemented yet
* The playBird() function gives the player the option to choose one of his birds and play it on the birds habitat
* The gainFood() function adds a random amount of food tokens between one and six to the players total amont of food tokens
* The drawBird() function draws a random Bird card from the stack of bird cards and adds it to the players birds cards
* The game is 3 rounds. After the 3 rounds the score is displayed

## October 30th submission game functionality

* The game has 54 birds implemented.
* At first the game asks for the amount of players (1-4)
* The game is 3 rounds so each player has 3 turns
* A player has 8 action cubes during his turn, so he can make up to 8 moves
* The player has 5 moves to choose from
* The first move is play a bird. The player chooses a bird from its hand, pays its foodcost and then puts it in the birds habitat.
* The second move is gain food. The player gains food dependent on the amount of birds he has in its forrest section.
* The third move is lay eggs. The player increases his eggCount dependent on the amount of birds he has on its grassland section.
* The fourth move is draw a bird card. The player gets a random bird from the birdstack.
* The fifth move is to end the tunr. If the player has some action cubes left but doesn't want to make any more moves he can end his turn.
* The players board gets printed after each move.
* At the end of the game the score of each player gets printed.

## November 8th submission

* implemented the model-view-controller-pattern
* moved all the view elements from the model to a new view directory

## November 13th submission

* updated bird class and added some fields(score, egglimit, food, habitats)
* added birds.json file containing all bird cards of the game
* implemented a new initBirds function to read the json file and create the bird objects

## Testing tool description

* The testing tool is written in python
* To run the testing tool in a command line navigate to the 'src' directory on your disk and type 'python testingTool.py'.
* The testing tool reads a JSON file containing the names of all the test classes of the project.
* The testing tool compiles each test class and each associated class.
* After that it runs every test and prints to the command line whether the test was successful or not.

## installation of the JSON.simple library

* To parse the JSON file we are using the JSON.simple library
* To compile the program you have to add the library to your classpath
* download the .jar file (http://www.java2s.com/Code/Jar/j/Downloadjsonsimple111jar.htm)
* add the jar file to your dependencies:
  * Eclipse: https://www.edureka.co/community/4028/how-to-import-a-jar-file-in-eclipse
  * Intellij: https://stackoverflow.com/questions/1051640/correct-way-to-add-external-jars-lib-jar-to-an-intellij-idea-project
