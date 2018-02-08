package com.ly.easy;

import android.databinding.BindingConversion;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;

/**
 * 常用的属性转换
 */
public class EasyConversion {

    /**
     * 将颜色值字符串转化为 ColorDrawable
     *
     * @param colorStr 颜色值字符串
     * @return ColorDrawable
     */
    @BindingConversion
    public static ColorDrawable convertColorStringToDrawable(String colorStr) {
        int color = Color.parseColor(colorStr);
        return new ColorDrawable(color);
    }
}
