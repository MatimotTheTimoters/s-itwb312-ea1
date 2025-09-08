package com.example.mymembershipregistration;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Home extends AppCompatActivity implements View.OnClickListener {

    TextView usernameTvValue;
    String username;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_home);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        getTextViewId(usernameTvValue, R.id.usernameTvValue);

        Bundle bundle = getIntent().getExtras();
        username = bundle.getString("username");

        usernameTvValue.setText(username);
    }

    @Override
    public void onClick(View v) {

    }

    public void getTextViewId(TextView et, int id) {
        et = findViewById(id);
        et.setOnClickListener(this);
    }
}