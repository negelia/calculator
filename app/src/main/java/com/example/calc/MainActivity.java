package com.example.calc;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import org.mariuszgromada.math.mxparser.*;

public class MainActivity extends AppCompatActivity {

    private EditText display;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //store value typed by an user
        display = findViewById(R.id.displayEditText);

        //prevent clicking on display by user
        display.setShowSoftInputOnFocus(false); //don't show a keyboard
    }
    private void updateText(String strToAdd){
        String oldstr = display.getText().toString();
        int cursorPos = display.getSelectionStart(); //get current cursor position
        String leftstr = oldstr.substring(0,cursorPos); //grab all values starting from left
        String rightstr = oldstr.substring(cursorPos); //pass position of cursor

        //leftstr stores values from the left
        //rightstr stores values from the right

        display.setText(String.format("%s%s%s", leftstr, strToAdd, rightstr));

        //move cursor position
        display.setSelection(cursorPos + strToAdd.length()); //length changes cause of device's position

    }

    public void zeroBTNPush(View view){
        updateText(getResources().getString(R.string.zeroText));
    }
    public void oneBTNPush(View view){
        updateText(getResources().getString(R.string.oneText));
    }
    public void twoBTNPush(View view){
        updateText(getResources().getString(R.string.twoText));
    }
    public void threeBTNPush(View view){
        updateText(getResources().getString(R.string.threeText));
    }
    public void fourBTNPush(View view){
        updateText(getResources().getString(R.string.fourText));
    }
    public void fiveBTNPush(View view){
        updateText(getResources().getString(R.string.fiveText));
    }
    public void sixBTNPush(View view){
        updateText(getResources().getString(R.string.sixText));
    }
    public void sevenBTNPush(View view){
        updateText(getResources().getString(R.string.sevenText));
    }
    public void eightBTNPush(View view){
        updateText(getResources().getString(R.string.eightText));
    }
    public void nineBTNPush(View view){
        updateText(getResources().getString(R.string.nineText));
    }


    public void positiveBTNPush(View view){
        updateText(getResources().getString(R.string.positiveText));
    }
    public void negativeBTNPush(View view){
        updateText(getResources().getString(R.string.negativeText));
    }
    public void devideBTNPush(View view){
        updateText(getResources().getString(R.string.devideText));
    }
    public void multiplyBTNPush(View view){
        updateText(getResources().getString(R.string.multiplyText));
    }
    public void clearBTNPush(View view){
        display.setText("");
    }
    public void parenthesesLeftBTNPush(View view){
        updateText(getResources().getString(R.string.parethesesLeftText));
    }
    public void parenthesesRightBTNPush(View view){
        updateText(getResources().getString(R.string.parethesesRightText));
    }
    public void dotBTNPush(View view){
        updateText(getResources().getString(R.string.dotText));
    }
    public void equalsBTNPush(View view){
        String userExp = display.getText().toString();
        //replace special characters into basic to prevent calculation errors
        userExp = userExp.replaceAll(getResources().getString(R.string.multiplyText), "*");
        userExp = userExp.replaceAll(getResources().getString(R.string.devideText), "/");

        Expression exp = new Expression(userExp);
        String res = String.valueOf(exp.calculate()); //converting result of calculating into string

        display.setText(res);

        //set cursor after calculated value
        display.setSelection(res.length());
    }
    public void backspaceBTNPush(View view){
        //deleting values based on the cursor position
        int cursorPos = display.getSelectionStart();
        int textLen = display.getText().length();

        if(cursorPos != 0 && textLen != 0){ //cursor shouldn't be at the start pos of string
            SpannableStringBuilder selection = (SpannableStringBuilder) display.getText();
            //take parts of string
            selection.replace(cursorPos-1, cursorPos, "");
            display.setText(selection);
            display.setSelection(cursorPos-1);
        }
    }
    public void SinBTNPush(View view){
        updateText("sin("); //calculator searches this name of function in math collection
        //one open parentheses to let user type any value find for

    }
    public void CosBTNPush(View view){
        updateText("cos(");
    }
    public void TanBTNPush(View view){
        updateText("tan(");
    }
    public void LogBTNPush(View view){
        updateText("log(");
    }
    public void LnBTNPush(View view){
        updateText("ln(");
    }
    public void xPowerYBTNPush(View view){
        updateText("^(");
    }
    public void xSquareBTNPush(View view){
        updateText("^(2)");
    }
    public void AbsBTNPush(View view){
        updateText("abs(");
    }
    public void eBTNPush(View view){
        updateText("e");
    }
    public void piBTNPush(View view){
        updateText("pi");
    }
    public void SquareBTNPush(View view){
        updateText("sqrt(");
    }

    public void ArcSinBTNPush(View view) {
        updateText("arcsin(");
    }

    public void ArcCosBTNPush(View view) {
        updateText("arccos(");
    }

    public void ArcTanBTNPush(View view) {
        updateText("arctan(");
    }

}