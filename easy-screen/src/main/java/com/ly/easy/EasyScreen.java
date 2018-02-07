package com.ly.easy;

import android.content.Context;

/**
 * @author liyi
 */
public class EasyScreen {
    /* 适配辅助类 */
    private static AdaptiveHelper mAdaptiveHelper;
    private static Context mContext;
    /* 设计稿的高度 */
    private static float mDesignHeight;
    /* 设计稿的宽度 */
    private static float mDesignWidth;

    private EasyScreen() {
        throw new UnsupportedOperationException("cannot be instantiated");
    }

    /**
     * 创建设计稿
     *
     * @param context       上下文对象（建议使用 Application 的上下文对象）
     * @param design_height 设计稿的高度
     * @param design_width  设计稿的宽度
     */
    public static void createDesign(Context context, float design_height, float design_width) {
        mContext = context;
        mDesignHeight = design_height;
        mDesignWidth = design_width;
        mAdaptiveHelper = new AdaptiveHelper(context, design_height, design_width);
    }

    /**
     * 是否使用系统栏的空间
     *
     * @param useStatusBar {@code true}: 使用状态栏空间<br>{@code false}: 不使用
     * @param useNavBar    {@code true}: 使用底部虚拟键栏空间<br>{@code false}: 不使用
     */
    public static void useSystemBar(boolean useStatusBar, boolean useNavBar) {
        checkNull();
        mAdaptiveHelper.useSystemBar(useStatusBar, useNavBar);
    }

    private static void checkNull() {
        if (mAdaptiveHelper == null) {
            mAdaptiveHelper = new AdaptiveHelper(mContext, mDesignHeight, mDesignWidth);
        }
    }

    /**
     * return 设计稿中的高度 px 与 设备实际的高度 px 的换算比例
     */
    public static float getHeightRatio() {
        checkNull();
        return mAdaptiveHelper.getHeightRatio();
    }

    /**
     * @return 设计稿中的宽度 px 与 设备实际的宽度 px 的换算比例
     */
    public static float getWidthRatio() {
        checkNull();
        return mAdaptiveHelper.getWidthRatio();
    }
}
