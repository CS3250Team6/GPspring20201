const express = require('express');
const bodyParser = require('body-parser')
const mysql = require('mysql');
const cors = require('cors');
const app = express();

var connection = mysql.createConnection({
    host: "localhost",
    user: "root",
    password: "password",
    database: "cruddatabase",
    port: "3306"
});
// he didn't explain coors
app.use(cors());
// he didn't explain this line but said we needed it
app.use(express.json());
// he didn't explain this line
app.use(bodyParser.urlencoded({extended: true}));


/*
not working yet
app.get("/api/get", (req, res)=> {
    const sqlSelect = "SELECT * FROM movie_reviews";
    connection.query(sqlSelect, (err, result)=> {
    //res.send(result);
    });  
});
*/

app.post('/api/insert', (req, res)=> {

const movieName = req.body.movieName
const movieReview = req.body.movieReview

    const sqlInsert = "INSERT INTO inventory_team6 (product_id, quantity, wholesale_cost, sale_price, supplier_id) Values (?,?,?,?,?,?)"
    connection.query(sqlInsert, [product_id, quantity, wholesale_cost, sale_price, supplier_id], (err, result)=> {
        console.log(result);
    })
})

app.listen(3000, ()=> {
    console.log("running on port 3000");
});
