# 1需求分析

本系统是学生成绩管理系统，所以应该做到可以录入学生成绩，修改学生成绩，删除学生成绩，查询学生成绩，以及最后的所有学生按照GPA排名。

本系统的数据来源期末考试成绩，用来实现录入，查询，修改，删除，以及排名。

## 1.1增加学生成绩

增加学生信息主要是把学生的成绩录入系统中，录入信息包括学生学号，姓名，C++成绩，电路成绩，英语听说成绩，英语读写成绩，大学物理成绩，概率论成绩，近代史成绩，形式与政策成绩，体育成绩，离散数学成绩。

## 1.2修改学生成绩

修改学生成绩功能可以通过输入学生的学号，如果该学生在系统中，就弹出一个可以编辑的显示成绩的窗体，然后用户再编辑想要修改的成绩，如果该学生不在系统中，就弹出该学生不在系统中的提醒窗体。

## 1.3查询学生成绩

通过查询功能输入学生的学号来查询学生的所有成绩以及GPA，总分。

## 1.4删除学生成绩

通过删除学生成绩的功能输入想要删除学生的编号，然后在系统中删除该学生。

## 1.5按GPA排名

通过该功能打印出所有学生的成绩，并按照GPA进行排名

# 2 概要设计

## 2.1数据库设计

![组织结构图](file:///C:/Users/86152/AppData/Local/Temp/msohtmlclip1/01/clip_image001.png)![img](file:///C:/Users/86152/AppData/Local/Temp/msohtmlclip1/01/clip_image003.png)

## 2.2功能模块结构图

根据需求分析，为了满足用户的功能需求，将本系统主要划分为如下模块：添加、修改、查询，显示，各模块之间的关系如图2-1所示。

 

图2-1  功能模块结构图

 

# 3运行环境

\1.  硬件环境:Macintosh电脑

\2.  软件环境：操作系统：macOS Sierra

# 4开发工具和编程语言

开发环境：IDEA

编程语言：Java语言、MySQL语言



# 5详细设计

在概要设计的基础上，对每个模块进行内部逻辑处理部分详细设计。下面分别列出各个模块具体实现流程图：

## 5.1增加学生信息

输入学生的学号，姓名，一系列成绩。

判断该学生的学号是否已经在系统中，如果在，重新输入，如果不在，就用链接mysql录入系统中

![img](file:///C:/Users/86152/AppData/Local/Temp/msohtmlclip1/01/clip_image005.png)

​                     **图****5-1** **增加学生信息**

## 5.2修改学生信息

首先输入想要修改的学生成绩的学号，然后先判断该学生是否在系统中，如果在，就弹出一个可以编辑成绩的窗体，直接在窗体上编辑就行。

![img](file:///C:/Users/86152/AppData/Local/Temp/msohtmlclip1/01/clip_image007.png)

**图5-2** **修改学生信息**

## 5.3查询学生信息

通过输入学号，来查找系统中是否有该学号的学生，如果有，则显示该学生的成绩，GPA，总分，如果不存在则重新输入。具体实现过程如图5-3所示。

![img](file:///C:/Users/86152/AppData/Local/Temp/msohtmlclip1/01/clip_image009.png)

**图5-3**  **查询学生信息**

 

## 5.4删除学生信息

通过输入学号，来查找系统中是否有该学号的学生，如果有，则删除该学生的成绩，如果不存在则重新输入。具体实现过程如图5-4所示。

![img](file:///C:/Users/86152/AppData/Local/Temp/msohtmlclip1/01/clip_image011.png)

**图5-4** **删除学生信息**

## 5.5按照GPA排名

从数据库取出所有数据时候调用排序函数来把所有的学生成绩根据算出的GPA进行排序，

然后用表格控件来接受所有数据，再输出。

![img](file:///C:/Users/86152/AppData/Local/Temp/msohtmlclip1/01/clip_image013.png)

**图5-5** **按照GPA****排名**

 

6调试分析

1，首先是理解了各个窗体之间的关系，每一个窗体都可以说是一个类，而窗体的操作什么的都可以写在构造函数里，而如果想让这个窗体出现的话，直接调用这个窗体的构造函数就好了。

2.窗体操作的时候，不能用窗体的容器进行操作，要用窗体自己本身的对象进行操作。

前面定义了这个窗体的容器，但是后面显示窗体的时候，还是要用窗体本身自己的对象。

decide.add(BorderLayout.***CENTER\***, dec);*//**设置窗体显示时间，一定要用窗体对象设置！！！！！**
\* decide.add(BorderLayout.***SOUTH\***, p3);
 decide.setBounds(400, 200, 500, 500);
 decide.setVisible(**true**);

 

7运行结果

主界面功能测试：结果如图7-1所示

![img](file:///C:/Users/86152/AppData/Local/Temp/msohtmlclip1/01/clip_image015.png)

![img](file:///C:/Users/86152/AppData/Local/Temp/msohtmlclip1/01/clip_image017.png)

 

**图7-1** **主界面**

 

增加学生成绩功能测试：结果如图7-2所示

![img](file:///C:/Users/86152/AppData/Local/Temp/msohtmlclip1/01/clip_image019.png)

![img](file:///C:/Users/86152/AppData/Local/Temp/msohtmlclip1/01/clip_image021.png)

**图****7-2** **增加学生成绩**

查找学生成绩功能测试：结果如图7-3所示

![img](file:///C:/Users/86152/AppData/Local/Temp/msohtmlclip1/01/clip_image023.png)

 

![img](file:///C:/Users/86152/AppData/Local/Temp/msohtmlclip1/01/clip_image025.png)

**图****7-3** **查找学生成绩**

 

修改学生成绩功能测试：结果如图7-4所示

![img](file:///C:/Users/86152/AppData/Local/Temp/msohtmlclip1/01/clip_image027.png)

![img](file:///C:/Users/86152/AppData/Local/Temp/msohtmlclip1/01/clip_image029.png)

![img](file:///C:/Users/86152/AppData/Local/Temp/msohtmlclip1/01/clip_image031.png)

**图****7-4** **修改学生成绩**

**此时再查询该同学成绩如下：**

**![img](file:///C:/Users/86152/AppData/Local/Temp/msohtmlclip1/01/clip_image033.png)**

 

 

 

 

 

 

 

 

按学生GPA排名功能测试：结果如图7-5所示.

![img](file:///C:/Users/86152/AppData/Local/Temp/msohtmlclip1/01/clip_image035.png)

 

**图****7-5** **按照****GPA****进行排名**

 

关于：结果如图7-6所示.

 

![img](file:///C:/Users/86152/AppData/Local/Temp/msohtmlclip1/01/clip_image037.png)

**图****7-6** **关于**

 

8心得体会

在11周周末泡了两天图书馆，我的带图形界面的学生成绩管理系统终于写完了。本来老师没有强制要求要写图形界面的，但是为了挑战自己，我还是先花了半天的时间来学习图形界面的相关知识。也不算很难。

在写大作业的过程中，也遇到了一些小的Bug，比如不能用窗体的容器来执行窗体的某些操作、设置按键监听的时候也会出现一些小问题，不过问题都不大，很快就解决了。

这次大作业也算是学完图形界面理解了一会后一气呵成的，也行这种XX管理系统本来就不难吧。插入，查找，删除，查询所用的数据库操作也都很相似，用的图形界面也都差不多，在自己写出插入操作后，查找删除查询操作也很快写完了，最后又花了半小时学习JTable控件后把按照GPA排名操作写完了。

这次大作业虽然不难，但是自己也学会了很多东西，比如数据库的操作，AWT图形界面的一些容器。这些一定都是很宝贵的经验。

9参考文献

[1] 李兴华，Java开发实战经典，北京：清华大学出版社，2009

 