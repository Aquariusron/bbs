<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>ログイン</title>
<<<<<<< HEAD
	<link href="bbs.css" rel="stylesheet" type="text/css">
=======
<<<<<<< HEAD
	<link href="css/style.css" rel="stylesheet" type="text/css">
=======
	<link href="./css/style.css" rel="stylesheet" type="text/css">
>>>>>>> 5d031482e1b8adaf9bead50a126f51124512905d
>>>>>>> f9fa4c744e7b745aa1b4fe1f30338b9834efdce4
</head>
<body>
<div class="main-contents">
<a href="./">戻る</a>
<br />
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

<form action="login" method="post"><br />
<<<<<<< HEAD
	<label for="accountOrEmail">アカウント名かメールアドレス</label>
	<input name="accountOrEmail" id="accountOrEmail"/> <br />
=======
	<label for="loginId">ログインID</label>
	<input name="loginId" id="loginId"/> <br />
>>>>>>> 5d031482e1b8adaf9bead50a126f51124512905d

	<label for="password">パスワード</label>
<<<<<<< HEAD
	<input name="password" type="password" id="password"/>
	<br />
	<br />
=======
	<input name="password" type="password" id="password"/> <br />

<<<<<<< HEAD
	<input type="submit" value="ログイン" /> <br />
	<a href="./">戻る</a>
</form>
<div class="copyright">Copyright(c)Satoshi Kimura</div>
</div>
</body>
</html>
=======

>>>>>>> f9fa4c744e7b745aa1b4fe1f30338b9834efdce4
	<input type="submit" value="ログイン" /> <br />
</form>

<div class="copyright">Copyright(c)Akane Yamashita</div>
</div>
</body>
</html>
>>>>>>> 5d031482e1b8adaf9bead50a126f51124512905d
