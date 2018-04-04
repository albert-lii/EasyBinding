package com.liyi.bindview.abslistview;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

/**
 * 简单的 AbsListView 的适配器
 */
public abstract class SimpleBindBaseAdpter<D extends ViewDataBinding> extends BaseAdapter {

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        BindViewHolder<D> holder = null;
        if (convertView == null) {
            D bd = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), onCreateItemView(), null, false);
            convertView = bd.getRoot();
            holder = new BindViewHolder<D>(bd);
            convertView.setTag(holder);
        } else {
            holder = (BindViewHolder<D>) convertView.getTag();
        }
        onBindViewHolder(holder, position, convertView, parent);
        return convertView;
    }

    public abstract int onCreateItemView();

    public abstract void onBindViewHolder(BindViewHolder<D> holder, int position, View convertView, ViewGroup parent);
}
