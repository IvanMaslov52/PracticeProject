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
  <form action="${pageContext.request.contextPath}/AddSubject" method="post">
              <input type="number" name="party" placeholder="введите номер группы"/>
              <input type="text" name="name" placeholder="введите название предмета"/>
              <input type="number"  name="studyingtime" placeholder="введите кол-во время обучения"/>
              <button type="submit">Добавить</button>
            </form>
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