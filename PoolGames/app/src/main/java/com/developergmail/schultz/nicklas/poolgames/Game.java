package com.developergmail.schultz.nicklas.poolgames;

import android.media.Image;

/**
 * Created by nicklasschultz on 30/08/16.
 */
public class Game {

    private String name;
    private Rule rules;
    private int image;

    public Game(String name, Rule rules, int image) {
        this.name = name;
        this.rules = rules;
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public Rule getRules() {
        return rules;
    }

    public int getImage() {
        return image;
    }
}
