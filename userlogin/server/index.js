const express = require("express");
const mysql = require("mysql");
const cors = require("cors");
const bodyParser = require("body-parser");

const app = express();

app.use(express.json());
app.use(cors());
//app.use(bodyParser.urlencoded({ extended: true}));

const db = mysql.createConnection({
    host: "localhost",
    user: "root",
    password: "password",
    database: "teamsix",
});

// creating a route in our back end
app.post("/register", (req, res) => {

    // grabs the value stored in username on the
    //front end and stores it here
    const username = req.body.username;
    const password = req.body.password;
    const location = req.body.location;
    db.query(
        "INSERT INTO customers(cust_email, cust_password, cust_location) VALUES (?,?,?)", 
        // passing it an array for username and password
        [username, password, location], 
        (err, result) => {
        console.log(err);
    }
 );
});

app.post('/login', (req, res) => {
    const username = req.body.username;
    const password = req.body.password;

    db.query(
        "SELECT * FROM users WHERE username = ? AND password = ?",
        // passing it an array for username and password
        [username, password], 
        (err, result) => {
            if (err) {
                res.send({err: err});
            } 

            // if there is no error and the user pass is in the db
            // send the result to the front end
            if (result.length > 0) {
                res.send(result);
            // else send a message saying wrong user pass
            } else {
                res.send({message: "Wrong username/password combination!"});
            }
            
        }
    );
    })

app.listen(3001, () => {
    console.log("running server");
});
app.post('/login', (req, res) => {
    const username = req.body.username;
    const password = req.body.password;

    db.query(
        "SELECT * FROM users WHERE username = ? AND password = ?",
        // passing it an array for username and password
        [username, password], 
        (err, result) => {
            if (err) {
                res.send({err: err});
            } 

            // if there is no error and the user pass is in the db
            // send the result to the front end
            if (result.length > 0) {
                res.send(result);
            // else send a message saying wrong user pass
            } else {
                res.send({message: "Wrong username/password combination!"});
            }
            
        }
    );
    })

app.listen(3001, () => {
    console.log("running server");
});
