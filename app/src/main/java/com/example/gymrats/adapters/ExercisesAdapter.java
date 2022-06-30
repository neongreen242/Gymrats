package com.example.gymrats.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.gymrats.R;
import com.example.gymrats.models.Exercises;

import java.util.List;

public class ExercisesAdapter extends RecyclerView.Adapter<ExercisesAdapter.ViewHolder> {

    Context context;
    List<Exercises> exercises;

    public ExercisesAdapter(Context context, List<Exercises> exercises) {
        this.context = context;
        this.exercises = exercises;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View exerciseView = LayoutInflater.from(context).inflate(R.layout.exercise_item, parent, false);
        return new ViewHolder(exerciseView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Exercises exercise = exercises.get(position);
        holder.bind(exercise);

    }

    @Override
    public int getItemCount () {
        return exercises.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView tvExercises;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            tvExercises = itemView.findViewById(R.id.tvExercises);

            itemView.setOnClickListener(this);
        }

        public void bind(Exercises exercise) {
            tvExercises.setText(exercise.getExercisesTittle());

        }

        @Override
        public void onClick(View v) {

        }

    }
    }

