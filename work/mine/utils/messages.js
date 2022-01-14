const moment = require("moment");
const mysql = require("mysql2");
const db = mysql.createConnection({
  host: "localhost",
  user: "root",
  password: "database2021",
  database: "try1",
});

function formatMessage(username, text) {
  console.log("hi ", username);

  let sql = `
  INSERT INTO room1(
    user,
    u_m
    )
    VALUES("${username}","${text}");
    `;

  db.execute(sql);

  return {
    username,
    text,
    time: moment().format("h:mm a"),
  };
}

// module.exports = { formatMessage, leftMessage };
module.exports = formatMessage;
