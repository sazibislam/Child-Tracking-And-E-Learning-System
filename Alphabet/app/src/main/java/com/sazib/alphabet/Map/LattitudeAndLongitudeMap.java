package com.sazib.alphabet.Map;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;

import com.sazib.alphabet.R;

public class LattitudeAndLongitudeMap extends AppCompatActivity {

    private WebView mywebview;
    Button mBtn;
    EditText mLattitude, mLongitude;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lattitude_and_longitude_map);

        mBtn = (Button) findViewById(R.id.btn);
        mLattitude = (EditText) findViewById(R.id.lattitude);
        mLongitude = (EditText) findViewById(R.id.longtude);



        mBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                String Latta = mLattitude.toString().trim();
                String longt = mLattitude.toString().trim();


                if (Latta != null && !Latta.isEmpty() && !longt.isEmpty() ) {
                    mywebview = (WebView) findViewById(R.id.webView_lattitude);
                    WebSettings webSettings = mywebview.getSettings();
                    webSettings.setJavaScriptEnabled(true);
                    mywebview.loadUrl("https://www.google.com.bd/maps");
                    mywebview.setWebViewClient(new WebViewClient());

                }else{
                    mywebview = (WebView) findViewById(R.id.webView_lattitude);
                    WebSettings webSettings = mywebview.getSettings();
                    webSettings.setJavaScriptEnabled(true);
                    mywebview.loadUrl("https://www.google.com.bd/maps/"+Latta+","+longt);
                    mywebview.setWebViewClient(new WebViewClient());
                }


            }
        });

    }
}
