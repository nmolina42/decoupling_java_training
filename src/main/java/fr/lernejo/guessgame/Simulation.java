package fr.lernejo.guessgame;


import fr.lernejo.logger.Logger;
import fr.lernejo.logger.LoggerFactory;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Simulation {
    private final Logger logger = LoggerFactory.getLogger("simulation");
    private final Player player;  //TODO add variable type
    private long numberToGuess; //TODO add variable type

    public Simulation(Player player) {
        this.player = player;
    }

    public void initialize(long numberToGuess) {
        this.numberToGuess = numberToGuess;
    }

    /**
     * @return true if the player have guessed the right number
     */
    private boolean nextRound() {
        long num = player.askNextGuess();
        if (num == numberToGuess) {
            return true;
        }
        if (num < numberToGuess) {
            logger.log("Le nombre est plus grand\n");
            player.respond(true);
        }else{
            logger.log("Le nombre est plus petit\n");
            player.respond(false);
        }
        return false;
    }

    public void loopUntilPlayerSucceed(long maximumLoops) {
        boolean win = false;
        long start = System.currentTimeMillis();
        for (int i = 0; i < maximumLoops; i++) {
            if (nextRound()) {
                win = true;
                break;
            }
        }
        long eLapsedTime = System.currentTimeMillis() - start;
        if(win)
        {
            logger.log("You have won\n");
        }else{
            logger.log("Vous avez perdu\n");
        }
        //logger.log(won ? "Bravo, vous avez done !" : "C'est la fin, vous avez perdu");
        logger.log("Temps total : "  + new SimpleDateFormat("mm:ss:SSS").format(new Date(eLapsedTime)));
    }
}
