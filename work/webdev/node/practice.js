// common js module
const http = require("http");
const fs = require("fs");

const server = http.createServer((req, res) => {
  res.write("Server started");
  res.end();
});

server.listen(3000, () => {
  console.log("Server Listening");
});
