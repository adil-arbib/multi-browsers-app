package com.arbib.multi_browser.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebView;

import com.arbib.multi_browser.R;
import com.arbib.multi_browser.adapters.WebViewAdapter;

public class MainActivity extends AppCompatActivity {


    private WebViewAdapter webViewAdapter;
    private RecyclerView recyclerView;



    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);

        Intent intent = getIntent();
        String url = intent.getStringExtra("URL");

        webViewAdapter = new WebViewAdapter(10000, url);

        recyclerView.setAdapter(webViewAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

    }
}