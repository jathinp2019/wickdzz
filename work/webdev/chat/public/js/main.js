//@ CLIENT SCRIPTING
// const fs = require("fs");

const username = document.getElementById("username");
const userForm = document.getElementById("userform");
const chatForm = document.getElementById("chat-form");
const chatMsg = document.querySelector(".chat-messages");

const socket = io();

socket.on("message", (message) => {
  console.log("In client : " + message);
});

// userForm.addEventListener("submit", (e) => {
//   e.preventDefault();
//   console.log(e.target.value);
// });

chatForm.addEventListener("submit", (e) => {
  e.preventDefault();
  const msg = e.target.elements.msg.value;
  console.log(msg);

  socket.emit("chatMessage", msg);
  outputMesage(msg);

  e.target.elements.msg.value = "";
  e.target.elements.msg.focus();
});

function outputMesage(message) {
  const div = document.createElement("div");
  div.classList.add("message");
  div.innerHTML = `<p class="meta">Mary <span>9:15pm</span></p>
    <p class="text">
        ${message}
    </p>`;

  chatMsg.appendChild(div);
  chatMsg.scrollTop = chatMsg.scrollHeight;
}
