package com.developergmail.schultz.nicklas.poolgames.games;

import android.view.View;

import com.developergmail.schultz.nicklas.poolgames.Rule;

/**
 * Created by nicklasschultz on 05/09/16.
 */
public abstract class IGame {

    abstract void addPoints(int points);

    abstract public int getLayoutId();

    abstract public void addEventListeners();

    abstract public String getName();

    abstract public int getIcon();

    abstract public int getRack();

    abstract public Rule getRules();

    abstract public void setView(View view);

    abstract public void setCurrentPlayer(int i);
}
