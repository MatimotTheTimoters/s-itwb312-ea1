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

        registerBtn = findViewById(R.id.registerBtn);
    }

    @Override
    public void onClick(View v) {

    }

    public void registerBtnOnClick(View v) {
        exportEditTextValues();
    }

    public void exportEditTextValues() {
        Login login = new Login();
        Intent exportIntent = new Intent(Registration.this, Login.class);
        Bundle bundle = new Bundle();
        bundle.putString("firstNameEt", firstNameEt.getText().toString());
        bundle.putString("lastNameEt", lastNameEt.getText().toString());
        bundle.putString("emailAddressEt", emailAddressEt.getText().toString());
        bundle.putString("birthdayEt", birthdayEt.getText().toString());
        bundle.putString("usernameEt", usernameEt.getText().toString());
        bundle.putString("passwordEt", passwordEt.getText().toString());
        exportIntent.putExtras(bundle);
        startActivity(exportIntent);
        finish();
    }

    public void getEditTextId(EditText et, int id) {
        et = findViewById(id);
        et.setOnClickListener(this);
    }
}