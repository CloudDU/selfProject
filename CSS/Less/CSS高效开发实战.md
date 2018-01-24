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
#### 2.2 跨浏览器CSS
兼容性问题有很多，解决方式也有很多，其中一种是通过条件注释(conditional comment)让不同的浏览器来加载不同的CSS。如下：
    `<!--[if !IE]><!-->` 初IE外都可以识别 `<!--<![endif]>-->`
    `<!--[if IE]>` 所有的IE都可以识别 `<![endif]>`
    `<!--[if IE 6]>` 仅IE6可以识别 `<![endif]>`
    `<!--[if lt IE 6]>` IE6及以下版本可以识别 `<![endif]>`
    `<!--[if gte IE 6]>` IE6及以上版本可以识别 `<![endif]>`


浏览器的属性前缀：
* -webkit: webkit核心浏览器，包括Chrome,Safari
* -moz: Firefox浏览器
* -ms: IE浏览器
* -o: Opera浏览器

#### 2.3 浮动布局
##### 2.3.1 设置浮动
float属性具有4个可选项：none、left、right、inherit。其中none为默认值，即不浮动。inherit表示继承父元素的float值。
而left、right分别是向左侧浮动和向右侧浮动。
（1）对于块级元素而言，不设置宽度时，默认为100%。一旦设置了浮动，它的宽度就会根据内容进行自动调整。
（2）设置了浮动的元素会脱离正常的文档流。设置浮动后，元素会在y轴和z轴上浮动。如，默认情况，父元素的高度会根据子元素的内容
自动进行调整，而如果子元素设置了浮动，父元素的高度就会变为0.
（3）虽然浮动元素脱离了文档流，但里面的内容仍会占据空间，并会根据相对位置进行布局。
##### 2.3.2 清楚浮动
清楚浮动主要应用CSS的clear属性，其定义了元素的哪一侧不允许出现浮动元素，可选项有left、right、both.
(1) 在需要的地方天机定义了clear:both的空标签。
(2) 对父元素使用:after伪类。
注意：IE6/7不支持:after伪类，需要添加zoom:1兼容代码。


