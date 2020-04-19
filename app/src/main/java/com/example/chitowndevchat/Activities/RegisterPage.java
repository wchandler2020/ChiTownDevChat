package com.example.chitowndevchat.Activities;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.chitowndevchat.R;

import de.hdodenhof.circleimageview.CircleImageView;

public class RegisterPage extends AppCompatActivity {
    //for XML objects

    private CircleImageView profileIV;
    private EditText userNameET, userEmailET, userPasswordET, userConfirmPasswordET;

    private Button registerBTN;
    private RadioGroup objectRadioGroup;

    private TextView dateTV;

    //class vars
    private Uri profileImageURL;
    private static int REQUEST_CODE=1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_page);
        attachJavaToXMLObjects();
    }

    private void attachJavaToXMLObjects() {
        try
        {
            profileIV=findViewById(R.id.RegisterPage_userProfileIV);
            userNameET=findViewById(R.id.RegisterPage_userNameET);
            userEmailET=findViewById(R.id.RegisterPage_userEmailET);

            userPasswordET=findViewById(R.id.RegisterPage_userPassword);
            userConfirmPasswordET=findViewById(R.id.RegisterPage_userConfirmPassword);
            dateTV = findViewById(R.id.RegisterPage_userDOBTV);

            registerBTN=findViewById(R.id.RegisterPage_RegisterBtn);
            objectRadioGroup=findViewById(R.id.RegisterPage_RadioGroup);

            profileIV.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    chooseImageFromMobileGallery();
                }
            });
        }
        catch (Exception e)
        {
            Toast.makeText(this, "RegisterPage: " + e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    private void chooseImageFromMobileGallery()
    {
        try
        {
            openMobileGallery();
        }
        catch (Exception e)
        {
            Toast.makeText(this, "RegisterPage: " + e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    private void openMobileGallery()
    {
        try
        {
            Intent galleryIntent = new Intent(Intent.ACTION_GET_CONTENT);
            galleryIntent.setDataAndType(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, "image/*");

            startActivityForResult(galleryIntent, REQUEST_CODE);
        }
        catch (Exception e)
        {
            Toast.makeText(this, "RegisterPage: " + e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(data.getData() != null && data !=null)
        {
            profileImageURL=data.getData();
            profileIV.setImageURI(profileImageURL);
        }
        else
        {
          Toast.makeText(this, "No image is selected", Toast.LENGTH_SHORT).show();
        }
    }
}