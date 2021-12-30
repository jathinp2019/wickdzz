function t1() {
  // if (count == 1) {
  gsap
    .timeline({
      scrollTrigger: {
        trigger: "main",
        start: "top -100",
        end: "bottom 50",
        // pin: ".text",
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

  gsap
    .timeline({
      scrollTrigger: {
        trigger: "main",
        start: "top -200",
        end: "bottom 50",
        // pin: ".text",
        scrub: 1,
        markers: true,
      },
    })
    .to(vidContainer, {
      scale: 0.9,
      duration: 5,
    });

  console.log("started");
}

function hiding(obj) {
  obj.classList.add("hide");
}
