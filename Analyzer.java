
import java.util.Scanner;

public class Analyzer {

    public int wins = 0; //Keeps tally of wins
    public int comeoutWins = 0; //Keeps tally of come out wins
    public int trials = 0; //Tally of total number of games played
    private final double PROBABILITY = 0.4929; //Probability of winning a game
    private final double COMEOUT_PROB = 0.2221;//Probability of win on come out
    private final double COMEOUT_END = 0.4210;//Proabibility of game end in comeout
    public int continuedGames = 0; //Keeps tally of game continued past comeout
    double winOutcome = 0; //Initializes variable to calculate win percentage
    int comeOutGames = 0; //Tally of games ending in the come out roll
    public int longestGame = 0; //Keeps length of the longest game

    public static void main(String args[]) {
        Analyzer test = new Analyzer();
        test.runGame();
        test.printWinStats();
    }

    /**
     * method runGame() Asks user for input and runs Craps class as many time as
     * defined by user Increments variables to tally wins and prints statistics
     * calculated from the variables from the tallies.
     *
     * @param: none
     * @return none
     */
    public void runGame() {
        Scanner input = new Scanner(System.in);
        Craps game = new Craps();
        System.out.print("Enter number of games: ");
        if (input.hasNextInt()) {
            trials = input.nextInt();
            for (int i = 1; i <= trials; i++) {
                game.playGame();
                if (game.currentGameLength > longestGame) {
                    longestGame = game.currentGameLength;
                }
                game.currentGameLength = 0;
                if (game.win) {
                    wins++;
                }
                if (game.comeoutWin) {
                    comeoutWins++;
                }
                if (game.continuedGame) {
                    continuedGames++;
                }
                if (game.comeoutGame) {
                    comeOutGames++;
                }
            }
            double averageLength = (double) game.diceRolled / trials;
            System.out.println("\nGame Statistics");
            System.out.println("(1) Games played: " + trials);
            System.out.println("(2) Total rolls: " + game.diceRolled);
            System.out.println("(3) Average game length: "
                    + String.format("%.4f", averageLength));
            System.out.println("(4) Longest game played: " + longestGame);
        }
    }

    /**
     * Method printWinStats() Calculates different win probabilities from the
     * games played. Also prints all the game statistics to 4 decimal accuracy.
     *
     * @param: none
     * @return none
     */
    public void printWinStats() {
        winOutcome = (double) wins / (double) trials;
        float actualComeoutP = (float) comeoutWins / (float) comeOutGames;
        double comeoutWinP = (double) comeOutGames / trials;
        float continuedGameP = (float) (trials - comeOutGames) / trials;
        System.out.println();
        System.out.println("(5) Total wins: " + wins);
        System.out.println("(7) Calculated win percentage: "
                + String.format("%.4f", winOutcome));
        System.out.println("(6) Expected win percentage: "
                + String.format("%.4f", PROBABILITY));
        System.out.println();
        System.out.println("(8) Come out wins: " + comeoutWins);
        System.out.println("(10) Expected probability of winning on come out: "
                + String.format("%.4f", COMEOUT_PROB));
        System.out.println("(11) Calculated probability of winning on come out: "
                + String.format("%.4f", actualComeoutP));
        System.out.println();
        System.out.println("(9) Games ended in comeout: " + comeOutGames);
        System.out.println("(12) Expected probability of game ending in comeout: "
                + COMEOUT_END);
        System.out.println("(13) Outcome of games ending on comeout: "
                + (String.format("%.4f", comeoutWinP)));
        System.out.println();
        System.out.println("(14) Total number of continued games after comeout: "
                + continuedGames);
        System.out.println("(15) Expected probability of the games continuing  "
                + (String.format("%.4f", 1 - COMEOUT_END)));
        System.out.println("(16) Calculated outcome of games continuing after "
                + "the coming out roll: " + continuedGameP);

    }
}
