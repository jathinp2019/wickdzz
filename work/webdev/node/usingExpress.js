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

app.use(logger);

/*

$IMP
 @ MIDDLEWARE(top-down approach):

 Middleware are those funct that take place in bw the starting and ending of a request

 Its like creating a single function that could be used my multiple routes...

 @e.g : params, or can be app.use(func name)

 *Note: Declare this at the top if wanted to be used by all routes

*/

app.get("/mw", logger, (req, res, next) => {
  res.send("Using mw");
}); // this way we could restrict the middleware to a specific route

function logger(req, res, next) {
  console.log("URL: ", req.originalUrl);
  next();
}

//---------------------------------
// @ Static files:
app.use(express.static("public"));

//---------------------------------
// @ Parsing JSON data from frontend
app.use(express.urlencoded({ extended: true }));

app.get("/form", (req, res) => {
  res.render("forms");
});

app.post("/form", (req, res) => {
  console.log(req.body.firstname); // getting the data
  res.send("User Created");
});

//---------------------------------
//---------------------------------
//---------------------------------
app.use("/users", userRouter);

// this means that use the 'userRouters' with the base dir of '/users'...so that we dnt hv to use it multple times while nesting... and makes it a cleaner code

app.listen(3000, () => {
  console.log("Server 3000 Listening");
});
