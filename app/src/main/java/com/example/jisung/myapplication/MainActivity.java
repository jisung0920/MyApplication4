package com.example.jisung.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
    public void onClick(View v){
        Intent intent;
        if(v.getId()==R.id.button)
            intent = new Intent(MainActivity.this,P1Activity.class);
        else
            intent = new Intent(MainActivity.this,P2Activity.class);
        startActivity(intent);
    }
}

