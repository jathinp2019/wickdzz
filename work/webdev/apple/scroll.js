const main = document.querySelector("main");
const vid = document.querySelector("main video");
const vidContainer = document.querySelector(".vidContainer");
const txt = document.querySelector(".text");

const txt1 = document.querySelector("#txt1");

let count = 0;

const controller = new ScrollMagic.Controller();
const scene1 = new ScrollMagic.Scene({
  duration: vid.duration * 1000,
  triggerElement: main,
  triggerHook: 0,
})
  .setPin(main)
  // .addIndicators()
  .addTo(controller);

let acc = 0.1;
let scrollpos = 0;
let delay = 0;

scene1.on("update", (e) => {
  scrollpos = (e.scrollPos - e.startPos) / 1000;
  let time = vid.currentTime.toFixed(2);
  console.log(scrollY);

  // if (time >= 2 && time < 2.32) {
  //   ++count;
  // }
  if (scrollY >= 2200 && scrollY < 2300) {
    ++count;
    // if (count == 1)
    t1();
    // return;
  }
});

setInterval(() => {
  delay += (scrollpos - delay) * acc;
  vid.currentTime = scrollpos;
}, 20);
