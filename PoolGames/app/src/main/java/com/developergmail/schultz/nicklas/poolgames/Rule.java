package com.developergmail.schultz.nicklas.poolgames;

/**
 * Created by nicklasschultz on 01/09/16.
 */
public class Rule {

    private String gameSetup;
    private String gamePlay;
    private String winning;

    public Rule(String gameSetup, String gamePlay, String winning) {
        this.gameSetup = gameSetup;
        this.gamePlay = gamePlay;
        this.winning = winning;
    }

    public String getGamePlay() {
        return gamePlay;
    }

    public String getWinning() {
        return winning;
    }

    public String getGameSetup() {
        return gameSetup;
    }
}
