package com.ly.easy.abslistview;

import android.databinding.ViewDataBinding;

/**
 * AbsListView 的 ViewHolder
 */
public class EasyViewHolder<T extends ViewDataBinding> {
    protected T mBinding;

    public EasyViewHolder(T t) {
        this.mBinding = t;
    }

    public T getBinding() {
        return mBinding;
    }
}
