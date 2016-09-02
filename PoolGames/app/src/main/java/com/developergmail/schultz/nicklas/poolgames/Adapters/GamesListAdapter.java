package com.developergmail.schultz.nicklas.poolgames.Adapters;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.developergmail.schultz.nicklas.poolgames.DetailsActivity;
import com.developergmail.schultz.nicklas.poolgames.Game;
import com.developergmail.schultz.nicklas.poolgames.R;

import java.util.ArrayList;

/**
 * Created by nicklasschultz on 30/08/16.
 */
public class GamesListAdapter extends BaseAdapter{

    private ArrayList<Game> games;
    private Activity context;
    private static LayoutInflater inflater = null;
    public static final String GAME_SELECTED = "GAME_SELECTED";

    public GamesListAdapter(Activity activity, ArrayList<Game> games) {
        this.games = games;
        this.context = activity;

        this.inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return this.games.size();
    }

    @Override
    public Object getItem(int position) {
        return this.games.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public class Holder
    {
        TextView textView;
        ImageView imageView;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        Holder holder=new Holder();
        View rowView;
        Game game = this.games.get(position);
        rowView = inflater.inflate(R.layout.image_text_layout, null);
        holder.textView =(TextView) rowView.findViewById(R.id.textView1);
        holder.imageView =(ImageView) rowView.findViewById(R.id.imageView1);
        holder.textView.setText(game.getName());
        holder.imageView.setImageResource(game.getImage());
        rowView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Game game = games.get(position);
                Intent intent = new Intent(context, DetailsActivity.class);
                intent.putExtra(GAME_SELECTED, game.getName());
                context.startActivity(intent);
            }
        });
        return rowView;
    }
}
