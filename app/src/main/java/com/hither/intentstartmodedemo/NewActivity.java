package com.hither.intentstartmodedemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class NewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new);
    }

    public void startA(View v) {
        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra("test", "http://www.qiushibaike.com");
        startActivity(intent);
    }
}