package com.liyi.bindview.abslistview;

import android.databinding.ViewDataBinding;

/**
 * AbsListView 的 ViewHolder
 */
public class BindViewHolder<D extends ViewDataBinding> {
    protected D mBinding;

    public BindViewHolder(D t) {
        this.mBinding = t;
    }

    public D getBinding() {
        return mBinding;
    }
}
