package com.linyuzai.demo4activityresult.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.linyuzai.aresult.AResult;
import com.linyuzai.demo4activityresult.R;
import com.linyuzai.demo4activityresult.SecondActivity;

/**
 * Created by linyuzai on 2018/1/3.
 *
 * @author linyuzai
 */

public class V4Fragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_fragment, container, false);
        view.findViewById(R.id.tv1).setOnClickListener(v ->
                new AResult(this).startForResult(SecondActivity.class).subscribe(result -> Log.d("AppFragment", result.toString())));
        return view;
    }
}
