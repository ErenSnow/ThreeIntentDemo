package com.example.eren.intentdemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

/**
 * 第二个界面
 */
public class SecondActivity extends AppCompatActivity {

    private android.widget.TextView tvSecond;

    private android.widget.Button btnSecond;

    private String second;

    private static final int SECOND = 2;

    private static final int THIRD = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        tvSecond = findViewById(R.id.tv_second);
        btnSecond = findViewById(R.id.btn_second);

        //显示跳转内容
        onShowView();

        //点击按钮跳转传值
        onButton();
    }

    /**
     * 返回回调方法
     */
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case SECOND:
                if (resultCode == THIRD) {
                    String result = data.getStringExtra("result");
                    tvSecond.setText(result);
                    Intent second = new Intent();
                    second.putExtra("result", result);
                    setResult(SECOND, second);
                }
                break;
            default:
        }
    }

    /**
     * 显示跳转内容
     */
    private void onShowView() {
        second = getIntent().getStringExtra("result");
        tvSecond.setText(second);
    }

    /**
     * 点击按钮跳转传值
     */
    private void onButton() {
        btnSecond.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SecondActivity.this, ThirdActivity.class);
                intent.putExtra("result", second);
                startActivityForResult(intent, SECOND);     //通过startActivityForResult进行跳转
            }
        });
    }
}
