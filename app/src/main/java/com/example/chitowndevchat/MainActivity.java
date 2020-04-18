package com.example.chitowndevchat;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.chitowndevchat.Activities.LoginPage;

public class MainActivity extends AppCompatActivity {

    //for xml views
    Button moveToLoginPageBtn;
    ImageView backgroundIV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        attachJavaObjectXML();
        startAnimations();

        moveToLoginPageBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToLoginPage();
            }
        });
    }

    private  void attachJavaObjectXML()
    {
        try {
            backgroundIV=findViewById(R.id.mainActivity_BackgroundIV);
            moveToLoginPageBtn=findViewById(R.id.mainActivity_MoveBtn);
        }catch (Exception e)
        {
            Toast.makeText(this, "MainAction: " + e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    private void startAnimations()
    {
        try
        {
            backgroundIV.animate().scaleX(2).scaleY(2).setDuration(30000).start();
        }
        catch (Exception e)
        {
            Toast.makeText(this, "MainActivity: " + e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    private void goToLoginPage()
    {
        try
        {
            startActivity(new Intent(this, LoginPage.class));
        }
        catch (Exception e)
        {
            Toast.makeText(this, "MainActivity" + e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }
}
