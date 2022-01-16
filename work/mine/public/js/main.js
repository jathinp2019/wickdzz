// const { io } = require("socket.io-client");

const socket = io();

const usersDisplay = document.querySelector(".userList");
const messageDisplay = document.querySelector(".messageArea");
const nameForm = document.querySelector("#nameForm");
const nameInput = document.querySelector("#nameInput");
const formInput = document.querySelector("#formInput");
const messageInput = document.querySelector("#messageInput");

let users = [];
var receiver = "";
var sender = "";
var c = 0;

var nameIn = prompt("Please enter your name", "Name");
sender = nameIn;
socket.emit("userConnected", nameIn); //to server
document.querySelector("title").innerText = nameIn;
joinUser("You", "connected");

formInput.addEventListener("submit", (e) => {
  e.preventDefault();
  let message = messageInput.value;
  let time = new Date().toLocaleTimeString();

  let pass = {
    sender: sender,
    receiver: receiver,
    message: message,
    time: time,
  };

  socket.emit("sendMessage", pass);

  createMessage({
    sender: sender,
    time: time,
    message: message,
  });
  messageInput.value = "";
});

socket.on("userConnected", function (name) {
  createUser(name);

  users.push(name);

  console.log(users);
  joinUser(name, "Connected");
});
console.log(users);

socket.on("newMessage", (data) => {
  receivedMessage(data);
});

function createUser(user) {
  const div = document.createElement("div");
  div.innerHTML = ` <div class="userBox ff-pp outline flex space-between">
  ${user}
  <div class="circle"></div>
</div>`;
  usersDisplay.appendChild(div);
}

function joinUser(user, message) {
  const div = document.createElement("div");
  div.innerHTML = ` <div class="msgBox flex column">
  <div class="userJoin ff-pp fs-small fw-500">
      <div class="msg">
          ${user} ${message}
      </div>
  </div>
</div>`;
  messageDisplay.appendChild(div);
}

function receivedMessage(data) {
  const div = document.createElement("div");

  div.innerHTML = `
  <div class="msgBox flex column">
  <div class="receiveMessage ff-pp fs-small fw-400">
  <div class="flex space-between">
      <div class="user fs-small">${data.sender}</div>
      <div class="time fs-small">${data.time}</div>
  </div>
  <div class="msg">
  ${data.message}
  </div>
</div>
</div>
  `;
  messageDisplay.appendChild(div);
}

function createMessage(pass) {
  const div = document.createElement("div");

  div.innerHTML = `
  <div class="msgBox flex column">
  <div class="sendMessage ff-pp fs-small fw-400">
  <div class="flex space-between">
      <div class="user fs-small">${pass.sender}</div>
      <div class="time fs-small">${pass.time}</div>
  </div>
  <div class="msg">
  ${pass.message}
  </div>
  </div>
</div>
  `;
  messageDisplay.appendChild(div);
}

socket.on("disconnected", (id) => {
  // c++;
  console.log(id);
  if (id) joinUser(id, "Disconnected");

  document.querySelectorAll(".userBox").forEach((user) => {
    if (user.innerText == id) {
      console.log("Inside : ", id);
      let circle = user.querySelector(".circle");
      circle.classList.add("bg-red");
    }
  });
});
