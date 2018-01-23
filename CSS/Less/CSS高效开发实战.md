## CSS高效开发实战

### 1. CSS3 基本特性
`
CSS 全称为Cascading Style Sheet,层叠样式表。用于展示网页样式和布局的标记语言。
`
1 圆角: border-radius

2 阴影: 可以为元素的边界(box-shadow)和文字(text-shadow)设置阴影.

3 渐变: 渐变(gradients)是CSS3为background-image属性新增的参数。渐变参数如下：
    
    · linear-gradient: 纵向渐变
    · radial-gradient: 横向渐变
    · repeating-linear-gradient: 重复的纵向渐变
    · repeating-radial-gradient: 重复的横向渐变
   
4 变换: 使用变换(transform)属性对元素进行位移、偏移、拉伸、旋转等操作。

    · 旋转：transform:rotate(-15deg)   transform:rotate(-15deg)
    · 缩放：transfrom:scale(.8) transform:scale(1.2)
    · 扭曲：transfrom:skew(-5deg)  transfrom:skew(-5deg, -5deg)

5 动画: 制作动画需要 _@keyframe_ 规则。

6 媒介查询: 媒介查询(media query)功能，使我们可以根据浏览器窗口或设备尺寸来应用不同的CSS样式，从而实现对不同设备的适配。
  随着开发者和设计者适配不同的设备的经验积累和各种技术的增进，一套方法论被逐渐总结出来，称之为 __响应式设计__ 。
  
* 使用 _modernizr_ 检测浏览器是否支持CSS3。它是一个检测浏览器对HTML5和CSS3特性是否支持的JavaScript库。
使用方式就是把"modernizr-1.5.js"引入即可。

### 2 HTML CSS基础
#### 2.1 盒子模型
一个块级元素，包括内容、外边距、边框、内边距4个组成部分，不设定时，内外编剧和边框都没有。设置内外边距和边框就像为商品套上包装盒一样。
这就是“盒子模型”的由来。

1. 内容
    元素框最内部分是实际内容，直接包围内容的是内边距(padding)，它呈现了元素的背景。内边距的边缘叫边框，边框以外的是外边距(margin)，
    外边距默认是透明的，因此不会遮挡其后的元素。
2. 内边距和边框
    内边距和边框主要的作用是装饰。
3. 外边距
    外边距主要用于布局，目的是控制元素之间的距离。
