package Fragment;


import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.shirui.cookbook.DetailsActivity;


public class MyFragmentPagerAdapter extends FragmentStatePagerAdapter {

    private final int PAGER_COUNT = 5;          //设置ViewPager总页数
    private MyFragment1 myFragment1 = null;
    private MyFragment2 myFragment2 = null;
    private MyFragment3 myFragment3 = null;
    private MyFragment4 myFragment4 = null;
    private MyFragment5 myFragment5 = null;


    public MyFragmentPagerAdapter(FragmentManager fm) {        //构造函数
        super(fm);
        myFragment1 = new MyFragment1();
        myFragment2 = new MyFragment2();
        myFragment3 = new MyFragment3();
        myFragment4 = new MyFragment4();
        myFragment5 = new MyFragment5();
    }


    @Override
    public int getCount() {
        return PAGER_COUNT;
    }       //ViewPager里有多少个item，即页数

    @Override
    public Object instantiateItem(ViewGroup vg, int position) {
        return super.instantiateItem(vg, position);
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {     //销毁不在当前的item，减轻内存压力
        System.out.println("position Destory" + position);
        super.destroyItem(container, position, object);
    }

    @Override
    public Fragment getItem(int position) {             //使每个item对应一个fragment
        Fragment fragment = null;
        switch (position) {
            case DetailsActivity.PAGE_ONE:
                fragment = myFragment1;
                break;
            case DetailsActivity.PAGE_TWO:
                fragment = myFragment2;
                break;
            case DetailsActivity.PAGE_THREE:
                fragment = myFragment3;
                break;
            case DetailsActivity.PAGE_FOUR:
                fragment = myFragment4;
                break;
            case DetailsActivity.PAGE_FIVE:
                fragment = myFragment5;
                break;
        }
        return fragment;
    }
}

