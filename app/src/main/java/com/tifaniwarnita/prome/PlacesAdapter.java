package com.tifaniwarnita.prome;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

/**
 * Created by Tifani on 5/14/2016.
 */
public class PlacesAdapter extends BaseAdapter {
    Context context;
    int[] layout;

    public PlacesAdapter(Context context, int[] layout) {
        this.context = context;
        this.layout = layout;
    }

    @Override
    public int getCount() {
        return layout.length;
    }

    @Override
    public Object getItem(int position) {
        return layout[position];
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View gridView;
        if (convertView == null) {
            gridView = new View(context);

            // get layout from mobile.xml
            int currentLayout = layout[position];
            gridView = inflater.inflate(currentLayout, null);

        } else {
            gridView = (View) convertView;
        }

        return gridView;
    }
}
