package com.tifaniwarnita.prome;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageButton;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        ImageButton buttonGuest = (ImageButton) findViewById(R.id.button_login_as_guest);
        ImageButton buttonAdmin = (ImageButton) findViewById(R.id.button_login_as_admin);
    }
}
