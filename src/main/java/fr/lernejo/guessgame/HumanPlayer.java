package fr.lernejo.guessgame;
import fr.lernejo.logger.Logger;
import fr.lernejo.logger.LoggerFactory;
import java.util.Scanner;

public class HumanPlayer implements Player {
    private static final Logger logger = LoggerFactory.getLogger("player");

    @Override
    public long askNextGuess() {
        long n = -1;
        try {
            n = new Scanner(System.in).nextLong();
        } catch (Exception e) {
            logger.log("Mauvais nombre !");
        }
        return n;
    }

    /**
     * Called by {@link Simulation} to inform that the previous guess was lower or greater that the number to find.
     */
    @Override
    public void respond(boolean lowerOrGreater) {
    }
}
