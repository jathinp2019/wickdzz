const mysql = require("mysql2");
// const jwt = require("jsonwebtoken");
const express = require("express");
const bcrypt = require("bcryptjs");
const async = require("hbs/lib/async");
const path = require("path");

var db = mysql.createConnection({
  host: "localhost",
  user: "root",
  password: "database2021",
  database: "try1",
});

exports.register = (req, res) => {
  console.log(req.body);

  const username = req.body.username;
  const phone = req.body.phone;
  const email = req.body.email;
  const password = req.body.password;
  const repassword = req.body.repassword;

  db.query(
    "SELECT user_email FROM loginUser WHERE user_email=?",
    [email],
    async (error, results) => {
      if (error) {
        console.log(error);
      }
      if (results.length > 0) {
        return res.render("register", {
          message: "That email is already in use",
        });
      } else if (password !== repassword) {
        return res.render("register", {
          message: "Passwords do not match",
        });
      }

      bcrypt.hash(password, 8, function (err, hashedPassword) {
        // Store hash in your password DB.
        db.query(
          "INSERT INTO loginUser SET ?",
          {
            user_name: username,
            user_email: email,
            user_pass: hashedPassword,
            user_phone: phone,
          },
          (error, results) => {
            if (error) {
              console.log(error);
            } else {
              console.log(results);
              return res.render("register", {
                message: "User registered",
              });
            }
          }
        );
      });
    }
  );
};
// for the login
exports.login = (req, res) => {
  console.log(req.body);
  const email = req.body.email;
  const password = req.body.password;
  db.query(
    "SELECT user_pass FROM loginUser WHERE user_email=?",
    [email],
    async (error, user) => {
      if (error) {
        console.log(error);
        console.log("Error block entered");
      } else if (user.length <= 0) {
        return res.render("login", {
          message: "Username does not exist",
        });
      } else {
        //console.log(user['user_pass']);
        console.log(typeof user);
        console.log(user);
        const stringUser = JSON.stringify(user);
        var json = JSON.parse(stringUser);
        console.log("below is json");
        console.log(json);
        console.log("below is json 0 name");
        console.log(json[0].user_pass);
        const finalUser = json[0].user_pass;
        //const testUser="$2a$08$zEFPXZH4gBJjsmmYuMDWSOufAkWq28WX7ZROztec.dCkxI/hCIRvm";

        // console.log("The password should be above");
        bcrypt.compare(password, finalUser, function (err, result) {
          // result == true
          if (result) {
            // return res.sendFile(
            //   "public/chat.html",
            //   path.join(__dirname),
            //   function (err) {
            //     if (err) {
            //       next(err);
            //     } else {
            //       console.log("Sent:", fileName);
            //     }
            //   }
            // );
            // return res.sendFile(__dirname + "../public/chat.html");
            return res.sendFile(path.join(__dirname, "../public", "chat.html"));
            // return res.render("chat");
          } else {
            return res.render("login", {
              message: "Check Password",
            });
          }
        });
      }
    }
  );
};
