package com.example.mymembershipregistration;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Login extends AppCompatActivity implements View.OnClickListener {

    EditText usernameEt, passwordEt;
    String firstName = "", lastName = "",
            emailAddress = "", birthday = "",
            username = "", password = "";
    Button loginBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Safely read incoming extras (may be null)
        Bundle bundle = getIntent() == null ? null : getIntent().getExtras();
        if (bundle != null) {
            firstName = bundle.getString("firstName", "");
            lastName = bundle.getString("lastName", "");
            emailAddress = bundle.getString("emailAddress", "");
            birthday = bundle.getString("birthday", "");
            username = bundle.getString("username", "");
            password = bundle.getString("password", "");
        }

        // BIND views to fields
        usernameEt = bindEditText(R.id.usernameEt);
        passwordEt = bindEditText(R.id.passwordEt);

        // If we received a username from Registration, prefill the field
        if (!username.isEmpty()) {
            usernameEt.setText(username);
        }

        loginBtn = findViewById(R.id.loginBtn);
        loginBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.loginBtn) {
            loginBtnOnClick(v);
        }
    }

    public void loginBtnOnClick(View v) {
        exportEditTextValues();
    }

    public void exportEditTextValues() {
        // Basic null-safety and validation
        if (usernameEt == null) {
            Toast.makeText(this, "Internal error: username field missing", Toast.LENGTH_SHORT).show();
            return;
        }

        String enteredUsername = usernameEt.getText() == null ? "" : usernameEt.getText().toString().trim();

        if (enteredUsername.isEmpty()) {
            usernameEt.setError("Please enter username");
            usernameEt.requestFocus();
            return;
        }

        Intent exportIntent = new Intent(Login.this, Home.class);
        Bundle bundle = new Bundle();
        bundle.putString("username", enteredUsername);
        exportIntent.putExtras(bundle);
        startActivity(exportIntent);
        finish();
    }

    private EditText bindEditText(int id) {
        EditText et = findViewById(id);
        if (et != null) {
            et.setOnClickListener(this);
        }
        return et;
    }
}