package com.example.task51newsapp;

import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {
    private RecyclerView horizontalRecyclerView;
    private ArrayList<String> dataSource;
    private LinearLayoutManager horizontalLayoutManager;
    private RecyclerView.LayoutManager gridLayoutManager;
    private NewsAdapter newsAdapter;
    private RecyclerView newsRecyclerView;
    private TopStoryAdapter topStoryAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Setup Horizontal RecyclerView
        horizontalRecyclerView = findViewById(R.id.horizontalRv);
        dataSource = new ArrayList<>();
        dataSource.addAll(Arrays.asList("First News", "Second News", "Third News", "Fourth News", "Fifth News", "Sixth News"));
        horizontalLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        newsAdapter = new NewsAdapter(dataSource);
        horizontalRecyclerView.setLayoutManager(horizontalLayoutManager);
        horizontalRecyclerView.setAdapter(newsAdapter);

        // Setup Grid RecyclerView
        int[] array = new int[6];
        Arrays.fill(array, R.drawable.ic_launcher_background);
        newsRecyclerView = findViewById(R.id.newsRv);
        gridLayoutManager = new GridLayoutManager(this, 2);
        newsRecyclerView.setLayoutManager(gridLayoutManager);
        topStoryAdapter = new TopStoryAdapter(array);
        newsRecyclerView.setAdapter(topStoryAdapter);
        newsRecyclerView.setHasFixedSize(true);

        // Set Item Click Listeners
        topStoryAdapter.setOnItemClickListener(position -> {
            showNewsDetail("Sample Title", "Sample Description", R.drawable.ic_launcher_background);
        });

        newsAdapter.setOnItemClickListener(position -> {
            String title = dataSource.get(position);
            showNewsDetail(title, "Sample Description", R.drawable.ic_launcher_background);
        });
    }

    private void showNewsDetail(String title, String description, int imageResId) {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.newsDetailFragmentContainer, NewsDetailFragment.newInstance(title, description, imageResId))
                .addToBackStack(null)
                .commit();
        findViewById(R.id.newsDetailFragmentContainer).setVisibility(View.VISIBLE);
    }
}
