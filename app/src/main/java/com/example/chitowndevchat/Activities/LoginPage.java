package com.example.chitowndevchat.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.chitowndevchat.R;

public class LoginPage extends AppCompatActivity {

    //Vars for XML
    private RelativeLayout objectRelativeLayout;
    private ImageView loginPageLogoIV;

    private EditText loginPageEmailET, loginPagePasswordET;
    private TextView loginPageTagLineTV;

    private Button loginPageLoginBtn, loginPageGoToRegisterBtn;

    // Class Vars
    private AnimationDrawable objectAnimationDrawable;
    private Animation objectAnimation;



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
            loginPageLogoIV=findViewById(R.id.loginPage_loginIV);

            loginPageEmailET=findViewById(R.id.loginPage_emailET);
            loginPagePasswordET=findViewById(R.id.loginPage_passwordET);

            loginPageTagLineTV=findViewById(R.id.loginPage_dontHaveAccountTagLine);
            loginPageLoginBtn=findViewById(R.id.loginPage_loginBtn);

            loginPageGoToRegisterBtn=findViewById(R.id.loginPage_moveToRegisterPageBtn);
            objectAnimation= AnimationUtils.loadAnimation(this,R.anim.anim_login_entry);

            loginPageLogoIV.startAnimation(objectAnimation);
            loginPageEmailET.startAnimation(objectAnimation);

            loginPagePasswordET.startAnimation(objectAnimation);
            loginPageLoginBtn.startAnimation(objectAnimation);

            loginPageGoToRegisterBtn.startAnimation(objectAnimation);
            loginPageLoginBtn.startAnimation(objectAnimation);

            loginPageGoToRegisterBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    moveToRegisterPage();
                }
            });

        }
        catch (Exception e)
        {
            Toast.makeText(this, "LoginPage: " + e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    private void moveToRegisterPage()
    {
        try
        {
            startActivity(new Intent(this, RegisterPage.class));
        }
        catch (Exception e)
        {
            Toast.makeText(this, "LoginPage: " + e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }
}
