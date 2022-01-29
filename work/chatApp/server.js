const path = require("path");
var mysql = require("mysql2");
const express = require("express");
const app = express();
const http = require("http").createServer(app);

const publicDirectory = path.join(__dirname, "./public");
app.use(express.static(publicDirectory));

app.use(
  express.urlencoded({
    extended: false,
  })
);

app.use(express.json());

app.get("/", function (req, res) {
  var options = {
    root: path.join(__dirname),
  };

  res.sendFile("public/chat.html", options, function (err) {
    if (err) {
      throw err;
    } else {
      console.log("Sent:");
    }
  });
});

const io = require("socket.io")(http);

var db = mysql.createConnection({
  host: "localhost",
  user: "root",
  password: "database2021",
  database: "try1",
});

var users = [];
var userNames = [];
var info = {};

db.connect(() => {
  console.log("DB Connection done");
});

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

    info = data;

    var room = users[data.receiver];
    // io.to(room).emit("newMessage", data);
    socket.broadcast.emit("newMessage", data);

    var sql = `INSERT INTO gchat( chat_id_GId,sender,receiver, msg,timeSent) VALUES ("grp1_${data.id}","${data.sender}","${data.receiver}","${data.message}","${data.time}");`;

    db.execute(sql);
    console.log("data: ", info);
  });

  socket.on("disconnect", () => {
    io.emit("user disconnect");
    console.log(socket.id, " Disconnect");

    io.emit("disconnected", users[socket.id]);
  });
});

http.listen(8080, () => {
  console.log("SERVER LISTENING 8080");
});
