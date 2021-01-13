package com.shirui.cookbook;

import android.content.Intent;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import org.greenrobot.eventbus.EventBus;

import com.shirui.cookbook.Fragment.MyFragmentPagerAdapter;

public class DetailsActivity extends AppCompatActivity {

    //UI Objects
    private RadioGroup rg_tab_bar;
    private RadioButton rb_1;
    private RadioButton rb_2;
    private RadioButton rb_3;
    private RadioButton rb_4;
    private RadioButton rb_5;
    private ViewPager viewPager;

    private MyFragmentPagerAdapter mAdapter;

    //几个代表页面的常量
    public static final int PAGE_ONE = 0;
    public static final int PAGE_TWO = 1;
    public static final int PAGE_THREE = 2;
    public static final int PAGE_FOUR = 3;
    public static final int PAGE_FIVE = 4;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details_on);
        transparentTop();
        initView();
        setListener();
        setData();
        rb_1.setChecked(true);          //初始化，设定第一个RadioButton被选中（好像没有也没问题？）
    }

    private void initView() {

        rg_tab_bar = findViewById(R.id.rg_tab_bar);
        rb_1 = findViewById(R.id.rb_1);
        rb_2 = findViewById(R.id.rb_2);
        rb_3 = findViewById(R.id.rb_3);
        rb_4 = findViewById(R.id.rb_4);
        rb_5 = findViewById(R.id.rb_5);
        viewPager = findViewById(R.id.viewpager);

        mAdapter = new MyFragmentPagerAdapter(getSupportFragmentManager()); //实例化，通过getSupportFragmentManager()获得FragmentManager设置适配器
        viewPager.setAdapter(mAdapter);
        viewPager.setCurrentItem(0);        //初始化，设置viewpager的开始页面
    }

    private void setListener() {

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            //重写ViewPager页面切换的处理方法
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

                //state的状态有三个，0表示什么都没做，1正在滑动，2滑动完毕
                if (state == 2) {
                    switch (viewPager.getCurrentItem()) {
                        case PAGE_ONE:
                            rb_1.setChecked(true);
                            break;
                        case PAGE_TWO:
                            rb_2.setChecked(true);
                            break;
                        case PAGE_THREE:
                            rb_3.setChecked(true);
                            break;
                        case PAGE_FOUR:
                            rb_4.setChecked(true);
                            break;
                        case PAGE_FIVE:
                            rb_5.setChecked(true);
                            break;
                    }
                }
            }
        });

        rg_tab_bar.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.rb_1:
                        viewPager.setCurrentItem(PAGE_ONE);
                        break;
                    case R.id.rb_2:
                        viewPager.setCurrentItem(PAGE_TWO);
                        break;
                    case R.id.rb_3:
                        viewPager.setCurrentItem(PAGE_THREE);
                        break;
                    case R.id.rb_4:
                        viewPager.setCurrentItem(PAGE_FOUR);
                        break;
                    case R.id.rb_5:
                        viewPager.setCurrentItem(PAGE_FIVE);
                        break;
                }
            }
        });
    }

    private void setData() {
        //接受上一级页面传来的数据
        Intent intent = getIntent();
        MealsBean mealsBean = (MealsBean) intent.getSerializableExtra("Meals");

        EventBus.getDefault().postSticky(mealsBean);        //通过EventBus发送粘性信息，以防接收方onCreate还没运行之前就进行了接收，所以使用粘性事件等待onCreate运行后才接收
    }

    //透明化通知栏
    private void transparentTop() {
        //隐藏ActionBar
        getSupportActionBar().hide();
        //透明化通知栏
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
    }
}
