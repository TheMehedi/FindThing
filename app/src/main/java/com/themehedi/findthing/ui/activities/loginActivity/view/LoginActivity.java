package com.themehedi.findthing.ui.activities.loginActivity.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.themehedi.findthing.R;
import com.themehedi.findthing.ui.activities.loginActivity.model.LoginDataModel;
import com.themehedi.findthing.ui.activities.loginActivity.presenter.LoginPresenter;
import com.themehedi.findthing.ui.activities.loginActivity.presenter.LoginPresenterInterface;
import com.themehedi.findthing.ui.activities.mainActivity.MainActivity;
import com.themehedi.findthing.ui.activities.registrationActivity.RegistrationActivity;

public class LoginActivity extends AppCompatActivity implements LoginPresenterInterface {

    private LinearLayout linearLayoutLink;
    private EditText phoneNumberEditText, passwordEditText;
    private Button loginBtn;
    private LoginPresenter loginPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //assigning views
        linearLayoutLink = findViewById(R.id.linearLayoutLink);
        phoneNumberEditText = findViewById(R.id.phoneNumberEditText);
        passwordEditText = findViewById(R.id.passwordEditText);
        loginBtn = findViewById(R.id.loginBtn);

        loginPresenter = new LoginPresenter(LoginActivity.this, this);

        linearLayoutLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(LoginActivity.this, RegistrationActivity.class);
                startActivity(intent);
            }
        });

        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String phoneInput = phoneNumberEditText.getText().toString();
                String passwordInput = passwordEditText.getText().toString();

                loginPresenter.Login(phoneInput, passwordInput);
            }
        });
    }

    @Override
    public void onLoginResponse(LoginDataModel data) {

        if(data.getData().size()>0){

            Toast.makeText(this, "Login Successful!", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(LoginActivity.this, MainActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);
        }
        else {

            Toast.makeText(this, "Something Wrong!", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onLoginError(String errMessage) {

        Toast.makeText(LoginActivity.this, "Please Input valid Data", Toast.LENGTH_SHORT).show();
    }
}