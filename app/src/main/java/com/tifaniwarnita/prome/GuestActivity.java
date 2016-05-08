package com.tifaniwarnita.prome;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageButton;

public class GuestActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guest);

        ImageButton buttonAvailablePlaces = (ImageButton) findViewById(R.id.button_available_places);
        ImageButton buttonTutorial = (ImageButton) findViewById(R.id.button_tutorial);
    }
}
