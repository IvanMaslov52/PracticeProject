<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>

<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <title>AddTeacher</title>

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
  <form:form action="${pageContext.request.contextPath}/AddTeacher" method="post" modelAttribute="TeacherForm">

  <div>
              <form:input type="text"  name="fio"  path="fio" placeholder="введите ФИО учителя"/>
              <form:errors path="fio"></form:errors>
              </div>
              <div>
                  <form:input type="text"  name="borndate" path="borndate" placeholder="введите даты"/>
            <form:errors path="borndate"></form:errors>
            </div>
            <div>
                  <form:input type="text"  name="subjects" path="subjects" placeholder="введите номера предметов через запятую"/>
                    <form:errors path="subjects"></form:errors>
            </div>
            <div>
                  <form:input type="text"  name="speciality" path="speciality" placeholder="введите специальность"/>
                  <form:errors path="speciality"></form:errors>
</div>

              <button type="submit">Добавить</button>
            </form:form>
     </div>


<div class=" size2">
<a class="ssilka" href="${pageContext.request.contextPath}/Teacher">Назад</a>
</div>
<footer>
        <a href="https://github.com/Papagoth"><img alt="logo_1" src="/resources/image/image_1.png"></a>
        <span>CREATED IN 2022</span>
    </footer>
</div>
</body>
</html>