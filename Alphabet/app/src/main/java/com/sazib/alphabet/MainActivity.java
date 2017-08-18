package com.sazib.alphabet;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    Button btnNext, btnBack, btnHome;

    Typeface tf;

    ImageView imageViewSmall, imageViewBig;
    private int currentImage = 0;
        int[] imagesA = { R.drawable.ojo, R.drawable.mango, R.drawable.mach, R.drawable.eid, R.drawable.unon,
            R.drawable.usha, R.drawable.rrin, R.drawable.ektara, R.drawable.oikko, R.drawable.oll, R.drawable.oushod,
            R.drawable.s1, R.drawable.khejorgac, R.drawable.golap, R.drawable.ghuri, R.drawable.shing,
            R.drawable.chasma, R.drawable.umbrella, R.drawable.jahaj,R.drawable.jinnok, R.drawable.miya_vai, R.drawable.tometo,
            R.drawable.thelagari, R.drawable.dab, R.drawable.dhol, R.drawable.rrin, R.drawable.tormuj, R.drawable.thala,
//            R.drawable.duat, R.drawable.dhanok, R.drawable.boat, R.drawable.pepe, R.drawable.flower, R.drawable.ball,
//            R.drawable.vela, R.drawable.moi, R.drawable.jata, R.drawable.roshi, R.drawable.latim, R.drawable.shosa,
//            R.drawable.sholo, R.drawable.sona, R.drawable.haalim, R.drawable.pahar, R.drawable.ashar, R.drawable.goyna,
//            R.drawable.katla, R.drawable.eye, R.drawable.shrimp, R.drawable.chad
        };

    int[] images = {R.drawable.a1, R.drawable.a2, R.drawable.a3, R.drawable.a4, R.drawable.a5,
            R.drawable.a6, R.drawable.a7, R.drawable.a8, R.drawable.a9, R.drawable.a10, R.drawable.a11,
            R.drawable.a13, R.drawable.a14, R.drawable.a15, R.drawable.a16, R.drawable.a17, R.drawable.a18,
            R.drawable.a19, R.drawable.a20, R.drawable.a21, R.drawable.a22, R.drawable.a23, R.drawable.a24,
            R.drawable.a25, R.drawable.a26, R.drawable.a27, R.drawable.a28, R.drawable.a, //R.drawable.a29,
//            R.drawable.a30, R.drawable.a31, R.drawable.a32, R.drawable.a33, R.drawable.a34, R.drawable.a35,
//            R.drawable.a37, R.drawable.a38, R.drawable.a39, R.drawable.a40, R.drawable.a41,
//            R.drawable.a42, R.drawable.a43, R.drawable.a44, R.drawable.a45, R.drawable.a46, R.drawable.a47,
//            R.drawable.a48, R.drawable.a49, R.drawable.a50, R.drawable.a51
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnBack = (Button) findViewById(R.id.btn_back);
        //btnHome = (Button) findViewById(R.id.btn_home);
        btnNext = (Button) findViewById(R.id.btn_next);

        tf = Typeface.createFromAsset(getAssets(), "fonts/solaimanlipinormal.ttf");

        btnNext.setTypeface(tf);
        //btnHome.setTypeface(tf);
        btnBack.setTypeface(tf);

        imageViewSmall = (ImageView) findViewById(R.id.image_small_alpha);
        imageViewBig = (ImageView) findViewById(R.id.image_big_alpha);

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                currentImage--;
                currentImage = (currentImage + images.length) % images.length;
                imageViewBig.setImageResource(imagesA[currentImage]);
                imageViewSmall.setImageResource(images[currentImage]);
            }
        });

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                currentImage++;
                currentImage = currentImage % images.length;
                imageViewBig.setImageResource(imagesA[currentImage]);
                imageViewSmall.setImageResource(images[currentImage]);
            }
        });

//        btnHome.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                startActivity(new Intent(MainActivity.this, Main2Activity.class));
//                finish();
//            }
//        });
    }
}
