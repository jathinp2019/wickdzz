const http = require("http");
const path = require("path");
var mysql = require("mysql2");

const express = require("express");
const app = express();
const server = http.createServer(app);

const dotenv = require("dotenv");
dotenv.config({ path: "./.env" });

// const io = require("socket.io")(server);

app.set("view engine", "hbs");

const publicDirectory = path.join(__dirname, "./public");
app.use(express.static(publicDirectory));

app.use(
  express.urlencoded({
    extended: false,
  })
);

app.use(express.json());

app.set("view engine", "hbs");

app.use("/", require("./routes/pages"));
app.use("/auth", require("./routes/auth"));

app.listen(2550, () => {
  console.log("Server started on port 2550");
});

const io = require("socket.io")(server);

// const io = require("socket.io")(2550);
// app.get("/", (req, res) => {
//   console.log(" SERVER STARTED");
// });
app.use(function (req, res, next) {
  req.io = io;
  next();
});

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
  });

  var sql =
    "INSERT INTO socket_chat(idsocket_chat, sender,receiver, msg,timeSent) VALUES (" +
    socket.id +
    "," +
    info.sender +
    "," +
    info.receiver +
    "," +
    info.message +
    "," +
    info.time +
    ");";
  console.log("data: ", info);

  socket.on("disconnect", () => {
    io.emit("user disconnect");
    console.log(socket.id, " Disconnect");

    io.emit("disconnected", users[socket.id]);
  });
});

server.listen(3000, () => {
  console.log("SERVER LISTENING");
});
