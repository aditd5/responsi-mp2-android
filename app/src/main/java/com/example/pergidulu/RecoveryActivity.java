package com.example.pergidulu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class RecoveryActivity extends AppCompatActivity {

    private Button btnSendEmail;
    private ImageView btnBack;
    private EditText etRecoverEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recovery);

        btnSendEmail = findViewById(R.id.btnSendEmail);
        btnBack = findViewById(R.id.btnBack);
        etRecoverEmail = findViewById(R.id.etRecoverEmail);

        btnBack.setOnClickListener(view -> {
            Intent intent = new Intent(RecoveryActivity.this, LoginActivity.class);
            startActivity(intent);
        });

        btnSendEmail.setOnClickListener(view -> {
            if (!etRecoverEmail.getText().toString().isEmpty()) {
                startActivity(new Intent(RecoveryActivity.this, LoginActivity.class));

            } else {
                Toast.makeText(getApplicationContext(), "Silahkan Masukkan Email Anda",
                        Toast.LENGTH_SHORT).show();
            }
        });
    }
}