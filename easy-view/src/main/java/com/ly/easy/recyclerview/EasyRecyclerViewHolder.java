package com.ly.easy.recyclerview;

import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView;

/**
 * RecyclerView 的 ViewHolder 的基类
 */
public class EasyRecyclerViewHolder<T extends ViewDataBinding> extends RecyclerView.ViewHolder {
    protected T mBinding;

    public EasyRecyclerViewHolder(T t) {
        super(t.getRoot());
        this.mBinding = t;
    }

    public T getBinding() {
        return mBinding;
    }
}
