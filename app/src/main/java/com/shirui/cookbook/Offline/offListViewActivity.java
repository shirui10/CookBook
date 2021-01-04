package com.shirui.cookbook.Offline;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.shirui.cookbook.ListViewActivity;
import com.shirui.cookbook.R;

import java.util.ArrayList;
import java.util.List;

public class offListViewActivity extends Activity {

    private ListView mLv_Meals;
    private EditText mSearchEt;
    private ImageView mSearchIv;
    private ImageView mFlushIv;
    List<offMealsBean> mData;
    List<offMealsBean> allMealsList;
    private offListAdapter adapter;
    private LinearLayout wholeView;
    private InputMethodManager manager;        //输入法管理器


    @Override
    protected void onCreate(@Nullable Bundle saveInstanceState) {
        super.onCreate(saveInstanceState);
        setContentView(R.layout.activity_listview_off);
        topTransparent();
        //查找控件
        initView();
        //去找到ListView的数据源
        mData = new ArrayList<>();
        allMealsList = offMealsUtils.getAllMealsList();
        mData.addAll(allMealsList);
        //创建适配器，即BaseAdapter的子类
        adapter = new offListAdapter(offListViewActivity.this, mData);
        mLv_Meals.setAdapter(adapter);   //设置适配器
        setListener();      //设置监听
    }


    private void initView() {
        mLv_Meals = findViewById(R.id.lv_1);
        mSearchEt = findViewById(R.id.search_Et);
        mSearchIv = findViewById(R.id.search_iv);
        mFlushIv = findViewById(R.id.flush_iv);
        wholeView = findViewById(R.id.whole_off_view);
        manager = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
    }


    //@SuppressLint("ClickableViewAccessibility")
    @SuppressLint("ClickableViewAccessibility")
    private void setListener() {

        //匿名内部类建立监听
        //Item点击监听
        mLv_Meals.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                offMealsBean offMealsBean = mData.get(position);
                Intent intent = new Intent(offListViewActivity.this, offDetailsActivity.class);
                intent.putExtra("Meal", offMealsBean);
                startActivity(intent);
            }
        });

        //触摸监听
        mSearchEt.setOnTouchListener((new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (MotionEvent.ACTION_DOWN == event.getAction()) {
                    mSearchEt.setCursorVisible(true);    //光标可见
                    mSearchEt.performClick();
                }
                return false;
            }
        }));

        //点击监听
        mSearchIv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String msg = mSearchEt.getText().toString().trim();
                if (TextUtils.isEmpty(msg)) {
                    showToast(offListViewActivity.this, "Empty message.");
                }
                List<offMealsBean> list = new ArrayList<>();
                for (int i = 0; i < allMealsList.size(); i++) {
                    String title = allMealsList.get(i).getTitle();
                    if (title.contains(msg)) {
                        list.add(allMealsList.get(i));
                    }
                }
                mData.clear();
                mData.addAll(list);
                adapter.notifyDataSetChanged();     //提示适配器更新
                if (adapter.getCount() == 0) {
                    showToast(offListViewActivity.this, "No Data.");
                }
            }
        });

        mFlushIv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mData.clear();
                mData.addAll(allMealsList);
                adapter.notifyDataSetChanged();
                mSearchEt.setText("");
                mSearchEt.setCursorVisible(false);
            }
        });

        //键盘监听，为了使软键盘上的回车可进行搜索操作
        mSearchEt.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (keyCode == KeyEvent.KEYCODE_ENTER && event.getAction() == KeyEvent.ACTION_DOWN) {
                    //先隐藏键盘
                    if (manager.isActive()) {
                        manager.hideSoftInputFromWindow(mSearchEt.getApplicationWindowToken(), 0);
                    }
                    //点击键盘上回车后进行的操作，即搜索
                    String msg = mSearchEt.getText().toString().trim();
                    if (TextUtils.isEmpty(msg)) {
                        showToast(offListViewActivity.this, "Empty message.");
                    }
                    List<offMealsBean> list = new ArrayList<>();
                    for (int i = 0; i < allMealsList.size(); i++) {
                        String title = allMealsList.get(i).getTitle();
                        if (title.contains(msg)) {
                            list.add(allMealsList.get(i));
                        }
                    }
                    mData.clear();
                    mData.addAll(list);
                    adapter.notifyDataSetChanged();     //提示适配器更新
                    if (adapter.getCount() == 0) {
                        showToast(offListViewActivity.this, "No Data.");
                    }
                }
                return false;
            }
        });

        //整个布局的触摸监听，用来使点击EditText以外的地方后取消在其上的焦点
        wholeView.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (null != offListViewActivity.this.getCurrentFocus()) {
                    //使焦点回到整个布局上
                    wholeView.setFocusable(true);
                    wholeView.setFocusableInTouchMode(true);
                    wholeView.requestFocus();
                    //点击空白位置,隐藏软键盘
                    InputMethodManager mInputMethodManager = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
                    return mInputMethodManager.hideSoftInputFromWindow(offListViewActivity.this.getCurrentFocus().getWindowToken(), 0);
                }
                return false;
            }
        });
    }


    //Toast工具
    public static void showToast(Context context, String msg) {
        Toast toast = Toast.makeText(context, null, Toast.LENGTH_SHORT);
        toast.setText(msg);
        toast.show();
    }


    //透明化通知栏
    public void topTransparent() {
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
    }
}
