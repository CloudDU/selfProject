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
##### 2.3.2 清除浮动
清楚浮动主要应用CSS的clear属性，其定义了元素的哪一侧不允许出现浮动元素，可选项有left、right、both.
(1) 在需要的地方天机定义了clear:both的空标签。
(2) 对父元素使用:after伪类。
注意：IE6/7不支持:after伪类，需要添加zoom:1兼容代码。
### 2.4 CSS定位技术
CSS使用top、left、right、bottom设置元素的二维（x,y轴）偏移量，使用z-index设置元素垂直于屏幕的方向，z轴的偏移量。
使用position选项定义元素的定位属性，该属性有5个可选项：static、relative、absolute、fixed、inheirt，默认值是static。
inferit属性表示继承父元素的定位属性。relative和static都是相对于文档其他元素进行定位，都属于相对定位的范畴，区别是是否可以控制位移。
#### 2.4.1 相对定位
1. static 若使用默认值，则再为元素定义top,left,right,botoom,z-index都不会生效。
2. relative 表现和static一样，不过可以通过设置偏移量和z-index控制其相对于正常位置的偏移。若只写postion:relative，而没有写
top/left/z-index等值时其情况和默认值是一样的。
#### 2.4.2 绝对定位
特点：
* 块级元素的宽度在未定义时不再为100%，而根据内容自动调整。
* 在不定义z-index时，absolute元素会覆盖其他元素之上。
* 它会脱离正常的文档流，不占空间，类型浮动后的效果。
1. absolute 是相对上一个不为static的元素进行绝对定位。即若不指定父元素的position，absolute将相对整个html文档进行绝对定位。
2. fixed 生成绝对定位的元素，相对于浏览器窗口进行定位。例如不论网页如何滚动，希望侧边框始终对用户可见，即可以使用postion:fixed定位。

### 3CSS选择器让样式更健壮
#### 3.1 基础选择器
1. 标签选择器 是最简单的选择器，其命名只要和对应的html标签相同即可。
下面是Bootstrap框架中关于标题的全局定义：
`h1,h2,h3,h4,h5,h6`{
`magrin:10px 0;`
`font-family:inherit;`
`font-weight:bold;`
`line-height:20px;`
`color:inherit;`
`text-rendering:optimizelegibility;`
}
`h1,h2,h3`{
`line-height:40px;`
}
`h1{font-size:38.5px;}`
`h2{font-size:31.5px;}`
`h3{font-size:24.5px;}`
`h4{font-size:17.5px;}`
`h5{font-size:14px;}`
`h6{font-size:11.9px;}`
2. 类选择器 也叫class选择器，其命名为在class名称前加一个"."。
3. id选择器 语法是在id的名称前加一个"#"。因为一个元素只能有一个id,所以id选择器的灵活性不如class选择器。
其用途一本是：
    * id选择器拥有最高的权重，因此可以用于覆盖之前的一些定义。
    * 和后台数据对应，从而配合JavaScript进行逻辑操作。
4. 通配符选择器(universal selector) 就是用一些符号代替某些字符。其被CSS从CSS2时代开始引入。如
*{color:red}; 其效果是将文档中每个元素都显示为红色。这个声明等价于列出文档中所有的元素的一个分组选择器。
实际开发中通配符选择器可以用于定义全局样式，不过使用标签选择器也能获得类似的效果。如：
body{color:red} html{color:red}。 注：通配符的权重是最低的，只要有其他定义，在通配符的定义就会被覆盖。
5. 子元素选择器 使用">"符号。">"的左边是父元素，右边是子元素。必须是严格意义上的“父子关系”。
6. 后代元素选择器 其类似于子元素选择器，但要求没有子元素选择器严格，使用空格符号。空格前为父元素，后为后代元素。 
7. 相邻元素选择器 使用"+"符号。使用条件是：
    * 二者必须拥有同一个父元素
    * 二者相邻
8. 属性选择器 使用"[]"符号。如
[title]{color:red}; 表示所有拥有title属性的元素的文字颜色设为红色。
a[href][title]{color:red};表示同时拥有href和title属性的a标签的文字颜色设为红色。
a[src ^= "https"]; 选择其src属性值以“https”开头的每个a元素；
a[src $= ".pdf"]; 选择其src属性值以“.pdf”结尾的每个a元素；
a[src *= "abc"]; 选择其src属性值包含“abc”子串的每个a元素；
9. 组选择器 使用","符号。例如h1,h2,h3{font-weight:bold}。
10. 复合选择器 如果说组选择器相当于并集，或者是或(||)，则复合选择器就表示为与(&)。使用"."符号，如
p.test{color:red}.表示p标签且class为test的元素的文字设置为红色。

#### 3.2 伪类选择器
伪类表示元素的状态：排序、鼠标是否悬停、是否已被访问过、光标是否指向等。
CSS2中只有:hover、:active、:visited、:link、:first-child、:lang 等有限的几种伪类选择器。CSS3添加了大量的伪类选择器。
1. 结构化伪类 
    即根据文档的结构来选取元素。首先给一样例：
    `<style>
    ul > li
    {
    display:inline-block;
    height:24px;
    line-height:24px;
    width:24px;
    font-size:15px;
    text-align:center;
    background-color:rgb(226,129,129);
    brder-radius:4px;
    margin:5px;
    }
    </style>
    `
    `<ul class="test">`
    `<li>1</li>`
    `<li>2</li>`
    `<li>3</li>`
    `<li>4</li>`
    `<li>5</li>`
    `<li>6</li>`
    `<li>7</li>`
    `<li>8</li>`
    `<li>9</li>`
    `<li>10</li>`
    `</ul>`
    `<div>`
    `<ul class="test_one">`
    `<li>1</li>`
    `<li>2</li>`
    `<li>3</li>`
    `<li>4</li>`
    `<li>5</li>`
    `<li>6</li>`
    `<li>7</li>`
    `<li>8</li>`
    `<li>9</li>`
    `<li>10</li>`
    `<ul>`
    `</div>`
    
    * :nth-child(n) 选择器表示选择某个父元素的第n个X（:之前的符号）元素。如：
    li:nth-child(2){
    background-color:red;
    color:green;
    }
    表示取某个父元素内第2个`<li>`元素，即需要同时满足是第2个元素，且为`<li>`元素。
    如果n没有取指定的值，则表示全选；如果写为2n则表示所有的偶数项。如果设为3n的话，
    则表示取3,6,9项；如果设为2n+1,则表示取所有的奇数项。如果设为n+3,则表示从第3个
    元素开始进行全选。
    * :nth-last-child(n) 类似于nth-child(n)，只是多了last,即是从最后一个元素开始计算。
    * :nth-of-type(n) 类似于nth-child(n),区别是后者，如果是p:nth-child(4),一旦
    第4个元素不是`<p>`元素，则该选择器不起作用。而前者，如果是p:nth-of-type(4),则查询
    的是第4个`<p>`元素。如果:符号前不设置元素，则表示选择所有的元素的第n个元素。
    * :nth-last-of-type(n) 类似于nth-of-type,只是从最后一个元素开始计算。
    * :last-child(n) 表示选择最后一个子元素。
    * :first-of-type 和 :last-of-type. 前者相当于:nth-of-type(1),后者相当于:nth-last-of-type(1)
    * :only-child 表示若一个父元素只有一个子元素，则选择这个子元素。
    * :only-of-type 类似only-child 
    * :root 选择文档的根元素
    * :empty 选择没有任何内容的元素

2. 目标伪类 :target
URL前面有个锚名称#，指向文档内某个具体的元素，称为目标元素。“:target”选择器可用于选取当前活动的目标元素。

3. 状态伪类 但是IE6-8不支持，所以实战中不推荐使用，而是要属性选择器代替实现相同的效果。
    * :enabled 和 :disabled 表单元素可以设置disabled属性表示禁用，:enabled选择器用于选择所有可用的元素，
    而:disabled则用于选择所有已禁用的元素。
    * :checked选择器用于选择所有被选中的checkbox或radio标签
    * :indeterminate和:default 前者用来指定当页面打开时，某组中的单选框或复选框元素还没有选取状态时的样式；
    后者用来指定当前元素处于非选取状态的单选框或复选框的样式。【只有Opera浏览器支持，所以不建议使用】
4. 否定伪类 :not(s) 选择非指定元素的每个元素。

### 4让字体更炫
#### 4.1定义字体
1. font/font-family属性定义传统的字体样式；使用@font-face属性可以加载服务器的字体文件，其语法是：
    @font-face{
        font-family:myFont;
        src:url('Sansation_Light.ttf');
    }
    div{
        font-family:myFont;
    }
    @font-face还可以添加字体图标，目前非常流行的字体图标插件Font Awesome。引入相应的CSS和字体文件后，就可以
    在使用的地方用“<i class='图标类'></i>”进行使用。
2. box-reflect属性目前只有webkit核心浏览器支持。它可以让文字、图片等具有反射的效果。其语法是：
    .box-reflect:{<方向><间距><渐变效果>}
    方向有：above、below、left、right;
    间距：表示倒影和元素本身之间的额外距离;
    渐变效果：none:无遮罩图像；<url>：使用绝对或相对地址指定遮罩图像；<linear-gradient>使用线性渐变创建遮罩图像；
        <radial-gradient>使用径向渐变创建遮罩图像；<repeating-linear-gradient>使用重复的线性渐变创建遮罩图像；
        <repeating-radial-gradient>使用重复的径向渐变创建遮罩图像。
    效果实例见(box-reflect.html)
3. 字体阴影-光晕、浮雕、投射效果
    text-shadow:h-shadow v-shadow blur color;一个四个参数，分别是水平偏移量，垂直偏移量，模糊程度和颜色。
    当偏移量设为0，就可以构建出光晕的效果；当垂直偏移量和水平偏移量设置相同的值就可以构建凸起的浮雕效果，设置不一样
    则会出现投影的效果。
4. 字体描边(text-stroke)目前只有webkit核心浏览器支持。实际开发可以通过text-shadow来实现。
    将每个方向上都添加模糊之为0的阴影即可。
    text-shadow:#000 1px 0 0,#000 0 1px 0,#000 -1px 0 0,#000 0 -1px 0;
5. 字体分栏.CSS3有多列效果，需要以下属性：
    * column-count:定义分列的数量;
    * column-gap:定义每一列中间的宽度;
    * column-rule:定义分栏中间的样式;语法为:样式宽度 样式类型 样式颜色
    其中样式类型有：none:没有定义规则；hidden:定义隐藏规则；dotted:点状规则；dashed:虚线规则；
    solid:实线规则；double:双线规则；groove:3Dgrooved规则，取决于宽度和颜色（以下相同）；ridge，inset,outset；
6. 文字溢出/破字处理 使用text-overflow属性，其参数有：clip:修剪文本；ellipsis:显示省略号来代表被修剪的文本；
    string:使用给定的字符串来代表被修剪的文本。
### 5 背景和颜色
#### 5.1 背景
1. 背景图大小 使用background-size属性，其有两个参数，第一个是宽度，第二个是高度。如果只设一个值，则高度默认为auto.有两个可选项：
cover和contain. cover相当于宽度等于元素的宽度，高度设为auto；contain相当于高度等于元素的高度，宽度设为auto。
2. 图层实现多背景 图层的上下是按照书写顺序而定。
3. 显示位置 background-origin属性，指定背景图片的起始位置。正常情况是从内边距的左上角开始延展，而该属性可以指定从边框的
左上角(border-box)、内边距左上角(padding-box)、内容左上角(content-box)开始延展。
4. 显示区域 backgroung-clip属性，指定背景图片的显示区域，可以是在边框部分也显示背景；在外边距内显示背景；在内容区域显示背景。
#### 5.2 颜色
CSS最基础的颜色模式是和计算机系统一致的RGB颜色，后来也支持多种颜色模式，包括在RGB模式基础上增加的透明通道的RGBA模式和工业界
常用的HSLA模式。
1. RGBA颜色模式 RGB是红(red)、蓝(blue)、绿(green)三种颜色的缩写，它们是光的三原色（美术中颜料的三原色是红黄蓝）。
通过这三种颜色理论可以调出除了黑色以外的任何颜色。RGB颜色模式使用RGB模型为图像中每一个像素的RGB分量分配一个0~255范围内的强度值。
可以调出(256*256*256=16777216)颜色。RGBA就是在RGB的基础上增加了Alpha透明度的参数。其值从0%~100%.
2. HSLA模式 是色调(Hue)、饱和度(Saturation)、亮度(Light)、透明通道(Alpha)的缩写。
backgound:hsla(0,100%,100%,1)等同于backgroung:red;其四个参数的解释：
    * 色调(Hue)：0（或360）表示红色，120表示绿色，240表示蓝色。可取其他数值表示其他颜色。
    * 饱和度(Saturation)：取值为0%~100%之间的值。
    * 亮度(Light)：取值为0%~100%之间的值。
    * 透明通道(Alpha)：取值为0%~100%之间的值。
3. 透明颜色 使用opacity属性设置，其值为0~1的值。还可以是inherit。
4. 线性渐变 background:linear-gradient属性。其3个参数：方向、起始颜色、结束颜色。简单模式只需设定起始颜色和结束颜色，起点，终点和方向
默认自元素的顶部到底部。如果要设置从左到右，就需要设置linear-gradient(left,red,blue)或者将left换成to right。
渐变还可以使用角度来表示，0deg,90deg,180deg,270deg分别对应to top,to right, to bottom, to left.还可以设置渐变色为多个颜色，
例如彩虹（7种颜色）background: linear-gradient(red,orange,yellow,green,blue,indigo,violet);。
5. 放射渐变 线性渐变是从一个方向向相对方向的色彩渐变效果，而放射渐变则用于表现从中心向外发散的色彩渐变效果。
使用radial-gradient.其只需要定义颜色即可。background: radial-gradient(red,orange,yellow);默认是按照颜色均匀渐变，
也可以设置不同颜色所占据的比例,background: radial-gradient(red 5%,orange 15%,yellow 60%);还可以设置渐变中心的位置，
使用buttom left（未测试），还有其他的一下参数，如形状有circle（圆）和ellipse(椭圆).尺寸如下：
    * closest-side 指定径向渐变半径长度为从圆心到离圆心最近的边
    * closest-corner 指定径向渐变的半径长度为从圆心到离圆心最近的角
    * farther-side 指定径向渐变半径长度为从圆心到离圆心最远的边
    * farther-corner 指定径向渐变半径长度为从圆心到离圆心最远的角
    * contain 包含，指定径向渐变半径长度为从圆心到离圆心最近的点
    * cover 覆盖,指定径向渐变半径长度为从圆心到离圆心最远的点
### 6 个性边框
CSS3新增了3种边框(border)属性:border-radius(圆角)、box-shadow(边框阴影)、border-image(图片边框)。
1. 圆角属性：border-radius其参数可以是具体的整数值，也可以是百分比。还可以设置不同位置的圆角：
    * border-top-left-radius:20px; 左上角
    * border-top-right-radius:20px; 右上角
    * border-bottom-left-radius:20px; 左下角
    * border-bottom-right-radius:20px; 右下角
2. 边框阴影：其有一下参数：
    * h-shadow:必须，水平阴影的位置，允许负值；
    * v-shadow:必须，垂直阴影的位置，允许负值；
    * blur:可选，模糊距离；
    * spread:可选，阴影的尺寸；
    * color:可选，阴影的颜色；
    * inset:可选，将外部阴影（outset）改为内部阴影。
    其参数的组合顺序是：color,水平偏移，垂直偏移，模糊距离，阴影尺寸 inset.
2.1 内外阴影： 外阴影：box-shadow:0 0 30px 10px; 内阴影：boxshadow:0 0 30px 10px inset;
2.2 偏移量：box-shadow:10px 10px 30px 10px; 对于外阴影，相当于把阴影从图形的正后方，向右下进行了偏移；
    box-shadow:10px 10px 30px 10px inset;对于内阴影，相当于图形内部没有被阴影覆盖的部分向右下进行了偏移。
2.3 阴影尺寸：指的是阴影外延出去总的长度。
2.4 模糊距离.
3. 图片边框 实际使用较少。参数：
    * border-image-source:用在边框的图片的路径。
    * border-image-slice:图片边框内偏移。
    * border-image-width:图片边框的宽度。
    * border-image-outset:边框图像区超出边框的量。
    * border-image-repeat:图像边框是否应平铺（repeat)、铺满(round)或拉伸(stretch)
4. resize属性改变输入框大小。其参数有：
    * none 用户无法调整元素的尺寸；
    * both 可调整元素的高度和宽度；
    * horizontal 可调整元素的高度；
    * vertical 可调整元素的宽度。
    目前只有webkit核心浏览器支持此属性。
### 7 变换和动画
#### 7.1 CSS3的变换类型
变换（transform）属性主要有两个作用：1构建一些CSS2中难以构造的图形，2配合javaScript制作更丰富的动画。
1. 旋转边框（rotate）
    rotate()传入一个角度值作为参数，元素将沿着中轴线顺时针偏转和这个角度值。还可以使用rotateX()和rotateY()
    分别表示沿着x轴和y轴方向旋转。rotateZ等同于rotate.还可以使用rotate3d(x,y,z,deg)，编辑x,y,z的值构建三维向量，
    最后一个参数是偏转的角度。
2. 扭曲变换(skew)
    skew(xdeg,ydeg)两个参数分别是x轴上的偏转角度和y轴上的偏转角度。
3. 比例缩放(scale)
    scale(x,y)两个参数分别是x和y轴上的缩放比例.
4. 位移变换(translate)
    translate(x,y)两个参数分别是x和y轴上位移的像素。
