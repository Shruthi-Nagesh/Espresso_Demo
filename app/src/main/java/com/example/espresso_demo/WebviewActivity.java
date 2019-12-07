package com.example.espresso_demo;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.annotation.Nullable;

public class WebviewActivity extends Activity {

    private ProgressDialog mProgDailog;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_webview);

        WebView webView = (WebView) findViewById(R.id.webview);

        mProgDailog = ProgressDialog.show(this, "Loading","Please wait...", true);
        mProgDailog.setCancelable(false);

        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webView.getSettings().setLoadWithOverviewMode(true);
        webView.getSettings().setUseWideViewPort(true);
        webView.setWebViewClient(new WebViewClient(){

            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                mProgDailog.show();
                view.loadUrl(url);
                return true;
            }
            @Override
            public void onPageFinished(WebView view, final String url) {
                mProgDailog.dismiss();
            }
        });

        webView.loadUrl("https://developer.android.com/training/testing/espresso/setup#java");
        //webView.loadUrl("http://<your domain or IP>/index.html");

    }

}

