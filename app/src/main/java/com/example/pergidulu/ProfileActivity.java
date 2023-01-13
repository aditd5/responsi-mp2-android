package com.example.pergidulu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;

public class ProfileActivity extends AppCompatActivity {

    ImageView btnBackP;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        btnBackP = findViewById(R.id.btnBackP);

        btnBackP.setOnClickListener(view -> {
            startActivity(new Intent(ProfileActivity.this, RegisterActivity.class));
        });
    }
}