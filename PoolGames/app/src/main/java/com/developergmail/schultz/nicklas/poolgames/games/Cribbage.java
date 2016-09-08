package com.developergmail.schultz.nicklas.poolgames.games;

import android.view.View;

import com.developergmail.schultz.nicklas.poolgames.R;
import com.developergmail.schultz.nicklas.poolgames.Rule;

/**
 * Created by nicklasschultz on 05/09/16.
 */
public class Cribbage extends IGame {
    private String name;
    private Rule rules;
    private int icon;

    public Cribbage(String name, Rule rules, int icon) {
        this.name = name;
        this.rules = rules;
        this.icon = icon;
    }
    @Override
    void addPoints(int points) {

    }

    @Override
    public int getLayoutId() {
        return R.layout.standard_result_view;
    }

    @Override
    public void addEventListeners() {
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getIcon() {
        return icon;
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
    @Override
    public int getRack() {
        return R.drawable.cribbage_rack;
    }
}
