package com.example.pergidulu;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.pergidulu.room.AppDatabase;
import com.example.pergidulu.room.Travel;
import com.example.pergidulu.room.TravelDao;

public class RegisterActivity extends AppCompatActivity {

    EditText etEmail;
    EditText etPassword;
    EditText etConfirmpass;
    Button btnRegisterAccount;
    ImageView btnBack;
    AppDatabase myDb;
    TravelDao usrDao;
    public static boolean isAllowed;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        etEmail = findViewById(R.id.etEmail);
        etPassword = findViewById(R.id.etPassword);
        etConfirmpass = findViewById(R.id.etConfirmPass);
        btnRegisterAccount = findViewById(R.id.btnRegisterAccount);
        btnBack = findViewById(R.id.btnBack);

        myDb = Room.databaseBuilder(this, AppDatabase.class,"travel")
                .allowMainThreadQueries().fallbackToDestructiveMigration().build();

        usrDao = myDb.userDao();

        etEmail.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                String email = s.toString();
                if (!usrDao.is_taken(email)) {
                    isAllowed = false;
                } else {
                    isAllowed = true;
                }

            }
        });

        btnRegisterAccount.setOnClickListener(view -> {
            if (isAllowed) {
                if (etConfirmpass == etPassword) {
                    Travel travel = new Travel(0, etEmail.getText().toString(), etPassword.getText().toString());
                    usrDao.insertUser(travel);

                    Toast.makeText(RegisterActivity.this, "Pendaftaran Berhasil", Toast.LENGTH_SHORT).show();

                    startActivity(new Intent(RegisterActivity.this, LoginActivity.class));
                } else {
                    Toast.makeText(RegisterActivity.this, "Konfirmasi password anda tidak sama", Toast.LENGTH_SHORT).show();
                }
            } else {
                Toast.makeText(RegisterActivity.this, "Akun ini sudah terdaftar", Toast.LENGTH_SHORT).show();
            }
        });

        btnBack.setOnClickListener(view -> {
            startActivity(new Intent(RegisterActivity.this, LoginActivity.class));
        });
    }
}