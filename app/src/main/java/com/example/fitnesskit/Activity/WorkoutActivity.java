package com.example.fitnesskit.Activity;

import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.bumptech.glide.Glide;
import com.example.fitnesskit.Adapter.LessionAdapter;
import com.example.fitnesskit.Modal.Workout;
import com.example.fitnesskit.R;
import com.example.fitnesskit.databinding.ActivityWorkoutBinding;

public class WorkoutActivity extends AppCompatActivity {

    ActivityWorkoutBinding binding;
    private Workout workout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityWorkoutBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);

        getObject();
        setVeriable();
    }

    private void getObject() {
        workout = (Workout) getIntent().getSerializableExtra("object");
    }

    private void setVeriable() {
        int resId=getResources().getIdentifier(workout.getPicPath(),"drawable",getPackageName());
        Glide.with(this).load(resId).into(binding.imageView);

        binding.backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        binding.texttitle.setText(workout.getTitle());
        binding.txtExcercise.setText(workout.getLessions().size()+"Excercise");
        binding.txtKcal.setText(workout.getKcal()+"Kcal");
        binding.txtmint.setText(workout.getDuration());
        binding.txtDecription.setText(workout.getDescription());

        binding.recyclerViewWorkout.setLayoutManager(new LinearLayoutManager(WorkoutActivity.this, LinearLayoutManager.HORIZONTAL, false));
        binding.recyclerViewWorkout.setAdapter(new LessionAdapter(workout.getLessions()));
    }
}