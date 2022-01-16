const http = require("http");
const path = require("path");

const express = require("express");
const app = express();
const server = http.createServer(app);

const io = require("socket.io")(server);

app.use("/", express.static(path.join(__dirname, "public")));

app.get("/", (req, res) => {
  console.log(" SERVER STARTED");
});

var users = [];
var userNames = [];

io.on("connection", (socket) => {
  console.log("user connected", socket.id);

  console.log(userNames);

  socket.on("userConnected", function (username) {
    //from client
    users[socket.id] = username;

    // if(userNames)
    userNames.push(username);
    console.log(users);

    socket.broadcast.emit("userConnected", username); //to client
  });

  socket.on("userSelect", function (username) {
    // console.log("user-selected: ", socket.id);
  });

  socket.on("sendMessage", function (data) {
    // console.log(data);
    var room = users[data.receiver];
    console.log("data: ", data);
    // io.to(room).emit("newMessage", data);
    socket.broadcast.emit("newMessage", data);
  });

  socket.on("disconnect", () => {
    io.emit("user disconnect");
    console.log(socket.id, " Disconnect");

    io.emit("disconnected", users[socket.id]);
  });
});

server.listen(3000, () => {
  console.log("SERVER LISTENING");
});
