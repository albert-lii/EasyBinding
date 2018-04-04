package com.liyi.bindview.recyclerview;

import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView;

/**
 * RecyclerView 的适配器基类
 */
public abstract class BindRecyclerAdapter<D extends ViewDataBinding> extends RecyclerView.Adapter<BindRecyclerViewHolder<D>> {
}
