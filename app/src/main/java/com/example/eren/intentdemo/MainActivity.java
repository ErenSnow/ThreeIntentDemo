package com.example.eren.intentdemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

/**
 * 第一个界面
 */
public class MainActivity extends AppCompatActivity {

    private android.widget.EditText etFirst;

    private android.widget.TextView tvFirst;

    private android.widget.Button btnFirst;

    private String first;

    private static final int FIRST = 1;

    private static final int SECOND = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvFirst = findViewById(R.id.tv_first);
        etFirst = findViewById(R.id.et_first);
        btnFirst = findViewById(R.id.btn_first);

        //点击按钮传值
        onButton();
    }

    /**
     * 点击按钮
     */
    private void onButton() {
        btnFirst.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                first = etFirst.getText().toString().trim();
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                intent.putExtra("result", first);
                startActivityForResult(intent, FIRST);   //通过startActivityForResult进行跳转
            }
        });
    }

    /**
     * 返回回调方法
     */
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case FIRST:
                if (resultCode == SECOND) {
                    String result = data.getStringExtra("result");
                    tvFirst.setText(result);
                }
                break;
            default:
        }
    }
}
