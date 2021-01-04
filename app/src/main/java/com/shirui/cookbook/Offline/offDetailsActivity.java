package com.shirui.cookbook.Offline;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.shirui.cookbook.R;

public class offDetailsActivity extends Activity {

    private ImageView imageView;
    private TextView title;
    private TextView step;
    private TextView ingredients;
    private TextView measure;
    private TextView tips, stepTip;


    @Override
    protected void onCreate(@Nullable Bundle saveInstanceState) {
        super.onCreate(saveInstanceState);
        setContentView(R.layout.activity_details_off);
        topTransparent();
        initView();
        setData();
    }


    //初始化控件
    private void initView() {
        imageView = findViewById(R.id.details_iv);
        title = findViewById(R.id.details_tv_title);
        step = findViewById(R.id.details_tv_step);
        ingredients = findViewById(R.id.details_tv_ing);
        measure = findViewById(R.id.details_tv_mea);
        tips = findViewById(R.id.details_tv_tips);
        stepTip = findViewById(R.id.details_tv_tip);
    }


    //给控件赋值
    private void setData() {
        //接受上一级页面传来的数据
        Intent intent = getIntent();
        offMealsBean offMealsBean = (offMealsBean) intent.getSerializableExtra("Meal");
        //设置显示控件
        imageView.setImageResource(offMealsBean.getPicID());
        title.setText(offMealsBean.getTitle());
        step.setText(offMealsBean.getStep());
        ingredients.setText(offMealsBean.getIngredients());
        measure.setText(offMealsBean.getMeasure());
        tips.setText(R.string.tip_1);
        stepTip.setText(R.string.tip_2);
    }


    //透明化通知栏
    public void topTransparent() {
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
    }
}
