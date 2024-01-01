package com.arbib.multi_browser.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.arbib.multi_browser.R;
import com.arbib.multi_browser.databinding.ActivitySelectWebSiteBinding;

import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;

public class SelectWebSiteActivity extends AppCompatActivity {

    private ActivitySelectWebSiteBinding binding;

    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySelectWebSiteBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        intent = new Intent(SelectWebSiteActivity.this, MainActivity.class);

        binding.ivGoogle.setOnClickListener(v -> {
            intent.putExtra("URL", "https://www.google.com/");
            startActivity(intent);
        });

        binding.ivFb.setOnClickListener(v -> {
            intent.putExtra("URL", "https://www.facebook.com/");
            startActivity(intent);
        });

        binding.ivTwitter.setOnClickListener(v -> {
            intent.putExtra("URL", "https://twitter.com/?lang=en");
            startActivity(intent);
        });

        binding.ivYoutube.setOnClickListener(v -> {
            intent.putExtra("URL", "https://www.youtube.com/");
            startActivity(intent);
        });

        binding.btnRun.setOnClickListener(v-> {
            if(!validate()){
                Toast.makeText(this, "Please enter a URL", Toast.LENGTH_SHORT).show();
                return;
            }
            String inputURL = binding.etURL.getText().toString();
            if(!isValidURL(inputURL)){
                Toast.makeText(this, "Please enter a valid URL", Toast.LENGTH_SHORT).show();
                return;
            }
            intent.putExtra("URL", inputURL);
            startActivity(intent);

        });


    }

    private boolean isValidURL(String url) {
        try {
            new URL(url).toURI();
            return true;
        } catch (MalformedURLException e) {
            return false;
        } catch (URISyntaxException e) {
            return false;
        }
    }
    private boolean validate() {
        return !binding.etURL.getText().toString().isEmpty();

    }


}