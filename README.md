# EasyBinding
[![jitpack][jitpacksvg]][jitpack] ![release][releasesvg] ![apisvg] [![license][licensesvg]][license] ![statussvg]

## 关于
EasyBinding是基于Android Studio的DataBinding实现的库，主要包含`easy-screen`和`easy-view`两个库。其中`easy-screen`巧妙的使用DataBinding的特性，只需三个文件，轻松实现Android屏幕精准适配；`easy-view`是将ListView、GridView、RecyclerView与DataBinding结合使用的库，让你的代码更简洁！

## 特点
- `fit-screen`与`bind-view`都只有少数几个文件，非常轻便
- `fit-screen`基于DataBinding的 @BindingAdapter功能实现，可任意修改扩展

## 文档
- [fit-screen（屏幕适配）][fit-screen]
- [bind-view（与ListView、GridView、RecyclerView的结合使用）][bind-view]

## 使用方法
- Step 1：  
```Java
  在项目工程的build.gradle中添加以下代码
  // 注：如果添加依赖成功，则此句不必添加，此句作用仅为当项目在被审核时，紧急需要使用时添加
   allprojects {
       repositories {
           ...
           // 如果添加依赖时，报找不到项目时（项目正在审核），可以添加此句maven地址，如果找到项目，可不必添加
           maven { url "https://dl.bintray.com/albertlii/android-maven/" }
       }
    }

```
- Step 2：  
```Java
dependencies {
    // 不需要全部添加，使用哪个，添加哪个依赖
   compile 'com.liyi.binding:fit-screen:1.0.4'
   compile 'com.liyi.binding:bind-view:1.0.4'
}
```
- Step 3：  
```Java
在项目的gradle（不是工程gradle）的android{...}中添加
  // 使用dataBinding
  dataBinding {
      enabled = true
  }
```
## fit-screen使用时，注意！注意！注意！（本人强烈推荐直接将fit-screen中的文件直接拷贝到项目中，更加方便扩展）
- 如果在使用gradle依赖后，一直不能找到fit-screen项目中的自定义属性，报错binding error，推荐将fit-screen中的文件拷贝到项目中（强烈推荐，更加方便项目扩展），或者导入easy-screen包则可解决！
- **加载布局时使用DataBinding加载布局，例如在Activity中加载布局，使用DataBindingUtil.setContentView()代替setContentView()，在ListView的适配器中，自定义布局中等等，凡是使用到适配的，都要用DataBinding加载布局**
- xml布局文件要遵守DataBinding的规则

## 赞赏
如果你感觉 `EasyBinding` 帮助到了你，可以点右上角 "Star" 支持一下 谢谢！:blush:

## LICENSE
Copyright 2018 liyi

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

   http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.


[fit-screen]:https://github.com/albert-lii/EasyBinding/blob/master/fit-screen/README.md
[bind-view]:https://github.com/albert-lii/EasyBinding/blob/master/bind-view/README.md
