package com.example.trombleyk.trombleyfirstapp;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        final Button button = (Button) findViewById(R.id.cal_btn);
        final EditText dec = (EditText) findViewById(R.id.dec_lbl);
        final EditText hex = (EditText) findViewById(R.id.hex_lbl);
        final EditText bin = (EditText) findViewById(R.id.bin);

        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
            if(bin.getText().toString().equals("") && hex.getText().toString().equals("")) {
                String input = dec.getText().toString();
                int value = Integer.parseInt(input);
              //  hex.setText();
              //  bin.setText();
            }
            else if(bin.getText().toString().equals("")){
                String input = hex.getText().toString();
                dec.setText(hexToDec(input) + "");
                //bin.setText();
            }
            else{
                String input = bin.getText().toString();
               // hex.setText();
                dec.setText(binToDec(input + ""));
                }
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
    public static int hexToDec(String s){
        int base = 16, exp = 0, digit = 0, answer = 0;
        for (int i  = s.length(); i >= 0; i--){
            digit = getLetterVal(s.charAt(i));
            answer += digit * Math.pow(base, exp);
            exp++;
        }
        return answer;
    }
    public static int binToDec(String s){
        int base = 2, exp = 0, digit = 0, answer = 0;
        for (int i  = s.length(); i >= 0; i--){
            digit = getLetterVal(s.charAt(i));
            answer += digit * Math.pow(base, exp);
            exp++;
        }
        return answer;
    }
    public static String decToHex(int i){
        int exp = 0, base = 16, count = 0;
        String s = "";
        int[] arr = new int[(int)Math.log10(i) / (int)Math.log10(base)];
        while(i > base){
            exp = (int)Math.log10(i)/ (int)Math.log10(base);
            i = i % (int)Math.pow(base, exp);
            arr[count] = getLetterVal(exp);
            count++;
        }
        for (int j : arr){
            s += j;
        }
        return s + getLetterVal(i);
    }
    public static int getNumVal(char c) {
        switch (c) {
            case '1':
                return 1;
            case '2':
                return 2;
            case '3':
                return 3;
            case '4':
                return 4;
            case '5':
                return 5;
            case '6':
                return 6;
            case '7':
                return 7;
            case '8':
                return 8;
            case '9':
                return 9;
            case 'A':
                return 10;
            case 'B':
                return 11;
            case 'C':
                return 12;
            case 'D':
                return 13;
            case 'E':
                return 14;
            case 'F':
                return 15;
        }
        return 0;
    }
    public static char getLetterVal(int c) {
        switch (c) {
            case 1:
                return '1';
            case 2:
                return '2';
            case 3:
                return '3';
            case 4:
                return '4';
            case 5:
                return '5';
            case 6:
                return '6';
            case 7:
                return '7';
            case 8:
                return '8';
            case 9:
                return '9';
            case 10:
                return 'a';
            case 11:
                return 'b';
            case 12:
                return 'c';
            case 13:
                return 'd';
            case 14:
                return 'e';
            case 15:
                return 'f';
        }
        return '0';
    }

}
