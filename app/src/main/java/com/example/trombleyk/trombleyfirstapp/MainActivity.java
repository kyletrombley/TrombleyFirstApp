package com.example.trombleyk.trombleyfirstapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import java.util.ArrayList;

import android.widget.ArrayAdapter;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {
    public Spinner to;
    public Spinner from;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
         to = (Spinner) findViewById(R.id.to);
         from = (Spinner) findViewById(R.id.from);


        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        addItemsOnFrom();
        addItemsOnTo();
        final Button cal = (Button) findViewById(R.id.cal);
        final EditText input = (EditText) findViewById(R.id.input);
        final TextView outputTxt = (TextView) findViewById(R.id.output_lbl);

        cal.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                String s1 = from.getSelectedItem().toString();
                String s2 = to.getSelectedItem().toString();
                int fromVal = getConversion(s1);
                int toVal = getConversion(s2);
                //Decimal to hex
                if (fromVal == 1 && toVal == 2) {
                    outputTxt.setText(decToHex(Integer.parseInt(input.getText().toString())));
                }
                //Decimal to binary
                else if (fromVal == 1 && toVal == 3) {
                    outputTxt.setText(decToHex(Integer.parseInt(input.getText().toString())));
                }
                //Hex to decimal
                else if (fromVal == 2 && toVal == 1) {
                    outputTxt.setText(hexToDec(input.getText().toString()) + "");
                }
                //Hex to binary
                else if (fromVal == 2 && toVal == 3) {
                    outputTxt.setText(hexToBin(input.getText().toString()));
                }
                //Binary to decimal
                else if (fromVal == 3 && toVal == 1) {
                    outputTxt.setText(binToDec(input.getText().toString()));
                }
                //Binary to hex
                else if (fromVal == 3 && toVal == 2) {
                    outputTxt.setText(binToHex((input.getText().toString())));
                }
                //Same to same
                else if (fromVal == toVal) {
                    outputTxt.setText(input.getText().toString());
                }
            }
        });

    }
    //Fill dropdown menus
    public void addItemsOnFrom() {
        ArrayList<String> list = new ArrayList<String>();
        list.add("Decimal");
        list.add("Hexadecimal");
        list.add("Binary");
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, list);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        from.setAdapter(dataAdapter);
    }
    public void addItemsOnTo() {
        ArrayList<String> list = new ArrayList<String>();
        list.add("Decimal");
        list.add("Hexadecimal");
        list.add("Binary");
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, list);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        to.setAdapter(dataAdapter);
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
        for (int i  = s.length() - 1; i >= 0; i--){
            digit = getNumVal(s.charAt(i));
            answer += digit * Math.pow(base, exp);
            exp++;
        }
        return answer;
    }
    public static int binToDec(String s){
        int base = 2, exp = 0, digit = 0, answer = 0;
        for (int i  = s.length() - 1; i >= 0; i--){
            String w = "" + s.charAt(i);
            digit = Integer.parseInt(w);
            answer += digit * Math.pow(base, exp);
            exp++;
        }
        return answer;
    }
    public static String decToHex(int i){
        int exp = 0, base = 16, index = 0;
        String s = "";
        int[] arr = new int[(int)Math.log10(i) / (int)Math.log10(base) + 1];
        exp = arr.length - 1;
        while(i > base){
            arr[index] = i / (int)Math.pow(base, exp);
            i = i % (int)Math.pow(base, exp);
            index++;
            exp--;
        }
        arr[arr.length - 1] = i;
        for (int j = 0; j < arr.length; j++){
            if(arr[0] == 0 && arr[j] == 0)
                continue;
            s += getLetterVal(arr[j]);
        }
        return s;
    }
    public static String decToBin(int i){
        int exp = 0, base = 2, index = 0;
        String s = "";
        int[] arr = new int[(int)(Math.log10(i) / Math.log10(base)) + 1];
        exp = arr.length - 1;
        while(i > base){
            arr[index] = i / (int)Math.pow(base, exp);
            i = i % (int)Math.pow(base, exp);
            index++;
            exp--;
        }
        arr[arr.length - 1] = i;
        for (int j : arr){
            s += j;
        }
        return s;
    }
    public static String binToHex(String s){
        return decToHex(binToDec(s));
    }
    public static String hexToBin(String s){
        return decToBin(hexToDec(s));
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
            case 'a':
                return 10;
            case 'B':
            case 'b':
                return 11;
            case 'C':
            case 'c':
                return 12;
            case 'D':
            case 'd':
                return 13;
            case 'E':
            case 'e':
                return 14;
            case 'F':
            case 'f':
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
                return 'A';
            case 11:
                return 'B';
            case 12:
                return 'C';
            case 13:
                return 'D';
            case 14:
                return 'E';
            case 15:
                return 'F';
        }
        return '0';
    }
    public static int getConversion(String s){
        switch (s){
            case "Decimal" : return 1;
            case "Hexadecimal" : return 2;
            case "Binary" : return 3;
        }
        return 0;
    }
    }