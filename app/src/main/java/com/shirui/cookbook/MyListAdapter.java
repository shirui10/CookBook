package com.shirui.cookbook;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

public class MyListAdapter extends BaseAdapter {            //ListView适配器，基础的模板大概都这样

    private final Context mContext;
    private final LayoutInflater mLayoutInflater;
    List<MealsBean> mData = new ArrayList<MealsBean>();


    public MyListAdapter(Context context, List<MealsBean> mData) {
        this.mContext = context;
        mLayoutInflater = LayoutInflater.from(context);
        this.mData = mData;
    }


    @Override
    public int getCount() {
        try {
            return mData.size();
        } catch (NullPointerException e) {
            return 0;
        }
    }


    @Override
    public Object getItem(int position) {
        return mData.get(position);
    }


    @Override
    public long getItemId(int position) {
        return position;
    }


    static class ViewHolder {

        public ImageView imageView;
        public TextView tv_title;
        public TextView tv_category;
        public TextView tv_tag;

        public ViewHolder(View view) {
            imageView = view.findViewById(R.id.iv);
            tv_title = view.findViewById(R.id.tv_title);
            tv_category = view.findViewById(R.id.tv_category);
            tv_tag = view.findViewById(R.id.tv_tag);
        }
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder holder = null;

        if (convertView == null) {
            convertView = mLayoutInflater.inflate(R.layout.layout_list_item, null);
            holder = new MyListAdapter.ViewHolder(convertView);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        //给控件赋值
        MealsBean mealsBean = mData.get(position);
        holder.tv_title.setText(mealsBean.getStrMeal());
        holder.tv_category.setText(mealsBean.getStrCategory());
        holder.tv_tag.setText(mealsBean.getStrTags());
        Glide.with(mContext).load(mealsBean.getStrMealThumb()).into(holder.imageView);
        return convertView;
    }
}
