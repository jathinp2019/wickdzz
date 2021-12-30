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
