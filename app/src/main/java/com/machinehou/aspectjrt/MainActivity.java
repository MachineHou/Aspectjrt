package com.machinehou.aspectjrt;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.machinehou.aspectjrtlib.AspectjrtActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView btn_test;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn_test = findViewById(R.id.btn_test);
        btn_test.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.btn_test) {
            startActivity(new Intent(this, AspectjrtActivity.class));
        }
    }
}