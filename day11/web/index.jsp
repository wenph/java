<%--
  Created by IntelliJ IDEA.
  User: pinghua.wph
  Date: 2016/4/19
  Time: 12:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page pageEncoding="utf-8" contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.awt.*" %>
<%@ page import="java.util.Iterator" %>
<%@ page import="java.util.LinkedList" %>

<html>
  <head>
    <title></title>
  </head>
  <body style="font-size: 30px;font-style: italic">
    <%
        LinkedList nameList = (LinkedList) request.getAttribute("nameList");
        for (int i = 0; i < 3; i++) {
            String name = (String) nameList.get(i);
    %>
    <%=name%><br/>
    <%
        }
    %>
  </body>
</html>
