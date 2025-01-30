package com.peditx.app;

import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // ایجاد یک WebView
        WebView webView = new WebView(this);

        // تنظیمات WebView
        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true); // فعال‌سازی JavaScript
        webSettings.setDomStorageEnabled(true); // فعال‌سازی DOM Storage

        // تنظیم WebViewClient برای بارگذاری صفحات درون WebView
        webView.setWebViewClient(new WebViewClient());

        // بارگذاری URL از ورودی GitHub Actions
        String websiteUrl = getIntent().getStringExtra("website_url");
        if (websiteUrl == null || websiteUrl.isEmpty()) {
            websiteUrl = "http://peditxos.lan"; // URL پیش‌فرض
        }
        webView.loadUrl(websiteUrl);

        // تنظیم WebView به عنوان محتوای Activity
        setContentView(webView);
    }
}
