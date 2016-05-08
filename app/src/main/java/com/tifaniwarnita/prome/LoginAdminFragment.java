package com.tifaniwarnita.prome;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.AppCompatEditText;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class LoginAdminFragment extends Fragment {
    private static final String USERNAME_DUMMY = "tes";
    private static final String PASSWORD_DUMMY = "tespassword";

    public LoginAdminFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_login_admin, container, false);
        final AppCompatEditText editTextUsername = (AppCompatEditText) v.findViewById(R.id.login_admin_username);
        final AppCompatEditText editTextPassword = (AppCompatEditText) v.findViewById(R.id.login_admin_password);
        Button buttonLogin = (Button) v.findViewById(R.id.button_login);

        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = editTextUsername.getText().toString();
                String password = editTextPassword.getText().toString();

                if (username.equals("") || password.equals("")) {
                    Toast.makeText(getContext(),
                            "Please fill username and password properly",
                            Toast.LENGTH_SHORT)
                            .show();
                } else if (!username.equals(USERNAME_DUMMY) || !password.equals(PASSWORD_DUMMY)) {
                    Toast.makeText(getContext(),
                            "Invalid username or password",
                            Toast.LENGTH_SHORT)
                            .show();
                } else {
                    Intent intent = new Intent(getActivity(), LoginActivity.class); //TODO: Change to admin class
                    startActivity(intent);
                    getActivity().overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                }
            }
        });
        return v;
    }

}
