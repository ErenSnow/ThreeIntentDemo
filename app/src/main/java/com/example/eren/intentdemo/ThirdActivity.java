package com.example.eren.intentdemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

/**
 * 第三个界面
 */
public class ThirdActivity extends AppCompatActivity {

    private android.widget.EditText etThird;

    private android.widget.TextView tvThird;

    private android.widget.Button btnThird;

    private static final int THIRD = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        tvThird = findViewById(R.id.tv_third);
        etThird = findViewById(R.id.et_third);
        btnThird = findViewById(R.id.btn_third);

        //显示跳转内容
        onShowView();

        //点击按钮返回并传值
        onBackButton();
    }

    /**
     * 显示跳转内容
     */
    private void onShowView() {
        String third = getIntent().getStringExtra("result");
        tvThird.setText(third);
    }

    /**
     * 点击按钮返回并传值
     */
    private void onBackButton() {
        btnThird.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String third = etThird.getText().toString().trim();
                Intent intent = new Intent();
                intent.putExtra("result", third);
                setResult(THIRD, intent);
                finish();
            }
        });
    }
}
