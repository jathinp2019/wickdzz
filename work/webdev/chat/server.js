//@  SERVER SCRIPTING

const path = require("path");
const http = require("http");
const express = require("express");
const socketio = require("socket.io");

const app = express();
const server = http.createServer(app);
const io = socketio(server);

const port = 3000 || process.env.PORT;

app.use(express.static(path.join(__dirname, "public")));

io.on("connection", (socket) => {
  console.log("new connection");

  //when client connects
  socket.emit("message", "Welcome , Connection established"); // "message" from main.js will be accessed

  //when user connects(broadcast)
  socket.broadcast.emit("message", "User joined"); // BROADCAST: evryone other than user

  socket.on("disconnect", () => {
    io.emit("message", "A USER LEFT"); //to evryone
  });

  //Listen for chat
  socket.on("chatMessage", (msg) => {
    console.log(msg);
  });
});

server.listen(port, () => {
  console.log(`Server Listening ${port}`);
});
