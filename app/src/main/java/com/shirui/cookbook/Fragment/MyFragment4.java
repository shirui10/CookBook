package com.shirui.cookbook.Fragment;

import android.graphics.Typeface;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.shirui.cookbook.MealsBean;
import com.shirui.cookbook.R;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

/**
 * Created by Jay on 2015/8/28 0028.
 */
public class MyFragment4 extends Fragment {

    private TextView title;
    private TextView ingredients1, ingredients2, ingredients3, ingredients4, ingredients5, ingredients6, ingredients7, ingredients8, ingredients9, ingredients10, ingredients11, ingredients12, ingredients13, ingredients14, ingredients15, ingredients16, ingredients17, ingredients18, ingredients19, ingredients20;
    private TextView measure1, measure2, measure3, measure4, measure5, measure6, measure7, measure8, measure9, measure10, measure11, measure12, measure13, measure14, measure15, measure16, measure17, measure18, measure19, measure20;

    public MyFragment4() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_4, container, false);

        title = view.findViewById(R.id.details_fg_tv_tips);
        Typeface tf = Typeface.createFromAsset(getContext().getAssets(), "Montel.ttf"); // 通过自定义字体生成字体对象
        title.setTypeface(tf); // 将TextView设置自定义字体

        ingredients1 = view.findViewById(R.id.details_on_tv_ing1);
        ingredients2 = view.findViewById(R.id.details_on_tv_ing2);
        ingredients3 = view.findViewById(R.id.details_on_tv_ing3);
        ingredients4 = view.findViewById(R.id.details_on_tv_ing4);
        ingredients5 = view.findViewById(R.id.details_on_tv_ing5);
        ingredients6 = view.findViewById(R.id.details_on_tv_ing6);
        ingredients7 = view.findViewById(R.id.details_on_tv_ing7);
        ingredients8 = view.findViewById(R.id.details_on_tv_ing8);
        ingredients9 = view.findViewById(R.id.details_on_tv_ing9);
        ingredients10 = view.findViewById(R.id.details_on_tv_ing10);
        ingredients11 = view.findViewById(R.id.details_on_tv_ing11);
        ingredients12 = view.findViewById(R.id.details_on_tv_ing12);
        ingredients13 = view.findViewById(R.id.details_on_tv_ing13);
        ingredients14 = view.findViewById(R.id.details_on_tv_ing14);
        ingredients15 = view.findViewById(R.id.details_on_tv_ing15);
        ingredients16 = view.findViewById(R.id.details_on_tv_ing16);
        ingredients17 = view.findViewById(R.id.details_on_tv_ing17);
        ingredients18 = view.findViewById(R.id.details_on_tv_ing18);
        ingredients19 = view.findViewById(R.id.details_on_tv_ing19);
        ingredients20 = view.findViewById(R.id.details_on_tv_ing20);

        measure1 = view.findViewById(R.id.details_on_tv_mea1);
        measure2 = view.findViewById(R.id.details_on_tv_mea2);
        measure3 = view.findViewById(R.id.details_on_tv_mea3);
        measure4 = view.findViewById(R.id.details_on_tv_mea4);
        measure5 = view.findViewById(R.id.details_on_tv_mea5);
        measure6 = view.findViewById(R.id.details_on_tv_mea6);
        measure7 = view.findViewById(R.id.details_on_tv_mea7);
        measure8 = view.findViewById(R.id.details_on_tv_mea8);
        measure9 = view.findViewById(R.id.details_on_tv_mea9);
        measure10 = view.findViewById(R.id.details_on_tv_mea10);
        measure11 = view.findViewById(R.id.details_on_tv_mea11);
        measure12 = view.findViewById(R.id.details_on_tv_mea12);
        measure13 = view.findViewById(R.id.details_on_tv_mea13);
        measure14 = view.findViewById(R.id.details_on_tv_mea14);
        measure15 = view.findViewById(R.id.details_on_tv_mea15);
        measure16 = view.findViewById(R.id.details_on_tv_mea16);
        measure17 = view.findViewById(R.id.details_on_tv_mea17);
        measure18 = view.findViewById(R.id.details_on_tv_mea18);
        measure19 = view.findViewById(R.id.details_on_tv_mea19);
        measure20 = view.findViewById(R.id.details_on_tv_mea20);

        Log.e("Cache Page:", "4");
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

            ingredients1.setText(mealsBean.getStrIngredient1());
            ingredients2.setText(mealsBean.getStrIngredient2());
            ingredients3.setText(mealsBean.getStrIngredient3());
            ingredients4.setText(mealsBean.getStrIngredient4());
            ingredients5.setText(mealsBean.getStrIngredient5());
            ingredients6.setText(mealsBean.getStrIngredient6());
            ingredients7.setText(mealsBean.getStrIngredient7());
            ingredients8.setText(mealsBean.getStrIngredient8());
            ingredients9.setText(mealsBean.getStrIngredient9());
            ingredients10.setText(mealsBean.getStrIngredient10());
            ingredients11.setText(mealsBean.getStrIngredient11());
            ingredients12.setText(mealsBean.getStrIngredient12());
            ingredients13.setText(mealsBean.getStrIngredient13());
            ingredients14.setText(mealsBean.getStrIngredient14());
            ingredients15.setText(mealsBean.getStrIngredient15());
            ingredients16.setText(mealsBean.getStrIngredient16());
            ingredients17.setText(mealsBean.getStrIngredient17());
            ingredients18.setText(mealsBean.getStrIngredient18());
            ingredients19.setText(mealsBean.getStrIngredient19());
            ingredients20.setText(mealsBean.getStrIngredient20());

            measure1.setText(mealsBean.getStrMeasure1());
            measure2.setText(mealsBean.getStrMeasure2());
            measure3.setText(mealsBean.getStrMeasure3());
            measure4.setText(mealsBean.getStrMeasure4());
            measure5.setText(mealsBean.getStrMeasure5());
            measure6.setText(mealsBean.getStrMeasure6());
            measure7.setText(mealsBean.getStrMeasure7());
            measure8.setText(mealsBean.getStrMeasure8());
            measure9.setText(mealsBean.getStrMeasure9());
            measure10.setText(mealsBean.getStrMeasure10());
            measure11.setText(mealsBean.getStrMeasure11());
            measure12.setText(mealsBean.getStrMeasure12());
            measure13.setText(mealsBean.getStrMeasure13());
            measure14.setText(mealsBean.getStrMeasure14());
            measure15.setText(mealsBean.getStrMeasure15());
            measure16.setText(mealsBean.getStrMeasure16());
            measure17.setText(mealsBean.getStrMeasure17());
            measure18.setText(mealsBean.getStrMeasure18());
            measure19.setText(mealsBean.getStrMeasure19());
            measure20.setText(mealsBean.getStrMeasure20());
        }
    }
}
