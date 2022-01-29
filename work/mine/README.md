# TEAM - 16
BL.EN.U4CSE20196 – V S S R L Asritha <br>
BL.EN.U4CSE20192 – Vaishakh Nambiar <br>
BL.EN.U4CSE20123 – P Rithika Reddy <br>
BL.EN.U4CSE20200 – Vignesh G S <br>


### TECHNOLOGIES:
NODEJS, EXPRESSJS, SOCKET.IO, POSTMAN(API TESTING), MySQL (DBMS) 


### DEPENDENCIES
(To be downloaded)

#### Commands:
- Downloading NodeJS from <a href="https://nodejs.org/en/download/">HERE</a>
- npm i express@4   (Express)
- npm socket.io socket.io-client (Socket communications)
- npm i hbs (Render Engine)
- npm mysql2  (Database)
- npm dotenv
- npm i jsonwebtokens
- npm i bcryptjs
- npm i cookie-parser
- npm i dotenv
- npm i google-gax


#### Creating relative Tables:

- CREATE TABLE if not exists loginUser (
`user_id` int NOT NULL PRIMARY KEY AUTO_INCREMENT,
`user_name` varchar(256),
`user_pass` varchar(256),
`user_email` varchar(256),
`user_phone` varchar(20)
);

- CREATE TABLE `gchat` (
  `chat_id_GID` varchar(45) NOT NULL,
  `sender` varchar(45) NOT NULL,
  `receiver` varchar(45) NOT NULL,
  `msg` text NOT NULL,
  `timeSent` varchar(45) NOT NULL,
  PRIMARY KEY (`chat_id_GID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

## To Run the application
 - node server.js
   at the respective PORT(here 3000)<br>
   So http://localhost:3000/