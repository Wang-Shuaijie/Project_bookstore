select * from USERINFO;
--用户表
drop table userinfo;
create table userinfo(
userid varchar2(20) primary key,
password varchar2(20),
country varchar2(20),
province varchar2(20),
city varchar2(20),
street1 varchar2(60),
street2 varchar2(60),
zip varchar2(20),
homephone varchar2(20),
officephone varchar2(20),
cellphone varchar2(20),
email varchar2(20)
);
--出版社
drop table publish;
create table publish(
id number primary key,
name varchar2(60)
);
--书的类型
drop table category;
create table category(
id number primary key,
name varchar2(20),
description varchar2(100)
);
--商品
drop table product;
create table product(
id number primary key,
name varchar2(60),
writer varchar2(100),
price number,
publish_id number references publish(id),
page number,
category_id number references category(id),
description varchar2(2000),
images varchar2(100)
);
--支付方式
drop table payway;
create table payway(
id number primary key,
name varchar2(20)
);
--订单状态
drop table orderstatus;
create table orderstatus(
id number primary key,
name varchar2(22),
description varchar2(1000)
);
--订单
drop table orders;
create table orders(
id number primary key,
user_id varchar2(20) references userinfo(userid),
payway_id number references payway(id),
name varchar2(22),
orderstatus_id number references orderstatus(id),
cost number
);
--订单项
drop table orderline;
create table orderline(
id number primary key,
order_id number references orders(id),
product_id number references product(id),
num number
);
--支付方式的插入
insert into payway values(1,'货到付款');
insert into payway values(2,'邮局汇款');
insert into payway values(3,'银行转账');
--订单状态插入
insert into orderstatus values(1,'等待处理','等待处理');
insert into orderstatus values(2,'正在处理','正在处理');
insert into orderstatus values(3,'处理完成','处理完成');
--书的类型插入
insert into category values(1,'计算机','计算机');
insert into category values(2,'英语','英语');
insert into category values(3,'自然科学','自然科学');
--出版社录入
insert into publish values(1,'电子工业出版社');
insert into publish values(2,'机械工业出版社');
--书的录入
insert into product values(1,'JAVA编程思想：第3版','(美)Bruce Eckel',95,2,796,1,'从本书获得的各项大奖以及来自世界各地的读者评论中，不难看出这是一本经典之作。本书作者有多年的教
					学经验，对C、C++、Java语言都有独到、深入的理解。因此他非常了解如何教授Java语言这门课程，也非
					常明白语言教学中的难点及人们的困惑。作者以通俗易懂及小而直接的示例解释了一个个晦涩抽象的概念，
					精心选取“对读者理解Java语言来说最为重要”的部分编写成书。同时又在随书光盘中提供了大量参考材料
					—这也是本书绝对物超所值的地方。
						随书光盘没有包含本书的源代码（可以从支持网站www.MindView.net免费下载），而是提供了大量
					作者讲授的讨论课内容及本书的前2版内容。
							本书内容丰富—从Java的基础语法到最高级特性，适合各层次的Java程序员阅读，同时也是高等
					院校讲授面向对象程序设计语言及Java语言的绝佳教材。','images/product/zcover.gif');
insert into product values(2,'精通Hibernate：Java对象持久化技术详解','孙卫琴',59,2,600,1,'孙卫琴的计算机书籍 创作心得:<br>
　　						如果说书的结构好比房屋的框架，书的内容则好比房屋的具体组成元素。计算机书的内容的形式分为：
					文字、 表格、图和范例。为了把某种知识讲清楚，常常需要综合使用这四种形式的元素......
					:<br>
　　						继《Tomcat 与 Java Web开发技术详解(含光盘)》和《精通Struts：基于MVC的Java Web设计与
					开发(含光盘)》之后，应广大读者的强烈要求，孙卫琴的又一力作《精通Hibernate：Java对象持久化技术
					详解》，正处在迎接面市的准备当中。
						Hibernate是一个基于Java的开放源代码的持久化中间件，它对JDBC作了轻量级封装，不仅提供ORM
					映射服务，还提供数据查询和数据缓存功能，Java开发人员可以方便的通过Hibernate API来操纵数据库。
						现在，越来越多的Java开发人员把Hibernate作为企业应用和关系数据库之间的中间件，以节省和对象
					持久化有关的30%的JDBC编程工作量。 2005年，Hibernate作为优秀的类库和组件，荣获了第15届Jolt大奖。
					Hibernate之所以能够流行，归功于它特有的优势。<br>
　　						本书结合大量典型的实例，详细介绍了运用目前最成熟的Hibernate2.1版本进行Java对象持久化的技术。
					Hibernate是连接Java 对象模型和关系数据模型的桥梁，通过本书，读者不仅能掌握用Hibernate工具对这两
					种模型进行映射的技术，还能获得设计与开发Java对象模型和关系数据模型的先进经验。','images/product/zcover2.gif');
insert into product values(3,'Java 2核心技术（第6版） 卷I：基础知识','(美)Gary Cornell',75,2,698,1,'如果你已经是Java程序员，想了解Java的最新特性，该怎么办呢?去问一问身边的Java专家，他们会告诉
			你：《Java核心技术》通过提供实战指导，能够使你快速掌握Java精髓，完成最具挑战性的任务。这也正是它能连续7
			年在世界范围内成为最畅销书籍的原因。<br>
　　				本书全面讲述了标准 Java 2 1．4版本的基本知识，涵盖了从正则表达式到高性能I／O这样的主要新特性。从中能
			够读到关于面向对象的Java平台开发的经典阐述，以及全面更新了的 Swing用户界面开发及其他更多内容。最重要的是
			，第6版包含了更多值得信赖的实用程序(本书一直就是以这些实用程序而著称)，并且进行了更新，反映了最近的SDK特
			性和发展!<br>
　　				本书为Java平台开发者提供了以下新信息：<br>
		　　●Swing GUI开发——包括输入验证和其他增强特性<br>
		　　●开发可靠代码——包括链式异常、栈帧，断言和日志<br>
		　　●新的高性能的I／O API——内存映射文件、文件加锁及字符集编码／解码<br>
		　　●使用了新的功能强大的java．utiI．regex包的正则表达式<br>
		　　●Java 1．4平台环境设置类：新的跨平台的配置信息存储库<br>
		　　●动态代理类、内部类、Java平台事件模型、流、文件管理以及其他内容<br>
			作者简介：<br>
			　　CayS．Horstmann是圣何塞州立大学的计算机科学教授，在C++、Java和面向对象开发方面已经有6本著作。 
			GaryCornell是康涅狄格大学的教授，也是广大开发人员喜爱的技术作家，许多著作都广受好评。近年来他还与人创办
			了著名的计算机技术图书出版社 Apress。','images/product/zcover3.gif');
insert into product values(4,'Effective Java中文版','(美)Joshua Bloch',39,2,214,1,'书介绍了在Java编程中57条极具实用价值的经验规则，这些经验规则涵盖了大多数开发人员每天所面
		临的问题的解决方案。通过对Java平台设计专家所使用的技术的全面描述，揭示了应该做什么、不应该做什么才能产生
		清晰、健壮和高效的代码。 本书中的每条规则都以简短、独立的小文章形式出现，这些小文章包含了详细而精确的建议
		，以及对语言中许多细微之处的深入分析，并通过例子代码加以进一步说明。贯穿全书的是通用的语言用法和设计模式
		，以及一些具有启发意义的技巧和技术。<br>
		<br>
		　　◆“真希望10年前我就能拥有这本书。可能有人会认为我不需要任何关于Java的书籍，但是我确实需要这本
		书。”<br> 　　　　　　　　　　　　　　　　　　——James Gosling，Java之父，Sun公司副总裁<br>
		<br>
		　　◆“一本非常优秀的书，充满了各种关于使用Java程序设计语言和面向对象程序设计的好的建议。”<br>
		　　　　　　　　　　　　　　　　　　　　 ——Gilad Bracha, Sun公司计算机科学家，《The Java TM Language 
		Specificationy》（Second Edition）的作者之一 ','images/product/zcover4.gif');
insert into product values(5,'Java与模式','阎宏',88,1,1024,1,'本书是一本讲解设计原则以及最为常见的设计模式的实用教材，目的是为工作繁忙的Java系统设计师提供一
			个快速而准确的设计原则和设计模式的辅导。本书分为55章，每一个章节讲解一个编程模式，说明此模式的用意、结构
			，以及这一模式适合于什么样的情况等。每一个章节都附有多个例子和练习题，研习这些例子、完成这些练习题可以帮
			助读者更好地理解所讲的内容。大多数的章节都是相对独立的，读者可以打开本书，从任何一章开始读起。为了满足不
			同程度的读者的需要，本书提供了一些标为“专题”的章节，不阅读这些章节，对阅读本书的标准章节没有影响。读过
			本书之后，读者可以很有信信心地在自己的系统设计工作中使用学过的内容，与同事交流面向对象的设计经验，并在事
			业发展上有更多的收获。本书适合于Java程序员、架构设计师及设计模式爱好者，是一本实用的设计原则和设计模式的
			自学教材和使用手册','images/product/zcover5.gif');
insert into product values(6,'深入浅出Hibernate','夏昕 曹晓钢 唐勇',59,1,512,1,'本书由互联网上影响广泛的开放文档OpenDoc系列自由文献首份文档“Hibernate开发指南”发展而来。在编
			写过程中，进行了重新构思与组织，同时对内容的深度与广度进行了重点强化。本书从持久层入手，引出对象/关系数据
			库映射的由来，接下来聚焦于目前最完善、最强悍的ORM产品—— Hibernate。从一个基础程序入手，讲述Hibernate的
			基本语法与配置，慢慢升高到缓存、延迟加载等高级特性。本书内容深入浅出，先讲述持久层设计与ORM，再由
			Hibernate概述、Hibernate基础Hibernate高级特性顺序展开，直至Hibernate实战，重点讲述了 Hibernate的基础语
			法、基础配置、O/R映射、数据关联、数据检索、HQL实用技术、自定义持久化实现、Hibernate回调与拦截、 
			Hibernate分页等实用技术，Hibernate实战部分则用一个真实论坛的创建演示了Hibernate的强大功能。本书有丰富的
			附录部，在附录中讲述了Hibernate常用的映射配置，Hibernate工具、XDoclet模板配置以及Hibernate的益友iBatis
			用法，还以卡片的形式列出了本书中所用的工具及软件，附录最后一部分是“快速启动代码”，供读者对比与参考，也
			给初学者提供了一个快带起步的基础。本书适合于Hibernate的各个阶层的读者。','images/product/zcover6.gif');
insert into product values(7,'Tomcat与Java Web开发技术详解','孙卫琴 李洪成',45,1,438,1,'本书详细介绍了在最新Tomcat 5版本上开发Java Web应用的各种技术。主要内容包括：Tomcat和Java 
		Web开发的基础知识，Java Web开发的高级技术，Tomcat与当前其他通用软件的集成，以及Tomcat的各种高级功能。书
		中内容注重理论与实践相结合，列举了大量具有典型性和实用价值的Web应用实例，并提供了详细的开发和部署步骤。由
		于Java Web技术是SUN公司在Java Servlet规范中提出的通用技术，因此本书讲解的Java Web应用例子可以运行在任何
		一个实现SUN的Servlet规范的Java Web服务器上。随书附赠光盘内容为本书所有范例源程序，以及本书涉及到的所有软
		件的最新版本的安装程序。本书语言深入浅出，通俗易懂。无论对于Java Web开发的新手还是行家来说，本书都是精通
		Tomcat技术和开发Java Web应用的必备的实用手册。','images/product/zcover7.gif');
insert into product values(8,'精通Spring','罗时飞',39,2,425,1,'本书深入剖析了当前流行的轻量级开发框架Spring技术。总共分成3部分。第一部分，重点阐述Spring的
			架构。这部分内容循序渐进带领开发者进入Spring中。主要在于阐述Spring IOC和Spring AOP。第二部分，重点阐述
			Spring的使用。这部分内容从简化Java/J2EE的角度出发，从J2EE平台各个技术层面分析并给出大量的研究实例，对
			Spring提供的API进行阐述。主要在于阐述Spring对J2EE API提供的服务抽象。第三部分，重点阐述Spring高级专题。
			这部分内容重点对视图技术进行了研究，因为对于开发Web应用而言，前端界面的开发往往工作量很大。因此，使用合理
			的视图技术开发Web应用对于项目的成功与否很关键。另外，Web应用的安全性往往也是企业应用中最为重要的需求之一
			，而用于 Spring的Acegi安全框架很好地解决了这个问题，这也是第三部分重点研究的内容之一。本书献给所有的Java
			、J2EE开发者阅读。','images/product/zcover8.gif');





























