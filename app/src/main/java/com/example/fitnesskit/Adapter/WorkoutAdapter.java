package com.example.fitnesskit.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.fitnesskit.Modal.Workout;
import com.example.fitnesskit.Activity.WorkoutActivity;
import com.example.fitnesskit.databinding.FitnesviewtileBinding;

import java.util.ArrayList;

public class WorkoutAdapter extends RecyclerView.Adapter<WorkoutAdapter.ViewHolder> {
   private final ArrayList<Workout> list;
    private Context context;

    public WorkoutAdapter(ArrayList<Workout> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public WorkoutAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context=parent.getContext();
        FitnesviewtileBinding binding = FitnesviewtileBinding.inflate(LayoutInflater.from(context),parent,false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull WorkoutAdapter.ViewHolder holder, int position) {
        holder.binding.txttitle.setText(list.get(position).getTitle());
        int resId = context.getResources().getIdentifier(list.get(position).getPicPath(), "drawable", context.getPackageName());

        Glide.with(context).load(resId).into(holder.binding.imgView6);
        holder.binding.txtExcercise.setText(list.get(position).getLessions().size()+"Excercise");
        holder.binding.txtKcal.setText(list.get(position).getKcal()+"Kcal");
        holder.binding.txtmint.setText(list.get(position).getDuration());

        holder.binding.getRoot().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, WorkoutActivity.class);

                intent.putExtra("object",list.get(position));
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        FitnesviewtileBinding binding;
        public ViewHolder(FitnesviewtileBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
