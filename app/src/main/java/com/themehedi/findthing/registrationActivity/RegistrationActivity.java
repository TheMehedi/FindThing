package com.themehedi.findthing.registrationActivity;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Base64;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.themehedi.findthing.R;
import com.themehedi.findthing.mainActivity.views.MainActivity;
import com.themehedi.findthing.registrationActivity.models.RegisterDataModel;
import com.themehedi.findthing.registrationActivity.presenters.RegisterPresenter;
import com.themehedi.findthing.registrationActivity.presenters.RegisterPresenterInterface;
import com.themehedi.findthing.utils.SessionManager;
import com.themehedi.findthing.utils.SpinDialog;
import com.themehedi.findthing.utils.StaticMethod;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

import de.hdodenhof.circleimageview.CircleImageView;

public class RegistrationActivity extends AppCompatActivity implements RegisterPresenterInterface {

    private LinearLayout linearLayoutLink;
    private Button registerBtn;
    private CircleImageView profileCircleImageView;
    private EditText fullName, emailAddress, phoneNumber, password;
    private String stringImage = "";
    private RelativeLayout imageViewRelativeLayout;

    private Uri filePath;
    private Bitmap bitmap = null;

    private RegisterPresenter registerPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);


        initViews();


        linearLayoutLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(RegistrationActivity.this, RegistrationActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK|Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent);
            }
        });

        imageViewRelativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                chooseImage();
            }
        });



        registerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String name = fullName.getText().toString();
                String email = emailAddress.getText().toString();
                String phone = phoneNumber.getText().toString();
                String passwords = password.getText().toString();

                imageToString(bitmap);

                registerPresenter.Register(name, email, phone, "1", "1", "1", passwords, stringImage);

            }
        });
    }

    private void initViews() {

        //assigning views
        linearLayoutLink = findViewById(R.id.linearLayoutLink);
        registerBtn = findViewById(R.id.registerBtn);
        profileCircleImageView = findViewById(R.id.profileCircleImageView);
        fullName = findViewById(R.id.fullName);
        emailAddress = findViewById(R.id.emailAddress);
        phoneNumber = findViewById(R.id.phoneNumber);
        password = findViewById(R.id.password);
        imageViewRelativeLayout = findViewById(R.id.imageViewRelativeLayout);

        registerPresenter = new RegisterPresenter(RegistrationActivity.this, this);
    }

    private void chooseImage() {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(intent, "Select Picture"), 1);
    }

    public Bitmap scaleDown(Bitmap realImage, float maxImageSize,
                                   boolean filter) {
        float ratio = Math.min(
                (float) maxImageSize / realImage.getWidth(),
                (float) maxImageSize / realImage.getHeight());
        int width = Math.round((float) ratio * realImage.getWidth());
        int height = Math.round((float) ratio * realImage.getHeight());

        Bitmap newBitmap = Bitmap.createScaledBitmap(realImage, width,
                height, filter);
        return newBitmap;
    }

    private void imageToString(Bitmap imageBitmap){

        // encode base64 from image
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        imageBitmap.compress(Bitmap.CompressFormat.PNG, 100, baos);
        byte[] b = baos.toByteArray();
        stringImage =  Base64.encodeToString(b, Base64.URL_SAFE | Base64.NO_WRAP);
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 1 && resultCode == RESULT_OK
                && data != null && data.getData() != null )
        {
            SpinDialog spinDialog = new SpinDialog(RegistrationActivity.this, false);
            //spinDialog.show();

            filePath = data.getData();

            try {
                bitmap = scaleDown(MediaStore.Images.Media.getBitmap(getContentResolver(), filePath), 512, true);
                //bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), filePath);
                profileCircleImageView.setImageBitmap(bitmap);
                //spinDialog.dismiss();
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }

        }
    }

    @Override
    public void onRegisterResponse(RegisterDataModel data) {

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


            SessionManager.setStringValue(StaticMethod.USER_ID, id, RegistrationActivity.this);
            SessionManager.setStringValue(StaticMethod.NAME, name, RegistrationActivity.this);
            SessionManager.setStringValue(StaticMethod.EMAIL, email, RegistrationActivity.this);
            SessionManager.setStringValue(StaticMethod.PHONE, phone, RegistrationActivity.this);
            SessionManager.setStringValue(StaticMethod.IMAGE, "user_images/" + image, RegistrationActivity.this);
            SessionManager.setStringValue(StaticMethod.DIVISION_NAME, division_name, RegistrationActivity.this);
            SessionManager.setStringValue(StaticMethod.DISTRICT_NAME, district_name, RegistrationActivity.this);
            SessionManager.setStringValue(StaticMethod.AREA_NAME, area_name, RegistrationActivity.this);
            SessionManager.setStringValue(StaticMethod.DIVISION_ID, division_id, RegistrationActivity.this);
            SessionManager.setStringValue(StaticMethod.DISTRICT_ID, district_id, RegistrationActivity.this);
            SessionManager.setStringValue(StaticMethod.AREA_ID, area_id, RegistrationActivity.this);
            SessionManager.setBooleanValue(StaticMethod.IS_LOGIN, true, RegistrationActivity.this);


            Toast.makeText(this, "Login Successful!", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(RegistrationActivity.this, MainActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK|Intent.FLAG_ACTIVITY_CLEAR_TASK);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);
        }
        else {

            Toast.makeText(this, "Something Wrong!", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onRegisterError(String errMessage) {

        Toast.makeText(this, errMessage, Toast.LENGTH_SHORT).show();
    }
}