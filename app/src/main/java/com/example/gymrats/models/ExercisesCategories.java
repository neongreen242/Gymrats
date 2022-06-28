package com.example.gymrats.models;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class ExercisesCategories {
    String category;


    public ExercisesCategories(){}

    public ExercisesCategories (JSONObject jsonObject)throws JSONException{

        category = jsonObject.getString("name");

    }

    public static List<ExercisesCategories> fromJsonArray(JSONArray exercisesCategoriesJsonArray) throws JSONException{
        List<ExercisesCategories> exercisesCategories = new ArrayList<>();

        for (int i = 0; i < exercisesCategoriesJsonArray.length(); i++){
            exercisesCategories.add(new ExercisesCategories(exercisesCategoriesJsonArray.getJSONObject(i)));
        }
        return exercisesCategories;
    }

    public String getCategory() {
        return category;
    }
}

