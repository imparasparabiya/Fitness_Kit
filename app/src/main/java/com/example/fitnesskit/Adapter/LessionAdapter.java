package com.example.fitnesskit.Adapter;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.fitnesskit.Modal.Lession;
import com.example.fitnesskit.databinding.ViewExerciseBinding;

import java.util.ArrayList;

public class LessionAdapter extends RecyclerView.Adapter<LessionAdapter.ViewHolder> {

    private final ArrayList<Lession> lessions;
    private Context context;


    public LessionAdapter(ArrayList<Lession> lessions) {
        this.lessions = lessions;
    }

    @NonNull
    @Override
    public LessionAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        ViewExerciseBinding binding = ViewExerciseBinding.inflate(LayoutInflater.from(context), parent, false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull LessionAdapter.ViewHolder holder, int position) {
        holder.binding.texttitle.setText(lessions.get(position).getTitle());
        holder.binding.texttime.setText(lessions.get(position).getDuartion());

        int resId=context.getResources().getIdentifier(lessions.get(position).getPicPath(), "drawable", context.getPackageName());
        Glide.with(context).load(resId).into(holder.binding.pic);

        holder.binding.getRoot().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("vnd.youtube:" + lessions.get(position).getLink()));
                Intent webIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.youtube.com/watch?v=" +lessions.get(position).getLink()));

                try {
                    context.startActivity(intent);
                }catch (ActivityNotFoundException ex){
                    context.startActivity(webIntent);
                }
            }
        });

    }

    @Override
    public int getItemCount() {
        return lessions.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ViewExerciseBinding binding;
        public ViewHolder(ViewExerciseBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
