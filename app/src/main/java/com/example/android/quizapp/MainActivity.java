package com.example.android.quizapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    //radio buttons

    private int checkRadioButtonQuestions() {
        // get answers for quiz
        RadioButton question1 = (RadioButton) findViewById(R.id.q1a1);
        boolean isQuestionOneIsRight = question1.isChecked();

        RadioButton question3 = (RadioButton) findViewById(R.id.q3a3);
        boolean isQuestionThreeIsRight = question3.isChecked();

        RadioButton question4 = (RadioButton) findViewById(R.id.q4a3);
        boolean isQuestionFourIsRight = question4.isChecked();

        RadioButton question5 = (RadioButton) findViewById(R.id.q5a2);
        boolean isQuestionFiveIsRight = question5.isChecked();

        boolean quizRadioAnswers[] = {isQuestionOneIsRight, isQuestionThreeIsRight, isQuestionFourIsRight, isQuestionFiveIsRight};

        int quizScore = 0;
        for (int i = 0; i < quizRadioAnswers.length; i++) {
            if (quizRadioAnswers[i]) {
                quizScore++;
            }
        }
        return quizScore;
    }

    //checkbox

    private int checkCheckboxQuestion() {
        int quizScore = 0;

        CheckBox q2a1 = (CheckBox) findViewById(R.id.q2a1);
        boolean isQ2A1checked = q2a1.isChecked();

        CheckBox q2a2 = (CheckBox) findViewById(R.id.q2a2);
        boolean isQ2A2checked = q2a2.isChecked();

        CheckBox q2a3 = (CheckBox) findViewById(R.id.q2a3);
        boolean isQ2A3checked = q2a3.isChecked();

        CheckBox q2a4 = (CheckBox) findViewById(R.id.q2a4);
        boolean isQ2A4checked = q2a4.isChecked();

        if ((isQ2A1checked && isQ2A3checked) && (!isQ2A2checked && !isQ2A4checked)) {
            quizScore = 1;
        }
        return quizScore;
    }

    private int checkFillInQuestion() {
        EditText q6a1 = (EditText) findViewById(R.id.q6a1);
        String questionSixAnswer = q6a1.getText().toString();
        questionSixAnswer = questionSixAnswer.trim();
        Log.v("checkFillInQuestion", questionSixAnswer); //test for logs
        if (questionSixAnswer.equals("muggal")) {
            return 1;
        }
        return 0;
    }

    // display results

    public void submitAnswers(View view) {
        int quizScore = 0;
        String message = "";
        quizScore += checkRadioButtonQuestions();
        quizScore += checkCheckboxQuestion();
        quizScore += checkFillInQuestion();

        if (quizScore == 6) {
            message = "You Aced it!";
        } else {
            message = "You Got " + quizScore + " out of 6";
        }

        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();


    }

}




