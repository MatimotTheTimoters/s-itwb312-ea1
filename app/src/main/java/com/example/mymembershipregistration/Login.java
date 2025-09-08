package com.example.mymembershipregistration;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Login extends AppCompatActivity implements View.OnClickListener {

    EditText usernameEt, passwordEt;
    String firstName, lastName,
           emailAddress, birthday,
           username, password;
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

        Bundle bundle = getIntent().getExtras();
        firstName = bundle.getString("firstName");
        lastName = bundle.getString("lastName");
        emailAddress = bundle.getString("emailAddress");
        birthday = bundle.getString("birthday");
        username = bundle.getString("username");
        password = bundle.getString("password");

        loginBtn = findViewById(R.id.loginBtn);
    }

    @Override
    public void onClick(View v) {

    }

    public void loginBtnOnClick(View v) {
        getEditTextId(usernameEt, R.id.usernameEt);
        getEditTextId(passwordEt, R.id.passwordEt);

        exportEditTextValues();
    }

    public void exportEditTextValues() {
        Login login = new Login();
        Intent exportIntent = new Intent(Login.this, Home.class);
        Bundle bundle = new Bundle();
        bundle.putString("username", usernameEt.getText().toString());
        exportIntent.putExtras(bundle);
        startActivity(exportIntent);
        finish();
    }

    public void getEditTextId(EditText et, int id) {
        et = findViewById(id);
        et.setOnClickListener(this);
    }
}