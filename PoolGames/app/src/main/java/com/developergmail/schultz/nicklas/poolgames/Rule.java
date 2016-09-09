package com.developergmail.schultz.nicklas.poolgames;

import android.text.SpannableString;
import android.text.SpannableStringBuilder;

/**
 * Created by nicklasschultz on 01/09/16.
 */
public class Rule {

    private SpannableStringBuilder gameSetup;
    private SpannableStringBuilder gamePlay;
    private SpannableStringBuilder winning;
    private SpannableStringBuilder g;

    public Rule(SpannableStringBuilder gameSetup, SpannableStringBuilder gamePlay, SpannableStringBuilder winning) {
        this.gameSetup = gameSetup;
        this.gamePlay = gamePlay;
        this.winning = winning;
    }


    public SpannableStringBuilder getGamePlay() {
        return gamePlay;
    }

    public SpannableStringBuilder getWinning() {
        return winning;
    }

    public SpannableStringBuilder getGameSetup() {
        return gameSetup;
    }
}
