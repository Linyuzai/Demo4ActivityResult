package com.linyuzai.aresult;

import android.app.Activity;
import android.content.Intent;

/**
 * Created by linyuzai on 2018/1/2.
 *
 * @author linyuzai
 */

public class AResultMessage {
    private int resultCode;
    private int requestCode;
    private Intent data;

    AResultMessage(Intent data, int resultCode, int requestCode) {
        this.data = data;
        this.resultCode = resultCode;
        this.requestCode = requestCode;
    }

    public Intent getData() {
        return data;
    }

    public int getResultCode() {
        return resultCode;
    }

    public int getRequestCode() {
        return requestCode;
    }

    public boolean isOk() {
        return resultCode == Activity.RESULT_OK;
    }

    public boolean isCancel() {
        return resultCode == Activity.RESULT_CANCELED;
    }

    public boolean isFirstUser() {
        return resultCode == Activity.RESULT_FIRST_USER;
    }

    @Override
    public String toString() {
        return "AResultMessage{" +
                "isOk=" + isOk() +
                ", isCancel=" + isCancel() +
                ", isFirstUser=" + isFirstUser() +
                ", resultCode=" + resultCode +
                ", requestCode=" + requestCode +
                ", data=" + data +
                '}';
    }
}
