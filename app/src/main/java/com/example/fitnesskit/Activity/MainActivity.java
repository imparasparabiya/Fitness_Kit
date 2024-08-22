package com.example.fitnesskit.Activity;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.fitnesskit.Adapter.WorkoutAdapter;
import com.example.fitnesskit.Modal.Lession;
import com.example.fitnesskit.Modal.Workout;
import com.example.fitnesskit.R;
import com.example.fitnesskit.databinding.ActivityMainBinding;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding mainbinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        mainbinding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(mainbinding.getRoot());
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        mainbinding.recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this,LinearLayoutManager.HORIZONTAL,false));
        mainbinding.recyclerView.setAdapter(new WorkoutAdapter(getWorkouts()));

    }

    private ArrayList<Workout> getWorkouts() {
        ArrayList<Workout> workouts = new ArrayList<>();
        workouts.add(new Workout("Running", "You just woke up. It is a beand new day. The canvas is blank. How do you bengin? Take 2", "pic_1", 25, "10:00", getLession_1()));
        workouts.add(new Workout("Swimming", "You just woke up. It is a beand new day. The canvas is blank. How do you bengin? Take 2", "pic_2", 15, "12:00", getLession_2()));
        workouts.add(new Workout("Cycling", "You just woke up. It is a beand new day. The canvas is blank. How do you bengin? Take 2", "pic_3", 10, "14:00,", getLession_3()));
        return workouts;
    }
    private ArrayList<Lession> getLession_1(){
        ArrayList<Lession> list = new ArrayList<>();
        list.add(new Lession("Lessio 1","03:46","dcbjksdbcdsjk","pic_1_1"));
        list.add(new Lession("Lessio 2","03:46","dcbjksdbcdsjk","pic_1_2"));
        list.add(new Lession("Lessio 3","03:46","dcbjksdbcdsjk","pic_1_3"));
        return list;
    }
    private ArrayList<Lession> getLession_2(){
        ArrayList<Lession> list = new ArrayList<>();
        list.add(new Lession("Lessio 1","03:46","dcbjksdbcdsjk","pic_2_1"));
        list.add(new Lession("Lessio 2","03:46","dcbjksdbcdsjk","pic_2_2"));
        list.add(new Lession("Lessio 3","03:46","dcbjksdbcdsjk","pic_2_3"));
        return list;
    }
    private ArrayList<Lession> getLession_3(){
        ArrayList<Lession> list = new ArrayList<>();
        list.add(new Lession("Lessio 1","03:46","dcbjksdbcdsjk","pic_3_1"));
        list.add(new Lession("Lessio 2","03:46","dcbjksdbcdsjk","pic_3_2"));
        list.add(new Lession("Lessio 3","03:46","dcbjksdbcdsjk","pic_3_3"));
        return list;
    }

}