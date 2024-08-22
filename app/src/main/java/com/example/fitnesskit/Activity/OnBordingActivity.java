package com.example.fitnesskit.Activity;

import android.content.Intent;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.fitnesskit.R;
import com.example.fitnesskit.databinding.ActivityOnBordingBinding;

public class OnBordingActivity extends AppCompatActivity {

    private ActivityOnBordingBinding onbinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        onbinding = ActivityOnBordingBinding.inflate(getLayoutInflater());
        setContentView(onbinding.getRoot());
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


       onbinding.nextcardbtn.setOnClickListener(v -> {
           Intent intent = new Intent(OnBordingActivity.this, LogInActivity.class);
           startActivity(intent);
       });


    }

}