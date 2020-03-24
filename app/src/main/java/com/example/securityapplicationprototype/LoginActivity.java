package com.example.securityapplicationprototype;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.hardware.Camera;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.securityapplicationprototype.CameraFunsionality.CamreaActivity;

public class LoginActivity extends AppCompatActivity {

    private CardView loginButton;
    private EditText userNameEditText, passwordEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        loadContents();
    }

    private void loadContents() {

        this.loginButton = findViewById(R.id.loginButton);
        this.userNameEditText = findViewById(R.id.userNameEditText);
        this.passwordEditText = findViewById(R.id.passwordEditText);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login();
            }
        });


    }

    public void login() {
        String userName = userNameEditText.getText().toString();
        String passWord = passwordEditText.getText().toString();

        if (userName.equals("") && passWord.equals("1")) {
            Intent intent = new Intent(LoginActivity.this, UnauthorizedPersonsInfoActivity.class);
            startActivity(intent);
        } else {
            Intent cameraIntent = new Intent(LoginActivity.this, CamreaActivity.class);
            startActivity(cameraIntent);

        }
    }

}
