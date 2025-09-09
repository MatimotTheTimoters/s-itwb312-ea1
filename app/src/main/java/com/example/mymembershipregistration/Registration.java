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

public class Registration extends AppCompatActivity implements View.OnClickListener {

    EditText firstNameEt, lastNameEt,
            emailAddressEt, birthdayEt,
            usernameEt, passwordEt;
    Button registerBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_registration);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        firstNameEt    = findViewById(R.id.firstNameEt);
        lastNameEt     = findViewById(R.id.lastNameEt);
        emailAddressEt = findViewById(R.id.emailAddressEt);
        birthdayEt     = findViewById(R.id.birthdayEt);
        usernameEt     = findViewById(R.id.usernameEt);
        passwordEt     = findViewById(R.id.passwordEt);

        registerBtn = findViewById(R.id.registerBtn);
        registerBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.registerBtn) {
            registerBtnOnClick(v);
        }
    }

    public void registerBtnOnClick(View v) {
        exportEditTextValues();
    }

    public void exportEditTextValues() {
        // Null-safety / simple validation example
        if (firstNameEt == null || usernameEt == null) {
            Toast.makeText(this, "Internal error: form not ready", Toast.LENGTH_SHORT).show();
            return;
        }

        String firstName = firstNameEt.getText() == null ? "" : firstNameEt.getText().toString();
        String lastName  = lastNameEt.getText() == null ? "" : lastNameEt.getText().toString();
        String email     = emailAddressEt.getText() == null ? "" : emailAddressEt.getText().toString();
        String birthday  = birthdayEt.getText() == null ? "" : birthdayEt.getText().toString();
        String username  = usernameEt.getText() == null ? "" : usernameEt.getText().toString();
        String password  = passwordEt.getText() == null ? "" : passwordEt.getText().toString();

        if (username.isEmpty() || password.isEmpty()) {
            Toast.makeText(this, "Please enter username and password", Toast.LENGTH_SHORT).show();
            return;
        }

        Intent exportIntent = new Intent(Registration.this, Login.class);
        Bundle bundle = new Bundle();
        bundle.putString("firstName", firstName);
        bundle.putString("lastName", lastName);
        bundle.putString("emailAddress", email);
        bundle.putString("birthday", birthday);
        bundle.putString("username", username);
        bundle.putString("password", password);
        exportIntent.putExtras(bundle);
        startActivity(exportIntent);
        finish();
    }
}