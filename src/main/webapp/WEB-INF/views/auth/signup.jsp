<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>signup!</title>
</head>
<body>
    <form action="/auth/signup" method="post">
        <sec:csrfInput />
        <input type="text" name="userId" placeholder="userid 입력">
        <input type="password" name="userPw" placeholder="password 입력">
        <%-- 갈호 안의 영문은 input의 name값이다. --%>
        ㅁ 개인정보 수집/이용 동의 (userPrivacyApproval)
        <%--  밑에 하단부는 숨겨져 있다가 개인정보 수집/이용 동의시 촤르르 펼쳐짐 하단부도 필수 입력은 아님  --%>
        <%-- 바로 아래 이메일은 동의를 클릭해야 입력이 가능하다. 필수 입력은 아님 --%>
        이메일 @ 이메일 ㅁ 이메일 수집/이용 동의 (userEmailApproval)
        사용자 성명 (userName)
        연락처 (userPhone)
        우편번호 (userAddr1)
        주소 (userAddr2)
        상세주소 (userAddr3)
        <%-- 하단부 끝 --%>

        <%-- 버튼 클릭시 개인정보/이메일 둘다 체크 시 알림으로 알려주고 넘기기 / 체크 안되어있다면 안된부분 출력과 함께 다시한번 가입버튼을 눌러달라 알림창을 띄운다 --%>
        <button type="submit">signup!</button>
    </form>
</body>
</html>
