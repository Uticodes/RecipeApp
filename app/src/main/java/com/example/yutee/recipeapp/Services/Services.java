package com.example.yutee.recipeapp.Services;

import com.example.yutee.recipeapp.Model.Recipe;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Services {
    @GET("/Nsikaktopdown/Recipe/master/Recipe.json")
    Call<List<Recipe>> readJson();
}
