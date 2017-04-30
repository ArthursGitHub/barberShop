<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@include file="../pagehelp/localization.jspf" %>

<!DOCTYPE html>
<html lang="ru">
	<head>
		<meta charset="utf-8">
		<title>Barber shop</title>
		<link rel="stylesheet" href="css/normalize.css">
		<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=PT+Sans+Narrow:400,700&amp;subset=cyrillic">
		<link rel="stylesheet" href="css/style.css">
	</head>
	<body>
		<header class="main-header">
				<div class="container clearfix">
					<nav class="main-navigation">
						<ul>						
							<li>
								<a href="information">${navigation_Information}</a>
							</li>
							<li>
								<a href="controller?command=showAllNews">${navigation_news}</a>
							</li>
							<li>
								<a href="price-list">${navigation_price}</a>
							</li>
							<li>
								<a href="shop">${navigation_shop}</a>
							</li>
							<li>
								<a href="contact">${navigation_contacts}</a>
							</li>
						</ul>	
					</nav>
					<div class="user-block">
						<c:if test="${sessionScope.logged == null}">
							<a class="login" href="#">${navigation_signIn}</a>
						</c:if>
						<c:if test="${sessionScope.logged == true}">
							<a class="login1" href="controller?command=cabinet">
								<c:out value="${user.name}"></c:out>
							</a>
						</c:if>
						<form action="controller" method="post">
							<input type="hidden" name="command" value="localization" />
							<button class="rus-localization" type="submit" name="local" value="ru"></button>
							<button class="us-localization" type="submit" name="local" value="en"></button>
						</form>
					</div>
				</div>
		</header>
		<main class="container">
			<div class="index-logo">
				<img src="img/index-logo.png" width="368" height="204" alt="Барбершоп <<Borodinski>>">	
			</div>
			<section class="features clearfix">
				<div class="features-item">
					<b class="features-name">${first_header}</b>
					<p>${first_features}</p>
				</div>
				<div class="features-item">
					<b class="features-name">${second_header}</b>
					<p>${second_features}</p>
				</div>
				<div class="features-item">
					<b class="features-name">${third_header}</b>
					<p>${third_features}</p>
				</div>
			</section>	
				<div class="index-content clearfix">
					<div class="index-content-left">
						<h2 class="index-content-title">${content_title_left}</h2>
						<ul class="news-preview">
							<li>
								<p>
									Нам наконец завезли Ягермайстер! Теперь вы можете
									пропустить стаканьчик во время стрижки
								</p>
								<time datetime="2017-01-11">11 Января</time>
							</li>
							<li>
								<p>
									В нашей команде пополнение, Борис "Бритва" Стригунец, обладатель
									множества титулов и наград пополнил наши стройные ряды
								</p>
								<time datetime="2017-01-05">5 Января</time>
							</li>
						</ul>
						<a class="btn" href="controller?command=showAllNews">${content_left_btn}</a>
					</div>
					<div class="index-content-right">
						<h2 class="index-content-title">${content_title_right}</h2>
						<div class="gallery">
							<figure class="gallery-content">
								<img src="img/photo-1.jpg" width="286" height="164" alt="">
							</figure>
							<button class="btn gallery-prev" type="button">${btn_gallery_prev}</button>
							<button class="btn gallery-next" type="button">${btn_gallery_next}</button>						
						</div>
					</div>
				</div>
				<div class="index-content clearfix">
					<div class="index-content-left">
						<h2 class="index-content-title">${content_title_left_inf}</h2>
						<p>
							Барбершоп Borodinski <br>
							Адрес: г.Минск, Валерьяново д. 18<br>
							Телефон: +375(29)555-55-22
						</p>	
						<p>
							Время работы:<br>
							пн - пт: c 10:00 до 22:00<br>
							сб - вс: с 10:00 до 19:00
						</p>
						<a class="btn js-open-map" href="#">${content_left_inf_btn_where}</a>
						<a class="btn" href="#">${content_left_inf_btn_feedback}</a>
					</div>	
					<div class="index-content-right">
						<h2 class="index-content-title">${content_title_right_registr}</h2>
						<p>
						Укажите желаемую дату и время
						и мы свяжемся с вами для подтверждения брони
						</p>
						<form class="appointment-form" action="controller" method="post">
							<input type="date" name="record_date" placeholder="Дата" required="required">
							<input type="time" name="record_time" placeholder="Время" required="required">
							<input type="text" name="record_name" value="${user.name}" placeholder="Имя" required="required">
							<input type="tel" name="record_phone"  placeholder="Телефон" required="required">
							<button class="btn" type="submit" name="command" value="record">${content_left_inf_btn_register}</button>
						</form>
					</div>	
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
		<!-- POP UP логинация -->
		<div class="modal-content">
			<button class="modal-content-close" type="button" title="Закрыть">Закрыть</button>
			<h2 class="modal-content-title">Личный кабинет</h2>
			<p>Введите свой логин и пароль</p>
			<form class="login-form" action="controller" method="post">
				<input class="icon-user" type="text" name="user_login" placeholder="Логин" required="required">
				<input class="icon-password" type="password" name="user_password" placeholder="Пароль" required="required">
				<label class="login-checkbox">
					<input type="checkbox" name="remember">
					<span class="checbox-indicator"></span>
					Запомнить меня
					</label>
					<a class="restore" href="#">Я забыл пароль</a>
					<a class="restore" href="registration">Регистрация</a>
				
				<button class="btn" type="submit" name="command" value="signin">Войти</button>
			</form>
		</div>
		<!-- КАРТА С POP-UP -->
		<div class="modal-content-map">
			 <button class="modal-content-close" type="button" title="Закрыть">Закрыть</button>
			 <iframe src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d2346.8370973253445!2d27.664170516205665!3d53.97016048011455!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x46dbc8de62279abb%3A0x2a802aca07fcef6a!2z0YPQuy4g0JLQsNC70LXRgNGM0Y_QvdC-0LLQviAxNiwg0JLQsNC70LXRgNGM0Y_QvdC-0LLQviAyMjMwNTMsINCR0LXQu9Cw0YDRg9GB0Yw!5e0!3m2!1sru!2sru!4v1484740519890" width="766" height="561" frameborder="0" style="border:0" allowfullscreen></iframe>
			 <div class="yandex-map"></div>
		</div>
		<div class="modal-overlay"></div>
		
		<script src="js/javascript.js"></script>
	</body>
</html>