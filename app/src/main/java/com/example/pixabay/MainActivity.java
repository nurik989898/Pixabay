package com.example.pixabay;

import androidx.appcompat.app.AppCompatActivity;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.pixabay.adaptor.ImageAdaptor;
import com.example.pixabay.databinding.ActivityMainBinding;
import com.example.pixabay.network.model.Hit;
import com.example.pixabay.network.model.RetrofitService;
import com.example.pixabay.network.model.pixModel;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    RetrofitService retrofitService;
    ActivityMainBinding binding;
    ImageAdaptor adaptor;
    public static final String KEY = "22057740-2d95ac4ce395d355525589b02";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        retrofitService = new RetrofitService();
        initClickers();
    }

    private void initClickers() {
        binding.applyBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String word = binding.wordEd.getText().toString();
                getImageFromApi(word, 1, 10);
            }
        });

    }

    private void getImageFromApi(String word, int page, int perPage) {
        retrofitService.getApi().getImages(KEY, word, page, perPage).enqueue(new Callback<pixModel>() {
            @Override
            public void onResponse(Call<pixModel> call, Response<pixModel> response) {
                if (response.isSuccessful()) {
                    adaptor = new ImageAdaptor((ArrayList<Hit>) response.body().getHits());
                    binding.recyclerView.setAdapter(adaptor);
                }
            }


            @Override
            public void onFailure(Call<pixModel> call, Throwable t) {
                Log.e("ololo", "OnFailure: " + t.getMessage());
            }
        });
        binding.swipeRefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                int count = 1;
                String word = binding.wordEd.getText().toString();
                getImageFromApi(word, ++count, 5);
                binding.swipeRefresh.setRefreshing(false);
            }
        });
    }
}