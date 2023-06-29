package com.luisito.colors;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.*;
public class MainActivity extends AppCompatActivity {

    private TextView lblTargetColor = null;
    private TextView lblProposedColor = null;
    private SeekBar sbrRed = null;
    private SeekBar sbrGreen = null;
    private SeekBar sbrBlue = null;
    private TextView lblRedValue = null;
    private TextView lblGreenValue = null;
    private TextView lblBlueValue = null;
    private Button btnGetScore = null;
    private Button btnNewColor = null;
    private ColorsGame colorsGame = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.initViews();

        this.colorsGame = new ColorsGame();
    }

    public void initViews(){
        this.lblTargetColor = findViewById(R.id.IbITargetColor);
        this.lblProposedColor = findViewById(R.id.IbIProposedColor);

        this.sbrRed = findViewById(R.id.sbrRed);
        this.sbrGreen = findViewById(R.id.sbrGreen);
        this.sbrBlue = findViewById(R.id.sbrBlue);

        this.lblRedValue = findViewById(R.id.IbIRedValue);
        this.lblGreenValue = findViewById(R.id.IbIGreenValue);
        this.lblBlueValue = findViewById(R.id.IbIBlueValue);

        this.btnGetScore = findViewById(R.id.btnGetScore);
        this.btnNewColor = findViewById(R.id.btnNewColor);
    }

    public void restartGame(){
        this.colorsGame.restartGame();
    }

    public void updateValues(){
        int redValue = this.sbrRed.getProgress();
        int greenValue = this.sbrGreen.getProgress();
        int blueValue = this.sbrBlue.getProgress();
        int newBackColor = Color.rgb(redValue, greenValue, blueValue);

        this.colorsGame.setProposedBackColor(newBackColor);
    }

    public void showScore(){
        final String RED = getString(R.string.Red);
        final String GREEN = getString(R.string.Green);
        final String BLUE = getString(R.string.Blue);
        final String LOW = getString(R.string.Low);
        final String VERY_LOW = getString(R.string.Very_low);
        final String HIGH = getString(R.string.High);
        final String VERY_HIGH = getString(R.string.Very_high);

        int targetColor = colorsGame.getTargetBackColor();
        int proposedColor = colorsGame.getProposedBackColor();

        AlertDialog.Builder alert = new AlertDialog.Builder(this);
        StringBuilder text = new StringBuilder();
        StringBuilder tips = new StringBuilder();

        int redDiff = Color.red(targetColor) - Color.red(proposedColor);
        int greenDiff = Color.green(targetColor) - Color.green(proposedColor);
        int blueDiff = Color.blue(targetColor) - Color.blue(proposedColor);

        text.append(getString(R.string.Your_score_is, String.valueOf(colorsGame.getScore())));

        alert.setMessage(text);
        alert.setPositiveButton(getString(R.string.Close), null);

        alert.show();
    }
}