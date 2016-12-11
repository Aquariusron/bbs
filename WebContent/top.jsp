<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>簡易Twitter</title>
	<link href="./css/style.css" rel="stylesheet" type="text/css">
</head>
<body>
<div class="main-contents">

<div class="header">

		<a href="login">ログイン</a>
		<a href="signup">新規登録</a>
		<a href="settings">設定</a>
		<a href="logout">ログアウト</a>

</div>

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

<c:if test="${ not empty user }">
	<div class="profile">

		<div class="name"><h2><c:out value="${user.name}" /></h2></div>
		<div class="account">
			<a href="./?user_id=${user.id}">@<c:out value="${user.account}" /></a>
		</div>
		<div class="account">
			<c:out value="${user.description}" />
		</div>
	</div>
</c:if>

<div class="form-area">
	<c:if test="${ not empty loginUser }">
		<form action="newMessage" method="post">
			いま、どうしてる？<br />
			<textarea name="message" cols="100" rows="5" class="tweet-box"></textarea>
			<br />
			<input type="submit" value="つぶやく"">（140文字まで）
		</form>
	</c:if>
</div>

<div class="messages">
	<c:forEach items="${messages}" var="message">
		<div class="message-icon">
			<div class="icon"><a href="./?user_id=${message.userId}"><img src="./icon?user_id=${message.userId}" width="50" height="50"  /></a></div>
			<div class="message">
				<div class="account-name">
					<a href="./?user_id=${message.userId}"><span class="account"><c:out value="${message.account}" /></span></a>
					<span class="name"><c:out value="${message.name}" /></span>
				</div>
				<div class="text"><c:out value="${message.text}" /></div>
				<div class="date"><fmt:formatDate value="${message.insertDate}" pattern="yyyy/MM/dd HH:mm:ss" /></div>
			</div>
		</div>
	</c:forEach>
</div>

<div class="copyright">Copyright(c)Akane Yamashita</div>
</div>
</body>
</html>
