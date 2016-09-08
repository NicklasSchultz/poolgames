package com.developergmail.schultz.nicklas.poolgames.Adapters;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.developergmail.schultz.nicklas.poolgames.Fragments.RulesFragment;
import com.developergmail.schultz.nicklas.poolgames.Fragments.RulesMainFragment;
import com.developergmail.schultz.nicklas.poolgames.games.IGame;

/**
 * Created by nicklasschultz on 08/09/16.
 */
public class AppSectionsPagerAdapter  extends FragmentPagerAdapter {

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
                return new RulesMainFragment(game);

            default:
                // The other sections of the app are dummy placeholders.
                Fragment fragment = new RulesFragment(game);
                Bundle args = new Bundle();
                args.putInt(RulesFragment.ARG_SECTION_NUMBER, i + 1);
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
