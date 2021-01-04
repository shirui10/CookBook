package com.shirui.cookbook;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
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
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.google.gson.Gson;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class ListViewActivity extends Activity {

    private List<MealsBean> meals = new ArrayList<>();
    private MyListAdapter adapter;
    private ListView mLv_Meals;
    private Spinner mSpinner;
    private EditText mEditText;
    private ImageView mSearchIv;
    private final String urlLetter = "https://www.themealdb.com/api/json/v1/1/search.php?f=";
    private final String urlSearch = "https://www.themealdb.com/api/json/v1/1/search.php?s=";
    private String urlTemp = "a";
    private boolean selected;
    private LinearLayout wholeView;
    InputMethodManager manager; //输入法管理器


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listview_on);
        topTransparent();
        initView();
        setListener();
        checkNetwork();
        makeList(urlLetter);
    }


    //初始化控件
    @SuppressLint("ClickableViewAccessibility")
    private void initView() {
        mLv_Meals = findViewById(R.id.lv_1_on);
        mSpinner = findViewById(R.id.spin_one);
        mEditText = findViewById(R.id.search_et_on);
        mSearchIv = findViewById(R.id.search_iv_on);
        wholeView = findViewById(R.id.whole_on_view);
        manager = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
    }


    //设置各类监听
    @SuppressLint("ClickableViewAccessibility")
    private void setListener() {

        //通过匿名内部类建立监听
        //Item点击监听
        mLv_Meals.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                MealsBean mealsBean = meals.get(position);
                Intent intent = new Intent(ListViewActivity.this, DetailsActivity.class);
                intent.putExtra("Meals", mealsBean);    //通过接口传递数据给下一activity
                startActivity(intent);
            }
        });

        //点击监听
        mEditText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mEditText.setHint(null);
            }
        });

        mSearchIv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (v.getId() == R.id.search_iv_on) {
                    urlTemp = "";
                    urlTemp = mEditText.getText().toString().trim();    //获取EditText上的文字
                    if (TextUtils.isEmpty(urlTemp)) {
                        showToast(ListViewActivity.this, "Empty message.");      //空信息提示
                    }
                    Log.d("Input:", urlTemp);
                    //meals.clear();
                    makeList(urlSearch);
                    //adapter.notifyDataSetChanged();   //提示适配器更新
                }
            }
        });

        //选择监听
        mSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (parent.getId() == R.id.spin_one) {
                    if (selected) {
                        String[] letters = getResources().getStringArray(R.array.data);     //获取res里的myarrays内的指定数组
                        String temp = letters[position];
                        urlTemp = temp.toLowerCase();  //把大写转换为小写字母
                        Log.d("Selected:", temp);
                        makeList(urlLetter);
                        //adapter.notifyDataSetChanged();   //提示适配器更新
                        //清空EditText并隐藏光标
                        mEditText.setText("");
                        mEditText.setCursorVisible(false);
                    } else selected = true;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        //触摸监听
        mEditText.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (MotionEvent.ACTION_DOWN == event.getAction()) {
                    mEditText.setCursorVisible(true);    //光标可见
                }
                return false;
            }
        });

        //键盘监听，为了使软键盘上的回车可进行搜索操作
        mEditText.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (keyCode == KeyEvent.KEYCODE_ENTER && event.getAction() == KeyEvent.ACTION_DOWN) {
                    //先隐藏键盘
                    if (manager.isActive()) {
                        manager.hideSoftInputFromWindow(mEditText.getApplicationWindowToken(), 0);
                    }
                    //点击键盘上回车键后进行的操作，即搜索
                    urlTemp = "";
                    urlTemp = mEditText.getText().toString().trim();    //获取EditText上的文字
                    if (TextUtils.isEmpty(urlTemp)) {
                        showToast(ListViewActivity.this, "Empty message.");      //空信息提示
                    }
                    Log.d("Input:", urlTemp);
                    //meals.clear();
                    makeList(urlSearch);
                    //adapter.notifyDataSetChanged();   //提示适配器更新
                }
                return false;
            }
        });


        //整个布局的触摸监听，用来使点击EditText以外的地方后取消在其上的焦点
        wholeView.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (null != ListViewActivity.this.getCurrentFocus()) {
                    //使焦点回到整个布局上
                    wholeView.setFocusable(true);
                    wholeView.setFocusableInTouchMode(true);
                    wholeView.requestFocus();
                    //点击空白位置,隐藏软键盘
                    InputMethodManager mInputMethodManager = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
                    return mInputMethodManager.hideSoftInputFromWindow(ListViewActivity.this.getCurrentFocus().getWindowToken(), 0);
                }
                return false;
            }
        });
    }


    //开启子线程访问网络，避免阻塞主线程，然后获取Json数据并解析，根据解析后的数据创建ListView
    private void makeList(final String url) {

        new Thread(new Runnable() {     //创建子线程
            @Override
            public void run() {
                try {
                    OkHttpClient client = new OkHttpClient();
                    Request request = new Request.Builder().url(url + urlTemp).build();   //发起访问数据请求
                    Response response = client.newCall(request).execute();      //获得回复的数据
                    String responsedata = Objects.requireNonNull(response.body()).string();         //赋值
                    Log.d("Response：", responsedata);
                    transJson(responsedata);    //解析Json
                    runOnUiThread(new Runnable() {      //子线程进行时可以给主线程UI进行的操作
                        @Override
                        public void run() {
                            // Stuff that updates the UI
                            adapter = new MyListAdapter(ListViewActivity.this, meals);    //创建适配器
                            mLv_Meals.setAdapter(adapter);    //设置适配器
                            if (adapter.getCount() == 0) {
                                showToast(ListViewActivity.this, "No Data.");   //若无数据便弹出提示
                            }
                        }
                    });
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }


    //Json解析
    private void transJson(String JsonData) {
        Gson gson = new Gson();
        MealsRootBean meal = gson.fromJson(JsonData, MealsRootBean.class);
        meals = meal.getMeals();
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


    //检测网络连接状态
    private void checkNetwork() {
        ConnectivityManager cwjManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo info = cwjManager.getActiveNetworkInfo();
        if (info != null && info.isAvailable()) {
            showToast(this, "Network connected.");
        } else {
            showToast(this, "Network NOT connected.");
        }
    }
}

