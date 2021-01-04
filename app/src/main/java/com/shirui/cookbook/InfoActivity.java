package com.shirui.cookbook;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;


public class InfoActivity extends Activity {

    private TextView textView;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);
        topTransparent();
        textView = findViewById(R.id.info_tv5);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showToast(InfoActivity.this, "你点你" + "\ud83d\udc34" + "呢");
            }
        });
    }


    //Toast工具
    public void showToast(Context context, String msg) {
        Toast toast = Toast.makeText(context, null, Toast.LENGTH_SHORT);
        toast.setText(msg);
        toast.show();
    }


    //透明化通知栏
    public void topTransparent() {
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
    }
}
