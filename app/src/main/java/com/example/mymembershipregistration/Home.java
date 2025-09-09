package com.example.mymembershipregistration;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Home extends AppCompatActivity implements View.OnClickListener {

    TextView usernameTvValue;
    String username = "";

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

        usernameTvValue = bindTextView(R.id.usernameTvValue);

        if (getIntent() != null) {
            String incoming = getIntent().getStringExtra("username");
            if (incoming != null) {
                username = incoming;
            } else {
                Bundle bundle = getIntent().getExtras();
                if (bundle != null) {
                    username = bundle.getString("username", "");
                }
            }
        }

        if (usernameTvValue != null) {
            usernameTvValue.setText(username.isEmpty() ? "Guest" : username);
        } else {
            Toast.makeText(this, "UI error: username view not found", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onClick(View v) {

    }

    private TextView bindTextView(int id) {
        TextView tv = findViewById(id);
        return tv;
    }
}