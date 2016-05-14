package com.tifaniwarnita.prome;

import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class AvailablePlacesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_available_places);

        TextView title = (TextView) findViewById(R.id.header_title_available_places);
        Typeface face = Typeface.createFromAsset(getAssets(),
                "NHaasGroteskDSPro-15UltTh.otf");
        title.setTypeface(face);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
    }
}
