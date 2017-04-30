<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@include file="../pagehelp/localization.jspf" %>

<!DOCTYPE html>
<html>
<head>
		<meta charset="UTF-8">
		<meta charset="utf-8">
		
		<link rel="stylesheet" href="css/normalize.css">
		<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=PT+Sans+Narrow:400,700&amp;subset=cyrillic">
		<link rel="stylesheet" href="css/style.css">
		<title>Personal Area</title>
</head>
<body>
	<div class="modal-content modal-content-show">
			<button class="modal-content-close" type="button" title="Закрыть">Закрыть</button>
			<h2 class="modal-content-title">Личтный кабинет</h2>
			<p>Введите свой логин и пароль</p>
			<form class="login-form" action="controller" method="post">
				<input class="icon-user" type="text" name="admin_login" placeholder="Логин" required="required">
				<input class="icon-password" type="password" name="admin_password" placeholder="Пароль" required="required">
				<button class="btn" type="submit" name="command" value="signinAdmin">Войти</button>
			</form>
		</div>
</body>
</html>