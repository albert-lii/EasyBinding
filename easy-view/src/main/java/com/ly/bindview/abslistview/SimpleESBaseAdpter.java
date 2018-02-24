package com.ly.bindview.abslistview;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

/**
 * 简单的 AbsListView 的适配器
 */
public abstract class SimpleESBaseAdpter<D extends ViewDataBinding> extends BaseAdapter {

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        EasyViewHolder<D> holder = null;
        if (convertView == null) {
            D bd = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), onCreateItemView(), null, false);
            convertView = bd.getRoot();
            holder = new EasyViewHolder<D>(bd);
            convertView.setTag(holder);
        } else {
            holder = (EasyViewHolder<D>) convertView.getTag();
        }
        onBindViewHolder(holder, position, convertView, parent);
        return convertView;
    }

    public abstract int onCreateItemView();

    public abstract void onBindViewHolder(EasyViewHolder<D> holder, int position, View convertView, ViewGroup parent);
}
