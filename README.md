**Battleship Game**


Welcome to the Battleship Game! This README will guide you through the setup and rules of the game.

**Game Setup**


***1. Start the Game***

Each player takes turns to place their ships on the game field.

***2. Game Field***

The game field is a 10x10 grid. Rows are labeled A to J, and columns are labeled 1 to 10.

***3. Placing Ships***

Each player has the following ships to place:

*1 Aircraft Carrier (5 cells)*

*1 Battleship (4 cells)*

*1 Submarine (3 cells)*

*1 Cruiser (3 cells)*

*1 Destroyer (2 cells)*

***4. Example of Ship Placement***

Player 1, place your ships on the game field:
```
  1 2 3 4 5 6 7 8 9 10
A ~ ~ ~ ~ ~ ~ ~ ~ ~ ~
B ~ ~ ~ ~ ~ ~ ~ ~ ~ ~
C ~ ~ ~ ~ ~ ~ ~ ~ ~ ~
D ~ ~ ~ ~ ~ ~ ~ ~ ~ ~
E ~ ~ ~ ~ ~ ~ ~ ~ ~ ~
F ~ ~ ~ ~ ~ ~ ~ ~ ~ ~
G ~ ~ ~ ~ ~ ~ ~ ~ ~ ~
H ~ ~ ~ ~ ~ ~ ~ ~ ~ ~
I ~ ~ ~ ~ ~ ~ ~ ~ ~ ~
J ~ ~ ~ ~ ~ ~ ~ ~ ~ ~
```

***5. Enter Coordinates***

Example: For the Aircraft Carrier (5 cells), you might enter F3 F7. The field will update:

```
  1 2 3 4 5 6 7 8 9 10
A ~ ~ ~ ~ ~ ~ ~ ~ ~ ~
B ~ ~ ~ ~ ~ ~ ~ ~ ~ ~
C ~ ~ ~ ~ ~ ~ ~ ~ ~ ~
D ~ ~ ~ ~ ~ ~ ~ ~ ~ ~
E ~ ~ ~ ~ ~ ~ ~ ~ ~ ~
F ~ ~ O O O O O ~ ~ ~
G ~ ~ ~ ~ ~ ~ ~ ~ ~ ~
H ~ ~ ~ ~ ~ ~ ~ ~ ~ ~
I ~ ~ ~ ~ ~ ~ ~ ~ ~ ~
J ~ ~ ~ ~ ~ ~ ~ ~ ~ ~
```

***6. Error Handling***

If you enter the wrong length for a ship or place it incorrectly, you will get an error message. Correct the placement to proceed.


**Taking Turns**


***1. Player Turns***

Players take turns to guess the coordinates of the opponent’s ships.

***2. Missed Shots***

If you miss, the game will indicate a miss:

```
Player 1, it's your turn:
> I3
You missed!
Press Enter and pass the move to another player.
```

***3. Hits***

If you hit an opponent’s ship, the game will indicate a hit:

```
Player 2, it's your turn:
> A1
You hit a ship!
Press Enter and pass the move to another player.
```

**Winning the Game**

The game continues until one player sinks all the ships of the opponent. The player who achieves this first is the winner.

**Notes**

Make sure to enter coordinates correctly.
Ships cannot overlap or be placed next to each other.
The game field updates after each move.

Enjoy the game!
