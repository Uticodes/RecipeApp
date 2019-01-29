package com.example.yutee.recipeapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

import com.bumptech.glide.Glide;
import com.example.yutee.recipeapp.Model.Recipe;

import java.util.HashSet;
import java.util.Set;

public class Recipe_Detail_Activity extends AppCompatActivity {
public static final String RECIPE_POSITION = "recipe_position";

public static final String PREFERENCE_NAME = "com.example.yutee.recipeapp";
public static final String PREFERENCE_KEY_NAME = "favourite";

    Set<String> mFavourite;
    int Position;

    TextView nameOfRecipe;
    TextView favoriteName;
    TextView nameOfFiber;
    TextView description;
    TextView nameOfIngredient;
    ImageView imageView;
    ImageView favButton;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(@Nullable final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        imageView = findViewById(R.id.thumb_header);
        Intent intent = getIntent();

        description = findViewById(R.id.recipe_description);
        favoriteName = findViewById(R.id.favorite);
        nameOfRecipe = findViewById(R.id.food_name);
        nameOfIngredient =  findViewById(R.id.ingredient);
        nameOfFiber =  findViewById(R.id.fibers);

        favButton = findViewById(R.id.favouriteBtn);
        mFavourite = getFavourite();

        if (intent != null) {
            Position = intent.getIntExtra(RECIPE_POSITION, 0);
            Recipe recipe = MainActivity.getRecipe(Position);
            Glide.with(this).load(recipe.getImage()).into(imageView);

            nameOfRecipe.setText(recipe.getName());
            description.setText(recipe.getDescription());
            nameOfIngredient.setText(recipe.getIngredients().toString());
            nameOfFiber.setText(recipe.getFibers());
            favoriteName.setText(recipe.getCalories());
        }
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        initCollapsingToolbar();
        saveFavourite();
    }
    public void fav(View v){

        if (ConfirmFavourite (Position)){
            mFavourite.remove(Integer.toString(Position));
            Toast.makeText(Recipe_Detail_Activity.this,"Removed from favorite list",Toast.LENGTH_SHORT).show();
        }else {
            mFavourite.add(Integer.toString(Position));
            Toast.makeText(Recipe_Detail_Activity.this,"Added to your favorite list",Toast.LENGTH_SHORT).show();
        }
        saveFavourite();
    }
    private boolean ConfirmFavourite(int isPosition) {
        Set<String> FavCF = getFavourite();
        if (FavCF.contains(Integer.toString(isPosition))){
            return true;
        }else {
            return false;
        }
    }
    private void saveFavourite() {
        SharedPreferences prefs = getSharedPreferences(PREFERENCE_NAME, 0);
        SharedPreferences.Editor editP = prefs.edit();
        editP.putStringSet(PREFERENCE_KEY_NAME, mFavourite).apply();
        if (ConfirmFavourite(Position)){
            favButton.setImageResource(R.drawable.ic_favorite);
        }else {
            favButton.setImageResource(R.drawable.ic_favorite_border);
        }
    }
    private Set<String> getFavourite() {
        SharedPreferences prefs = getSharedPreferences(PREFERENCE_NAME, 0);
        return prefs.getStringSet(PREFERENCE_KEY_NAME, new HashSet<String>());
    }

    private void initCollapsingToolbar() {
    }
}




