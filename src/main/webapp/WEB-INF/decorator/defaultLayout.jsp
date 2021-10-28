<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no, viewport-fit=cover">
    <title><sitemesh:write property='title'/> :: ${siteName}</title>
    <!-- 합쳐지고 최소화된 최신 CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">

    <!-- 부가적인 테마 -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">

    <script src="https://code.jquery.com/jquery-3.6.0.js" integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk=" crossorigin="anonymous"></script>
    <!-- 합쳐지고 최소화된 최신 자바스크립트 -->
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
    <link rel="stylesheet" type="text/css" href="http://linkplantec.com/assets/lib/simplePagination/simplePagination.css">
</head>
<body>

    <ul class="">
        <sec:authorize access="isAnonymous()">
            <li><a href="<c:url value="/auth/login" />">로그인</a></li>
        </sec:authorize>
        <sec:authorize access="isAuthenticated()">
            <li><a href="<c:url value="/logout" />">로그아웃</a></li>
            <sec:authorize access="hasAnyRole('ROLE_MEMBER')" >
                <li><a href="<c:url value="#" />">마이페이지</a></li>
            </sec:authorize>
        </sec:authorize>
        <li><a href="<c:url value="#" />">회사소개</a></li>
        <li><a href="<c:url value="#" />" title="SITEMAP">SITEMAP</a></li>
    </ul>

    <c:forEach var="menuList" items="${menuFullList}" varStatus="status">
    <ul>
        <li class="gnb_1">
            <a href="${menuList.menuLink}">${menuList.menuNm}</a>
            <p class="h_title">
                <span>${menuList.menuAlt}</span>
            </p>
        </li>
    </ul>
    </c:forEach>
    HEADER<br>
    ------------------------<br>

    <div class="container-fluid">
        <sitemesh:write property='body'/>
    </div>
    ------------------------<br>
    FOOTER
</body>
</html>
