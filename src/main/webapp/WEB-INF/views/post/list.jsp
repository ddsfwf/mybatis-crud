<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Iist 페이지</title>
</head>
<body>
<img src="/aaa.jpg" width="20px" height="20px" />
<table border="1">
     <tr>
     <th>번호</th>
     <th>제목</th>
     <th>날짜</th>
     </tr>
     <c:forEach var="post" items="${posts}">
     <tr>
         <td>${post.id}</td>
         <td><a href="/post/${post.id}">${post.title}</a></td>
         <td>${post.createDate}</td>
       </tr>
     </c:forEach>
</table>
<a href="/post/writeForm">글쓰기</a>
</body>
</html>

