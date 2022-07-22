package com.example.gymrats.filter;

import com.example.gymrats.models.Post;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Filter {

    //Creates the filter as well as adds an Array list containing all the categories to filter by
    public final static List<String> CATEGORY_LIST = new ArrayList<>(Arrays.asList("ABS","ARMS","BACK", "CALVES", "CHEST","LEGS","SHOULDERS"));

    private Filter (){}

    public void getPostByFiltering(List<String> types, List<Post> currentPosts){

        List<String> categoryWords = new ArrayList<>();

    }

}
