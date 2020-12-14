
import java.util.Random;


/** Used to randomly generate a number to simulate a dice roll */
//import java.util.Random;

public class Die {

    private final int sides;
    private final Random rnd;

    /**
     * Initializes a dice object
     *
     * @param s Number of sides needed per dice
     */

    public Die(int s) {
        if (s <= 1) {
            s = 2;
        }
        if (s > 100) {
            s = 100;
        }
        sides = s;
        rnd = new Random();
    }

    /**
     * Rolls a die and calculates the outcome
     *
     * @param diceAmount Number of dice user wants to roll.
     * @return The total sum of the numbers rolled on the dice or die.
     */
    public int rollDie(int diceAmount) {
        int dicesum = 0;
        for (int i = 0; i < diceAmount; i++) {
            int currentRoll = 1 + rnd.nextInt(sides);
            dicesum += currentRoll;
        }
        return dicesum;
    }
}
