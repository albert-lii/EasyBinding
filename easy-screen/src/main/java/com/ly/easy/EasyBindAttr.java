package com.ly.easy;

import android.databinding.BindingAdapter;
import android.view.View;

/**
 * 常用的属性
 */
public class EasyBindAttr {
    /**
     * 设置 selected 属性（部分 View 在 xml 中不支持 selected 属性）
     *
     * @param view
     * @param isSelected
     */
    @BindingAdapter("eb_selected")
    public static void setSelected(View view, boolean isSelected) {
        view.setSelected(isSelected);
    }
}
