const express = require("express");
const router = express.Router();

//routers
router.get("/users", (req, res) => {
  res.send("users");
});
router.get("/users/new", (req, res) => {
  res.send("users/new");
});
