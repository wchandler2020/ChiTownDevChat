package com.example.chitowndevchat.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.example.chitowndevchat.R;

public class LoginPage extends AppCompatActivity {

    //Vars for XML
    RelativeLayout objectRelativeLayout;

    // Class Vars
    private AnimationDrawable objectAnimationDrawable;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);

        attachJavaObjectToXML();
    }

    private void attachJavaObjectToXML()
    {
        try
        {
            objectRelativeLayout = findViewById(R.id.loginPage_RL);
            objectAnimationDrawable=(AnimationDrawable) objectRelativeLayout.getBackground();

            objectAnimationDrawable.setEnterFadeDuration(4500);
            objectAnimationDrawable.setExitFadeDuration(4500);

            objectAnimationDrawable.start();
        }
        catch (Exception e)
        {
            Toast.makeText(this, "LoginPage: " + e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }
}
