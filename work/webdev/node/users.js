const express = require("express");
const router = express.Router();

//routers
router.get("/", (req, res) => {
  res.send("users");
});

router.get("/new", (req, res) => {
  res.send("users/new");
});

/* 
@Dynamic Routing:
creating a dynamic parameter( using :parm )

*Note: Declare all specific routings before mentioning this
*/

router.get("/:id", (req, res) => {
  res.send(`the id is : ${req.params.id}`);
});

/*
 @Route moethods:
  .get .put .delete
 Express has a combined functionality for this:
*/

router
  .route("/para/:p")

  .get((req, res) => {
    console.log(req.u);
    res.send(`GET param: ${req.params.p}`);
  })

  .put((req, res) => {
    res.send(`PUT param: ${req.params.p}`);
  })
  .delete((req, res) => {
    res.send(`GET param: ${req.params.p}`);
  });

//---------------------------
const users = [
  { n: "appu", num: 10 },
  { n: "kichu", num: 10 },
  { n: "adi", num: 10 },
  { n: "puttu", num: 10 },
  { n: "kutta", num: 10 },
];

router.param("p", (req, res, next, p) => {
  req.u = users[p].n;
  //   console.log(
  //     `Used router.param to call a function wrt to a specific parameter: ${p}`
  //   );
  next();
});

module.exports = router;
