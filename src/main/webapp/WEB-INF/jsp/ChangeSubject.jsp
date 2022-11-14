<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>

<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <title>ChangeSubject</title>

    <link rel="stylesheet" href="/resources/css/style.css" type="text/css">
</head>

<body>
<div class ="size1">
<jsp:include page="header.jsp"/>
     <div class = "size2">
  <form:form action="${pageContext.request.contextPath}/ChangeSubject/${SubjectForm.id}" method="post"  modelAttribute="SubjectForm">

                <div>
                    <form:select path="party" name="party">
                        <option value="${SubjectForm.party.id}" selected>${SubjectForm.party.name}</option>
                        <c:forEach items="${PartyList}" var="party">
                            <option value="${party.id}">${party.name}</option>
                        </c:forEach>
                    </form:select>
                    <form:errors path="party"></form:errors>
              </div>
                            <div>
              <form:input type="text" name="name" path="name" value="${SubjectForm.name}" placeholder="${SubjectForm.name}"/>
              <form:errors path="name"></form:errors>
              </div>
                            <div>
              <form:input type="number" name="studyingtime" path ="studyingtime" value="${SubjectForm.studyingtime}" placeholder="${SubjectForm.studyingtime}"/>
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