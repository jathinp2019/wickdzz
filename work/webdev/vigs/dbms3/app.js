const express = require("express");
const mysql = require("mysql");
const path=require('path');
const app = express();
const dotenv = require('dotenv');
dotenv.config({ path: './.env' });
// creating conn
const db = mysql.createConnection({
    host: process.env.DATABASE_HOST,  
    user: process.env.DATABASE_USER,
    password: process.env.DATABASE_PASSWORD,
    database: process.env.DATABASE,
    
}) 
const publicDirectory = path.join(__dirname, './public');
app.use(express.static(publicDirectory));

//to parse the url encoded bodies sent by forms
app.use(express.urlencoded({
    extended:false
}));

//parse JSON bodies that are sent by API clients
app.use(express.json());

app.set('view engine', 'hbs');


//connect
db.connect( (error) => {
    if(error) {
        console.log(error);
    }
    else {
    console.log("MySql Connected..."); 
}
})

//defining the routes
app.use('/',require('./routes/pages'));
app.use('/auth', require('./routes/auth'));

app.listen(8080,() => {
    console.log("Server started on port 8080");
}) 
 