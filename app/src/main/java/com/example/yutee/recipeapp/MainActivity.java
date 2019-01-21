package com.example.yutee.recipeapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.yutee.recipeapp.Model.Recipe;

import java.util.List;

/**
 * Created by Utibe Etim
 * 17/01/2019
 */

public class MainActivity extends AppCompatActivity {

    static List<Recipe> recipesList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public  static Recipe getRecipe(int position){
        return recipesList.get(position);
    }
}
