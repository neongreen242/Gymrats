package com.example.gymrats.models;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import com.example.gymrats.adapters.CategoryAdapter;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.parceler.Parcels;

import java.util.ArrayList;
import java.util.List;

import javax.xml.namespace.QName;

public class Exercises {

    protected String title;
    private static final String TAG = "Exercise";


    public Exercises(){}


    public Exercises (JSONObject jsonObject) throws JSONException {


    title = jsonObject.getString("name");



    }
    public static List<Exercises> fromJsonArray(JSONArray exercisesJsonArray) throws JSONException {
        List<Exercises> exercise= new ArrayList<>();
        for (int i =0; i < exercisesJsonArray.length(); i++){
            exercise.add(new Exercises(exercisesJsonArray.getJSONObject(i)));

        }
        return exercise;
    }



    public String getExercisesTittle() {
        return title;
    }
}
