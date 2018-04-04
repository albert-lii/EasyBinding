package com.liyi.example;

import com.liyi.bindview.recyclerview.BindRecyclerViewHolder;
import com.liyi.bindview.recyclerview.SimpleBindRecyclerAdapter;
import com.liyi.example.databinding.ListItemBD;

import java.util.ArrayList;

/**
 * Created by albertlii on 2018/2/6.
 */

public class RecyclerAdapter extends SimpleBindRecyclerAdapter<ListItemBD> {
    private ArrayList<String> mList;

    public RecyclerAdapter(ArrayList<String> list) {
        this.mList = list;
    }

    @Override
    public int onCreateItemView() {
        return R.layout.item_list;
    }

    @Override
    public void onBindViewHolder(BindRecyclerViewHolder<ListItemBD> holder, int position) {
        holder.getBinding().setText(mList.get(position));
    }

    @Override
    public int getItemCount() {
        return mList != null ? mList.size() : 0;
    }
}
