const main = document.querySelector("main");
const vid = document.querySelector("main video");

const controller = new ScrollMagic.Controller();
console.log(vid.duration * 1000);
const scene1 = new ScrollMagic.Scene({
  duration: vid.duration * 1000,
  triggerElement: main,
  triggerHook: 0,
})
  .setPin(main)
  .addIndicators()
  .addTo(controller);

let acc = 0.1;
let scrollpos = 0;
let delay = 0;

scene1.on("update", (e) => {
  scrollpos = (e.scrollPos - e.startPos) / 1000;
  // console.log(e.scrollPos);
});

setInterval(() => {
  delay += (scrollpos - delay) * acc;
  vid.currentTime = scrollpos;
  // console.log(vid.currentTime);
}, 50);
// requestAnimationFrame(() => {
//   delay += (scrollpos - delay) * acc;
//   vid.currentTime = scrollpos;
//   console.log(vid.currentTime);
// }, 50);
