package com.example.gymrats.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.gymrats.R;
import com.example.gymrats.models.ExercisesCategories;

import java.util.List;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.ViewHolder> {

    Context context;
    List<ExercisesCategories> exercisesCategories;

    public CategoryAdapter(Context context, List<ExercisesCategories> exercisesCategories){
        this.context = context;
        this.exercisesCategories = exercisesCategories;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View categoryView = LayoutInflater.from(context).inflate(R.layout.exercise_item, parent, false);
        return new ViewHolder(categoryView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        ExercisesCategories category = exercisesCategories.get(position);
        holder.bind(category);
    }

    @Override
    public int getItemCount() {
        return exercisesCategories.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        TextView tvCategoryTittle;

        public ViewHolder (@NonNull View itemView){
            super(itemView);

            tvCategoryTittle = itemView.findViewById(R.id.tvCategoryTittle);


            itemView.setOnClickListener(this);
        }

        public void bind(ExercisesCategories category) {
            tvCategoryTittle.setText(category.getCategory());

        }

        @Override
        public void onClick(View v) {


        }

    }
}
