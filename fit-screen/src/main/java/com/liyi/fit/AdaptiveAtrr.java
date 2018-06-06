package com.liyi.fit;

import android.databinding.BindingAdapter;
import android.os.Build;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.TextView;

/**
 * 适配的属性
 */
public class AdaptiveAtrr {

    private AdaptiveAtrr() {
        throw new UnsupportedOperationException("cannot be instantiated");
    }

    /**
     * 获取换算比例
     *
     * @param base 参考标准
     * @return 换算比例
     */
    private static float getConversionRatio(String base) {
        return AdaptiveBase.getConversionRatio(TextUtils.isEmpty(base) ? AdaptiveBase.DEFAULT : base);
    }

    /**
     * =============================================================================================
     * 支持的适配属性
     * =============================================================================================
     */

    /**
     * 适配 View 的宽高
     *
     * @param view
     * @param baseWidth  宽度参考标准
     * @param baseHeight 高度参考标准
     */
    @BindingAdapter(value = {"fit_base_width", "fit_base_height"}, requireAll = false)
    public static void setLayoutSize(View view, String baseWidth, String baseHeight) {
        ViewGroup.LayoutParams lp = view.getLayoutParams();
        lp.width = (int) (lp.width * getConversionRatio(baseWidth));
        lp.height = (int) (lp.height * getConversionRatio(baseHeight));
        view.setLayoutParams(lp);
    }

    /**
     * 适配 View 的最小宽度
     *
     * @param view
     * @param minWidth 最小宽度
     * @param base     最小宽度的参考标准
     */
    @BindingAdapter(value = {"fit_layout_minWidth", "fit_base_minWidth"}, requireAll = false)
    public static void setLayoutMinWidth(View view, int minWidth, String base) {
        if (Build.VERSION.SDK_INT < 16) {
            view.setMinimumWidth((int) (minWidth * getConversionRatio(base)));
        } else {
            if (minWidth <= 0) {
                view.setMinimumWidth((int) (view.getMinimumWidth() * getConversionRatio(base)));
            } else {
                view.setMinimumWidth((int) (minWidth * getConversionRatio(base)));
            }
        }
    }

    /**
     * 适配 View 的最小高度
     *
     * @param view
     * @param minHeight 最小高度
     * @param base      最小高度的参考标准
     */
    @BindingAdapter(value = {"fit_layout_minHeight", "fit_base_minHeight"}, requireAll = false)
    public static void setLayoutMinHeight(View view, int minHeight, String base) {
        if (Build.VERSION.SDK_INT < 16) {
            view.setMinimumHeight((int) (minHeight * getConversionRatio(base)));
        } else {
            if (minHeight <= 0) {
                view.setMinimumHeight((int) (view.getMinimumHeight() * getConversionRatio(base)));
            } else {
                view.setMinimumHeight((int) (minHeight * getConversionRatio(base)));
            }
        }
    }

    /**
     * 适配 View 的外边距
     *
     * @param view
     * @param baseMargin 外边距参考标准（优先级低于单独设置外边距）
     * @param baseLeft   左外边距参考标准
     * @param baseTop    上外边距参考标准
     * @param baseRight  右外边距参考标准
     * @param baseBottom 下外边距参考标准
     */
    @BindingAdapter(value = {"fit_base_margin", "fit_base_marginLeft", "fit_base_marginTop", "fit_base_marginRight", "fit_base_marginBottom"}, requireAll = false)
    public static void setLayoutMargin(View view, String baseMargin, String baseLeft, String baseTop, String baseRight, String baseBottom) {
        ViewGroup.MarginLayoutParams lp = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        int leftMargin = (int) (lp.leftMargin * getConversionRatio(TextUtils.isEmpty(baseLeft) ? baseMargin : baseLeft));
        int topMargin = (int) (lp.topMargin * getConversionRatio(TextUtils.isEmpty(baseTop) ? baseMargin : baseTop));
        int rightMargin = (int) (lp.rightMargin * getConversionRatio(TextUtils.isEmpty(baseRight) ? baseMargin : baseRight));
        int bottomMargin = (int) (lp.bottomMargin * getConversionRatio(TextUtils.isEmpty(baseBottom) ? baseMargin : baseBottom));
        lp.setMargins(leftMargin, topMargin, rightMargin, bottomMargin);
        view.setLayoutParams(lp);
    }

    /**
     * 适配 View 的内边距
     *
     * @param view
     * @param basePadding 内边距参考标准（优先级低于单独设置内边距）
     * @param baseLeft    左内边距参考标准
     * @param baseTop     上内边距参考标准
     * @param baseRight   右内边距参考标准
     * @param baseBottom  下内边距参考标准
     */
    @BindingAdapter(value = {"fit_base_padding", "fit_base_paddingLeft", "fit_base_paddingTop", "fit_base_paddingRight", "fit_base_paddingBottom"}, requireAll = false)
    public static void setLayoutPadding(View view, String basePadding, String baseLeft, String baseTop, String baseRight, String baseBottom) {
        int leftPadding = (int) (view.getPaddingLeft() * (getConversionRatio(TextUtils.isEmpty(baseLeft) ? basePadding : baseLeft)));
        int topPadding = (int) (view.getPaddingTop() * getConversionRatio(TextUtils.isEmpty(baseTop) ? basePadding : baseTop));
        int rightPadding = (int) (view.getPaddingRight() * getConversionRatio(TextUtils.isEmpty(baseRight) ? basePadding : baseRight));
        int bottomPadding = (int) (view.getPaddingBottom() * getConversionRatio(TextUtils.isEmpty(baseBottom) ? basePadding : baseBottom));
        view.setPadding(leftPadding, topPadding, rightPadding, bottomPadding);
    }

    /**
     * 适配 TextView 的字体大小
     *
     * @param textView
     * @param base     字体大小的参考标准
     */
    @BindingAdapter("fit_base_textSize")
    public static void setTextViewSize(TextView textView, String base) {
        textView.setTextSize(TypedValue.COMPLEX_UNIT_PX, (int) (textView.getTextSize() * getConversionRatio(base)));
    }

    /**
     * 适配 TextView 的最大宽度
     *
     * @param textView
     * @param maxWidth 最大宽度
     * @param base     最大宽度的参考标准
     */
    @BindingAdapter(value = {"fit_text_maxWidth", "fit_base_textMaxWidth"}, requireAll = false)
    public static void setTextViewMaxWidth(TextView textView, int maxWidth, String base) {
        if (Build.VERSION.SDK_INT < 16) {
            textView.setMaxWidth((int) (maxWidth * getConversionRatio(base)));
        } else {
            if (maxWidth <= 0) {
                textView.setMaxWidth((int) (textView.getMaxWidth() * getConversionRatio(base)));
            } else
                textView.setMaxWidth((int) (maxWidth * getConversionRatio(base)));
        }
    }

    /**
     * 适配 TextView 的最大高度
     *
     * @param textView
     * @param maxHeight 最大高度
     * @param base      最大高度的参考标准
     */
    @BindingAdapter(value = {"fit_text_maxHeight", "fit_base_textMaxHeight"}, requireAll = false)
    public static void setTextViewMaxHeight(TextView textView, int maxHeight, String base) {
        if (Build.VERSION.SDK_INT < 16) {
            textView.setMaxHeight((int) (maxHeight * getConversionRatio(base)));
        } else {
            if (maxHeight <= 0) {
                textView.setMaxHeight((int) (textView.getMaxHeight() * getConversionRatio(base)));
            } else
                textView.setMaxHeight((int) (maxHeight * getConversionRatio(base)));
        }
    }

    /**
     * 适配 GridView 的 Item 之间的横向间距
     *
     * @param gridView
     * @param space      横向间距
     * @param baseHspace 横向间距的参考标准
     */
    @BindingAdapter(value = {"fit_grid_hspace", "fit_base_gridHspace"}, requireAll = false)
    public static void setGridViewHSpace(GridView gridView, int space, String baseHspace) {
        if (Build.VERSION.SDK_INT < 16) {
            gridView.setHorizontalSpacing((int) (space * getConversionRatio(baseHspace)));
        } else {
            if (space <= 0) {
                gridView.setHorizontalSpacing((int) (gridView.getHorizontalSpacing() * getConversionRatio(baseHspace)));
            } else {
                gridView.setHorizontalSpacing((int) (space * getConversionRatio(baseHspace)));
            }
        }
    }

    /**
     * 适配 GridView 的 Item 之间的纵向间距
     *
     * @param gridView
     * @param space      纵向间距
     * @param baseVspace 纵向间距的参考标准
     */
    @BindingAdapter(value = {"fit_grid_vspace", "fit_base_gridVspace"}, requireAll = false)
    public static void setGridViewVSpace(GridView gridView, int space, String baseVspace) {
        if (Build.VERSION.SDK_INT < 16) {
            gridView.setVerticalSpacing((int) (space * getConversionRatio(baseVspace)));
        } else {
            if (space <= 0) {
                gridView.setVerticalSpacing((int) (gridView.getVerticalSpacing() * getConversionRatio(baseVspace)));
            } else {
                gridView.setVerticalSpacing((int) (space * getConversionRatio(baseVspace)));
            }
        }
    }

    /**
     * 适配 GridView 的列宽
     *
     * @param gridView
     * @param columnWidth 列宽
     * @param base        列宽的参考标准
     */
    @BindingAdapter(value = {"fit_grid_colwidth", "fit_base_gridColwidth"}, requireAll = false)
    public static void setGridColumnWidth(GridView gridView, int columnWidth, String base) {
        if (Build.VERSION.SDK_INT < 16) {
            gridView.setColumnWidth((int) (columnWidth * getConversionRatio(base)));
        } else {
            if (columnWidth <= 0) {
                gridView.setColumnWidth((int) (gridView.getColumnWidth() * getConversionRatio(base)));
            } else {
                gridView.setColumnWidth((int) (columnWidth * getConversionRatio(base)));
            }
        }
    }

    /**
     * =============================================================================================
     * 以下针对尺寸需要在代码中计算后，传递给 xml 的情况
     * =============================================================================================
     */
    /**
     * 设置 view 的宽
     */
    @BindingAdapter("fit_layout_width")
    public static void setLayoutWidthByPX(View view, int width) {
        ViewGroup.LayoutParams params = view.getLayoutParams();
        params.width = width;
        view.setLayoutParams(params);
    }

    /**
     * 设置 view 的高
     */
    @BindingAdapter("fit_layout_height")
    public static void setLayoutHeightByPX(View view, int height) {
        ViewGroup.LayoutParams params = view.getLayoutParams();
        params.height = height;
        view.setLayoutParams(params);
    }

    /**
     * 设置 view 的左内边距
     */
    @BindingAdapter("fit_paddingLeft")
    public static void setPaddingLeftByPX(View view, int left) {
        view.setPadding(left, view.getPaddingTop(), view.getPaddingRight(), view.getPaddingBottom());
    }

    /**
     * 设置 view 的上内边距
     */
    @BindingAdapter("fit_paddingTop")
    public static void setPaddingTopByPX(View view, int top) {
        view.setPadding(view.getPaddingLeft(), top, view.getPaddingRight(), view.getPaddingBottom());
    }

    /**
     * 设置 view 的右内边距
     */
    @BindingAdapter("fit_paddingRight")
    public static void setPaddingRightByPX(View view, int right) {
        view.setPadding(view.getPaddingLeft(), view.getPaddingTop(), right, view.getPaddingBottom());
    }

    /**
     * 设置 view 的下内边距
     */
    @BindingAdapter("fit_paddingBottom")
    public static void setPaddingBottomByPX(View view, int bottom) {
        view.setPadding(view.getPaddingLeft(), view.getPaddingTop(), view.getPaddingRight(), bottom);
    }

    /**
     * 设置 view 的左外边距
     */
    @BindingAdapter("fit_layout_marginLeft")
    public static void setLayoutMarginLeftByPX(View view, int leftMargin) {
        ViewGroup.MarginLayoutParams lp = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        lp.setMargins(leftMargin, lp.topMargin, lp.rightMargin, lp.bottomMargin);
        view.setLayoutParams(lp);
    }

    /**
     * 设置 view 的上外边距
     */
    @BindingAdapter("fit_layout_marginTop")
    public static void setLayoutMarginTopByPX(View view, int topMargin) {
        ViewGroup.MarginLayoutParams lp = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        lp.setMargins(lp.leftMargin, topMargin, lp.rightMargin, lp.bottomMargin);
        view.setLayoutParams(lp);
    }

    /**
     * 设置 view 的右外边距
     */
    @BindingAdapter("fit_layout_marginRight")
    public static void setLayoutMarginRightByPX(View view, int rightMargin) {
        ViewGroup.MarginLayoutParams lp = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        lp.setMargins(lp.leftMargin, lp.topMargin, rightMargin, lp.bottomMargin);
        view.setLayoutParams(lp);
    }

    /**
     * 设置 view 的下外边距
     */
    @BindingAdapter("fit_layout_marginBottom")
    public static void setLayoutMarginBottomByPX(View view, int bottomMargin) {
        ViewGroup.MarginLayoutParams lp = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        lp.setMargins(lp.leftMargin, lp.topMargin, lp.rightMargin, bottomMargin);
        view.setLayoutParams(lp);
    }

    /**
     * 设置 textView 的字体大小
     */
    @BindingAdapter("fit_textSize")
    public static void setTextViewSizeByPX(TextView textView, int textSize) {
        textView.setTextSize(textSize);
    }
}

