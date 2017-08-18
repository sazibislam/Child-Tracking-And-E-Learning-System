package com.sazib.alphabet.Math;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.sazib.alphabet.Main2Activity;
import com.sazib.alphabet.R;

public class ResultActivity extends AppCompatActivity {

    Button btnStart, btnHome;
    Typeface tf;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        tf = Typeface.createFromAsset(getAssets(), "fonts/solaimanlipinormal.ttf");

        //String stringText = "ফলাফল";

        TextView textResult = (TextView) findViewById(R.id.textResult);
        Bundle b = getIntent().getExtras();
        int score = b.getInt("score");
        textResult.setTypeface(tf);

        switch (score){
            case 1:
                textResult.setText("স্কোর : ১");
                break;
            case 2:
                textResult.setText("স্কোর : ২");
                break;
            case 3:
                textResult.setText("স্কোর : ৩");
                break;
            case 4:
                textResult.setText("স্কোর : ৪");
                break;
            case 5:
                textResult.setText("স্কোর : ৫");
                break;
            case 6:
                textResult.setText("স্কোর : ৬");
                break;
            case 7:
                textResult.setText("স্কোর : ৭");
                break;
            case 8:
                textResult.setText("স্কোর : ৮");
                break;
            case 9:
                textResult.setText("স্কোর : ৯");
                break;
            case 10:
                textResult.setText("স্কোর : ১০");
                break;
            case 11:
                textResult.setText("স্কোর : ১১");
                break;
            case 12:
                textResult.setText("স্কোর : ১২");
                break;
            case 13:
                textResult.setText("স্কোর : ১৩");
                break;
            case 14:
                textResult.setText("স্কোর : ১৪");
                break;
            case 15:
                textResult.setText("স্কোর : ১৫");
                break;
            case 16:
                textResult.setText("স্কোর : ১৬");
                break;
            case 17:
                textResult.setText("স্কোর : ১৭");
                break;
            case 18:
                textResult.setText("স্কোর : ১৮");
                break;
            case 19:
                textResult.setText("স্কোর : ১৯");
                break;
            case 20:
                textResult.setText("স্কোর : ২০");
                break;
            default :
                textResult.setText("স্কোর ঃ ০");
                break;
        }
        //textResult.setText("তোমার স্কোর : " + " " + score + " ");

        btnStart = (Button) findViewById(R.id.btnStart);
        btnHome = (Button) findViewById(R.id.btnHome);

        btnStart.setTypeface(tf);
        btnHome.setTypeface(tf);

        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ResultActivity.this, QuestionActivity.class));
                finish();
            }
        });

        btnHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ResultActivity.this, Main2Activity.class));
                finish();
            }
        });
    }
}
