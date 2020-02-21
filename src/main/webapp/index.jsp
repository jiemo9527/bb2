<%--
  Date-Time: 2019/8/7 14:13
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<%
//    request.getRequestDispatcher("/WEB-INF/jsp/index.jsp").forward(request,response);
    request.getRequestDispatcher("index.do").forward(request,response);
%>
<%--<jsp:forward page="/WEB-INF/views/login.jsp"></jsp:forward>--%>
<%--<jsp:forward page="/login.do"></jsp:forward>--%>
</body>
</html>
