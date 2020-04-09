package com.example.localization;

import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.localization.pojo.News;

public class ContentActivity  extends AppCompatActivity {
    private TextView mTv_new_title,mTv_new_content;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_news_content);
        mTv_new_title = findViewById(R.id.news_title);
        mTv_new_content = findViewById(R.id.news_content);
        Bundle bundle =getIntent().getExtras();
        News news = (News) bundle.getSerializable("news");
        mTv_new_title.setText(news.getNewsTitle());
        mTv_new_content.setText(news.getNewsContent());
    }
}
