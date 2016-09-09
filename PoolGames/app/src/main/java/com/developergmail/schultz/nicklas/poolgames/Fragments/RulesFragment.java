package com.developergmail.schultz.nicklas.poolgames.Fragments;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.SpannableString;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import com.developergmail.schultz.nicklas.poolgames.LauncherActivity;
import com.developergmail.schultz.nicklas.poolgames.R;
import com.developergmail.schultz.nicklas.poolgames.ResultActivity;
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
            txt.setText(game.getRules().getGamePlay());
        } else {
            rootView = inflater.inflate(R.layout.fragment_image_object, container, false);
            TextView txt = (TextView) rootView.findViewById(R.id.rack_text);
            ImageButton imgBtn = (ImageButton) rootView.findViewById(R.id.startGame);
            imgBtn.setVisibility(View.VISIBLE);
            imgBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(getActivity(), ResultActivity.class);
                    intent.putExtra(LauncherActivity.GAME, game.getName());
                    getActivity().startActivity(intent);
                }
            });
            txt.setText(game.getRules().getWinning());
        }

        return rootView;
    }
}
