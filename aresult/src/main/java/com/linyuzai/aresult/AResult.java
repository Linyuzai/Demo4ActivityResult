package com.linyuzai.aresult;

import android.app.Activity;
import android.app.FragmentManager;
import android.content.Intent;

import io.reactivex.Observable;

/**
 * Created by linyuzai on 2018/1/2.
 *
 * @author linyuzai
 */

public class AResult {
    private static final String TAG = "AResult";
    private static final int REQUEST_CODE = -8;
    private AResultFragment mAResultFragment;

    public AResult(Activity activity) {
        mAResultFragment = getAResultFragment(activity);
    }

    public AResult(android.app.Fragment fragment) {
        this(fragment.getActivity());
    }

    public AResult(android.support.v4.app.Fragment fragment) {
        this(fragment.getActivity());
    }

    private AResultFragment getAResultFragment(Activity activity) {
        AResultFragment fragment = (AResultFragment) activity.getFragmentManager().findFragmentByTag(TAG);
        if (fragment == null) {
            fragment = AResultFragment.newInstance();
            FragmentManager fragmentManager = activity.getFragmentManager();
            fragmentManager.beginTransaction()
                    .add(fragment, TAG)
                    .commitAllowingStateLoss();
            fragmentManager.executePendingTransactions();
        }
        return fragment;
    }

    public Observable<AResultMessage> startForResult(Intent intent, int requestCode) {
        return mAResultFragment.startForResult(intent, requestCode);
    }

    public Observable<AResultMessage> startForResult(Intent intent) {
        return startForResult(intent, REQUEST_CODE);
    }

    public Observable<AResultMessage> startForResult(Class<?> clazz, int requestCode) {
        Intent intent = new Intent(mAResultFragment.getActivity(), clazz);
        return startForResult(intent, requestCode);
    }

    public Observable<AResultMessage> startForResult(Class<?> clazz) {
        return startForResult(clazz, REQUEST_CODE);
    }

    public void startForResult(Intent intent, int requestCode, Callback callback) {
        mAResultFragment.startForResult(intent, requestCode, callback);
    }

    public void startForResult(Intent intent, Callback callback) {
        mAResultFragment.startForResult(intent, REQUEST_CODE, callback);
    }

    public void startForResult(Class<?> clazz, int requestCode, Callback callback) {
        Intent intent = new Intent(mAResultFragment.getActivity(), clazz);
        startForResult(intent, requestCode, callback);
    }

    public void startForResult(Class<?> clazz, Callback callback) {
        startForResult(clazz, REQUEST_CODE, callback);
    }

    interface Callback {
        void onActivityResult(AResultMessage result);
    }
}
