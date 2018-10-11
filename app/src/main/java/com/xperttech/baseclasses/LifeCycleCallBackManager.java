package com.xperttech.baseclasses;

import android.content.Intent;
import android.support.annotation.NonNull;

public interface LifeCycleCallBackManager {

    void onActivityResult(int requestCode, int resultCode, Intent data);

    void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions,
                                           @NonNull int[] grantResults);

    void onDestroy();

    void onStartActivity();

}