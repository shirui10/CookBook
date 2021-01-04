package com.shirui.cookbook.animation_justforfun;

import android.app.Activity;
import android.view.ViewGroup;

public class FloatViewControl {
    private static FloatViewControl sInstance;

    private FloatViewControl() {
        //构造方法私有化
    }

    public static synchronized FloatViewControl getInstance() {
        if (sInstance == null)
            sInstance = new FloatViewControl();
        return sInstance;
    }


    private FloatView mFloatView;

    public void startAnimation(Activity activity) {
        if (mFloatView == null) {
            mFloatView = new FloatView(activity);
            mFloatView.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
            mFloatView.attachActivity(activity);
            mFloatView.start();
        }
    }

    public void stopAnimation(Activity activity) {
        if (mFloatView != null) {
            mFloatView.stop();
            mFloatView.disAttach(activity);
            mFloatView = null;
        }
    }

}