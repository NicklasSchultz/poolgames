package com.developergmail.schultz.nicklas.poolgames.Fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.SpannableString;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.developergmail.schultz.nicklas.poolgames.R;
import com.developergmail.schultz.nicklas.poolgames.games.IGame;
import com.developergmail.schultz.nicklas.poolgames.helpers.StringHelper;

/**
 * Created by nicklasschultz on 08/09/16.
 */
public class RulesFragment extends Fragment {

    private IGame game;
    public RulesFragment(IGame game) {
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
}
