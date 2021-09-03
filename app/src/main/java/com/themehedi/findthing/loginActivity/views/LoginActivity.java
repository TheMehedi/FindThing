package com.themehedi.findthing.loginActivity.views;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.themehedi.findthing.R;
import com.themehedi.findthing.loginActivity.models.LoginDataModel;
import com.themehedi.findthing.loginActivity.presenters.LoginPresenter;
import com.themehedi.findthing.loginActivity.presenters.LoginPresenterInterface;
import com.themehedi.findthing.mainActivity.views.MainActivity;
import com.themehedi.findthing.registrationActivity.RegistrationActivity;
import com.themehedi.findthing.utils.SessionManager;
import com.themehedi.findthing.utils.StaticMethod;

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

            String id = data.getData().get(0).getId();
            String name = data.getData().get(0).getName();
            String email = data.getData().get(0).getEmail();
            String phone = data.getData().get(0).getPhone();
            String image = data.getData().get(0).getImage();
            String division_name = data.getData().get(0).getDivisionName();
            String district_name = data.getData().get(0).getDistrictName();
            String area_name = data.getData().get(0).getAreaName();
            String division_id = data.getData().get(0).getDivisionId();
            String district_id = data.getData().get(0).getDistrictId();
            String area_id = data.getData().get(0).getAreaId();


            SessionManager.setStringValue(StaticMethod.USER_ID, id, LoginActivity.this);
            SessionManager.setStringValue(StaticMethod.NAME, name, LoginActivity.this);
            SessionManager.setStringValue(StaticMethod.EMAIL, email, LoginActivity.this);
            SessionManager.setStringValue(StaticMethod.PHONE, phone, LoginActivity.this);
            SessionManager.setStringValue(StaticMethod.IMAGE, "user_images/" + image, LoginActivity.this);
            SessionManager.setStringValue(StaticMethod.DIVISION_NAME, division_name, LoginActivity.this);
            SessionManager.setStringValue(StaticMethod.DISTRICT_NAME, district_name, LoginActivity.this);
            SessionManager.setStringValue(StaticMethod.AREA_NAME, area_name, LoginActivity.this);
            SessionManager.setStringValue(StaticMethod.DIVISION_ID, division_id, LoginActivity.this);
            SessionManager.setStringValue(StaticMethod.DISTRICT_ID, district_id, LoginActivity.this);
            SessionManager.setStringValue(StaticMethod.AREA_ID, area_id, LoginActivity.this);
            SessionManager.setBooleanValue(StaticMethod.IS_LOGIN, true, LoginActivity.this);


            Toast.makeText(this, "Login Successful!", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(LoginActivity.this, MainActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK|Intent.FLAG_ACTIVITY_CLEAR_TASK);
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

    @Override
    public void onBackPressed() {

        finish();
    }
}