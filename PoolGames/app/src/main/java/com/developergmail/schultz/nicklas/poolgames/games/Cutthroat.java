package com.developergmail.schultz.nicklas.poolgames.games;

import android.view.View;

import com.developergmail.schultz.nicklas.poolgames.Rule;

/**
 * Created by nicklasschultz on 05/09/16.
 */
public class Cutthroat extends IGame {
    private String name;
    private Rule rules;
    private int image;

    public Cutthroat(String name, Rule rules, int image) {
        this.name = name;
        this.rules = rules;
        this.image = image;
    }
    @Override
    void addPoints(int points) {

    }

    @Override
    public int getLayoutId() {
        return 0;
    }

    @Override
    public void addEventListeners() {

    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getImage() {
        return image;
    }

    @Override
    public Rule getRules() {
        return rules;
    }

    @Override
    public void setView(View view) {

    }

    @Override
    public void setCurrentPlayer(int i) {

    }
}
