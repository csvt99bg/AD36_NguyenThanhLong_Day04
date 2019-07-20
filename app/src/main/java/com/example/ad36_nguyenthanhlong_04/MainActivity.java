package com.example.ad36_nguyenthanhlong_04;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText edUser, edPass;
    Button btLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edUser = findViewById(R.id.edUser);
        edPass = findViewById(R.id.edPassword);
        btLogin = findViewById(R.id.btLogin);

        btLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (edUser.getText().toString().isEmpty() || edPass.getText().toString().isEmpty()) {
                    Toast.makeText(getBaseContext(), "Login Erros", Toast.LENGTH_LONG).show();
                } else {
                    Intent intent = new Intent(getBaseContext(), MainActivity2.class);
                    String name = edUser.getText().toString();
                    intent.putExtra("name", name);
                    startActivity(intent);
                }
            }
        });

    }
}
