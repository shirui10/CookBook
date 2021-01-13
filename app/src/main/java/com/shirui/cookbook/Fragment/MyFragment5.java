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

public class MyFragment5 extends Fragment {

    private TextView title;
    private ImageView ing1, ing2, ing3, ing4, ing5, ing6, ing7, ing8, ing9, ing10, ing11, ing12, ing13, ing14, ing15, ing16, ing17, ing18, ing19, ing20;
    private String ingredients1, ingredients2, ingredients3, ingredients4, ingredients5, ingredients6, ingredients7, ingredients8, ingredients9, ingredients10, ingredients11, ingredients12, ingredients13, ingredients14, ingredients15, ingredients16, ingredients17, ingredients18, ingredients19, ingredients20;
    private final String url = "https://www.themealdb.com/images/ingredients/";

    public MyFragment5() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_5, container, false);

        title = view.findViewById(R.id.details_fg_pic);
        Typeface tf = Typeface.createFromAsset(getContext().getAssets(), "Montel.ttf"); // 通过自定义字体生成字体对象
        title.setTypeface(tf); // 将TextView设置自定义字体

        ing1 = view.findViewById(R.id.ing1);
        ing2 = view.findViewById(R.id.ing2);
        ing3 = view.findViewById(R.id.ing3);
        ing4 = view.findViewById(R.id.ing4);
        ing5 = view.findViewById(R.id.ing5);
        ing6 = view.findViewById(R.id.ing6);
        ing7 = view.findViewById(R.id.ing7);
        ing8 = view.findViewById(R.id.ing8);
        ing9 = view.findViewById(R.id.ing9);
        ing10 = view.findViewById(R.id.ing10);
        ing11 = view.findViewById(R.id.ing11);
        ing12 = view.findViewById(R.id.ing12);
        ing13 = view.findViewById(R.id.ing13);
        ing14 = view.findViewById(R.id.ing14);
        ing15 = view.findViewById(R.id.ing15);
        ing16 = view.findViewById(R.id.ing16);
        ing17 = view.findViewById(R.id.ing17);
        ing18 = view.findViewById(R.id.ing18);
        ing19 = view.findViewById(R.id.ing19);
        ing20 = view.findViewById(R.id.ing20);

        Log.e("Cache Page:", "5");
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

            ingredients1 = mealsBean.getStrIngredient1();
            ingredients2 = mealsBean.getStrIngredient2();
            ingredients3 = mealsBean.getStrIngredient3();
            ingredients4 = mealsBean.getStrIngredient4();
            ingredients5 = mealsBean.getStrIngredient5();
            ingredients6 = mealsBean.getStrIngredient6();
            ingredients7 = mealsBean.getStrIngredient7();
            ingredients8 = mealsBean.getStrIngredient8();
            ingredients9 = mealsBean.getStrIngredient9();
            ingredients10 = mealsBean.getStrIngredient10();
            ingredients11 = mealsBean.getStrIngredient11();
            ingredients12 = mealsBean.getStrIngredient12();
            ingredients13 = mealsBean.getStrIngredient13();
            ingredients14 = mealsBean.getStrIngredient14();
            ingredients15 = mealsBean.getStrIngredient15();
            ingredients16 = mealsBean.getStrIngredient16();
            ingredients17 = mealsBean.getStrIngredient17();
            ingredients18 = mealsBean.getStrIngredient18();
            ingredients19 = mealsBean.getStrIngredient19();
            ingredients20 = mealsBean.getStrIngredient20();

            Glide.with(this).load(url + ingredients1 + ".png").into(ing1);
            Glide.with(this).load(url + ingredients2 + ".png").into(ing2);
            Glide.with(this).load(url + ingredients3 + ".png").into(ing3);
            Glide.with(this).load(url + ingredients4 + ".png").into(ing4);
            Glide.with(this).load(url + ingredients5 + ".png").into(ing5);
            Glide.with(this).load(url + ingredients6 + ".png").into(ing6);
            Glide.with(this).load(url + ingredients7 + ".png").into(ing7);
            Glide.with(this).load(url + ingredients8 + ".png").into(ing8);
            Glide.with(this).load(url + ingredients9 + ".png").into(ing9);
            Glide.with(this).load(url + ingredients10 + ".png").into(ing10);
            Glide.with(this).load(url + ingredients11 + ".png").into(ing11);
            Glide.with(this).load(url + ingredients12 + ".png").into(ing12);
            Glide.with(this).load(url + ingredients13 + ".png").into(ing13);
            Glide.with(this).load(url + ingredients14 + ".png").into(ing14);
            Glide.with(this).load(url + ingredients15 + ".png").into(ing15);
            Glide.with(this).load(url + ingredients16 + ".png").into(ing16);
            Glide.with(this).load(url + ingredients17 + ".png").into(ing17);
            Glide.with(this).load(url + ingredients18 + ".png").into(ing18);
            Glide.with(this).load(url + ingredients19 + ".png").into(ing19);
            Glide.with(this).load(url + ingredients20 + ".png").into(ing20);


        }
    }
}
