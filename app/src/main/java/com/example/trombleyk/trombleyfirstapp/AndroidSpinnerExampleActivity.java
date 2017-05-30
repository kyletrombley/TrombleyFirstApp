package com.example.trombleyk.trombleyfirstapp;

/**
 * Created by Kyle on 5/29/17.
 */

import java.util.ArrayList;
import java.util.List;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;
import android.widget.AdapterView.OnItemSelectedListener;

    public class AndroidSpinnerExampleActivity extends Activity implements OnItemSelectedListener{
        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            //setContentView(R.layout.main);

            // Spinner element
            Spinner spinner = (Spinner) findViewById(R.id.from);

            // Spinner click listener
            spinner.setOnItemSelectedListener(this);
        }

        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            // On selecting a spinner item
            String item = parent.getItemAtPosition(position).toString();

            // Showing selected spinner item
            Toast.makeText(parent.getContext(), "Selected: " + item, Toast.LENGTH_LONG).show();
        }
        public void onNothingSelected(AdapterView<?> arg0) {
            // TODO Auto-generated method stub
        }
    }