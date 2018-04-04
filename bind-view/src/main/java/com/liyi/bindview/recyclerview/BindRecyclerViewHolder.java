package com.liyi.bindview.recyclerview;

import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView;

/**
 * RecyclerView 的 ViewHolder 的基类
 */
public class BindRecyclerViewHolder<D extends ViewDataBinding> extends RecyclerView.ViewHolder {
    protected D mBinding;

    public BindRecyclerViewHolder(D t) {
        super(t.getRoot());
        this.mBinding = t;
    }

    public D getBinding() {
        return mBinding;
    }
}
