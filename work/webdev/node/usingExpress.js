const express = require("express");
const userRouter = require("./users");
const app = express(); // creating an application

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

//-----------------------------

//for rendering: we need a 'RENDER-ENGINE'

app.set("view engine", "ejs");
// and the file too should be with '.ejs' extension
app.get("/render", (req, res, next) => {
  res.render("rendering"); // by default it will be saved inside 'views' file
});

app.get("/toFront", (req, res) => {
  res.render("toFrontEnd", { text: "from backEnd through express" });
});

//---------------------------------
app.use("/users", userRouter);

// this means that use the 'userRouters' with the base dir of '/users'...so that we dnt hv to use it multple times while nesting... and makes it a cleaner code

app.listen(3000, () => {
  console.log("Server 3000");
});
