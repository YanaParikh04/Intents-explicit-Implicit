package com.example.practical_4;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    EditText etName;
    Button btnExplicit, btnImplicit;
    Intent intent;
    Intent dialIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        etName = findViewById(R.id.etName);
        btnExplicit = findViewById(R.id.btnExplicit);
        btnImplicit = findViewById(R.id.btnImplicit);

        btnExplicit.setOnClickListener(v -> {
            String name = etName.getText().toString();

            if (name.isEmpty()) {
                Toast.makeText(this, "Enter your name!", Toast.LENGTH_SHORT).show();
                return;
            }

            intent = new Intent(MainActivity.this, SecondActivity.class);
            intent.putExtra("username", name);
            startActivity(intent);
        });
        btnImplicit.setOnClickListener(v -> {
            dialIntent = new Intent(Intent.ACTION_DIAL);
            dialIntent.setData(Uri.parse("tel:" + "1234567890"));
            startActivity(dialIntent);
        });
    }
}