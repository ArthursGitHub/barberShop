<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@include file="../../pagehelp/localization.jspf" %>

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
<body class="inner-page">
	<header class="main-header"> 
				<div class="container clearfix">
					<nav class="main-navigation">
						<a class="logo-inner" href="index">
							<img src="img/loggo-inner.png" width="111" height="24" alt="Borodinski">
						</a>
						<ul>						
							<li>
								<a href="#">${navigation_Information}</a>
							</li>
							<li>
								<a href="controller?command=showAllNews">${navigation_news}</a>
							</li>
							<li>
								<a href="price-list">${navigation_price}</a>
							</li>
							<li>
								<a href="shop.html">${navigation_shop}</a>
							</li>
							<li>
								<a href="#">${navigation_contacts}</a>
							</li>
						</ul>	
					</nav>
					
					<div class="user-block">
						<c:if test="${sessionScope.loggedAdmin == null}">
							<a class="login" href="#">${navigation_signIn}</a>
						</c:if>
						<c:if test="${sessionScope.loggedAdmin == true}">
						<form action="controller" method="post">
							<button class="btn exit" type="submit" name="command" value="signout">Выход</button>
						</form>
							<a class="login1" href="cabinet">
								<c:out value="${superUser.name}"></c:out>
							</a>
						</c:if>
					</div>
				</div>
		</header>
		
		<main class="container">
		<div class="inner-page-title">
			<ul class="breadcrumbs">
				<li>
					<a href="index">Главная</a>
				</li>
				<li class="current">
					Личный Кабинет
				</li>			
			</ul>
		</div>
		<div class="inner-content">
			<div class="big-heading">
				<h2>Администратор</h2>
			</div>
				<table class="admin_table">
					<tr class="admin_table">
					        	
					        	<td>
					        		<form action="controller" method="post">			
										<button class="btn"  type="submit" name="command" value="show_users">ShowAllUsers</button>
									</form>
								</td>
								<td>
								<form action="controller" method="post">			
										<button class="btn"  type="submit" name="command" value="page_add_news">Add News</button>
								</form>
					 </tr>      	
					 <tr>
					 		<td>
					        		<form action="controller" method="post">			
										<button class="btn"  type="submit" name="command" value="registration_haircut">All registration for a haircut</button>
									</form>
								</td>
								<td>
					        		<form action="controller" method="post">			
										<button class="btn"  type="submit" name="command" value="show_users">Spending Email</button>
									</form>
								</td>
					 
					 </tr>
					  <tr>
					 		<td>
					        		<form action="controller" method="post">			
										<button class="btn"  type="submit" name="command" value="show_users">Add goods</button>
									</form>
								</td>
								<td>
					        		<form action="controller" method="post">			
										<button class="btn"  type="submit" name="command" value="show_users">schedule hairdresser</button>
									</form>
								</td>
					 
					 </tr>
				</table>
		  		
			
			
				
		</div>
		</main>
		
		
		
		<footer class="main-footer">
			<div class="container clearfix">
				<section class="footer-contacts">
					${footer_contacts_first} <br>
					${footer_contacts_second}<br>
					<a href="#">${footer_contacts_thrid}</a><br>
					${footer_contacts_forsth}
				</section>
				<section class="footer-social">
					<p>
						${footer_social}
					</p>
					<a class="social-btn social-btn-vk" href="#">Вконтакте</a>
					<a class="social-btn social-btn-fb" href="#">Фейсбук</a>
					<a class="social-btn social-btn-inst" href="#">Инстаграм</a>
					
				</section>
				<section class="footer-copyright">
					<p>${footer_copyright}</p>
					<a class="btn" href="#">Николаев Илья</a>
				</section>
			</div>
		</footer>
</body>
</html>