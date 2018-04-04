package com.liyi.fit;

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
                ratio = FitScreen.getWidthRatio();
                break;
            case HEIGHT:
                ratio = FitScreen.getHeightRatio();
                break;
            case MAX:
                ratio = Math.max(FitScreen.getWidthRatio(), FitScreen.getHeightRatio());
                break;
            case MIN:
                ratio = Math.min(FitScreen.getWidthRatio(), FitScreen.getHeightRatio());
                break;
            case DEFAULT:
                ratio = 1;
                break;
            default:
                throw new IllegalArgumentException("invalid parameter ===> " + base);
        }
        return ratio;
    }
}