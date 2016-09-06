package com.developergmail.schultz.nicklas.poolgames;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.developergmail.schultz.nicklas.poolgames.games.IGame;

public class ResultActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private LinearLayout playerNamesView;
    private LinearLayout resultView;
    private Button button;
    private TextView player1;
    private TextView player2;
    private int turn;
    private TextView player2score;
    private TextView player1score;
    private TextView playerTurn;
    private IGame game;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        setupNavigation();
        Intent intent = getIntent();
        String gameName = intent.getStringExtra(DetailsActivity.GAME);
        ContentManager cm = (ContentManager) getApplicationContext();
        game = cm.getGameByName(gameName);

        int layoutId = game.getLayoutId();

        LayoutInflater inflater = LayoutInflater.from(this);
        View inflatedLayout= inflater.inflate(layoutId, null, false);

        // Inflate the layout the set listener
        playerNamesView = (LinearLayout) findViewById(R.id.playerNamesView);
        resultView = (LinearLayout) findViewById(R.id.resultView);

        game.setView(resultView);

        // Add the games layout to the view
        resultView.addView(inflatedLayout);
        button = (Button) findViewById(R.id.startPlay);
        player1 = (TextView) findViewById(R.id.player1name);
        player2 = (TextView) findViewById(R.id.player2name);
        player1score = (TextView) findViewById(R.id.player1score);
        player2score = (TextView) findViewById(R.id.player2score);
        playerTurn = (TextView) findViewById(R.id.playerTurn);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startPlay();
            }
        });
        setupPlayerTurn();
        resultView.setVisibility(View.INVISIBLE);
        game.addEventListeners();
    }

    private void setupPlayerTurn() {
        ImageButton nextTurn = (ImageButton) findViewById(R.id.nextTurn);
        nextTurn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeTurn();
            }
        });
    }
    private void changeTurn() {
        if(turn == 1) {
            turn = 2;
            playerTurn.setText(player2.getText() + "'s turn");
        } else {
            turn = 1;
            playerTurn.setText(player1.getText() + "'s turn");
        }
        game.setCurrentPlayer(turn);
    }

    private void startPlay() {
        turn = 1;
        playerNamesView.setVisibility(View.INVISIBLE);
        resultView.setVisibility(View.VISIBLE);
        TextView p1 = (TextView) findViewById(R.id.p1);
        TextView p2 = (TextView) findViewById(R.id.p2);
        player1.setText(p1.getText());
        player2.setText(p2.getText());
        playerTurn.setText(player1.getText() + "'s turn");
    }

    private void setupNavigation() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.result, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_statistics) {
            // Handle the camera action
        } else if (id == R.id.nav_rules) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
