package com.sazib.alphabet;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Arrays;
import java.util.Random;

public class PicActivity extends AppCompatActivity {

    private TextView textView;
    private Button btnLeft, btnRight, btnLeftDown, btnRightDown;
    private ImageView imageView;

    Typeface tf;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image);

        final int[] imagesA = {R.drawable.s1, R.drawable.s4, R.drawable.mango, R.drawable.tormuj, R.drawable.golap,
                R.drawable.jahaj, R.drawable.mach, R.drawable.dab, R.drawable.unon,R.drawable.dhol, R.drawable.khejorgac,
                R.drawable.ghori,R.drawable.book, R.drawable.chari, R.drawable.chamos,R.drawable.mogh, R.drawable.bottol,
                R.drawable.light,R.drawable.pen, R.drawable.bag,R.drawable.chair,R.drawable.cha, R.drawable.kha, R.drawable.goru,
                R.drawable.goru
        };

        final String[] name = {"কলা", "ককিল", "আম", "তরমুজ", "গোলাপ", "জাহাজ", "মাছ","ডাব", "চুলা","ঢোল","খেজুরগাছ","ঘড়ি","বই","চাবি","চামস","মগ",
        "বতল","লাইট","কলম","ব্যাগ","চেয়ার", "চ্ড়ুইপাখি","খরগোস","গরু"};

        final String[] nameCheck = {"কলা", "ককিল", "আম", "তরমুজ", "গোলাপ", "জাহাজ", "মাছ","ডাব", "চুলা","ঢোল","খেজুরগাছ","ঘড়ি","বই","চাবি","চামস","মগ",
                "বতল","লাইট","কলম","ব্যাগ","চেয়ার", "চ্ড়ুইপাখি","খরগোস","গরু", "" };

        final String[] wrong = {"বিড়াল", "মহিষ", "চিল", "ছুরি", "কাঁঠাল", "তরকারি", "মানুষ", "গাড়ি", "পাতা", "মুরগি", "সোনা"};

        final String[] wrongB = {"আপেল", "চিল", "আনারস", "বাদাম", "জবা ফুল", "ঠেলা গাড়ি", "তিমি", "মুরগি"};

        tf = Typeface.createFromAsset(getAssets(), "fonts/solaimanlipinormal.ttf");

        btnLeft = (Button) findViewById(R.id.pic_image_btn1);
        btnLeftDown = (Button) findViewById(R.id.pic_image_btn11);
        btnRight = (Button) findViewById(R.id.pic_image_btn2);
        btnRightDown = (Button) findViewById(R.id.pic_image_btn22);

        btnLeft.setTypeface(tf);
        btnLeftDown.setTypeface(tf);
        btnRight.setTypeface(tf);
        btnRightDown.setTypeface(tf);

        textView = (TextView) findViewById(R.id.pic_textview);
        textView.setTypeface(tf);
        imageView = (ImageView) findViewById(R.id.pic_imageview_btn);

        btnLeft.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {

                String text = btnLeft.getText().toString().trim();

                if (Arrays.asList(nameCheck).contains(text)) {

                    textView.setText("সঠিক হয়েছে!");
                    String random = (name[new Random().nextInt(name.length)]);
                    btnRight.setText(random);
//btnLeft
                    for (int i = 0; i <= name.length-1; i++) {
                        if (name[i].equals(random)) {
                            imageView.setImageResource(imagesA[i]);
                        }
                    }
                    String randomRight = (wrong[new Random().nextInt(wrong.length)]);
                    btnLeft.setText(randomRight);
                    //btnRight
                    String randomRight22 = (wrongB[new Random().nextInt(wrongB.length)]);
                    btnRightDown.setText(randomRight22);
                    String randomLeft11 = (wrong[new Random().nextInt(wrong.length)]);
                    btnLeftDown.setText(randomLeft11);

                } else {
                    textView.setText("ভুল হয়েছে। আবার চেষ্টা কর");

                }
            }
        });

        btnRight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String text = btnRight.getText().toString().trim();
                if (Arrays.asList(nameCheck).contains(text)) {
                    textView.setText("সঠিক হয়েছে!");

                    String random = (name[new Random().nextInt(name.length)]);
                    btnLeft.setText(random);
                    //btnRight

                    for (int i = 0; i <= name.length-1; i++) {
                        if (name[i].equals(random)) {
                            imageView.setImageResource(imagesA[i]);
                        }
                    }

                    String randomLeft = (wrong[new Random().nextInt(wrong.length)]);
                    btnRight.setText(randomLeft);
                    String randomRight22 = (wrongB[new Random().nextInt(wrongB.length)]);
                    btnLeftDown.setText(randomRight22);
                    String randomLeft22 = (wrong[new Random().nextInt(wrong.length)]);
                    btnRightDown.setText(randomLeft22);

                } else {
                    textView.setText("ভুল হয়েছে। আবার চেষ্টা কর");
                }
            }
        });


        btnRightDown.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String text = btnRightDown.getText().toString().trim();

                if (Arrays.asList(nameCheck).contains(text)) {

                    textView.setText("সঠিক হয়েছে!");

                    String random = (name[new Random().nextInt(name.length)]);
                    btnLeftDown.setText(random);
//btnRightDown
                    for (int i = 0; i <= name.length-1; i++) {
                        if (name[i].equals(random)) {
                            imageView.setImageResource(imagesA[i]);
                        }
                    }
                    String randomRight = (wrong[new Random().nextInt(wrong.length)]);
                    btnRight.setText(randomRight);
                    String randomRight22 = (wrong[new Random().nextInt(wrong.length)]);
                    btnRightDown.setText(randomRight22);
                    //btnLeftDown
                    String randomLeft11 = (wrongB[new Random().nextInt(wrongB.length)]);
                    btnLeft.setText(randomLeft11);

                } else {
                    textView.setText("ভুল হয়েছে। আবার চেষ্টা কর");
                }
            }
        });

        btnLeftDown.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String text = btnLeftDown.getText().toString().trim();

                if (Arrays.asList(nameCheck).contains(text)) {

                    textView.setText("সঠিক হয়েছে!");

                    String random = (name[new Random().nextInt(name.length)]);
                    btnRightDown.setText(random);

                    for (int i = 0; i <= name.length-1; i++) {
                        if (name[i].equals(random)) {
                            imageView.setImageResource(imagesA[i]);
                        }
                    }
                    String randomRight = (wrong[new Random().nextInt(wrong.length)]);
                    btnRight.setText(randomRight);
                    String randomRight22 = (wrong[new Random().nextInt(wrong.length)]);
                    btnLeftDown.setText(randomRight22);
                    //
                    String randomLeft11 = (wrongB[new Random().nextInt(wrongB.length)]);
                    btnLeft.setText(randomLeft11);

                } else {
                    textView.setText("ভুল হয়েছে। আবার চেষ্টা কর");
                }
            }
        });
    }
}
