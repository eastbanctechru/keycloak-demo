<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Список видео</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css"
          integrity="sha512-dTfge/zgoMYpP7QbHy4gWMEGsbsdZeCXz7irItjcC3sPUFtf0kuFbDz/ixG7ArTxmDjLXDmezHubeNikyKGVyQ=="
          crossorigin="anonymous">

</head>
<body>

<h2>Данные</h2>
<table class="table table-striped">
    <thead>
    <tr>
        <th>Источник</th>
        <th>Название</th>
        <th>Категория</th>
        <th>Рейтинг</th>
        <th>Ссылка</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="video" items="${list}">
        <tr>
            <td>${video.source}</td>
            <td>${video.title}</td>
            <td>${video.category}</td>
            <td>${video.rating}</td>
            <td><a href="${video.url}" target="_new">Смотреть</a></td>
        </tr>
    </c:forEach>
    </tbody>
</table>


<h2>Системная информация</h2>
<div class="row">
    <div class="col-md-3">${ksc.tokenString}</div>
</div>
</body>
</html>
