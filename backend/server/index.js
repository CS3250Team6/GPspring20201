const express = require("express");
const bodyParser = require('body-parser');
const cors = require('cors');
const app = express();
const mysql = require("mysql");

const db = mysql.createPool({
    host: "localhost",
    user: "root",
    password: "password",
    database: "teamsix",
    port: '3306',
});

/*
// this method says get the / route
// then send hello world to that route
app.get("/", (req, res) =>{
    res.send("hello world")
});
*/
app.use(cors());
app.use(express.json());
app.use(bodyParser.urlencoded({ extended: true }));

// Create
app.post("/api/insert", (req, res) => {

    const indexProductID = req.body.productID;
    const indexQuantity = req.body.quantity;
    const indexWholesaleCost = req.body.wholesaleCost;
    const indexSalePrice = req.body.salePrice;
    const indexSupplierID = req.body.supplierID;

    // create a string to pass to the db
    const sqlInsert = 
        "INSERT INTO inventory_team_six (productid, quantity, wholesalecost, saleprice, supplierid) VALUES (?, ?, ?, ?, ?)";
    db.query(sqlInsert, [indexProductID, indexQuantity, indexWholesaleCost, indexSalePrice, indexSupplierID], (err, result) => {
        console.log(result);
    
    });
}); 


//sends the entire database
// Read
app.post('/api/read', (req, res) => {

    const productid = req.body.productid;
    const quantity = req.body.quantity;
    const wholesaleCost = req.body.wholesalecost;
    const salePrice = req.body.saleprice;
    const supplierID = req.body.supplierid;

    db.query(
        "SELECT * FROM inventory_team_six WHERE productid = ?",
    (productid), 
    (err, result) => {
        if (err) {
        res.send({err: err});
        }

        if (result.length > 0) {
            res.send(result);
        } else {
            res.send({message: "No product found."});
        }
    });
});

//Finds if there are any products under $20
app.post('/api/under20', (req,res) =>{

    const salePrice = req.body.saleprice;

    db.query(
        "SELECT * FROM inventory_team_six WHERE productid = ?",
    (saleprice), 
    (err, result) => {
        if (err) {
        res.send({err: err});
        }

        if (result.salePrice < 20) {
            res.send(result);
        } else {
            res.send({message: "No product found."});
        }
    });


/*
// Trying to get it to accept one variable and display
// the data in that row. Not working
// Read
app.get('/api/get', (req, res)=> {
    const indexProductID = req.body.productID;
    const sqlSelect = 
    "SELECT * FROM inventory_team_six WHERE productid = ?;";
    db.query(sqlSelect, (indexProductID), (err, result) => {
    res.send(result); 
    });
});
*/


// Update
app.put("/api/update", (req, res) => {
    const productid = req.body.updateProductid;
    const quantity = req.body.updateProductQuantity;
    const sqlUpdate = "UPDATE inventory_team_six SET quantity = ? WHERE productid = ?";

    db.query(sqlUpdate, [quantity, productid], (err, result) => {
        console.log(result);
        if (err) console.log(err);
    });
});



// Delete
app.delete("/api/delete/:productid", (req, res) => {
    const deleteProductID = req.params.productid;
    const sqlDelete = "DELETE FROM inventory_team_six WHERE productid = ?";

    db.query(sqlDelete, deleteProductID, (err, result) => {
        if (err) console.log(err);
    });
});



app.listen(3001, () =>{
    console.log("running on port 3001");
});
