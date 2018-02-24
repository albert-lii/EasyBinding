package com.ly.example;

import android.view.View;
import android.view.ViewGroup;

import com.ly.bindview.abslistview.EasyViewHolder;
import com.ly.bindview.abslistview.SimpleESBaseAdpter;
import com.ly.example.databinding.ListItemBD;

import java.util.ArrayList;

/**
 * Created by albertlii on 2018/2/6.
 */

public class ListAdapter extends SimpleESBaseAdpter<ListItemBD> {
    private ArrayList<String> mList;

    public ListAdapter(ArrayList<String> list) {
        this.mList = list;
    }

    @Override
    public int onCreateItemView() {
        return R.layout.item_list;
    }

    @Override
    public void onBindViewHolder(EasyViewHolder<ListItemBD> holder, int position, View convertView, ViewGroup parent) {
        holder.getBinding().setText(mList.get(position));
    }

    @Override
    public int getCount() {
        return mList != null ? mList.size() : 0;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }
}
