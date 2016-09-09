package com.developergmail.schultz.nicklas.poolgames.games;

import android.view.View;
import android.view.animation.Interpolator;
import android.widget.ImageButton;
import android.widget.TextView;

import com.developergmail.schultz.nicklas.poolgames.R;
import com.developergmail.schultz.nicklas.poolgames.Rule;

/**
 * Created by nicklasschultz on 05/09/16.
 */
public class Snooker extends IGame {

    private static int LAYOUT_ID = R.layout.snooker_results;
    private final String name;
    private final Rule rules;
    private final int image;
    private View view;
    private TextView player1score;
    private TextView player2score;
    private TextView playerStats;
    private int turn;
    private int redsPotted = 0;
    private int totalReds = 15;
    private TextView player1name;
    private TextView player2name;

    public Snooker(String name, Rule rules, int image) {
        this.name = name;
        this.rules = rules;
        this.image = image;
    }

    @Override
    public int getLayoutId() {
        return LAYOUT_ID;
    }

    public void setView(View view) {
        this.view = view;
        player1score = (TextView) view.findViewById(R.id.player1score);
        player2score = (TextView) view.findViewById(R.id.player2score);
        player1name = (TextView) view.findViewById(R.id.player1name);
        player2name = (TextView) view.findViewById(R.id.player2name);
        playerStats = (TextView) view.findViewById(R.id.stats);
    }

    @Override
    public void addEventListeners() {
        ImageButton[] _button = new ImageButton[7];
        _button[0] = (ImageButton) view.findViewById(R.id.Button01);
        _button[1] = (ImageButton) view.findViewById(R.id.Button02);
        _button[2] = (ImageButton) view.findViewById(R.id.Button03);
        _button[3] = (ImageButton) view.findViewById(R.id.Button04);
        _button[4] = (ImageButton) view.findViewById(R.id.Button05);
        _button[5] = (ImageButton) view.findViewById(R.id.Button06);
        _button[6] = (ImageButton) view.findViewById(R.id.Button07);

        for (int j = 0; j < _button.length; j++){
            _button[j].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    buttonClickListener(v);
                }
            });
        }
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getIcon() {
        return image;
    }

    @Override
    public int getRack() {
        return R.drawable.snooker_reds;
    }

    @Override
    public Rule getRules() {
        return rules;
    }

    @Override
    public void addPoints(int points) {
        if(points == 1) {
            redsPotted++;
        }
        int currentScore;
        if(turn == 1) {
            currentScore = Integer.parseInt(player1score.getText().toString());
            currentScore += points;
            player1score.setText(Integer.toString(currentScore));
        } else {
            currentScore = Integer.parseInt(player2score.getText().toString());
            currentScore += points;
            player2score.setText(Integer.toString(currentScore));
        }
        int p1Score = Integer.parseInt(player1score.getText().toString());
        int p2Score = Integer.parseInt(player2score.getText().toString());
        int ahead = 0;
        int left;
        String s;
        left = getPointsLeft();
        if(points == 1) {
            left += 7;
        }
        if(p1Score > p2Score) {
            ahead = p1Score - p2Score;
            s = player1name.getText().toString() + " is ahead with " + ahead + ", points left " + left;
        } else {
            ahead = p2Score - p1Score;
            s = player2name.getText().toString() + " is ahead with " + ahead + ", points left " + left;
        }
        playerStats.setText(s);
    }

    private int getPointsLeft() {
        return ((totalReds - redsPotted) * 8) + 27;
    }

    @Override
    public void setCurrentPlayer(int i){
        turn = i;
    }

    private void buttonClickListener(View v) {
        int id = v.getId();
        int points = 0;
        switch (id) {
            case R.id.Button01:
                points = 1;
                break;
            case R.id.Button02:
                points = 2;
                break;
            case R.id.Button03:
                points = 3;
                break;
            case R.id.Button04:
                points = 4;
                break;
            case R.id.Button05:
                points = 5;
                break;
            case R.id.Button06:
                points = 6;
                break;
            case R.id.Button07:
                points = 7;
                break;
        }
        addPoints(points);
    }
}
