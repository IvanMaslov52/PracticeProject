<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>

<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <title>ChangeParty</title>

    <link rel="stylesheet" href="/resources/css/style.css" type="text/css">
</head>

<body>
<div class="size1">
<jsp:include page="header.jsp"/>



<div class = "size2">
  <form:form action="${pageContext.request.contextPath}/ChangeParty/${PartyForm.id}" method="post" modelAttribute="PartyForm">

              <div>
              <form:input type="text" name="name" path="name" value="${PartyForm.name}" placeholder="${PartyForm.name}"/>
                <form:errors path="name"></form:errors>
                </div>
              <div>
              <form:input type="text" name="course" path="course" value="${PartyForm.course}" placeholder="${PartyForm.course}"/>
                    <form:errors path="course"></form:errors>
                    </div>
              <button type="submit">Добавить</button>
            </form:form>
</div>

<div class=" size2">
<a class="ssilka" href="<c:url value="/Party"/>">Назад</a>
</div>
<jsp:include page="footer.jsp"/>
</div>
</body>
</html>