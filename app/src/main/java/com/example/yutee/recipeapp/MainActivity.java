package com.example.yutee.recipeapp;

import android.app.Activity;
import android.app.ProgressDialog;
import android.app.Service;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.Configuration;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.yutee.recipeapp.Adapter.RecipeAdapter;
import com.example.yutee.recipeapp.Client.Client;
import com.example.yutee.recipeapp.Model.Recipe;
import com.example.yutee.recipeapp.Services.Services;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Utibe Etim
 * 17/01/2019
 */

public class MainActivity extends AppCompatActivity {

    static List<Recipe> recipesList;
    private RecyclerView recyclerView;
    private RecipeAdapter adapter;
    ProgressDialog progressDialog;
    private SwipeRefreshLayout swipeContainer;

    public static final String LOG_TAG = RecipeAdapter.class.getName();

    public Activity getActivity() {
        Context context = this;
        while (context instanceof ContextWrapper) {
            if (context instanceof Activity) {
                return (Activity) context;
            }
            context = ((ContextWrapper) context).getBaseContext();
        }

        return null;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();

        swipeContainer = (SwipeRefreshLayout) findViewById(R.id.main_content);
        swipeContainer.setColorSchemeResources(android.R.color.holo_blue_dark);
        swipeContainer.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {


            @Override
            public void onRefresh() {
                initViews();
                loadJson();


            }
        });
        loadJson();

    }

    private void loadJson() {

            Services service = Client.getClient().create(Services.class);
            Call<List<Recipe>> call = service.readJson();
            call.enqueue(new Callback<List<Recipe>>() {
                @Override
                public void onResponse(Call<List<Recipe>> call, Response<List<Recipe>> response) {
                    recipesList = response.body();
                    adapter.setRecipes(recipesList);
                    progressDialog.dismiss();


                }

                @Override
                public void onFailure(Call<List<Recipe>> call, Throwable t) {
                    Log.e("failure", "failure");

                }
            });



    }

    private void initViews() {
        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Fetching...");
        progressDialog.setCancelable(false);



        recyclerView =  findViewById(R.id.rv_view);
        recipesList = new ArrayList<>();
        adapter = new RecipeAdapter(this, recipesList);

        if (getActivity().getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT) {

            recyclerView.setLayoutManager(new LinearLayoutManager(this));
            recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
            recyclerView.setItemAnimator(new DefaultItemAnimator());
            recyclerView.setAdapter(adapter);

        }


    }

    public  static Recipe getRecipe(int position){
        return recipesList.get(position);
    }
}
