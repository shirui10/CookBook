package com.shirui.cookbook;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.shirui.cookbook.animation_justforfun.FloatViewControl;
import com.shirui.cookbook.Offline.offListViewActivity;

public class MainActivity extends Activity {

    private ImageButton mBtn_Online;
    private ImageButton mBtn_Offline;
    private ImageButton mBtn_Info;
    private TextView mBtn_Surprise;
    private TextView textView;
    private int flag = 0;       //用于二次点击里，第一次点击为0，第二次为1


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fullScreen();
        initView();
        setListener();
    }


    //初始化控件
    private void initView() {
        mBtn_Online = findViewById(R.id.btn_1);
        mBtn_Offline = findViewById(R.id.btn_2);
        mBtn_Info = findViewById(R.id.btn_3);
        mBtn_Surprise = findViewById(R.id.btn_surprise);
        textView = findViewById(R.id.main_tv);

        Typeface tf = Typeface.createFromAsset(getAssets(), "GooeyDrippySticky.ttf"); // 通过自定义字体生成字体对象
        textView.setText(R.string.app_title);
        textView.setTypeface(tf); // 将TextView设置自定义字体。

    }


    //设置监听
    private void setListener() {

        //通过匿名内部类建立点击监听
        mBtn_Online.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ListViewActivity.class);
                startActivity(intent);
            }
        });

        mBtn_Offline.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, offListViewActivity.class);
                startActivity(intent);
            }
        });

        mBtn_Info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, InfoActivity.class);
                startActivity(intent);
            }
        });

        mBtn_Surprise.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (flag) {
                    case 0:
                        FloatViewControl.getInstance().startAnimation(MainActivity.this);
                        showToast(MainActivity.this, "Just for fun lol, click again can stop it.");
                        flag = 1;
                        break;
                    case 1:
                        FloatViewControl.getInstance().stopAnimation(MainActivity.this);
                        showToast(MainActivity.this, "THANK YOU! Have a good day!");
                        flag = 0;
                        break;
                }
            }
        });


        //设置长按监听
        mBtn_Online.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                showToast(MainActivity.this, "It is Online Mode.");
                return true;        //长按要返回true，返回false的话短按操作也会被触发。 因为true，表示action_down事件已经被消耗了，下面同理
            }
        });

        mBtn_Offline.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                showToast(MainActivity.this, "It is Offline Mode.");
                return true;
            }
        });

        mBtn_Info.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                showToast(MainActivity.this, "It is Info.");
                return true;
            }
        });

        mBtn_Surprise.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                showToast(MainActivity.this, "Nothing happen.");
                return true;
            }
        });
    }


    //Toast工具,因为部分手机如小米直接用Toast的话前缀会有程序名，因而需要进行消除后再Toast,别处该方法同理
    public void showToast(Context context, String msg) {
        Toast toast = Toast.makeText(context, null, Toast.LENGTH_LONG);
        toast.setText(msg);
        toast.show();
    }


    //全屏
    public void fullScreen() {
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);       //透明化通知栏
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);      //页面底部下沉
    }
}
