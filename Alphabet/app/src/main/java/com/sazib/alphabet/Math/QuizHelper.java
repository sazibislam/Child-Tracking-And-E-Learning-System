package com.sazib.alphabet.Math;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sazib on 3/24/2017.
 */

public class QuizHelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    // Database Name
    private static final String DATABASE_NAME = "mathsone";
    // tasks table name
    private static final String TABLE_QUEST = "quest";
    // tasks Table Columns names
    private static final String KEY_ID = "qid";
    private static final String KEY_QUES = "question";
    private static final String KEY_ANSWER = "answer"; // correct option
    private static final String KEY_OPTA = "opta"; // option a
    private static final String KEY_OPTB = "optb"; // option b
    private static final String KEY_OPTC = "optc"; // option c

    private SQLiteDatabase dbase;

    public QuizHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        dbase = db;
        String sql = "CREATE TABLE IF NOT EXISTS " + TABLE_QUEST + " ( "
                + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + KEY_QUES
                + " TEXT, " + KEY_ANSWER + " TEXT, " + KEY_OPTA + " TEXT, "
                + KEY_OPTB + " TEXT, " + KEY_OPTC + " TEXT)";
        db.execSQL(sql);
        addQuestion();
        // db.close();
    }

    private void addQuestion() {
        Question q1 = new Question("৫+২ = ?", "৭", "৮", "৬", "৭");
        this.addQuestion(q1);
        Question q2 = new Question("২+১৮ = ?", "১৮", "১৯", "২০", "২০");
        this.addQuestion(q2);
        Question q3 = new Question("১০-৩ = ?", "৬", "৭", "৮", "৭");
        this.addQuestion(q3);
        Question q4 = new Question("৫+৭ = ?", "১২", "১৩", "১৪", "১২");
        this.addQuestion(q4);
        Question q5 = new Question("৩-১ = ?", "১", "৩", "২", "২");
        this.addQuestion(q5);
        Question q6 = new Question("০+১ = ?", "১", "০", "১০", "১");
        this.addQuestion(q6);
        Question q7 = new Question("৯-৯ = ?", "০", "৯", "১", "০");
        this.addQuestion(q7);
        Question q8 = new Question("৩+৬ = ?", "৮", "৭", "৯", "৯");
        this.addQuestion(q8);
        Question q9 = new Question("১+৫ = ?", "৬", "৭", "৫", "৬");
        this.addQuestion(q9);
        Question q10 = new Question("৭-৫ = ?", "৩", "২", "৬", "২");
        this.addQuestion(q10);
        Question q11 = new Question("৭-২ = ?", "৭", "৬", "৫", "৫");
        this.addQuestion(q11);
        Question q12 = new Question("৩+৫ = ?", "৮", "৭", "৫", "৮");
        this.addQuestion(q12);
        Question q13 = new Question("০+৬ = ?", "৭", "৬", "৫", "৬");
        this.addQuestion(q13);
        Question q14 = new Question("১২-১০ = ?", "১", "২", "৩", "২");
        this.addQuestion(q14);
        Question q15 = new Question("১২+ ২= ?", "১৪", "১৫", "১৬", "১৪");
        this.addQuestion(q15);
        Question q16 = new Question("২-১ = ?", "২", "১", "০", "১");
        this.addQuestion(q16);
        Question q17 = new Question("৬-৬ = ?", "৬", "১২", "০", "০");
        this.addQuestion(q17);
        Question q18 = new Question("৫-১ = ?", "৪", "৩", "২", "৪");
        this.addQuestion(q18);
        Question q19 = new Question("৪+২ = ?", "৬", "৭", "৫", "৬");
        this.addQuestion(q19);
        Question q20 = new Question("৫+১ = ?", "৬", "৭", "৫", "৬");
        this.addQuestion(q20);
        Question q21 = new Question("৫-৪ = ?", "৫", "৪", "১", "১");
        this.addQuestion(q21);
        // END
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldV, int newV) {
        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_QUEST);
        // Create tables again
        onCreate(db);
    }

    // Adding new question
    public void addQuestion(Question quest) {
        // SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_QUES, quest.getQUESTION());
        values.put(KEY_ANSWER, quest.getANSWER());
        values.put(KEY_OPTA, quest.getOPTA());
        values.put(KEY_OPTB, quest.getOPTB());
        values.put(KEY_OPTC, quest.getOPTC());

        // Inserting Row
        dbase.insert(TABLE_QUEST, null, values);
    }

    public List<Question> getAllQuestions() {
        List<Question> quesList = new ArrayList<Question>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_QUEST;
        dbase = this.getReadableDatabase();
        Cursor cursor = dbase.rawQuery(selectQuery, null);
        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                Question quest = new Question();
                quest.setID(cursor.getInt(0));
                quest.setQUESTION(cursor.getString(1));
                quest.setANSWER(cursor.getString(2));
                quest.setOPTA(cursor.getString(3));
                quest.setOPTB(cursor.getString(4));
                quest.setOPTC(cursor.getString(5));

                quesList.add(quest);
            } while (cursor.moveToNext());
        }
        // return quest list
        return quesList;
    }
}
