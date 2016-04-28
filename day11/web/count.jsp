<%--
  Created by IntelliJ IDEA.
  User: pinghua.wph
  Date: 2016/4/28
  Time: 9:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.awt.*" %>
<%@ page import="java.util.Iterator" %>
<%@ page import="java.util.LinkedList" %>
<html>
<head>
    <title></title>
</head>
<body>
    <%
      int count = (Integer) session.getAttribute("count");
    %>
      <%=count%><br/>
</body>
</html>
