const intro = document.querySelector(".intro");
const mid = document.querySelector(".mid");

const vid1 = intro.querySelector("video");
const vid2 = mid.querySelector("#vid2");

const img = document.querySelector("img");
const section = document.querySelector("section");

const tl1 = gsap.timeline({
  scrollTrigger: {
    trigger: ".intro",
    pin: false,
    start: "bottom -500",
    end: "bottom -1000",
    scrub: 1,
    // markers: true,
  },
});

tl1
  .from("#t1", {
    y: 0,
    duration: 1500,
    opacity: 0,
  })
  .to("#t1", {
    y: -50,
    duration: 1000,
    opacity: 1,
    delay: 400,
  })
  .to("#t1", {
    y: -150,
    duration: 1500,
    opacity: 0,
    delay: 50,
  });

tl1
  .from("#t2", {
    y: 0,
    duration: 1500,
    opacity: 0,
    delay: 50,
  })
  .to("#t2", {
    y: -50,
    duration: 1000,
    opacity: 1,
    delay: 50,
  })
  .to("#t2", {
    y: -150,
    duration: 1500,
    opacity: 0,
    delay: 10,
  });

const tl2 = gsap.timeline({
  scrollTrigger: {
    trigger: ".mid",
    pin: false,
    start: "500",
    end: "bottom -500",
    scrub: 1,
    // markers: true,
  },
});

tl2
  .from("#t3", {
    y: 0,
    duration: 1500,
    opacity: 0,
  })
  .to("#t3", {
    y: -50,
    duration: 1000,
    opacity: 1,
    delay: 400,
  })
  .to("#t3", {
    y: -150,
    duration: 1500,
    opacity: 0,
    delay: 50,
  });

//now we can control it!
const controller = new ScrollMagic.Controller();

const scene1 = new ScrollMagic.Scene({
  duration: 3000,
  triggerElement: intro,
  triggerHook: 0,
})
  .setPin(intro)
  .addIndicators()
  .addTo(controller);

let acc = 0.1;
let scrollpos = 0;
let delay = 0;

scene1.on("update", (e) => {
  scrollpos = e.scrollPos / 1000;
  // console.log(e);
});

setInterval(() => {
  delay += (scrollpos - delay) * acc;
  vid1.currentTime = scrollpos;
}, 99.9);
//3000/30

const scene2 = new ScrollMagic.Scene({
  duration: 3000,
  triggerElement: mid,
  triggerHook: 0,
})
  .setPin(mid)
  // .addIndicators()
  .addTo(controller);

let accl = 0.1;
let sp = 0;
delay = 0;

scene2.on("update", function (e) {
  sp = (e.scrollPos - e.startPos) / 1000;
  // console.log(sp);
});

setInterval(() => {
  delay += (sp - delay) * accl;
  vid2.currentTime = sp;
}, 99.9);
