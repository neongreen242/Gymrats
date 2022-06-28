package com.example.gymrats.models;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Exercises {

    String exercisesTittle;



    public Exercises(){}

    public Exercises (JSONObject jsonObject)throws JSONException {

        exercisesTittle = jsonObject.getString("name");

    }
    public static List<Exercises> fromJsonArray(JSONArray exercisesJsonArray) throws JSONException {
        List<Exercises> exercise= new ArrayList<>();
        for (int i =0; i < exercisesJsonArray.length(); i++){
            exercise.add(new Exercises(exercisesJsonArray.getJSONObject(i)));
        }
        return exercise;
    }

    public String getExercisesTittle() {
        return exercisesTittle;
    }
}
