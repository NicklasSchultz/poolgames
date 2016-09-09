package com.developergmail.schultz.nicklas.poolgames.Fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.SpannableString;
import android.text.style.RelativeSizeSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.developergmail.schultz.nicklas.poolgames.R;
import com.developergmail.schultz.nicklas.poolgames.games.IGame;

/**
 * Created by nicklasschultz on 08/09/16.
 */
public class RulesMainFragment extends Fragment {

    private IGame game;

    public RulesMainFragment(IGame game) {
        this.game = game;
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_image_object, container, false);
        ImageView imgView = (ImageView) rootView.findViewById(R.id.rack_image);
        imgView.setImageResource(game.getRack());
        TextView txt = (TextView) rootView.findViewById(R.id.rack_text);
        txt.append(game.getRules().getGameSetup());

        return rootView;
    }
}