package com.machinehou.aspectjrtlib;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.blankj.utilcode.util.ToastUtils;

public class AspectjrtActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView btn_test;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aspectjrt);
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