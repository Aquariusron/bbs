<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>ユーザー登録</title>
<<<<<<< HEAD
=======
	<link href="./css/style.css" rel="stylesheet" type="text/css">
>>>>>>> 5d031482e1b8adaf9bead50a126f51124512905d
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
<<<<<<< HEAD


<form action="signup" method="post"><br />
	<label for="name">名前</label>
	<input name="name" id="name"/><br />

	<label for="loginid">アカウントID</label>
	<input name="loginid" id="loginid"/><br />
=======
<form action="signup" method="post"><br />
	<label for="name">名前</label>
	<input name="name" id="name" value="${editUser.name}"/><br />

	<label for="loginId">ログインID名</label>
	<input name="loginId" id="loginId" value="${editUser.loginId}"/><br />
>>>>>>> 5d031482e1b8adaf9bead50a126f51124512905d

	<label for="password">パスワード</label>
	<input name="password" type="password" id="password"/> <br />

<<<<<<< HEAD
	 <select name="branchId">
			<c:forEach var="branch" items="${branches}">
				<c:out value="${branches}" />
			</c:forEach>
 		 </select>

	 	<select name="postId">
			<c:forEach var="post" items="${positions}"></c:forEach>
	 	 </select>
 	 <br>
=======
	<label for="password_confirm">パスワードの確認</label>
	<input name="password_confirm" type="password" id="password_confirm"/> <br />


	<select name="branchId">
		<c:forEach items="${branches}" var="branch">
			<c:if test="${ branch.id == editUser.branchId }">
				<option value="${branch.id}" selected><c:out value="${branch.name}"></c:out></option>
			</c:if>
			<c:if test="${ branch.id != editUser.branchId }">
				<option value="${branch.id}"><c:out value="${branch.name}"></c:out></option>
			</c:if>
		</c:forEach>
	</select>

	<select name="positionId">
		<c:forEach items="${positions}" var="position">
			<c:if test="${ position.id == editUser.postId }">
				<option value="${position.id}"><c:out value="${position.name}"></c:out></option>
			</c:if>
			<c:if test="${ position.id != editUser.postId }">
				<option value="${position.id}"><c:out value="${position.name}"></c:out></option>
			</c:if>

		</c:forEach>
	</select>
>>>>>>> 5d031482e1b8adaf9bead50a126f51124512905d

	<input type="submit" value="登録" /> <br />
	<a href="./">戻る</a>
</form>
<div class="copyright">Copyright(c)Akane Yamashita</div>
</div>
</body>
</html>
