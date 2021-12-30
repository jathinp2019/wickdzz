function t1() {
  if (count == 1) {
    gsap
      .timeline({
        scrollTrigger: {
          trigger: "main",
          start: "top -100",
          end: "bottom 0",
          // pin: true,
          scrub: 1,
          markers: true,
        },
      })

      .from("#txt1", {
        opacity: 0,
        duration: 1,
      })
      .to("#txt1", {
        y: 0,
        opacity: 1,
        duration: 10,
      })
      .to("#txt1", {
        y: -10,
        opacity: 0,
      })

      .from("#txt2", {
        y: 50,
        opacity: 0,
        duration: 2,
      })
      .to("#txt2", {
        y: 0,
        opacity: 1,
        duration: 10,
      })
      .to("#txt2", {
        y: -50,
        opacity: 0,
      })
      .from("#txt3", {
        y: 50,
        opacity: 0,
        duration: 0.5,
      })

      .to("#txt3", {
        y: 0,
        opacity: 1,
        duration: 10,
      })
      .to("#txt3", {
        y: -50,
        opacity: 0,
      });

    console.log("started");
  } else console.log(count);
}
