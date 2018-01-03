package com.linyuzai.aresult;

import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;

import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.subjects.PublishSubject;

/**
 * Created by linyuzai on 2018/1/2.
 *
 * @author linyuzai
 */

public class AResultFragment extends Fragment {
    private PublishSubject<AResultMessage> mSubject;
    private AResult.Callback mCallback;

    public static AResultFragment newInstance() {
        return new AResultFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
    }

    public Observable<AResultMessage> startForResult(final Intent intent, final int requestCode) {
        mCallback = null;
        mSubject = PublishSubject.create();
        return mSubject.doOnSubscribe(new Consumer<Disposable>() {
            @Override
            public void accept(Disposable disposable) throws Exception {
                startActivityForResult(intent, requestCode);
            }
        });
    }

    public void startForResult(Intent intent, int requestCode, AResult.Callback callback) {
        mSubject = null;
        mCallback = callback;
        startActivityForResult(intent, requestCode);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (mSubject != null) {
            mSubject.onNext(new AResultMessage(data, resultCode, requestCode,
                    resultCode == Activity.RESULT_OK,
                    resultCode == Activity.RESULT_CANCELED,
                    resultCode == Activity.RESULT_FIRST_USER));
            mSubject.onComplete();
        }
        if (mCallback != null) {
            mCallback.onActivityResult(new AResultMessage(data, resultCode, requestCode,
                    resultCode == Activity.RESULT_OK,
                    resultCode == Activity.RESULT_CANCELED,
                    resultCode == Activity.RESULT_FIRST_USER));
        }
    }
}
