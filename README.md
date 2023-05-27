# SnakeGame

* The Snake Game is a simple console-based game where the player controls a snake to eat food and grow longer.
  The objective is to achieve the highest score possible without colliding with the walls or the snake's own body.

* The game is designed using Object-Oriented Programming (OOP) principles, allowing for easy extensibility and modularity.
The game follows the SOLID principles, ensuring a clean and maintainable code structure.


# Compilation and Execution
To compile and run the Snake Game, follow these steps:
* Make sure you have Java Development Kit (JDK) installed on your system.
* Open a terminal or command prompt and navigate to the project directory.
* Compile the Java source files using the following command:
   
```yava
 javac Board.java Cell.java CellType.java GameControler.java Snake.java GameTest.java 
 ```
    
start to play: run the game using the following command:
```java
java GameTest
```

# how  to play
 Use the following controls to navigate the snake:
 * 8 : Move the snake up
 * 5 : Move the snake down
 * 4 : Move the snake left
 * 6 : Move the snake right

NOTE : After each navigation, press Enter to confirm the movement.

* The snake will move continuously in the last chosen direction.
* The snake can eat food ('@') that randomly appears on the board. Eating food increases the snake's length and score.
* Avoid collisions with the walls or the snake's own body. Collisions will result in game over.
* The game ends when the snake collides with the walls or itself.

