package com.example.task51newsapp;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.Arrays;

public class NewsDetailFragment extends Fragment {

    private String newsTitle;
    private String newsDescription;
    private int newsImage;
    private RelativeNewsAdapter relativeNewsAdapter;
    private LinearLayoutManager linearLayoutManager;

    public NewsDetailFragment() {
        // empty public constructor
    }

    public static NewsDetailFragment newInstance(String title, String description, int imageResId) {
        Bundle args = new Bundle();
        args.putString("title", title);
        args.putString("description", description);
        args.putInt("imageResId", imageResId);

        NewsDetailFragment fragment = new NewsDetailFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            newsTitle = getArguments().getString("title");
            newsDescription = getArguments().getString("description");
            newsImage = getArguments().getInt("imageResId");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Log.d("NewsDetailFragment", "Fragment view being created");
        View view = inflater.inflate(R.layout.fragment_news_detail, container, false);
        TextView tvDescription = view.findViewById(R.id.newsDescription);
        ImageView ivImage = view.findViewById(R.id.newsImage);
        RecyclerView rvRelatedNews = view.findViewById(R.id.relatedNewsRv);
        linearLayoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        rvRelatedNews.setLayoutManager(linearLayoutManager);
        int []array = new int [6];
        Arrays.fill(array, R.drawable.ic_launcher_foreground);

        relativeNewsAdapter = new RelativeNewsAdapter(array);
        rvRelatedNews.setAdapter(relativeNewsAdapter);
        rvRelatedNews.setHasFixedSize(true);

        tvDescription.setText(newsDescription);
        ivImage.setImageResource(newsImage);

        return view;
    }
}