<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>AddParty</title>
    <link rel="stylesheet" href="/resources/css/style.css" type="text/css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.11.1/jquery.validate.js"></script>
    <script>
        $.validator.addMethod('symbols', function(value, element) {
            return value.match(new RegExp("^" + "[А-Яа-яЁё ]" + "+$"));
        }, "Здесь должны быть только русские символы");
        $(function () {
            $("#PartyForm").validate
            ({
                rules: {
                    name: {
                        required:true,
                        symbols:true,
                        minlength:4

                    },
                    course: {
                        required:true,
                        symbols:true,
                        minlength:4
                    }
                },
                messages: {
                    name: {
                        required:'Это поле не должно быть пустым',
                        minlength: 'Название группы должно содержать больше 4 символов'
                    },
                    course: {
                        required:'Это поле не должно быть пустым',
                        minlength: 'Название курса должно содержать больше 4 символов'
                    }
                }
            });
        })
    </script>
</head>
<body>

<div class="size1">
    <jsp:include page="header.jsp"/>
    <div class="size2">
        <form:form action="${pageContext.request.contextPath}/AddParty" method="post" modelAttribute="PartyForm"
                   id="PartyForm" class="form">
            <div>
                <form:input type="text" name="name" path="name" id="name"  placeholder="введите название группы"/>
                <form:errors path="name"></form:errors>
            </div>
            <div>
                <form:input type="text" name="course" path="course" id="course"  placeholder="введите курс"/>
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
</div>
</body>
</html>