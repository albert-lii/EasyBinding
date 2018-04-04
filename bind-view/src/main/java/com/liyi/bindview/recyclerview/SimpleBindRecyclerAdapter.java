package com.liyi.bindview.recyclerview;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.view.LayoutInflater;
import android.view.ViewGroup;

/**
 * 简单的 RecyclerView 的适配器
 */
public abstract class SimpleBindRecyclerAdapter<D extends ViewDataBinding> extends BindRecyclerAdapter<D> {

    @Override
    public BindRecyclerViewHolder<D> onCreateViewHolder(ViewGroup parent, int viewType) {
        D bd = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), onCreateItemView(), parent, false);
        return new BindRecyclerViewHolder<D>(bd);
    }

    public abstract int onCreateItemView();
}
