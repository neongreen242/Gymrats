package com.example.gymrats.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.codepath.asynchttpclient.AsyncHttpClient;
import com.codepath.asynchttpclient.callback.JsonHttpResponseHandler;
import com.example.gymrats.R;
import com.example.gymrats.adapters.ExerciseAdapter;
import com.example.gymrats.models.Exercises;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import okhttp3.Headers;


public class ExerciseFragment extends Fragment {

    List<Exercises> exercises;
    protected RecyclerView rvExercises;
    public static final String TAG = "ExerciseFragment";
    private static final String ARG_PARAM1 = "ARG_PARAM1";
    public static final String EXERCISE_URL = "https://wger.de/api/v2/exercise/";


    public String categoryID;


    public static ExerciseFragment newInstance(String categoryID) {

        Bundle args = new Bundle();

        ExerciseFragment fragment = new ExerciseFragment();
        args.putString(ARG_PARAM1, categoryID);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null){
            categoryID = getArguments().getString(ARG_PARAM1);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        return inflater.inflate(R.layout.fragment_execise, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        rvExercises = view.findViewById(R.id.rvExercises);
        exercises = new ArrayList<>();

        ExerciseAdapter exercisesAdapter = new ExerciseAdapter(getContext(), exercises);

        //Sets the recycler view to the adapter
        rvExercises.setAdapter(exercisesAdapter);
        //sets the layout manager
        rvExercises.setLayoutManager(new LinearLayoutManager(getContext()));

        AsyncHttpClient client = new AsyncHttpClient();

        client.get(EXERCISE_URL + "?limit=200" + "&category=" + categoryID + "&language=2", new JsonHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Headers headers, JSON json) {
                Log.d(TAG, "onSuccess");
                JSONObject jsonObject = json.jsonObject;
                //try catches the JSON exception
                try {
                    JSONArray results = jsonObject.getJSONArray("results");
                    Log.i(TAG,"results"+results.toString());
                    exercises.addAll(Exercises.fromJsonArray(results));
                    exercisesAdapter.notifyDataSetChanged();
//


                } catch (JSONException e) {
                    Log.e(TAG, "Hit json exception");
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(int statusCode, Headers headers, String response, Throwable throwable) {

            }
        });


    }
}