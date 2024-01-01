package com.arbib.multi_browser.adapters;

import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.arbib.multi_browser.R;

public class WebViewAdapter extends RecyclerView.Adapter<WebViewAdapter.ViewHolder> {


    private int count;

    private String url;

    public WebViewAdapter(int count, String url) {
        this.count = count;
        this.url = url;
    }

    @NonNull
    @Override
    public WebViewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_webview, parent, false);
        return new WebViewAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull WebViewAdapter.ViewHolder holder, int position) {

        holder.webView.loadUrl(url);
        holder.webView.setWebViewClient(new WebViewClient() {

            @Override
            public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
                super.shouldOverrideUrlLoading(view, request);
                view.loadUrl(url);
                return true;
            }

            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                super.onPageStarted(view, url, favicon);
                holder.progressBar.setVisibility(View.VISIBLE);
            }

            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                holder.progressBar.setVisibility(View.GONE);
            }
        });
    }

    @Override
    public int getItemCount() {
        return count;
    }


    public static class ViewHolder extends RecyclerView.ViewHolder{
        private WebView webView;
        private ProgressBar progressBar;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            this.webView = itemView.findViewById(R.id.webview);
            this.progressBar = itemView.findViewById(R.id.progress_bar);
        }
    }

}
