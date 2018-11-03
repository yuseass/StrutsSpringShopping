<%--
  Created by IntelliJ IDEA.
  User: sea
  Date: 2018年4月30日 0030
  Time: 20:58:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>增删改查</title>
</head>
<body>
<form id="add" action="getAllGoods!addGoods">
    增<br>
    编号： <input type="text" name="id"><br>
    名称：<input type="text" name="name"><br>
    价格：<input type="text" name="price"><br>
    <input type="submit" value="提交"><br>

</form>
<br><br><br><br><br>
<form id="delete" action="getAllGoods!deleteGoods">
    删<br>
    编号： <input type="text" name="id"><br>
    <input type="submit" value="提交"><br>

</form>
<br><br><br><br><br>
<form id="update" action="getAllGoods!updateGoods">
    改<br>
    编号： <input type="text" name="id"><br>
    名称：<input type="text" name="name"><br>
    价格：<input type="text" name="price"><br>
    <input type="submit" value="提交"><br>

</form>
<br><br><br><br><br>
<form id="query" action="getAllGoods!queryGoods">
    查<br>
    编号： <input type="text" name="id"><br>
    <input type="submit" value="提交"><br>
</form>

</body>
</html>
