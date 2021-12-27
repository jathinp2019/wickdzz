const intro = document.querySelector(".intro");
const vid = document.querySelector("video");
const img = document.querySelector("img");
const section = document.querySelector("section");

// scroll

const controller = new ScrollMagic.Controller();

const scene = new ScrollMagic.Scene({
  duration: 2000,
  //total duration for which the animation would play

  triggerElement: intro,
  //the element from where this should start functioning

  triggerHook: 0,
  // the posiiton where it should start the trigger
})
  .addIndicators()
  .setPin(intro) // pin the area until animation is over
  .addTo(controller);

//setting a smoothness
let acc = 0.1;
let scrollpos = 0;
let delay = 0;

scene.on("update", (e) => {
  scrollpos = e.scrollPos / 1000;
  //   vid.currentTime = scrollpos;
});

setInterval(() => {
  delay += (scrollpos - delay) * acc;
  vid.currentTime = scrollpos;
  //   console.log(scrollpos * 1000);
}, 99.9);

// 3000/30 = 100
//i.e. duration/fps (for smoothness)
