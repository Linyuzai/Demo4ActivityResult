package com.linyuzai.aresult;

import android.content.Intent;

/**
 * Created by linyuzai on 2018/1/2.
 *
 * @author linyuzai
 */

public class AResultMessage {
    private boolean isOk;
    private boolean isCancel;
    private boolean isFirstUser;
    private int resultCode;
    private int requestCode;
    private Intent intent;

    AResultMessage(Intent intent, int resultCode, int requestCode, boolean isOk, boolean isCancel, boolean isFirstUser) {
        this.intent = intent;
        this.resultCode = resultCode;
        this.requestCode = requestCode;
        this.isOk = isOk;
        this.isCancel = isCancel;
        this.isFirstUser = isFirstUser;
    }

    public Intent getIntent() {
        return intent;
    }

    public int getResultCode() {
        return resultCode;
    }

    public int getRequestCode() {
        return requestCode;
    }

    public boolean isOk() {
        return isOk;
    }

    public boolean isCancel() {
        return isCancel;
    }

    public boolean isFirstUser() {
        return isFirstUser;
    }
}
