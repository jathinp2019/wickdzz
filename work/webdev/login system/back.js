const express = require("express");
const app = express();

app.get("/", (req, res) => {
  res.send("Hi from server");
  res.end();
});
app.use(express.static("public"));

app.get("/:id", (req, res) => {
  res.send(`In ${req.params.id}`);
  res.end();
});

app.listen(3000, (req, res) => {
  console.log("Server Listening");
});
