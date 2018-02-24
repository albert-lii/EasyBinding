package com.ly.screen;

import android.content.Context;
import android.graphics.Point;
import android.os.Build;
import android.util.DisplayMetrics;

/**
 * 适配辅助类
 */
public class AdaptiveHelper {
    /* 设计稿的高度 */
    private float mDesignHeight;
    /* 设计稿的宽度 */
    private float mDesignWidth;
    /* 设计稿中的高度 px 与 设备实际的高度 px 的换算比例 */
    private float mHeightRatio;
    /* 设计稿中的宽度 px 与 设备实际的宽度 px 的换算比例 */
    private float mWidthRatio;
    /* 设备屏幕的尺寸 */
    private Point mScreenSize;
    /* 状态栏的高度 */
    private int mStatusBarHeight;
    /* 底部虚拟键的高度 */
    private int mNavBarHeight;

    public AdaptiveHelper(Context context, float design_height, float design_width) {
        this.mDesignHeight = design_height;
        this.mDesignWidth = design_width;
        this.mScreenSize = getScreenSize(context);
        this.mStatusBarHeight = getStatusBarHeight(context);
        this.mNavBarHeight = getNavBarHeight(context);
        caculateConversionRatio();
    }

    /**
     * 计算设计稿尺寸与设备实际尺寸之间的换算比例
     */
    private void caculateConversionRatio() {
        mWidthRatio = mScreenSize.x / mDesignWidth;
        useSystemBar(false, false);
    }

    /**
     * 是否使用系统栏的空间
     *
     * @param useStatusBar {@code true}: 使用状态栏空间<br>{@code false}: 不使用
     * @param useNavBar    {@code true}: 使用底部虚拟键栏空间<br>{@code false}: 不使用
     */
    public void useSystemBar(boolean useStatusBar, boolean useNavBar) {
        int h;
        // android 从 3.2 版本开始获取屏幕区域高度会自动减去状态栏高度
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.HONEYCOMB_MR2) {
            h = mScreenSize.y - (useStatusBar ? 0 : mStatusBarHeight) - (useNavBar ? 0 : mNavBarHeight);
        } else {
            h = mScreenSize.y + (useStatusBar ? mStatusBarHeight : 0) - (useNavBar ? 0 : mNavBarHeight);
        }
        mHeightRatio = h / mDesignHeight;
    }

    /**
     * 获取屏幕尺寸
     *
     * @param context 上下文对象
     * @return 屏幕尺寸（SDK >=13 后，高度不包含状态栏）
     */
    private Point getScreenSize(Context context) {
        DisplayMetrics dm = context.getResources().getDisplayMetrics();
        return new Point(dm.widthPixels, dm.heightPixels);
    }

    /**
     * 获取状态栏的高度
     *
     * @param context 上下文对象
     * @return 状态栏的高度
     */
    private int getStatusBarHeight(Context context) {
        int result = 0;
        int resourceId = context.getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (resourceId > 0) {
            result = context.getResources().getDimensionPixelSize(resourceId);
        }
        return result;
    }

    /**
     * 获取底部虚拟键的高度
     *
     * @return 底部虚拟键的高度
     */
    private int getNavBarHeight(Context context) {
        int result = 0;
        int resourceId = 0;
        // 判断底部虚拟键是否显示
        int rid = context.getResources().getIdentifier("config_showNavigationBar", "bool", "android");
        if (rid != 0) {
            resourceId = context.getResources().getIdentifier("navigation_bar_height", "dimen", "android");
            if (resourceId > 0) {
                result = context.getResources().getDimensionPixelSize(resourceId);
            }
        }
        return result;
    }

    public float getHeightRatio() {
        return mHeightRatio;
    }

    public float getWidthRatio() {
        return mWidthRatio;
    }
}
