import React, { useState, useEffect} from "react";
import './App.css';
import axios from 'axios'

function App() {
const [product_id, setProductID] = useState('')
const [quantity, setquantity] = useState('')
const [wholesale_cost, setWholesaleCost] = useState('')
const [sale_price, setSalePrice] = useState('')
const [supplier_id, setSupplierID] = useState('')

useEffect(() => {
  axios.get("http://localhost:3000/api/get").then((response)=> {
    console.log(response.data);
  });
}, []);

const submitReview = () => {
  axios.post("http://localhost:3000/api/insert", {
    movieName: movieName, 
    movieReview: review
  }).then(() => {
    alert("successful insert")
  })
};

  return (
    <div className="App">
      <h1>CRUD-APPLICATION</h1>
      <div className="form">
        
      <label>product id:</label>
        <input type="text" name="product_id" onChange={(e)=> {
          setProductID(e.target.value)
        }}/>

      <label>quantity:</label>
        <input type="int" name="quantity" onChange={(e)=> {
          setQuantity(e.target.value)
        }}/>

        <label>wholesale cost:</label>
        <input type="int" name="wholesale_cost" onChange={(e)=> {
          setWholesaleCost(e.target.value)
        }}/>

        <label>sale price:</label>
        <input type="int" name="sale_price" onChange={(e)=> {
          setSalePrice(e.target.value)
        }}/>

        <label>supplier id</label>
        <input type="text" name="supplier_id"onChange={(e)=> {
          setSupplierID(e.target.value)
        }}/>

        <button onClick={submitReview}>Submit</button>
      </div>
    </div>
  );
}

export default App;

