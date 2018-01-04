package com.linyuzai.demo4activityresult;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by linyuzai on 2018/1/3.
 * @author linyuzai
 */

public class SecondActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setResult(200);
        findViewById(R.id.tv).setOnClickListener(v -> finish());
    }
}
