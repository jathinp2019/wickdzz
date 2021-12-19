function play() {
  document.addEventListener("DOMContentLoaded", () => {
    const bird = document.querySelector(".bird");
    const container = document.querySelector(".container");
    const count = document.querySelector(".counter div");

    var birdBottom = 300;
    var birdLeft = 100;
    var gravityValue = 3;
    var counter = 0;
    var over = false;

    bird.style.bottom = birdBottom + "px";
    bird.style.Left = birdLeft + "px";

    document.addEventListener("keydown", (key) => {
      if ((key.code = "Space")) jump();
    });

    function randomHeight() {
      return Math.floor(Math.random() * 400 + 100);
    }

    function jump() {
      if (!over) {
        birdBottom += 50;
        bird.style.bottom = birdBottom + "px";
      }
    }

    function gravity() {
      birdBottom -= gravityValue;
      bird.style.bottom = birdBottom + "px";
    }

    function make() {
      var left = 650;
      var h = randomHeight();

      if (!over) {
        var obst = document.createElement("div");

        obst.classList.add("col");
        obst.style.height = h + "px";

        obst.style.left = left + "px";
        obst.style.border = "2px solid black";
        container.appendChild(obst);
      }

      function move() {
        if (!over) {
          left += -20;
          obst.style.left = left + "px";

          if (left < -100) {
            clearInterval(m);
            container.removeChild(obst);
            counter++;
          }
          //checking
          if (
            (left < 100 &&
              left > 50 &&
              (birdBottom < h - 10 || birdBottom > h + 110)) ||
            birdBottom < 50
          ) {
            console.log("Dead");
            document.removeEventListener("keydown", jump);
            clearInterval(m);
            clearInterval(g);
            alert("GAME OVER");
            over = true;
          }
        }
      }
      count.innerText = counter;

      let m = setInterval(move, 100);
      setTimeout(make, 2000);
    }
    make();
    let g = setInterval(gravity, 20);
  });
}

play();
