package org.toon.sharedpreferences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText name, password;
    Button submit, retrive;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name = (EditText) findViewById(R.id.nameEditText);
        password = (EditText) findViewById(R.id.passwordEditText);
        submit = (Button) findViewById(R.id.submitButton);
        retrive = (Button) findViewById(R.id.retriveButton);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userName = name.getText().toString();
                String userPassword = password.getText().toString();

                SharedPreferences.Editor editor = getSharedPreferences("MyPrefs", MODE_PRIVATE).edit();

                editor.putString("nameKey", userName);
                editor.putString("passwordKey", userPassword);
                editor.commit();
            }
        });

        retrive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String displayName = getSharedPreferences("MyPrefs", MODE_PRIVATE).getString("nameKey", "Not Found");
                String displayPassword = getSharedPreferences("MyPrefs", MODE_PRIVATE).getString("passwordKey", "Not Found");


                Toast.makeText(MainActivity.this, "Name: " + displayName + "\nPassword: " + displayPassword, Toast.LENGTH_SHORT).show();
            }
        });

    }
}
