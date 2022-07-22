package com.example.gymrats.models;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class ExercisesCategories {
    String id;
    String category;
    public static HashMap<String, String> categoryMap = new HashMap<>();

    //TODO: ADD STRINGS TO STRINGS.XML FILE
    public static final String URL_ARMS = "https://cdn.mos.cms.futurecdn.net/6TGkrUJK6J9a69Xtiuu9Qb.jpg";
    public static final String URL_ABS = "https://cdn.shopify.com/s/files/1/1876/4703/articles/shutterstock_1724837179_1000x.jpg?v=1623225167";
    public static final String URL_SHOULDER = "https://www.themanual.com/wp-content/uploads/sites/9/2021/05/athlete-doing-push-ups-in-gym.jpg?p=1";
    public static final String URL_CALVES = "https://d3h9ln6psucegz.cloudfront.net/wp-content/uploads/2021/11/How-to-Build-Calves-with-One-Workout-a-Week.jpg";
    public static final String URL_LEGS = "https://www.bodybuilding.com/images/2016/june/leg-workouts-for-men-7-best-workouts-for-quads-glutes-hams-header-v2-960x540.jpg";
    public static final String URL_CHEST = "https://bod-blog-assets.prod.cd.beachbodyondemand.com/bod-blog/wp-content/uploads/2022/06/15144207/chest-muscles-960-715x358.png";
    public static final String URL_BACK = "https://us.123rf.com/450wm/nikolasjkd/nikolasjkd2010/nikolasjkd201000013/156458585-muscular-man-workout-in-gym-doing-exercise-for-back-strong-male-rear-view.jpg?ver=6";

    private static ArrayList <String> Category_URL = new ArrayList<>(Arrays.asList(URL_ABS,URL_ARMS,URL_BACK,URL_CALVES,URL_CHEST,URL_LEGS,URL_SHOULDER));

    public ExercisesCategories(){}

    public ExercisesCategories (JSONObject jsonObject)throws JSONException{

        category = jsonObject.getString("name");
        id = Integer.toString(jsonObject.getInt("id"));

    }

    public static List<ExercisesCategories> fromJsonArray(JSONArray exercisesCategoriesJsonArray) throws JSONException{
        List<ExercisesCategories> exercisesCategories = new ArrayList<>();

        for (int i = 0; i < exercisesCategoriesJsonArray.length(); i++){
            exercisesCategories.add(new ExercisesCategories(exercisesCategoriesJsonArray.getJSONObject(i)));
            categoryMap.put(new ExercisesCategories(exercisesCategoriesJsonArray.getJSONObject(i)).getCategory(), Category_URL.get(i));
        }
        return exercisesCategories;
    }

    public String getCategory() {
        return category;
    }

    public String getId() {
        return id;
    }

    public String getImage(ExercisesCategories exercisesCategories){
        return categoryMap.get(exercisesCategories.getCategory());
    }
}


