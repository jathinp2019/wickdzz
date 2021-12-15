const express = require("express");
const app = express(); // creating an application
/*
app.get("/", (req, res, next) => {
  res.write("Using express");
  res.end();
});

app.get("/download", (req, res, next) => {
  res.download("practice.js");
});

app.get("/json", (req, res, next) => {
  res.json({ message: "Error " });
});
*/
//-----------------------------

//for rendering: we need a 'RENDER-ENGINE'
app.set("view engine", "ejs");
// and the file too should be with '.ejs' extension
app.get("/", (req, res, next) => {
  res.render("render");
});
// by default it will be saved inside 'views' file

//---------------------------------

app.listen(3000, () => {
  console.log("Server 3000");
});
