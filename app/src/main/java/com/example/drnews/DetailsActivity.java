package com.example.drnews;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.drnews.Models.NewsHeadlines;
import com.squareup.picasso.Picasso;

public class DetailsActivity extends AppCompatActivity {
    NewsHeadlines headlines;
    TextView detail_title, detail_author, detail_time, detail_detail, detail_content;
    ImageView news_image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        detail_title =  findViewById(R.id.detail_title);
        detail_author = findViewById(R.id.detail_author);
        detail_time = findViewById(R.id.detail_time);
        detail_detail = findViewById(R.id.detail_detail);
        detail_content = findViewById(R.id.detail_content);
        news_image = findViewById(R.id.detail_image);

        headlines = (NewsHeadlines) getIntent().getSerializableExtra("data");

        detail_title.setText(headlines.getTitle());
        detail_author.setText(headlines.getAuthor());
        detail_time.setText(headlines.getPublishedAt());
        detail_detail.setText(headlines.getDescription());
        detail_content.setText(headlines.getContent());
        Picasso.get().load(headlines.getUrlToImage()).into(news_image);
    }
}