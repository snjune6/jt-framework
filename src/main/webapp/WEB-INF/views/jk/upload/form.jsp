<%--
  Created by IntelliJ IDEA.
  User: DEV-BACK04
  Date: 2021-10-21
  Time: 오후 2:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h4><span class="glyphicon glyphicon-pencil" aria-hidden="true"><b> 사이트관리</b></span></h4>
    <div class="well">
        <form:form modelAttribute="fileDto" cssClass="form-horizontal" enctype="multipart/form-data">
            <div class="form-group">
                <form:label path="uploadFile" cssClass="col-sm-2 control-label">file</form:label>
                <div class="col-sm-10">
                    <form:input path="uploadFile" type="file" cssClass="form-control" multiple="multiple" />
                    <form:errors path="uploadFile" />
                </div>
            </div>

            <div class="form-group">
                <div class="col-sm-offset-2 col-sm-10">
                    <form:button class="btn btn-default" >수정</form:button>
                </div>
            </div>
        </form:form>
    </div>
    <script>
        $(function(){
            $("#siteDomain.errors").on("click", function(e){
                console.log(e);
            });
        });
    </script>
</body>
</html>
