package com.example.yutee.recipeapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import com.example.yutee.recipeapp.Model.Recipe;

public class Recipe_Detail_Activity extends AppCompatActivity {
public static final String RECIPE_POSITION = "recipe_position";

    TextView nameOfRecipe;
    TextView favoriteName;
    TextView nameOfFiber;
    TextView description;
    TextView nameOfIngredient;
    ImageView imageView;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe_details);
        imageView = findViewById(R.id.loopback);
        Intent intent = getIntent();

        description = findViewById(R.id.recipe_description);
        favoriteName = findViewById(R.id.favorite);
        nameOfRecipe = findViewById(R.id.recipe_name);
        nameOfIngredient =  findViewById(R.id.ingredient);
        nameOfFiber =  findViewById(R.id.fibers);

        if (intent != null) {
            int position = intent.getIntExtra(RECIPE_POSITION, 0);
            Recipe recipe = MainActivity.getRecipe(position);
            Glide.with(this).load(recipe.getImage()).into(imageView);


            nameOfRecipe.setText(recipe.getDescription());
            nameOfIngredient.setText(recipe.getHeadline());
            nameOfFiber.setText(recipe.getFibers());
            favoriteName.setText(recipe.getCalories());




        }

    }
}
