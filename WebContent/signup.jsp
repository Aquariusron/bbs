<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>ユーザー登録</title>
</head>
<body>
<div class="main-contents">
<c:if test="${ not empty errorMessages }">
	<div class="errorMessages">
		<ul>
			<c:forEach items="${errorMessages}" var="message">
				<li><c:out value="${message}" />
			</c:forEach>
		</ul>
	</div>
	<c:remove var="errorMessages" scope="session"/>
</c:if>


<form action="signup" method="post"><br />
	<label for="name">名前</label>
	<input name="name" id="name"/><br />

	<label for="loginid">アカウントID</label>
	<input name="loginid" id="loginid"/><br />

	<label for="password">パスワード</label>
	<input name="password" type="password" id="password"/> <br />

	 <select name="branchId">
			<c:forEach var="branch" items="${branches}">
				<c:out value="${branches}" />
			</c:forEach>
 		 </select>

	 	<select name="postId">
			<c:forEach var="post" items="${positions}"></c:forEach>
	 	 </select>
 	 <br>

	<input type="submit" value="登録" /> <br />
	<a href="./">戻る</a>
</form>
<div class="copyright">Copyright(c)Akane Yamashita</div>
</div>
</body>
</html>
