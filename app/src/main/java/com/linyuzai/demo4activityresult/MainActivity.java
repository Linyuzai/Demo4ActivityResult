package com.linyuzai.demo4activityresult;

import android.content.Intent;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.linyuzai.aresult.AResult;
import com.linyuzai.aresult.AResultMessage;
import com.linyuzai.demo4activityresult.fragment.AppFragment;
import com.linyuzai.demo4activityresult.fragment.V4Fragment;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private AResult mResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frame);
        //getFragmentManager().beginTransaction().add(R.id.frame, new AppFragment()).commit();
        getSupportFragmentManager().beginTransaction().add(R.id.frame, new V4Fragment()).commit();
        /*TextView text = (TextView) findViewById(R.id.tv);
        text.setOnClickListener(this);*/
        mResult = new AResult(this);
    }

    @Override
    public void onClick(View v) {
        //mResult.startForResult(new Intent(MediaStore.ACTION_IMAGE_CAPTURE), result -> Log.i("AResult", result.toString()));
        //mResult.startForResult(SecondActivity.class, result -> Log.i("AResult", result.toString()));
        /*mResult.startForResult(new Intent(MediaStore.ACTION_IMAGE_CAPTURE))
                .filter(AResultMessage::isOk)
                .map(AResultMessage::getData)
                .subscribe(it -> Log.i("AResult", it.toString()));*/
    }
}
