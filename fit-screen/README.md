# fit-screen
使用DataBinding的@BindingAdapter功能实现屏幕精准适配，适用于任何分辨率的手机

## 目录
- [原理](#原理)
- [优势](#优势)
- [注意点](#注意点)
- [属性详解](#属性详解)
- [使用方法](#使用方法)
- [预览问题](#预览问题)

## 原理 （必看！必看！必看）
本库原理与鸿洋大神的[AutoLayout][autolayout]一致，根据UI给出的设计稿的尺寸，将设计稿的尺寸与我们实际的手机的宽高尺寸进行处理换算，获取换算比例ratio，例如设计稿尺寸为320x480，我们手机的宽高尺寸为1080x1920,则获取换算比例`widthRatio=(1080/320)`，`heightRatio=(1920/480)`。我们在xml中填写尺寸时，单位都为`px`,直接填写设计稿中的px尺寸值，在程序编译时，会将`宽度 x widthRatio`,`高度 x heightRatio`，以此将我们绘制的view等比缩放，适配屏幕，做到几乎和设计图完全一致，不必再写xml时自己计算。  

## 优势
- 基于@BindingAdapter实现，简单易懂，非常容易扩展，小白也可立马上手
- 与鸿洋大神的[AutoLayout][autolayout]相比，我们只需要一次入门，即可终生使用，在任何环境，任何布局中都可以使用，鸿洋大神的[AutoLayout][autolayout]只是定义了一些基本常用的view，遇到自定义view以及google的最新控件时，则需要自己重新按照鸿洋大神的规则，为需要适配的view重写，不是很方便。
- 本库只有少数几个文件，非常轻便！

## 注意点（必看！必看！必看）
在ListView、GridView、RecyclerView的item中使用时，不要在item布局的最外层使用本库，可以嵌套一层使用，因为ListView、GridView的item的容器是ListView与GridView，他们LayoutParams不是ViewGroup.LayoutParams而是ListView.LayoutParams与GridView.LayoutParams,本库中并为对这两种LayoutParams进行处理，当然你可以根据需要，在`AdaptiveAtrr`文件种对其进行处理（虽然我认为没有这个必要）

## 属性详解
**看过原理后，我们可知，在我们的适配种，“宽度方向的1px” 与 “高度方向的1px” 是不一样大小的，所以在适配时，可以选择以宽度或者高度作为参考标准**

| 参考标准 | 描述 |
| ---- | ---- |
| width | 以屏幕宽度作为参考标准，ratio=widthRatio |
| height | 以屏幕高度作为参考标准，ratio=heightRatio |
| max | 以 Math.max( 宽,高 ) 作为参考标准，ratio=Math.max(widthRatio,heightRatio) |
| min | 以 Math.min( 宽,高 ) 作为参考标准，ratio=Math.min(widthRatio,heightRatio) |
| default | 默认原始尺寸，不做改变，ratio=1 |

| 属性 | 描述 |
| ---- | ---- |
| fit_base_width | view 的宽度参考标准 |
| fit_base_height | view 的高度参考标准 |
| fit_layout_minWidth | view 最小宽度 |
| fit_base_minWidth | view 的宽度参考标准 |
| fit_layout_minHeight | view 最小高度 |
| fit_base_minHeight | view 最小高度的参考标准 |
| fit_base_margin | view 外边距参考标准（优先级低于单独设置外边距）|
| fit_base_marginLeft | view 左外边距参考标准 |
| fit_base_marginTop | view 上外边距参考标准 |
| fit_base_marginRight | view 右外边距参考标准 |
| fit_base_marginBottom | view 下外边距参考标准 |
| fit_base_padding | view 内边距参考标准 |
| fit_base_paddingLeft | view 左内边距参考标准 |
| fit_base_paddingTop | view 上内边距参考标准 |
| fit_base_paddingRight | view 右内边距参考标准 |
| fit_base_paddingBottom | view 下内边距参考标准 |
| fit_base_textSize | textView 字体大小的参考标准 |
| fit_text_maxWidth | textView 最大宽度 |
| fit_base_textMaxWidth | textView 最大宽度的参考标准 |
| fit_text_maxHeight | textView 最大高度 |
| fit_base_textMaxHeight | textView 最大高度的参考标准 |
| fit_grid_hspace | gridView 的 Item 之间的横向间距 |
| fit_base_gridHspace | gridView 的 Item 之间横向间距的参考标准 |
| fit_grid_vspace | gridView 的 Item 之间的纵向间距|
| fit_base_gridVspace | gridView 的 Item 之间的纵向间距的参考标准 |
| fit_grid_columnWidth | gridView 的列宽 |
| fit_base_columnWidth | gridView 列宽的参考标准 |  
|------------------|----------------------------------------------|  
| fit_layout_width | 设置 view 的宽 |
| fit_layout_height | 设置 view 的高 |
| fit_paddingLeft | 设置 view 的左内边距 |
| fit_paddingTop | 设置 view 的上内边距 |
| fit_paddingRight | 设置 view 的右内边距 |
| fit_paddingBottom | 设置 view 的下内边距 |
| fit_layout_marginLeft | 设置 view 的左外边距 |
| fit_layout_marginTop | 设置 view 的上外边距 |
| fit_layout_marginRight | 设置 view 的右外边距 |
| fit_layout_marginBottom | 设置 view 的下外边距 |
| fit_textSize | 设置 textView 的字体大小 |
| fit_grid_horizontalSpacing | 设置 GridView 的 Item 之间的横向间距 |
| fit_grid_verticalSpacing | 设置 GridView 的 Item 之间的纵向间距 |
| fit_grid_columnWidth | 设置 GridView 的列宽 |

### 注意：
- fit_layout_minWidth、fit_layout_minHeight、fit_text_maxWidth、fit_text_maxHeight、fit_grid_hspace、fit_grid_vspace、fit_grid_columnWidth这几个属性，在sdk>=16时,可以使用他们的原生属性即android:minWidth=""、android:maxHeight=""...，如果设置了这些自定义属性，则以自定义属性为准；当sdk<16时，使用自定义属性

## 使用方法
1. 在Application中（或者Activity中）创建设计稿

```Java
  FitScreen .createDesign(context, height, width);
```

2. 对于要适配的属性，在xml种添加参考标准（注：所有要适配的属性，使用px作为单位，直接抄下设计稿上的px尺寸即可）
例：
```Java
 <TextView
      android:layout_width="200px"
      android:layout_height="200px"
      android:layout_gravity="center_horizontal"
      android:background="#365"
      android:gravity="center"
      android:text="200px"
      android:textColor="#ffffff"
      android:textSize="20sp"
      app:fit_base_height='@{"height"}'
      app:fit_base_textSize='@{"width"}'
      app:fit_base_width='@{"width"}' />
      
  在上述TextView中，需要适配TextView的高度、宽度以及字体大小，所以在TextView添加自定义属性  
      app:fit_base_height='@{"height"}'  ===> 以屏高作为参考标准
      app:fit_base_width='@{"width"}'    ===> 以屏宽作为参考标准
      app:fit_base_textSize='@{"width"}' ===> 以屏宽作为参考标准
```
## 预览问题
选择与创建的设计稿尺寸一致或者相近的模拟器预览即可（因为有的公司给的是IOS设计稿，没有安卓版，只能选相近的，这种情况下预览会有些偏差，不必在意，真实显示绝对与设计稿一致）

[autolayout]:http://blog.csdn.net/lmj623565791/article/details/49990941

