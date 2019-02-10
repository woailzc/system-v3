<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/10/9
  Time: 21:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
${message}

<a href="check">查看</a>
<shiro:hasRole name="管理员">
   <h1>管理员权限</h1>
</shiro:hasRole>
<shiro:hasRole name="普通用户">
<h1>普通用户权限</h1>
</shiro:hasRole>
<shiro:hasPermission name="/readName">
<h1>有查看名单</h1>
</shiro:hasPermission>
<shiro:hasPermission name="sys:user:save">
<h1>有查看数据</h1>
</shiro:hasPermission>
</body>
</html>
