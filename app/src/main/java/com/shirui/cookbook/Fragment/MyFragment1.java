package com.shirui.cookbook.Fragment;

import android.graphics.Typeface;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.bumptech.glide.Glide;
import com.shirui.cookbook.MealsBean;
import com.shirui.cookbook.R;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

/**
 * Created by Jay on 2015/8/28 0028.
 */
public class MyFragment1 extends Fragment {

    private ImageView imageView;
    private TextView title;

    public MyFragment1() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_1, container, false);
        title = view.findViewById(R.id.details_fg_tv_title);
        Typeface tf = Typeface.createFromAsset(getContext().getAssets(), "Montel.ttf"); // 通过自定义字体生成字体对象
        title.setTypeface(tf); // 将TextView设置自定义字体
        imageView = view.findViewById(R.id.details_fg_iv);
        Log.e("Cache Page:", "1");
        EventBus.getDefault().register(this);       //这里为接收方，注册EventBus
        return view;
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        EventBus.getDefault().unregister(this);     //生命周期，在结束即onDestory被调用时取消订阅
    }


    //接收EventBus信息，并设置接收后进行的操作
    @Subscribe(sticky = true, threadMode = ThreadMode.MAIN)     //设置并声明使用的线程与信息的属性，不可少
    public void onEvent(MealsBean mealsBean) {
        if (mealsBean != null) {
            title.setText(mealsBean.getStrMeal());
            Glide.with(this).load(mealsBean.getStrMealThumb()).into(imageView);
        }
    }
}
