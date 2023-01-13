package com.example.pergidulu;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Index;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.pergidulu.home.HomeActivity;
import com.example.pergidulu.room.AppDatabase;
import com.example.pergidulu.room.TravelDao;

public class LoginActivity extends AppCompatActivity {

    EditText etEmail;
    EditText etPassword;
    Button btnLogin;
    Button btnResetPass;
    Button btnRegister;
    AppDatabase myDb;
    TravelDao usrDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        etEmail = findViewById(R.id.etEmail);
        etPassword = findViewById(R.id.etPassword);
        btnLogin = findViewById(R.id.btnLogin);
        btnResetPass = findViewById(R.id.btnResettPass);
        btnRegister = findViewById(R.id.btnRegister);

        myDb = Room.databaseBuilder(this, AppDatabase.class, "travel")
                .allowMainThreadQueries().fallbackToDestructiveMigration().build();

        usrDao = myDb.userDao();


        btnLogin.setOnClickListener(view -> {
            String email = etEmail.getText().toString();
            String password = etPassword.getText().toString();
            if (usrDao.is_login(email,password)) {
                startActivity(new Intent(LoginActivity.this, HomeActivity.class));
            } else {
                Toast.makeText(LoginActivity.this, "Email atau Password Anda Salah", Toast.LENGTH_SHORT).show();
            }
        });

        btnResetPass.setOnClickListener(view -> {
            startActivity(new Intent(LoginActivity.this, RecoveryActivity.class));
        });

        btnRegister.setOnClickListener(view -> {
            startActivity(new Intent(LoginActivity.this, RegisterActivity.class));
        });
    }
}