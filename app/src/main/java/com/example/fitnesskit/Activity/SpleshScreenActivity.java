package com.example.fitnesskit.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.fitnesskit.R;
import com.example.fitnesskit.databinding.ActivitySpleshScreenBinding;

public class SpleshScreenActivity extends AppCompatActivity {

    private ActivitySpleshScreenBinding spleshbinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS, WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        spleshbinding = ActivitySpleshScreenBinding.inflate(getLayoutInflater());
        setContentView(spleshbinding.getRoot());

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                startActivity(new Intent(SpleshScreenActivity.this, OnBordingActivity.class));
                finish();
            }
        }, 3000);
        }
    }
