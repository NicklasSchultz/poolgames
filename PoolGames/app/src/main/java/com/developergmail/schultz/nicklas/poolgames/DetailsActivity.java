package com.developergmail.schultz.nicklas.poolgames;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ExpandableListView;

import com.developergmail.schultz.nicklas.poolgames.Adapters.ExpandableListAdapter;
import com.developergmail.schultz.nicklas.poolgames.Adapters.GamesListAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DetailsActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    ExpandableListAdapter listAdapter;
    ExpandableListView expListView;
    View buttonsView;
    List<String> listDataHeader;
    HashMap<String, List<String>> listDataChild;
    private Game game;
    Button showRulesButton;
    Button showResultsButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        String gameName = getIntent().getStringExtra(GamesListAdapter.GAME_SELECTED);
        ContentManager contentManager = (ContentManager) getApplicationContext();
        this.game = contentManager.getGameByName(gameName);
        setTitle(game.getName());
        setupNav();

        expListView = (ExpandableListView) findViewById(R.id.lvExp);
        buttonsView = findViewById(R.id.buttonsLayout);
        showRulesButton = (Button) findViewById(R.id.rules);
        showResultsButton = (Button) findViewById(R.id.gameon);
        buttonsView.setVisibility(View.VISIBLE);
        prepareListData();
        listAdapter = new ExpandableListAdapter(this, listDataHeader, listDataChild);
        expListView.setAdapter(listAdapter);

        showRulesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switchView();
            }
        });
        showResultsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showResults();
            }
        });
    }

    private void showResults() {
        // Go to results view
    }

    private void setupNav() {
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

    private void switchView() {
        if(buttonsView.getVisibility() == View.VISIBLE) {
            expListView.setVisibility(View.VISIBLE);
            buttonsView.setVisibility(View.GONE);
        } else {
            expListView.setVisibility(View.INVISIBLE);
            buttonsView.setVisibility(View.VISIBLE);
        }
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
        getMenuInflater().inflate(R.menu.details, menu);
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

    /*
     * Preparing the list data
     */
    private void prepareListData() {
        // setting list adapter

        listDataHeader = new ArrayList<>();
        listDataChild = new HashMap<>();

        // Adding child data
        listDataHeader.add("Game Setup");
        listDataHeader.add("Gameplay");
        listDataHeader.add("Winning");

        // Adding child data
        List<String> gameSetup = new ArrayList<>();
        gameSetup.add(game.getRules().getGameSetup());

        List<String> nowShowing = new ArrayList<>();
        nowShowing.add(game.getRules().getGamePlay());

        List<String> comingSoon = new ArrayList<>();
        comingSoon.add(game.getRules().getWinning());

        listDataChild.put(listDataHeader.get(0), gameSetup); // Header, Child data
        listDataChild.put(listDataHeader.get(1), nowShowing);
        listDataChild.put(listDataHeader.get(2), comingSoon);
    }
}
