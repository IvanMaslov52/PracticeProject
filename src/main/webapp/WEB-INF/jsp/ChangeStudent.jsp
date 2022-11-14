<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>

<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <title>ChangeStudent</title>

    <link rel="stylesheet" href="/resources/css/style.css" type="text/css">
    <link rel="stylesheet" href="//code.jquery.com/ui/1.13.2/themes/base/jquery-ui.css">
    <link rel="stylesheet" href="/resources/demos/style.css">
    <script src="https://code.jquery.com/jquery-3.6.0.js"></script>
    <script src="https://code.jquery.com/ui/1.13.2/jquery-ui.js"></script>
    <script>
        $( function() {
            $( "#datepicker" ).datepicker();
        } );
    </script>
</head>

<body>
<div class= "size1">


<jsp:include page="header.jsp"/>

        <div class = "size2">
  <form:form action="${pageContext.request.contextPath}/ChangeStudent/${StudentForm.id}" method="post" modelAttribute="StudentForm">

                <div>
                    <form:select path="party" name="party">
                        <option value="${StudentForm.party.id}" selected>${StudentForm.party.name}</option>
                        <c:forEach items="${PartyList}" var="party">
                            <option value="${party.id}">${party.name}</option>
                        </c:forEach>
                    </form:select>
                    <form:errors path="party"></form:errors>
              </div>
                            <div>
              <form:input type="text" name="fio" path="fio" value="${StudentForm.fio}" placeholder="${StudentForm.fio}"/>
              <form:errors path="fio"></form:errors>
              </div>
                            <div>
              <form:input type="number" name="sticket" path="sticket" value="${StudentForm.sticket}" placeholder="${StudentForm.sticket}"/>
              <form:errors path="sticket"></form:errors>
              </div>
                            <div>
                                <form:input id="datepicker" type="text" path = "borndata" name="borndata" value="${StudentForm.borndata}" readonly="true"/>
                                <form:errors path="borndata"></form:errors>
               </div>

              <button type="submit">Добавить</button>
            </form:form>
            </div>
<div class=" size2">
<a class="ssilka" href="<c:url value="/Student"/>">Назад</a>
</div>
<jsp:include page="footer.jsp"/>
</div>
</body>
</html>