package com.example.yutee.recipeapp.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.yutee.recipeapp.Model.Recipe;
import com.example.yutee.recipeapp.R;
import com.example.yutee.recipeapp.Recipe_Detail_Activity;

import java.util.List;

public class RecipeAdapter extends RecyclerView.Adapter<RecipeAdapter.MyHolder> {

    Context mContext;
    List<Recipe> recipes;
    RecipeOnclickListener mListener;

    public interface  RecipeOnclickListener{
        void onClick(int position);
    }

    public RecipeAdapter(Context context, List<Recipe> recipes) {

        mContext = context;
        this.recipes = recipes;
    }

    @Override
    public int getItemViewType(int position) {
        return super.getItemViewType(position);
    }

    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int position) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.single_food_portrait, viewGroup, false);

        return new MyHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder myHolder, int position) {
        Recipe recipe = recipes.get(position);
        myHolder.headline.setText(recipe.getHeadline());
        myHolder.name.setText(recipe.getName());


        if (recipe.getRating() == null){
            myHolder.rating.setRating(0);
        }else{
            myHolder.rating.setRating(recipe.getRating().floatValue());
        }

        Glide.with(mContext).load(recipe.getImage()).into(myHolder.thumbnail);

    }

    @Override
    public int getItemCount() {
        return recipes == null ? 0 : recipes.size();
    }

    public void setRecipes(List<Recipe> recipes){
        for(Recipe recipe:recipes){
            addRecipe(recipe);
        }
    }

    public void addRecipe(Recipe recipe){
        recipes.add(recipe);
        notifyItemInserted(recipes.size());
    }

    class MyHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private ImageView thumbnail;
        private TextView headline;
        private RatingBar rating;
        private TextView name;



        public MyHolder(View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.recipe_name);
            thumbnail = itemView.findViewById(R.id.recipe_thumbnail);
            headline = itemView.findViewById(R.id.recipe_headline);
            rating = itemView.findViewById(R.id.recipe_rating);

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            Intent intent = new Intent(mContext, Recipe_Detail_Activity.class);
            intent.putExtra(Recipe_Detail_Activity.RECIPE_POSITION,getAdapterPosition());
            mContext.startActivity(intent);
        }
    }
}
