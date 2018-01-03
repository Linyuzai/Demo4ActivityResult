package com.linyuzai.demo4activityresult;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.linyuzai.aresult.AResult;
import com.linyuzai.aresult.AResultMessage;

public class MainActivity extends AppCompatActivity {

    private AResult mResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mResult = new AResult(this);
        mResult.startForResult(MainActivity.class).filter(AResultMessage::isOk).map(AResultMessage::getIntent).subscribe(it -> {
            it.getStringExtra("");
        });
    }
}
