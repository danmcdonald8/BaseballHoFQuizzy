package com.example.android.baseballhofquizzy;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * This method is called when the Submit button is clicked.
     */
    public void submitAnswers(View view) {

        if (checkComplete() == 7) {
            String message = "You scored " + calculateScore() + " out of 7!";
            Toast.makeText(this, message,
                    Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "You have not finished the quiz.",
                    Toast.LENGTH_SHORT).show();
        }
    }

    /**
     * Calculate the quiz score.
     *
     * @return quiz score
     */
    private int calculateScore() {
        int score = 0;

        /* checks to see if correct answers are checked */
        RadioButton q1Answer = findViewById(R.id.q1a3);
        RadioButton q2Answer = findViewById(R.id.q2a1);
        RadioButton q3Answer = findViewById(R.id.q3a2);
        RadioButton q4Answer = findViewById(R.id.q4a2);
        RadioButton q5Answer = findViewById(R.id.q5a4);
        EditText q6Answer = findViewById(R.id.q6a1);
        CheckBox q7Answer1 = (CheckBox) findViewById(R.id.q7a1);
        CheckBox q7Answer2 = (CheckBox) findViewById(R.id.q7a2);
        CheckBox q7Answer3 = (CheckBox) findViewById(R.id.q7a3);
        CheckBox q7Answer4 = (CheckBox) findViewById(R.id.q7a4);

        if (q1Answer.isChecked()) {
            score++;
        }
        if (q2Answer.isChecked()) {
            score++;
        }
        if (q3Answer.isChecked()) {
            score++;
        }
        if (q4Answer.isChecked()) {
            score++;
        }
        if (q5Answer.isChecked()) {
            score++;
        }
        if (q6Answer.getText().toString().equals(getString(R.string.q6a1))) {
            score++;
        }
        if ((q7Answer1.isChecked() && q7Answer2.isChecked()) &&
                !(q7Answer3.isChecked() || q7Answer4.isChecked())) {
            score++;
        }

        return score;
    }

    /**
     * Checks to see how many answers are complete.
     *
     * @return number of answers completed.
     */
    private int checkComplete() {
        int numberComplete = 0;

        RadioGroup q1Answered = findViewById(R.id.q1);
        RadioGroup q2Answered = findViewById(R.id.q2);
        RadioGroup q3Answered = findViewById(R.id.q3);
        RadioGroup q4Answered = findViewById(R.id.q4);
        RadioGroup q5Answered = findViewById(R.id.q5);
        EditText q6Answered = findViewById(R.id.q6a1);
        CheckBox q7Answered1 = findViewById(R.id.q7a1);
        CheckBox q7Answered2 = findViewById(R.id.q7a2);
        CheckBox q7Answered3 = findViewById(R.id.q7a3);
        CheckBox q7Answered4 = findViewById(R.id.q7a4);

        if (q1Answered.getCheckedRadioButtonId() > 0) {
            numberComplete++;
        }
        if (q2Answered.getCheckedRadioButtonId() > 0) {
            numberComplete++;
        }
        if (q3Answered.getCheckedRadioButtonId() > 0) {
            numberComplete++;
        }
        if (q4Answered.getCheckedRadioButtonId() > 0) {
            numberComplete++;
        }
        if (q5Answered.getCheckedRadioButtonId() > 0) {
            numberComplete++;
        }
        if (q6Answered.length() > 0) {
            numberComplete++;
        }
        if (q7Answered1.isChecked() || q7Answered2.isChecked() ||
                q7Answered3.isChecked() || q7Answered4.isChecked()) {
            numberComplete++;
        }
        return numberComplete;
    }
}
