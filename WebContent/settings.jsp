<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>${loginUser.account}の設定</title>
	<link href="css/style.css" rel="stylesheet" type="text/css">
	<title>${editUser.name}の設定</title>
	<link href="bbs.css" rel="stylesheet" type="text/css">
	<link href="./css/style.css" rel="stylesheet" type="text/css">
</head>
<body>
<div class="main-contents">
<a href="users">戻る</a>
<br/>
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

<form action="settings" method="post" enctype="multipart/form-data"><br />
	<label for="name">名前</label>
<<<<<<< HEAD
	<input name="name" value="${editUser.name}" id="name"/>（名前はあなたの公開プロフィールに表示されます）<br />

	<label for="account">アカウント名</label>
	<input name="account" value="${editUser.account}" />（あなたの公開プロフィール:http://localhost:8080/?account=アカウント名）<br />

	<label for="password">パスワード</label>
	<input name="password" type="password" id="password"/> <br />

	<label for="email">メールアドレス</label>
	<input name="email" value="${editUser.email}" id="email"/> <br />

	<label for="description">説明</label>
	<textarea name="description" cols="35" rows="5" id="description"><c:out value="${editUser.description}" /></textarea> <br />

	<label for="icon">アイコン</label>
	<input type="file" name="icon" id="icon"> <br />

	<input type="submit" value="登録" /> <br />
	<a href="./">戻る</a>
</form>
	<input name="name" value="${editUser.name}" id="name"/><br />

	<label for="account">ログインID</label>
	<input name="account" value="${editUser.loginId}" /><br />

	<label for="password">パスワード</label>
	<input name="password" id="password"/> <br />
	<label for="password">パスワードの確認</label>
	<input name="password_confirm" id="password"/> <br />


	<select name="branchId">
		<c:forEach items="${branches}" var="branch">
			<c:if test="${ branch.id == editUser.branchId }">
				<option value="${editUser.branchId}" selected><c:out value="${branch.name}"></c:out></option>
			</c:if>
			<c:if test="${ branch.id != editUser.branchId }">
				<option value="${editUser.branchId}" ><c:out value="${branch.name}"></c:out></option>
			</c:if>
		</c:forEach>
	</select>

	<select name="positionId">
		<c:forEach items="${positions}" var="position">
			<c:if test="${ position.id == editUser.postId }">
				<option value="${position.id}"selected><c:out value="${position.name}"></c:out></option>
			</c:if>
			<c:if test="${ position.id != editUser.postId }">
				<option value="${position.id}"><c:out value="${position.name}"></c:out></option>
			</c:if>

		</c:forEach>
	</select>
	<input type="submit" value="変更" /> <br />

</form>
<div class="copyright">Copyright(c)Akane Yamashita</div>
</div>
</body>
</html>
