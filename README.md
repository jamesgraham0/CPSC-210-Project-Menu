# Don't Get Hit

## *Don't Get Hit* is a single player java application where you dodge enemies to progress to the next level.



----------
- **What will the application do?**

*Don't Get Hit* is a single player game where the user uses the arrow keys to move their
character to avoid enemies and reach the end zone in order to progress to the next level.
It will run as a Java application via simple GUI (Graphical User Interface).


----------


- **Who will use it?**

Anyone! *Don't Get Hit* is a fun and intuitive game anyone can enjoy. It is a Java application though,
so you must use java to play.

----------

- **Why is this project of interest to you?**

After passing around ideas for this project I've decided that it would be significantly more rewarding and 
enjoyable to make a game, as it sparks my interests. I was three years old when I mastered the classic side-scroller - Super Mario World on the Super Nintendo.
Since then, I've been obsessed with the Nintendo 64, Gamecube, Wii, Wii U, and now the Nintendo Switch.
The evolution of smartphones has made playing intuitive, quickly completed games extremely common; games
with few controls, and a clear goal are easy to play on a bus ride or while waiting for a friend.
Because of my love for video games and inspiration from the current market of mobile games I've decided
to make *Don't Get Hit*. 

----------

## **User Stories**

- As a user, I want to be able to change my character's name.
- As a user, I want to be able to select a color for my character.
- As a user, I want to be able to select the difficulty of level based on
what levels I have already completed.
- As a user, I want to be able to access a short "how to play" explanation.
- As a user, I want to be able to save my current game, which saves my character's
name, color, and available/locked levels.
- As a user, I want to be able to load my previously saved file with my character's
name, color, and available/locked levels.

### **Phase 4: Task 2**
There are several bi-directional associations within my code. One of which is shared between
the MainMenuPanel and LevelsButtonPanel classes, where the LevelsButtonPanel is added onto
the MainMenuPanel and is manipulated through this class depending on the user input. Most
notably, the relationship can be viewed through the clearPanelsAndButtons() and regeneratePanelsAndButtons()
methods in the MainMenuPanel class, and the overridden actionPerformed(ActionEvent e) method in
the LevelsButtonPanel class.

### **Phase 4: Task 3**
The UML diagram of this app reminds me that I am new to coding in general, and that projects
don't turn out perfectly on the first try. The design of the diagram didn't have much
organization, and there are classes that are not yet implemented. Otherwise, I think that the 
JPanel's are well-designed and represented in the diagram where there is one main menu containing all
panels. Depending on the user input, these panels become visible and invisible. I really enjoyed making
that. If I had more time to work on the project I could:
- Decrease code duplication.
- Delete any functionless lines of code.
- Delete code from previous phases that is no longer needed to run my GUI.
- Plan more efficient class associations, reducing the number of associations coming from the Player class.
- Improve readability by improving method specifications and refactoring large bits of code into
their own methods.