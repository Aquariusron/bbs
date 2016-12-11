<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page isELIgnored = "false"%>
<%@taglib prefix ="c" uri = "http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix ="fmt" uri = "http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>掲示板</title>
<link href="bbs.css" rel="stylesheet" type="text/css">
</head>
<body>
<div class = "main-contents">
<div class="header">
			<a href="signup">新規登録</a>/
			<a href="newMessage">新規投稿</a>/
			<a href="users">ユーザー管理</a>/
			<a href="login">ログイン</a>/
			<a href="logout">ログアウト</a>
</div>
<br />
<br />
<div class="profile">
	<div class="name"><h2><c:out value="${loginUser.name}" /></h2></div>
</div>
<c:if test="${ not empty errorMessages }">
	<div class="errorMessages">
		<ul>
			<c:forEach items="${errorMessages}" var="comment">
				<li><c:out value="${comment}" />
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
<br />
<div class="messages">
	<c:forEach items="${messages}" var="message">
		<br />
			<div class="message">
				<div class="account-name">
					<span class="name"><c:out value="${message.name}" /></span>
				</div>

				<div class="subject"><c:out value="■${message.subject}" /></div>
				<div class="category"><c:out value=">${message.category}" /></div>
				<div class="text"><c:out value="${message.text}" /></div>
				<div class="name"><c:out value="${message.name}" /></div>
				<div class="date"><fmt:formatDate value="${message.insertDate}" pattern="yyyy/MM/dd HH:mm:ss" /></div>
			</div>
			<HR width="100%" align="left">
			<div class="comment">
				<c:forEach items="${comments}" var="comment">
					<c:if test="${comment.id == message.id}">
						<%--これはログインしてるユーザーのIDを表示させるだけなのでいらない
						<div class="user_id"><c:out value="${loginUser.id}" /></div> --%>
						<div class="text"><c:out value="${comment.getComment()}" /></div>
						<div class="date"><fmt:formatDate value="${comment.getInsertDate()}" pattern="yyyy/MM/dd HH:mm:ss" />
						<c:out value="  ${comment.name}" /></div>
					</c:if>
				</c:forEach>
			</div>
			<br />
			<div class="form-area">
				<form action="comment" method="post" style="padding: 20px;">
					コメント：<br />
					<TEXTAREA cols="100" rows="5" name="text" margin-left="10px";></TEXTAREA>
						<input type ="hidden" name="message_id" value="${message.id}">
						<br />
						<br />
						<input type="submit" value="返信する">(500文字まで)
					<br />
				</form>
			</div>
	</c:forEach>

	<br />
	<br />
</div>
<br />
<br />
<br />
<br />
<br />
<div class = "copyright">Copyright(c)Akane Yamashita</div>
</div>
</body>
</html>

