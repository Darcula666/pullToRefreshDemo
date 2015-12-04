package net.gfdz.com.pulltorefreshdemo.utils;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.List;

/**
 * Created by Administrator on 2015/11/30.
 */
public abstract class CommonAdapter<T> extends BaseAdapter {
    protected Context context;
    protected List<T> datas;
    protected LayoutInflater inflater;
    private int layoutId;

    public CommonAdapter(Context context, List<T> datas, int layoutId) {
        this.context = context;
        this.datas = datas;
        this.layoutId = layoutId;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return datas.size();
    }

    @Override
    public T getItem(int position) {
        return datas.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = ViewHolder.get(context, convertView, parent, layoutId, position);

        conver(holder, getItem(position));


        return holder.getConvertView();
    }

    public abstract void conver(ViewHolder holder, T t);
   /* 用法
   public void conver(ViewHolder holder, Bean bean) {

        holder.setText(R.id.id_title, bean.getTitle())
                .setText(R.id.id_desc, bean.getDesc())
                .setText(R.id.id_time, bean.getTime())
                .setText(R.id.id_phone, bean.getPhone());
       *//* TextView mTitle=holder.getView(R.id.id_title);
        mTitle.setText(bean.getTitle());

        TextView mDesc=holder.getView(R.id.id_desc);
        mDesc.setText(bean.getDesc());

        TextView mTime=holder.getView(R.id.id_time);
        mTime.setText(bean.getTime());

        TextView mPhone=holder.getView(R.id.id_phone);
        mPhone.setText(bean.getPhone());*//*

    }*/
}
