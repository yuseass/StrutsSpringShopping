# StrutsSpringShopping
大三下ssh实验二

实验目的及要求	
使用Struts2编写运行Shopping项目，综合应用Struts2标签，action，拦截器等技术。综合运用Spring的各种技术

实验环境	Windows10,JDK6,IDEA

实验内容	依据提供的使用Struts2 完成的Struts2ShoppingLecture项目，改写一个StrutsSpringShopping项目，完成用户登录，查看商品列表，将商品添加到购物车中等功能。

算法描述及实验步骤
1、依据原有的Struts2ShoppingLecture项目，创建使用Spring改写的StrutsSpringShopping项目，使用Spring管理所需要的Action，添加适当的Service接口及其实现类，使用Spring JdbcTemplate对象改写GoodsDao.java为接口IGoodsDao.java及其实现类GoodsDaoImpl.java对数据库进行访问。
2、编写一个userLogin.jsp页面，如下：
 
使用用户名qtech，密码java登录，经名为名myLogin的action处理后显示商品列表界面
 
添加到购物车后：
 
并可进行购物车内的修改数量，删除项目，清空购物车
3、添加Service层，实现GoodsService、CartService接口及对应的实现类GoodsServiceImpl,CartServiceImpl。
3、通过配置AOP，对CartServiceImpl中的所有方法应用Spring事务
4、添加商品增删改查功能，完成对应的JSP界面、action、dao、service组件
实验报告附录部分包括：
1.	applicationContext.xml文件
2.	action.CartAction.java类文件
3.	service.impl. GoodsServiceImpl.java类文件
4.	bean.dao.impl. GoodsDaoImpl.java类文件


注意：分页可以使用MySQL的limit语法
SELECT * FROM table limit M,N 
M: 开始序号
N: 每次取数据条目数
