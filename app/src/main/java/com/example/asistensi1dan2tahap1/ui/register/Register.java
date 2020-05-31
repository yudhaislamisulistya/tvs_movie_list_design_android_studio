package com.example.asistensi1dan2tahap1.ui.register;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.asistensi1dan2tahap1.R;
import com.example.asistensi1dan2tahap1.ui.login.Login;

public class Register extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
    }

    public void goLoginScreen(View view) {
        startActivity(new Intent(Register.this, Login.class));
    }
}
