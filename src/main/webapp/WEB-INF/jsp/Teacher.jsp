<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>

<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <title>Teacher</title>

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
    <div class="roboto">
<div class="size2">
<table>
    <thead>
    <th>ID</th>
    <th>FIO</th>
    <th>borndate</th>
    <th>Subjects</th>
    <th>Speciality</th>
    <th>Кнопка</th>
    </thead>
        <c:forEach items="${Teacher}" var="teacher">
            <tr>
        <td>${teacher.id}</td>
        <td>${teacher.fio}</td>
        <td>${teacher.borndate}</td>
        <td>${teacher.parseIntoString()}</td>
        <td>${teacher.speciality}</td>
        <td> <a class="ssilka" href="${pageContext.request.contextPath}/ChangeTeacher/${teacher.id}">Изменить учителя</a></td>

        </c:forEach>

        </table>


        </div>
        </div>

    <div class=" size2">
     <a class="ssilka" href="${pageContext.request.contextPath}/AddTeacher">Добавить учителя</a>
     </div>
     <footer>
             <a href="https://github.com/Papagoth"><img alt="logo_1" src="/resources/image/image_1.png"></a>
             <span>CREATED IN 2022</span>
         </footer>
</div>
</body>
</html>