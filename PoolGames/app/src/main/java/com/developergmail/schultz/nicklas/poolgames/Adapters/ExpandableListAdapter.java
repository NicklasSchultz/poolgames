package com.developergmail.schultz.nicklas.poolgames.Adapters;

import android.content.Context;
import android.graphics.Typeface;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.developergmail.schultz.nicklas.poolgames.R;
import com.developergmail.schultz.nicklas.poolgames.games.IGame;

import java.util.HashMap;
import java.util.List;

/**
 * Created by nicklasschultz on 01/09/16.
 */

public class ExpandableListAdapter extends BaseExpandableListAdapter {

    private Context _context;
    private List<String> _list_groups;
    private HashMap<String, List<String>> _listChildren;
    private IGame _game;

    public ExpandableListAdapter(Context context, List<String> list_groups,
                                 HashMap<String, List<String>> listChildren, IGame game) {
        this._context = context;
        this._list_groups = list_groups;
        this._listChildren = listChildren;
        this._game = game;
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return this._listChildren.get(this._list_groups.get(groupPosition))
                .get(childPosition);
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public View getChildView(int groupPosition, final int childPosition,
                             boolean isLastChild, View convertView, ViewGroup parent) {

        final String childText = (String) getChild(groupPosition, childPosition);

        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) this._context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.list_item, null);
        }

        TextView txtListChild = (TextView) convertView
                .findViewById(R.id.lblListItem);

        ImageView iv = (ImageView) convertView.findViewById(R.id.lblListImage);

        txtListChild.setText(childText);
        Log.d("NICKLAS", "group position " + groupPosition);
        if(groupPosition == 0) {
            iv.setImageResource(R.drawable.rack_setup);
        }
        return convertView;
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return this._listChildren.get(this._list_groups.get(groupPosition))
                .size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return this._list_groups.get(groupPosition);
    }

    @Override
    public int getGroupCount() {
        return this._list_groups.size();
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        String headerTitle = (String) getGroup(groupPosition);
        if (convertView == null) {
            LayoutInflater infalInflater = (LayoutInflater) this._context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = infalInflater.inflate(R.layout.list_group, null);
        }

        TextView lblListHeader = (TextView) convertView
                .findViewById(R.id.lblListHeader);
        lblListHeader.setTypeface(null, Typeface.BOLD);
        lblListHeader.setText(headerTitle);

        return convertView;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }
}
