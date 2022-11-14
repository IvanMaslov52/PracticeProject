<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>

<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <title>AddSubject</title>

    <link rel="stylesheet" href="/resources/css/style.css" type="text/css">
</head>

<body>
<div class="size1">

<jsp:include page="header.jsp"/>


  <div class = "size2">
  <form:form action="${pageContext.request.contextPath}/AddSubject" method="post" modelAttribute="SubjectForm">

<div>
    <form:select path="party" name="party">
        <option value="">Выберите группу</option>
        <c:forEach items="${PartyList}" var="party">
            <option value="${party.id}">${party.name}</option>
        </c:forEach>
    </form:select>
    <form:errors path="party"></form:errors>

</div>
<div>
              <form:input type="text" name="name" path="name" placeholder="введите название предмета"/>
               <form:errors path="name"></form:errors>
</div>
<div>
              <form:input type="number" path="studyingtime"  name="studyingtime" placeholder="введите кол-во время обучения"/>
               <form:errors path="studyingtime"></form:errors>
               </div>

              <button type="submit">Добавить</button>
            </form:form>
    </div>




<div class=" size2">
<a class="ssilka" href="<c:url value="/Subject"/>">Назад</a>
</div>
<jsp:include page="footer.jsp"/>
</div>
</body>
</html>