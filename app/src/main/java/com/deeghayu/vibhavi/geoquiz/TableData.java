package com.deeghayu.vibhavi.geoquiz;

import android.provider.BaseColumns;

/**
 * Created by Vibhavi on 3/10/2015.
 */
public class TableData {

    public static abstract class tableinfo implements BaseColumns
    {
        public static final String Question="question";
        public static final String answer="answer";
        public static final String dbname="quizdb";
        public static final String table="quiz";


    }
}
