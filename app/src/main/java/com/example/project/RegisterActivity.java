package com.example.project;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowCompat;
import androidx.core.view.WindowInsetsCompat;

public class RegisterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        WindowCompat.enableEdgeToEdge(getWindow());
        setContentView(R.layout.activity_register);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        EditText etUser = findViewById(R.id.etRegUser);
        EditText etPass = findViewById(R.id.etRegPass);
        EditText etConfirm = findViewById(R.id.etRegConfirm);
        Button btnRegister = findViewById(R.id.btnRegister);

        btnRegister.setOnClickListener(v -> {
            String user = etUser.getText().toString().trim();
            String pass = etPass.getText().toString();
            String confirm = etConfirm.getText().toString();

            if (user.isEmpty()) {
                etUser.setError("Required field");
                return;
            }
            if (pass.length() < 6) {
                etPass.setError("At least 6 characters");
                return;
            }
            if (!pass.equals(confirm)) {
                etConfirm.setError("Passwords do not match");
                return;
            }

            Intent intent = new Intent(this, LoginActivity.class);
            intent.putExtra("username", user);
            intent.putExtra("password", pass);
            startActivity(intent);
            finish();
        });
    }
}