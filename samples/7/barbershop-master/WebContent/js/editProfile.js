var edit = document.querySelector(".edit");
var popup = document.querySelector(".modal-content-edit");
var popOff = popup.querySelector(".modal-content-close");
var overlay = document.querySelector(".modal-overlay");

edit.addEventListener("click", function(event) {
	event.preventDefault();
	popup.classList.add("modal-content-show");
	overlay.classList.add("modal-content-show");
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

/* Скрип для карты */
var mapOpen = document.querySelector(".where");
var mapPopup = document.querySelector(".modal-content-map");
var mapPopupOff = mapPopup.querySelector(".modal-content-close");
var mapOverlay = document.querySelector(".modal-overlay");

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