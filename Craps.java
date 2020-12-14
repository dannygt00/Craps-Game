
public class Craps {
    
    
// Calls Die class to create new Die object
    Die d = new Die(6);

    private static final int SNAKE_EYES = 2; //dice roll of 2
    private static final int TREY = 3; //Dice roll of 3
    private static final int SEVEN = 7; // Dice roll of 7
    private static final int YOLEVEN = 11; //Dice roll of 11
    private static final int BOXCARS = 12; //Dice roll of 12
    public int diceRolled = 0; //Keeps counter of how many total dice rolled
    public boolean win = true; // Determines if the game has been won
    public boolean comeoutWin = false; // Determines if the game won in comeout
    public boolean continuedGame = false; //Determines if game continued after comeout
    public boolean comeoutGame = false;//Determines if game end in comeout roll
    public int longestGame = 0; //Keeps length of the longest game in rolls
    public int currentGameLength = 0; //Keeps length of current game

    /** Method playGame()
     * Plays a game of Craps
     * Increments counters of different types of wins
     * @param: none
     * @return Whether the game resulted in a win or a loss
     */
    public boolean playGame() {
        int comeOut = d.rollDie(2);
        currentGameLength++;
        diceRolled++;
        switch (comeOut) {
            case SEVEN:
            case YOLEVEN:
                comeoutWin = true;
                continuedGame = false;
                comeoutGame = true;
                return win = true;
            case SNAKE_EYES:
            case TREY:
            case BOXCARS:
                comeoutGame = true;
                continuedGame = false;
                return win = false;
            default:
                int pointRoll = d.rollDie(2);
                currentGameLength++;
                diceRolled++;
                continuedGame = true;
                comeoutWin = false;
                comeoutGame = false;
                
                while (pointRoll != SEVEN && pointRoll != comeOut) {
                    if (pointRoll == comeOut) {
                        return win = true;
                    } else {
                        pointRoll = d.rollDie(2);
                        currentGameLength++;
                        diceRolled++;
                    }
                }
                if (pointRoll == SEVEN) {
                    return win = false;
                }
                return win;
        }
    }
/** method getLongestGame()
 * Uses finding maximum technique to find longest game
 * @param: none 
 * @return length of longest game played
 */
    public int getLongestGame() {
        if (longestGame < diceRolled) {
            longestGame = diceRolled;
        }
        return longestGame;
    }
   
}
