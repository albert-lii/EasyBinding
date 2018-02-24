package com.ly.screen;

/**
 * 属性适配的参考标准
 */
public class AdaptiveBase {
    /* 以高度作为参考标准 */
    public static final String WIDTH = "width";
    /* 以宽度作为参考标准 */
    public static final String HEIGHT = "height";
    /* 以 Math.max( 宽,高 ) 作为参考标准 */
    public static final String MAX = "max";
    /* 以 Math.min( 宽,高 ) 作为参考标准 */
    public static final String MIN = "min";
    /* 默认原始尺寸，不做改变 */
    public static final String DEFAULT = "default";

    /**
     * 获取 px 换算比例
     *
     * @param base 参考标准
     * @return 换算比例
     */
    public static float getConversionRatio(String base) {
        float ratio = 1;
        switch (base.toLowerCase()) {
            case WIDTH:
                ratio = EasyScreen.getWidthRatio();
                break;
            case HEIGHT:
                ratio = EasyScreen.getHeightRatio();
                break;
            case MAX:
                ratio = Math.max(EasyScreen.getWidthRatio(), EasyScreen.getHeightRatio());
                break;
            case MIN:
                ratio = Math.min(EasyScreen.getWidthRatio(), EasyScreen.getHeightRatio());
                break;
            case DEFAULT:
            default:
                ratio = 1;
                break;
        }
        return ratio;
    }
}
