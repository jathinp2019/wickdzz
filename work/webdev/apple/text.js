function t1() {
  if (count == 1) {
    gsap
      .timeline({
        scrollTrigger: {
          // trigger: "main",
          trigger: ".vidContainer",
          start: "top -100",
          end: "bottom 50",
          scrub: 1,
          markers: true,
          ease: "power2.in",
        },
      })

      // .from("#txt1", {
      //   opacity: 0,
      //   duration: 1,
      // })
      .to("#txt1", {
        y: 0,
        opacity: 1,
        duration: 2,
      })
      .to("#txt1", {
        y: -10,
        opacity: 0,
        // stagger: 0.5,
      })

      // .from("#txt2", {
      //   y: 50,
      //   opacity: 0,
      // })
      .to("#txt2", {
        y: 0,
        opacity: 1,
        duration: 4,
        delay: 2,
      })
      .to("#txt2", {
        y: -50,
        opacity: 0,
      })

      // .from("#txt3", {
      //   y: 50,
      //   opacity: 0,
      // })
      .to("#txt3", {
        y: 0,
        opacity: 1,
        duration: 6,
        delay: 4,
      })
      .to("#txt3", {
        y: -50,
        opacity: 0,
      });

    // console.log("started");
  }
}
