package com.tifaniwarnita.prome;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Tifani on 5/14/2016.
 */
public class PlacesAdapter extends BaseAdapter {
    private static final String TAG = PlacesAdapter.class.getSimpleName();
    Context context;
    int[] layout;
    ArrayList<Promo> promoLists;

    public PlacesAdapter(Context context, int[] layout, ArrayList<Promo> promoLists) {
        this.context = context;
        this.layout = layout;
        this.promoLists = promoLists;
        Log.d(TAG, layout.length + " + " + promoLists.size());
    }

    @Override
    public int getCount() {
        return layout.length + promoLists.size();
    }

    @Override
    public Object getItem(int position) {
        if (position < layout.length)
            return layout[position];
        else
            return promoLists.get(position - layout.length);
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

        if (position < layout.length) {
            Log.d(TAG, "Position: " + position + " default layout length " + layout.length);
            // if (convertView == null) {
                Log.d(TAG, "Null");
                int currentLayout = layout[position];
                gridView = inflater.inflate(currentLayout, null);

            /*} else {
                Log.d(TAG, "Not null");
                gridView = (View) convertView;
            }*/
        } else {
            Log.d(TAG, "Position: " + position + " custom layout length " + layout.length);
            //if (convertView == null) {
                Log.d(TAG, "Null");
                gridView = inflater.inflate(R.layout.promo_template, null);
                ((TextView) gridView.findViewById(R.id.promo_title)).setText(
                        ((Promo) getItem(position)).getTitle());
                ((TextView) gridView.findViewById(R.id.promo_period)).setText(
                        ((Promo) getItem(position)).getPeriod());
                ((ImageView) gridView.findViewById(R.id.promo_image)).setImageBitmap(
                        ((Promo) getItem(position)).getBitmap());
            /*} else {
                Log.d(TAG, "Not null");
                gridView = (View) convertView;
            }*/
        }

        return gridView;
    }
}
