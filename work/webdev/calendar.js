const icon = document.querySelectorAll(".icon");
const slider = document.querySelector(".slider");

const timer = document.querySelector(".timer");
const date = document.querySelector(".date");
const day = document.querySelector(".day");

const bgImg = document.querySelector(".bg-img");
const imgToggle = document.querySelector(".fa-image");

const calDay = [
  "",
  "Monday",
  "tuesday",
  "wednesday",
  "thursday",
  "friday",
  "saturday",
  "sunday",
];

const calMonth = [
  "",
  "Jan",
  "feb",
  "mar",
  "apr",
  "may",
  "jun",
  "jul",
  "aug",
  "sept",
  "oct",
  "nov",
  "dec",
];

/*
icon.forEach((ic) => {
  ic.addEventListener("click", () => {
    [val, ...other] = ic.classList;

    if (val == "r-icon") {
      slider.classList.add("body-slide-left");
    } else slider.classList.add("body-slide-right");
  });
});
*/

const d = new Date();
day.innerText = calDay[d.getDay()];
let dt = d.getDate() < 10 ? "0" + d.getDate() : d.getDate();
date.innerText = dt + " / " + (d.getMonth() + 1);

function showTime() {
  var date = new Date();
  var h = date.getHours(); // 0 - 23
  var m = date.getMinutes(); // 0 - 59

  if (h == 0) {
    h = 12;
  }

  h = h < 10 ? "0" + h : h;
  m = m < 10 ? "0" + m : m;

  var time = h + ":" + m;
  timer.innerText = time;
  timer.textContent = time;

  setTimeout(showTime, 1000);
}

showTime();

imgToggle.addEventListener("click", () => {
  let n = Math.floor(Math.random() * 9) + 1;
  bgImg.style.backgroundImage = ` url(pics/${n}.jpg)`;
});
