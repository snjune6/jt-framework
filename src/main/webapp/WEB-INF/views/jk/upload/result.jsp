<%--
  Created by IntelliJ IDEA.
  User: DEV-BACK04
  Date: 2021-10-21
  Time: 오후 2:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h4><span class="glyphicon glyphicon-pencil" aria-hidden="true"><b> 사이트관리</b></span></h4>
    <div class="well">
        <ul>
            <c:forEach items="${files}" var="file" varStatus="state">
                <li><span>${file.fileName}_${file.originalfileName}</span><a href="#" href="/jk-framework/upload/download">[download]</a></li>
            </c:forEach>
        </ul>
    </div>
</body>
</html>
