package com.machinehou.aspectjrt;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.blankj.utilcode.util.ToastUtils;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button btn_test;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn_test = findViewById(R.id.btn_test);
        btn_test.setOnClickListener(this);
    }

    @SingleClick(1000)
    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.btn_test) {
            ToastUtils.showShort("点击成功");
        }
    }
}