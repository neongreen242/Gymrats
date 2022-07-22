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
import com.example.gymrats.adapters.CategoryAdapter;
import com.example.gymrats.models.ExercisesCategories;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import okhttp3.Headers;

public class CategoryFragment extends Fragment {


    protected RecyclerView rvCategories;
    List<ExercisesCategories> exercisesCategories;
    public static final String  TAG = "CategoryFragment";
    public static final String CATEGORY_URL = "https://wger.de/api/v2/exercisecategory/";


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_category, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {

        super.onViewCreated(view, savedInstanceState);

        exercisesCategories = new ArrayList<>();
        rvCategories = view.findViewById(R.id.rvCategories);

        CategoryAdapter categoryAdapter = new CategoryAdapter(getContext(), exercisesCategories);

        rvCategories.setAdapter(categoryAdapter);

        rvCategories.setLayoutManager(new LinearLayoutManager(getContext()));

        //Calls the API
        AsyncHttpClient client = new AsyncHttpClient();
        //Uses the API URL to call the array of categories
        client.get(CATEGORY_URL, new JsonHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Headers headers, JSON json) {
                Log.d(TAG, "onSuccess");
                JSONObject jsonObject = json.jsonObject;
                //Try catches the JSON exception
                try {
                    JSONArray results = jsonObject.getJSONArray("results");
                    Log.i(TAG,"results"+results.toString());
                    exercisesCategories.addAll(ExercisesCategories.fromJsonArray(results));
                    categoryAdapter.notifyDataSetChanged();
                } catch (JSONException e) {
                    Log.e(TAG,"Hit json exception");
                    e.printStackTrace();
                }

            }

            @Override
            public void onFailure(int statusCode, Headers headers, String response, Throwable throwable) {

            }
        });

    }
}