package com.example.taras.gascalculation.ui;

import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;


public abstract class BaseActivity extends AppCompatActivity {


    void toastMessage (String text){
        Toast.makeText(this, text, Toast.LENGTH_LONG).show();
    }
}
