package com.sazib.alphabet.Map;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.sazib.alphabet.R;

public class Map extends AppCompatActivity {

    private WebView mywebview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);

        mywebview = (WebView) findViewById(R.id.webView);
        WebSettings webSettings = mywebview.getSettings();
        webSettings.setJavaScriptEnabled(true);
        //mywebview.loadUrl("https://www.google.com.bd/maps/@23.815000,90.426306,15z");
        mywebview.loadUrl("https://www.google.com.bd/maps/place/NSU+SAC/@23.8151922,90.426019,18.86z/data=!4m5!3m4!1s0x3755c64c125b6dc9:0x8ab3bb2e7c784ebc!8m2!3d23.8149819!4d90.4259733");
        mywebview.setWebViewClient(new WebViewClient());
    }

    @Override
    public void onBackPressed() {
        if (mywebview.canGoBack()) {
            mywebview.goBack();
        } else {
            super.onBackPressed();
        }

    }

}
