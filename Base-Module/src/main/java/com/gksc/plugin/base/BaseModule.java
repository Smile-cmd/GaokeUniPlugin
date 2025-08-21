package com.gksc.plugin.base;

import android.widget.Toast;

import io.dcloud.feature.uniapp.annotation.UniJSMethod;
import io.dcloud.feature.uniapp.common.UniModule;

public class BaseModule extends UniModule{

    private static final String TAG = "BaseModule";

    @UniJSMethod
    public void test(){
        showToast();;
    }

    private void showToast() {
        Toast.makeText(mUniSDKInstance.getContext(), "原生插件调用成功_1.0.5", Toast.LENGTH_LONG).show();
    }
}