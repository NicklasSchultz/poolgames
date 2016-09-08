package com.developergmail.schultz.nicklas.poolgames;

import android.app.ActionBar;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.text.SpannableString;
import android.text.style.RelativeSizeSpan;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.developergmail.schultz.nicklas.poolgames.Adapters.GamesListAdapter;
import com.developergmail.schultz.nicklas.poolgames.games.IGame;
import com.developergmail.schultz.nicklas.poolgames.helpers.StringHelper;

import org.w3c.dom.Text;

public class GameDetailsActivity extends FragmentActivity implements ActionBar.TabListener {

    AppSectionsPagerAdapter mAppSectionsPagerAdapter;
    ViewPager mViewPager;
    private IGame game;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_details);

        Intent intent = getIntent();
        String gameName = intent.getStringExtra(DetailsActivity.GAME);
        ContentManager cm = (ContentManager) getApplicationContext();
        game = cm.getGameByName(gameName);

        // Create the adapter that will return a fragment for each of the three primary sections
        // of the app.
        mAppSectionsPagerAdapter = new AppSectionsPagerAdapter(getSupportFragmentManager(),game);

        // Set up the ViewPager, attaching the adapter and setting up a listener for when the
        // user swipes between sections.
        mViewPager = (ViewPager) findViewById(R.id.pager);
        mViewPager.setAdapter(mAppSectionsPagerAdapter);
        mViewPager.addOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener() {
            @Override
            public void onPageSelected(int position) {
                // Add dots and select the correct here
            }
        });
    }

    @Override
    public void onTabUnselected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {
    }

    @Override
    public void onTabSelected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {
        // When the given tab is selected, switch to the corresponding page in the ViewPager.
        mViewPager.setCurrentItem(tab.getPosition());
    }

    @Override
    public void onTabReselected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {
    }

    /**
     * A {@link FragmentPagerAdapter} that returns a fragment corresponding to one of the primary
     * sections of the app.
     */
    public static class AppSectionsPagerAdapter extends FragmentPagerAdapter {

        private IGame game;
        public AppSectionsPagerAdapter(FragmentManager fm, IGame game) {
            super(fm);
            this.game = game;
        }

        @Override
        public Fragment getItem(int i) {
            switch (i) {
                case 0:
                    // The first section of the app is the most interesting -- it offers
                    // a launchpad into the other demonstrations in this example application.
                    return new LaunchpadSectionFragment(game);

                default:
                    // The other sections of the app are dummy placeholders.
                    Fragment fragment = new DummySectionFragment(game);
                    Bundle args = new Bundle();
                    args.putInt(DummySectionFragment.ARG_SECTION_NUMBER, i + 1);
                    fragment.setArguments(args);
                    return fragment;
            }
        }

        @Override
        public int getCount() {
            return 3;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return "Section " + (position + 1);
        }
    }

    /**
     * A fragment that launches other parts of the demo application.
     */
    public static class LaunchpadSectionFragment extends Fragment {

        private IGame game;

        public LaunchpadSectionFragment(IGame game) {
            this.game = game;
        }
        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_image_object, container, false);
            ImageView imgView = (ImageView) rootView.findViewById(R.id.rack_image);
            imgView.setImageResource(game.getRack());
            TextView txt = (TextView) rootView.findViewById(R.id.rack_text);
            SpannableString styledString = new SpannableString("Game setup");
            styledString.setSpan(new RelativeSizeSpan(1.5f), 0 ,"Game setup".length(), 0);
            txt.append(styledString);
            txt.append("\n\n" + game.getRules().getGameSetup());

            return rootView;
        }
    }

    /**
     * A dummy fragment representing a section of the app, but that simply displays dummy text.
     */
    public static class DummySectionFragment extends Fragment {

        private IGame game;
        public DummySectionFragment(IGame game) {
            this.game = game;
        }

        public static final String ARG_SECTION_NUMBER = "section_number";

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            Bundle args = getArguments();
            int section = args.getInt(ARG_SECTION_NUMBER);
            View rootView;
            if(section == 2) {
                rootView = inflater.inflate(R.layout.fragment_image_object, container, false);
                TextView txt = (TextView) rootView.findViewById(R.id.rack_text);
                txt.append(StringHelper.getLargeText("Game Play"));
                txt.append("\n\n" + game.getRules().getGamePlay() + "\n\n");
            } else {
                rootView = inflater.inflate(R.layout.fragment_image_object, container, false);
                TextView txt = (TextView) rootView.findViewById(R.id.rack_text);
                txt.append(StringHelper.getLargeText("Winning"));
                txt.append("\n\n" + new SpannableString(game.getRules().getWinning()));
            }

            return rootView;
        }

        private void formatText(TextView v, String s) {
            SpannableString styledString = new SpannableString(s);
            styledString.setSpan(new RelativeSizeSpan(1.5f), 0 ,s.length(), 0);
            v.append(styledString);
        }
    }
}
