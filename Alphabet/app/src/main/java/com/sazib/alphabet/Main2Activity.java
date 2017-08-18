package com.sazib.alphabet;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.sazib.alphabet.Map.LattitudeAndLongitudeMap;
import com.sazib.alphabet.Map.Map;

public class Main2Activity extends AppCompatActivity {

    Button btnAlpha, btnMath, btnImageLearning;
    Button mMap, mPinPoint;
    TextView textView, textView2;

    Typeface tf;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);


        //textView = (TextView)findViewById(R.id.activity2_textview);

        btnAlpha = (Button) findViewById(R.id.alphabet);
        //btnMath = (Button) findViewById(R.id.math);
        mMap    = (Button) findViewById(R.id.map);
        mPinPoint    = (Button) findViewById(R.id.pinPoint);

        //btnImageLearning = (Button) findViewById(R.id.picture);
        textView2 = (TextView)findViewById(R.id.main2_textview);


        tf = Typeface.createFromAsset(getAssets(), "fonts/solaimanlipinormal.ttf");


        //btnImageLearning.setTypeface(tf);

        /*btnImageLearning.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Main2Activity.this, PicActivity.class));
            }
        });*/

        btnAlpha.setTypeface(tf);
        mMap.setTypeface(tf);
        mPinPoint.setTypeface(tf);
        //btnMath.setTypeface(tf);
        //btnImageLearning.setTypeface(tf);
        textView2.setTypeface(tf);

//        btnMath.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                startActivity(new Intent(Main2Activity.this, QuestionActivity.class));
//            }
//        });

        btnAlpha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Main2Activity.this, MainActivity.class));
                //finish();
            }
        });


        mMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(Main2Activity.this, Map.class));
            }
        });


        mPinPoint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(Main2Activity.this, LattitudeAndLongitudeMap.class));

            }
        });
    }

}
