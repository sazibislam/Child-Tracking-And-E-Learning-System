package com.sazib.alphabet.Math;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.sazib.alphabet.R;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class QuestionActivity extends Activity {

    Typeface tf;

    List<Question> quesList;
    int score = 0;
    int qid = 0;

    Question currentQ;
    TextView txtQuestion, times, scored;
    Button button1, button2, button3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_math);

        tf = Typeface.createFromAsset(getAssets(), "fonts/solaimanlipinormal.ttf");

        QuizHelper db = new QuizHelper(this);  // my question bank class
        quesList = db.getAllQuestions();  // this will fetch all quetonall questions
        currentQ = quesList.get(qid); // the current question

        txtQuestion = (TextView) findViewById(R.id.txtQuestion);
        // the textview in which the question will be displayed
        // the three buttons,
        // the idea is to set the text of three buttons with the options from question bank
        button1 = (Button) findViewById(R.id.button1);
        button2 = (Button) findViewById(R.id.button2);
        button3 = (Button) findViewById(R.id.button3);

        button1.setTypeface(tf);
        button2.setTypeface(tf);
        button3.setTypeface(tf);
        txtQuestion.setTypeface(tf);

        // the textview in which score will be displayed
        scored = (TextView) findViewById(R.id.score);
        scored.setTypeface(tf);
        // the timer
        times = (TextView) findViewById(R.id.timers);
        times.setTypeface(tf);

        // method which will set the things up for our game
        setQuestionView();
        times.setText("00:02:00");

        // A timer of 60 seconds to play for, with an interval of 1 second (1000 milliseconds)
        CounterClass timer = new CounterClass(60000, 1000);
        timer.start();

        // button click listeners
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // passing the button text to other method
                // to check whether the anser is correct or not
                // same for all three buttons
                getAnswer(button1.getText().toString());
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getAnswer(button2.getText().toString());
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getAnswer(button3.getText().toString());
            }
        });
    }

    public void getAnswer(String AnswerString) {
        if (currentQ.getANSWER().equals(AnswerString)) {
            // if conditions matches increase the int (score) by 1
            // and set the text of the score view
            score++;
           switch (score){

               case 1:
                   scored.setText("স্কোর ঃ ১");
                   break;
               case 2:
                   scored.setText("স্কোর ঃ ২");
                   break;
               case 3:
                   scored.setText("স্কোর ঃ ৩");
                   break;
               case 4:
                   scored.setText("স্কোর ঃ ৪");
                   break;
               case 5:
                   scored.setText("স্কোর ঃ ৫");
                   break;
               case 6:
                   scored.setText("স্কোর ঃ ৬");
                   break;
               case 7:
                   scored.setText("স্কোর ঃ ৭");
                   break;
               case 8:
                   scored.setText("স্কোর ঃ ৮");
                   break;
               case 9:
                   scored.setText("স্কোর ঃ ৯");
                   break;
               case 10:
                   scored.setText("স্কোর ঃ ১০");
                   break;
               case 11:
                   scored.setText("স্কোর ঃ ১১");
                   break;
               case 12:
                   scored.setText("স্কোর ঃ ১২");
                   break;
               case 13:
                   scored.setText("স্কোর ঃ ১৩");
                   break;
               case 14:
                   scored.setText("স্কোর ঃ ১৪");
                   break;
               case 15:
                   scored.setText("স্কোর ঃ ১৫");
                   break;
               case 16:
                   scored.setText("স্কোর ঃ ১৬");
                   break;
               case 17:
                   scored.setText("স্কোর ঃ ১৭");
                   break;
               case 18:
                   scored.setText("স্কোর ঃ ১৮");
                   break;
               case 19:
                   scored.setText("স্কোর ঃ ১৯");
                   break;
               case 20:
                   scored.setText("স্কোর ঃ ২০");
                   break;
               default :
                   scored.setText("স্কোর ঃ ০");
                   break;
           }
            //scored.setText("স্কোর ঃ " + score);
        } else {
            // if unlucky start activity and finish the game
            Intent intent = new Intent(QuestionActivity.this,
                    ResultActivity.class);

            // passing the int value
            Bundle b = new Bundle();
            b.putInt("score", score); // Your score
            intent.putExtras(b); // Put your score to your next
            startActivity(intent);
            finish();
        }
        if (qid < 20) {
            // if questions are not over then do this
            currentQ = quesList.get(qid);
            setQuestionView();
        } else {
            // if over do this
            Intent intent = new Intent(QuestionActivity.this, ResultActivity.class);
            Bundle b = new Bundle();
            b.putInt("score", score); // Your score
            intent.putExtras(b); // Put your score to your next
            startActivity(intent);
            finish();
        }
    }

    @TargetApi(Build.VERSION_CODES.GINGERBREAD)
    @SuppressLint("NewApi")
    public class CounterClass extends CountDownTimer {

        public CounterClass(long millisInFuture, long countDownInterval) {
            super(millisInFuture, countDownInterval);
            // TODO Auto-generated constructor stub
        }

        @Override
        public void onFinish() {
            times.setText("সময় শেষ");
        }

        @Override
        public void onTick(long millisUntilFinished) {
            // TODO Auto-generated method stub

            long millis = millisUntilFinished;
            String hms = String.format(
                    "%02d:%02d:%02d",
                    TimeUnit.MILLISECONDS.toHours(millis),
                    TimeUnit.MILLISECONDS.toMinutes(millis)
                            - TimeUnit.HOURS.toMinutes(TimeUnit.MILLISECONDS
                            .toHours(millis)),
                    TimeUnit.MILLISECONDS.toSeconds(millis)
                            - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS
                            .toMinutes(millis)));
            System.out.println(hms);
            times.setText(hms);
        }
    }

    private void setQuestionView() {
        // the method which will put all things together
        txtQuestion.setText(currentQ.getQUESTION());
        button1.setText(currentQ.getOPTA());
        button2.setText(currentQ.getOPTB());
        button3.setText(currentQ.getOPTC());
        qid++;
    }

}
