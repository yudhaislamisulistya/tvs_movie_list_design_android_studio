package com.example.asistensi1dan2tahap1.ui.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.asistensi1dan2tahap1.Home;
import com.example.asistensi1dan2tahap1.R;
import com.example.asistensi1dan2tahap1.ui.register.Register;

public class Login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    public void goRegisterScreen(View view) {
        startActivity(new Intent(Login.this, Register.class));
    }

    public void goHomeScreen(View view) {
        startActivity(new Intent(Login.this, Home.class));
    }
}
