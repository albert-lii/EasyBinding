package com.ly.bindview.recyclerview;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.view.LayoutInflater;
import android.view.ViewGroup;

/**
 * 简单的 RecyclerView 的适配器
 */
public abstract class SimpleESRecyclerAdapter<D extends ViewDataBinding> extends EasyRecyclerAdapter<D> {

    @Override
    public EasyRecyclerViewHolder<D> onCreateViewHolder(ViewGroup parent, int viewType) {
        D bd = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), onCreateItemView(), parent, false);
        return new EasyRecyclerViewHolder<D>(bd);
    }

    public abstract int onCreateItemView();
}
