package com.example.api_project_retrofit;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.Movie;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.api_project_retrofit.Adapter.MovieAdapter;
import com.example.api_project_retrofit.Api.ApiClient;
import com.example.api_project_retrofit.Api.ApiInterface;
import com.example.api_project_retrofit.Model.BaseModel;
import com.example.api_project_retrofit.Model.Result;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    List<Result> list = new ArrayList<>();
    MovieAdapter adapter ;


    ApiInterface request;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        request = ApiClient.getApiClient().create(ApiInterface.class);

        recyclerView = findViewById(R.id.rv_main);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));
        recyclerView.setHasFixedSize(true);



        Call<BaseModel> call = request.getMovie("fad81aafa497ef20154174367fb6c3ac");


        call.enqueue(new Callback<BaseModel>() {
            @Override
            public void onResponse(Call<BaseModel> call, Response<BaseModel> response) {


                list = response.body().getResults();
                adapter = new MovieAdapter(getApplicationContext(),list);
                recyclerView.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<BaseModel> call, Throwable t) {


                Toast.makeText(MainActivity.this, "failed", Toast.LENGTH_SHORT).show();
               //learn this single code help u a lot for debugging :)
                Log.d("error" ,t.getMessage());

            }
        });
    }
}