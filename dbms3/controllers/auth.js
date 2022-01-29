const mysql = require("mysql");
const jwt= require("jsonwebtoken");
const express=require('express');
const bcrypt= require("bcryptjs");
const async = require("hbs/lib/async");
const db = mysql.createConnection({
    host: process.env.DATABASE_HOST,
    user: process.env.DATABASE_USER,
    password: process.env.DATABASE_PASSWORD,
    database: process.env.DATABASE,
    
}) 



exports.register = (req,res) => {
    console.log(req.body);
   
    const username= req.body.username;
    const phone=req.body.phone; 
    const email= req.body.email;
    const password= req.body.password;
    const repassword=req.body.repassword; 
   //destructuring
   // const { username,phone,email,password,repassword} =req.body;
   // var results=[1,2,3];
    db.query('SELECT user_email FROM loginUser WHERE user_email=?', [email], async (error,results) => {
        if(error) {
            console.log(error);
        }
       if(results.length>0)
        {
            return res.render('register', {
                message: 'That email is already in use'
            })
        }
        else   if ( password !== repassword ) {
            return res.render('register', {
                message: 'Passwords do not match'
            }); 
        }

          /* let hashedPassword = await bcrypt.hash(password,8);
          console.log(hashedPassword);

          //res.send("testing");
          db.query('INSERT INTO loginUser SET ?', {
              user_name: username,
              user_email:email,
              user_pass: hashedPassword,
              user_phone: phone
          }, (error,results) => {
                 if(error)
                 {console.log(error);}
                 else {
                     console.log(results);
                     return res.render('register',{
                         message: 'User registered'
                     });
                 }
          } ) */


          bcrypt.hash(password, 8, function(err, hashedPassword) {
            // Store hash in your password DB.
            db.query('INSERT INTO loginUser SET ?', {
                user_name: username,
                user_email:email,
                user_pass: hashedPassword,
                user_phone: phone
            }, (error,results) => {
                   if(error)
                   {console.log(error);}
                   else {
                       console.log(results);
                       return res.render('register',{
                           message: 'User registered'
                       });
                   }
            } )
        });
        



        } ) 
 
      
       
}   
// for the login
    exports.login = (req,res) => {
    console.log(req.body);
    const email = req.body.email;
    const password = req.body.password;
    db.query("SELECT user_pass FROM loginUser WHERE user_email=?",[email],  async(error,user) => {
       
        if(error)
        {
            console.log(error);
            console.log("Error block entered");
        }
        else if(user.length<=0)
        {
             return res.render('login',{
                message: 'Username does not exist'
            });
        }
        else {
           //console.log(user['user_pass']);
           console.log(typeof(user));
           console.log(user);
          const stringUser= JSON.stringify(user);
          var json= JSON.parse(stringUser);
          console.log("below is json");
          console.log(json);
          console.log("below is json 0 name");
          console.log(json[0].user_pass);
          const finalUser=json[0].user_pass
           //const testUser="$2a$08$zEFPXZH4gBJjsmmYuMDWSOufAkWq28WX7ZROztec.dCkxI/hCIRvm";

          // console.log("The password should be above");
            bcrypt.compare(password, finalUser, function(err, result) {
                // result == true
                if(result)
                {
                    return res.render('index',{
                        message: 'Username loged in'
                    });
                }
                else {
                    return res.render('login',{
                        message: 'Check Password'
                    });

                }
            });
           
        } 
    });
}

        



        




        /*
        doing it my way
        if(error)
        {
            console.log(error);
            console.log("Error block entered");
        }
        else if(user.length<=0)
        {
             return res.render('login',{
                message: 'Username does not exist'
            });
        }
             else{
                 //let hashedPassword=await bcrypt.hash(password,8);
                 //console.log(hashedPassword);
                 //console.log("Above is the hashed password");

                 db.query("SELECT * FROM loginUser WHERE user_pass=?",[hashedPassword],  async(error,results) => {
                    if(results.length<=0)
                    {
                        console.log(results);
                        console.log("results above");
                        return res.render('login',{
                            message: 'Check Password'
                        });
                    }
                    else {
                        return res.render('index',{
                            message: 'User logged in'
                        });
                    }
             })
            }
        });
     }
      */
    




        /*else {
         return res.render('login',{
             message: 'Please enter the correct password'
         }); 
            
        } 
         )*/
    

    







    /*const hashedPassword= bcrypt.hash(password,8);
    console.log(hashedPassword);
    db.query("SELECT * FROM loginUser WHERE user_email=?",[email],  function(error,results,fields){
           if(error)
           {console.log(error)}
           else if(results.length<=0)
           {
                return res.render('login',{
                   message: 'Check Username and Password'
               });
           }
           else bcrypt.compare(password, hashedPassword, function(err, res) {
             if (res == true)
             {
                return res.render('index',{
                    message: 'User logged in'
                });
             } 
             else {
                return res.render('login',{
                    message: 'Wrong Password'
                });
             }
          });
           
           /*else {
            return res.render('login',{
                message: 'Please enter the correct password'
            }); 
               
           } 
           ) */
        
