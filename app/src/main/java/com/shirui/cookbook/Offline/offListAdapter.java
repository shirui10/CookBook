package com.shirui.cookbook.Offline;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.shirui.cookbook.R;

import java.util.ArrayList;
import java.util.List;

public class offListAdapter extends BaseAdapter {           //适配器，模板基本大概都这样

    private final Context mContext;
    private final LayoutInflater mLayoutInflater;
    List<offMealsBean> mDatas = new ArrayList<offMealsBean>();


    public offListAdapter(Context context, List<offMealsBean> mDatas) {
        this.mContext = context;
        mLayoutInflater = LayoutInflater.from(context);
        this.mDatas = mDatas;
    }


    @Override
    public int getCount() {
        return mDatas.size();
    }


    @Override
    public Object getItem(int position) {
        return mDatas.get(position);
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
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        //给控件赋值
        offMealsBean offMealsBean = mDatas.get(position);
        holder.tv_title.setText(offMealsBean.getTitle());
        holder.tv_category.setText(offMealsBean.getCategory());
        holder.tv_tag.setText(offMealsBean.getTag());
        holder.imageView.setImageResource(offMealsBean.getPicID());
        return convertView;
    }
}
