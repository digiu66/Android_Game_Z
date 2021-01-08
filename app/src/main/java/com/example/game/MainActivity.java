package com.example.game;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    Random r = new Random();
    int number = r.nextInt(100) + 1;
    int counter = 0;
    Toast temp = null;

    public void checkNumber(View view) {
        EditText myNumber = findViewById(R.id.inputNumber);
        TextView countMoves = findViewById(R.id.movesCounter);

        if(temp != null) {
            temp.cancel();
        }

        if (myNumber.getText().toString().equals(null) || myNumber.getText().toString().equals("")) {
            temp = Toast.makeText(this, "Please enter a number.", Toast.LENGTH_SHORT);
        } else {

            String stringNumber = myNumber.getText().toString();
            int chosenNumber = Integer.parseInt(stringNumber);

            if (chosenNumber > 100 || chosenNumber < 0) {
                temp = Toast.makeText(this, "Please choose a number in range. (1-100)", Toast.LENGTH_SHORT);
                myNumber.getText().clear();
            } else if (chosenNumber > number) {
                temp = Toast.makeText(this, "Lower!", Toast.LENGTH_SHORT);
                myNumber.getText().clear();
                counter++;
                countMoves.setText("Moves left: " + Integer.toString(10-counter));
            } else if (chosenNumber < number) {
                temp = Toast.makeText(this, "Higher!", Toast.LENGTH_SHORT);
                myNumber.getText().clear();
                counter++;
                countMoves.setText("Moves left: " + Integer.toString(10-counter));
            } else if (chosenNumber == number) {
                temp = Toast.makeText(this, "Congratulations, you guessed the number! New number chosen.", Toast.LENGTH_LONG);
                myNumber.getText().clear();
                number = r.nextInt(100) + 1;
                counter = 0;
                countMoves.setText("Moves left: " + Integer.toString(10-counter));
            }

            if (counter == 10) {
                temp = Toast.makeText(this, "You lost, correct number was: " + number + ". New number chosen.", Toast.LENGTH_LONG);
                myNumber.getText().clear();
                number = r.nextInt(100) + 1;
                counter = 0;
                countMoves.setText("Moves left: " + Integer.toString(10-counter));
            }
            }
        if(temp != null) {
            temp.show();
        }
    }
}