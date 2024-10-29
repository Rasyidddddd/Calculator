package com.ubl.calculator;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.app.AlertDialog;
import android.content.Context;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
    EditText number1, number2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        number1 = findViewById(R.id.txtNumber1);
        number2 = findViewById(R.id.txtNumber2);

        findViewById(R.id.btnPlus).setOnClickListener(v -> handlePlusButton(this));
        findViewById(R.id.btnMinus).setOnClickListener(v -> handleMinusButton(this));
    }

    public void handlePlusButton(Context context) {
        if (validateInputs(context)) {
            int numberA = Integer.parseInt(number1.getText().toString());
            int numberB = Integer.parseInt(number2.getText().toString());
            int result = numberA + numberB;

            showDialog(context, "Result", "The result of addition is: " + result);
        }
    }

    private void handleMinusButton(Context context) {
        if (validateInputs(context)) {
            int numberA = Integer.parseInt(number1.getText().toString());
            int numberB = Integer.parseInt(number2.getText().toString());
            int result = numberA - numberB;

            showDialog(context, "Result", "The result of subtraction is: " + result);
        }
    }

    private boolean validateInputs(Context context) {
        if (number1.getText().toString().isEmpty()) {
            Toast.makeText(context, "Number 1 is required", Toast.LENGTH_SHORT).show();
            return false;
        } else if (number2.getText().toString().isEmpty()) {
            Toast.makeText(context, "Number 2 is required", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }

    private void showDialog(Context context, String title, String message) {
        new AlertDialog.Builder(context)
                .setTitle(title)
                .setMessage(message)
                .setPositiveButton("OK", (dialog, which) -> dialog.dismiss())
                .show();
    }
}


