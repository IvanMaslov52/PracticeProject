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
<div class="nav_color">
            <div class="size2">
                <div class="header-margin">
                    <div class="roboto">
                        <nav class="header-nav">
                            <a class="ssilka" href="${pageContext.request.contextPath}/Party"> Группы</a>
                            <a class="ssilka" href="${pageContext.request.contextPath}/Student" >Студенты</a>
                            <a class="ssilka" href="${pageContext.request.contextPath}/Subject" >Предметы</a>
                            <a class="ssilka" href="${pageContext.request.contextPath}/Teacher" >Учителя</a>
                        </nav>
                    </div>
                </div>
            </div>
        </div>



  <div class = "size2">
  <form:form action="${pageContext.request.contextPath}/AddSubject" method="post" modelAttribute="SubjectForm">

<div>
              <form:input type="number" name="party" path="party" placeholder="введите номер группы"/>
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
<a class="ssilka" href="${pageContext.request.contextPath}/Subject">Назад</a>
</div>
<footer>
        <a href="https://github.com/Papagoth"><img alt="logo_1" src="/resources/image/image_1.png"></a>
        <span>CREATED IN 2022</span>
    </footer>
</div>
</body>
</html>