# Wingspan
by Brian Deitchman, Madison Schiller and Simon Wand


## October 25th submission

* There is only one kind of food and eggs yet
* Each player gets 10 food tokens, 10 eggs and 3 bird cards
* There are 9 different birds in the game
* Three of the four possible moves have been implemented yet
* The playBird() function gives the player the option to choose one of his birds and play it on the birds habitat
* The gainFood() function adds a random amount of food tokens between one and six to the players total amont of food tokens
* The drawBird() function draws a random Bird card from the stack of bird cards and adds it to the players birds cards
* The game is 3 rounds. After the 3 rounds the score is displayed

## Testing tool description

* The testing tool is written in python
* To run the testing tool in a command line navigate to the 'src' directory on your disk and type 'python testingTool.py'.
* The testing tool reads a JSON file containing the names of all the test classes of the project.
* The testing tool compiles each test class and each associated class.
* After that it runs every test and prints to the command line whether the test was successful or not.
