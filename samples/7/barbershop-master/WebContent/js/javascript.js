	var entrance = document.querySelector(".login");
	var popup = document.querySelector(".modal-content");
	var popOff = popup.querySelector(".modal-content-close");
	var login = popup.querySelector("[name=login]");
	var formLog = popup.querySelector("form");
	var pass = popup.querySelector("[name=password]");
	var overlay = document.querySelector(".modal-overlay");
	/*for map*/
	var mapOpen = document.querySelector(".js-open-map");
	var mapPopup = document.querySelector(".modal-content-map");
	var mapPopupOff = mapPopup.querySelector(".modal-content-close");
	var mapOverlay = document.querySelector(".modal-overlay");
	
	
	
	
entrance.addEventListener("click", function(event) {
	event.preventDefault();
	popup.classList.add("modal-content-show");
	overlay.classList.add("modal-content-show");
	login.focus();
});

popOff.addEventListener("click", function(event) {
	event.preventDefault();
	popup.classList.remove("modal-content-show");
	popup.classList.remove("modal-error");
	overlay.classList.remove("modal-content-show");
	
});

window.addEventListener("keydown", function(event){
	if(event.keyCode === 27){
		if(popup.classList.contains("modal-content-show")) {
			popup.classList.remove("modal-content-show");
			popup.classList.remove("modal-error");
			overlay.classList.remove("modal-content-show");
		}
	}
});


formLog.addEventListener("submit", function(event){
	
	if(!login.value || !pass.value) {
		event.preventDefault();
		popup.classList.add("modal-error");
		/*alert("Нужно ввести Логин и Пароль");*/
	}
});
			/* Скрип для карты */
			
mapOpen.addEventListener("click", function(event){
	event.preventDefault();
	mapPopup.classList.add("modal-content-show");
	mapOverlay.classList.add("modal-content-show");
});			

mapPopupOff.addEventListener("click", function(event){
	event.preventDefault();
	mapPopup.classList.remove("modal-content-show");
	mapOverlay.classList.remove("modal-content-show");
});

window.addEventListener("keydown", function(event){
	if(event.keyCode ===27){
		if(mapPopup.classList.contains("modal-content-map")){
			mapPopup.classList.remove("modal-content-show");
			mapOverlay.classList.remove("modal-content-show");
		}
	}
	
});

















