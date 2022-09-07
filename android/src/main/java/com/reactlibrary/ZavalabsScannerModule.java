package com.reactlibrary;

import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

import com.facebook.react.bridge.ActivityEventListener;
import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.NativeModule;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;


public class ZavalabsScannerModule extends ReactContextBaseJavaModule  implements ActivityEventListener {
    private static ReactApplicationContext reactContext;
    private Callback mCallback;

    public ZavalabsScannerModule(ReactApplicationContext context) {
        super(context);
        reactContext = context;
    }

    @ReactMethod
    public void showBarcodeReader(Callback callback) {
        mCallback = callback;
        IntentIntegrator integrator = new IntentIntegrator(getCurrentActivity());
        integrator.setOrientationLocked(true);
        integrator.setCaptureActivity(ContinuousCaptureActivity.class);
        integrator.initiateScan();
        reactContext.addActivityEventListener(this);
    }

    @Override
    public String getName() {
        return "ZavalabsScanner";
    }

    @Override
    public void onNewIntent(Intent intent) {}

    @Override
    public void onActivityResult(Activity activity, int requestCode, int resultCode, Intent data) {
        IntentResult result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);
        mCallback.invoke(result.getContents(), result.getBarcodeImagePath());
        reactContext.removeActivityEventListener(this);
    }

}
