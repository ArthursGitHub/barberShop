var link = document.querySelector(".user-block__login");
var popup = document.querySelector(".modal-content--login");
var overlay = document.querySelector(".modal-overlay");

var close = popup.querySelector(".modal-content__close");
var form = popup.querySelector(".modal-content__form");
var login = popup.querySelector("[name=login]");
var password = popup.querySelector("[name=password]");

var storage = localStorage.getItem("login");

link.addEventListener("click", function(event) {
  event.preventDefault();
  popup.classList.add("modal-content--visible");
  overlay.classList.add("modal-overlay--visible");

  if (storage) {
    login.value = storage;
    password.focus();
  } else {
    login.focus();
  }

});

close.addEventListener("click", function(event) {
  event.preventDefault();
  popup.classList.remove("modal-content--visible");
  popup.classList.remove("modal-content--error");
  overlay.classList.remove("modal-overlay--visible");
});

form.addEventListener("submit", function(event) {
  if (!login.value || !password.value) {
    event.preventDefault();
    popup.classList.remove("modal-content--error");
    popup.offsetTop;
    popup.classList.add("modal-content--error");
  } else {
    localStorage.setItem("login", login.value);
  }
});

window.addEventListener("keydown", function(event) {
  if (event.keyCode === 27) {
    if (popup.classList.contains("modal-content--visible")) {
      popup.classList.remove("modal-content--visible");
      popup.classList.remove("modal-content--error");
      overlay.classList.remove("modal-overlay--visible");
    }
  }
});

var script = document.createElement('script');
script.src = "https://api-maps.yandex.ru/services/constructor/1.0/js/?sid=dZ__d9DttniMUcDgU-QPVUykM8uE7hFJ&amp;width=766&amp;height=561&amp;id=yandex-map&amp;lang=ru_RU&amp;sourceType=constructor&amp;scroll=true";
document.body.appendChild(script);

script.onload = function() {
  var mapOpenFooter = document.querySelector(".footer-contacts__link");
  var overlay = document.querySelector(".modal-overlay");
  var mapPopup = document.querySelector(".modal-content--map");

  var mapClose = mapPopup.querySelector(".modal-content__close");

  function showMap() {
    mapPopup.classList.add("modal-content--visible");
    overlay.classList.add("modal-overlay--visible");
  }

  function closeMap() {
    mapPopup.classList.remove("modal-content--visible");
    overlay.classList.remove("modal-overlay--visible");
  }

  mapOpenFooter.addEventListener("click", function(event) {
    event.preventDefault();
    showMap();
  });

  mapClose.addEventListener("click", function(event) {
    event.preventDefault();
    closeMap();
  });

  window.addEventListener("keydown", function(event) {
    if (event.keyCode === 27) {
      if (mapPopup.classList.contains("modal-content--visible")) {
        mapPopup.classList.remove("modal-content--visible");
        overlay.classList.remove("modal-overlay--visible");
      }
    }
  });

  if (document.querySelector(".index-content__btn--open-map")) {
    var mapOpen = document.querySelector(".index-content__btn--open-map");

    mapOpen.addEventListener("click", function(event) {
      event.preventDefault();
      showMap();
    });
  }
};