import './App.css';
import Axios from 'axios';
import React, { useState } from "react";


function App() {

  // constants for inserting items to the db
  const [appProductID, setProductID] = useState("");
  const [appQuantity, setQuantity] = useState("");
  const [appWholesaleCost, setWholesaleCost] = useState("");
  const [appSalePrice, setSalePrice] = useState("");
  const [appSupplierID, setSupplierID] = useState("");
  const [productList, setProductList] = useState([]);

    // constants for reading items from the db
    const [readProductID, setReadProductID] = useState("");
    const [readQuantity, setReadQuantity] = useState("");
    const [readWholesaleCost, setReadWholesaleCost] = useState("");
    const [readSalePrice, setReadSalePrice] = useState("");
    const [readSupplierID, setReadupplierID] = useState("");
    const [productStatus, setproductStatus] = useState("");
    const [productStatusList, setProductStatusList] = useState([]);

    //constants for updating itams from the db
    const [updateProductQuantity, setUpdateProductQuantity] = useState("");


  // create method
  const submitItem = () => {
    Axios.post("http://localhost:3001/api/insert", {
      productID: appProductID, 
      quantity: appQuantity, 
      wholesaleCost: appWholesaleCost, 
      salePrice: appSalePrice, 
      supplierID: appSupplierID 
    });

      setProductList([
        ...productList,
        {  productid: appProductID, quantity: appQuantity, wholesaleCost: appWholesaleCost, salePrice: appSalePrice, supplierID: appSupplierID  },
        ]);
  
  };

  // read method
    const readItem = () => {
      Axios.post("http://localhost:3001/api/read", {
        productid: readProductID,
        quantity: readQuantity,
        wholesalecost: readWholesaleCost,
        saleprice: readSalePrice,
        supplierid: readSupplierID,

      }).then((response) => {
        if (response.data.message) {
          setproductStatus(response.data.message);
        } else {
          setProductStatusList(response.data)
        }
        console.log(response.data);
      });
    };

  // update method
  const updateItem = (updateProductid) => {
    Axios.put("http://localhost:3001/api/update", {
  
    productid: updateProductid,
      quantity: updateProductQuantity,
    });
  };

  // delete method uses `` quotes not "" quotes or '' quotes
    const deleteItem = (productid) => {
      Axios.delete(`http://localhost:3001/api/delete/${productid}`);
    }

  return (
    <div className="App">
     
    <h1>Team Six Database</h1>

    <div className="inputForm">

      <div className="create">
      <label>Product ID</label>
      <input type="text" name="productID" onChange={(e)=> {
        setProductID(e.target.value)
      }}></input>
      
      <label>Item Quantity</label>
      <input type="number" name="quantity"onChange={(e)=> {
        setQuantity(e.target.value)
      }}></input>
      
      <label>Wholesale Cost</label>
      <input type="number" name="wholesaleCost"onChange={(e)=> {
        setWholesaleCost(e.target.value)
      }}></input>
      
      <label>Sale Price</label>
      <input type="number" name="salePrice"onChange={(e)=> {
        setSalePrice(e.target.value)
      }}></input>
      
      <label>Supplier ID</label>
      <input type="text" name="supplierID"onChange={(e)=> {
        setSupplierID(e.target.value)
      }}></input>
      </div>
  
      <button onClick={submitItem}>Submit</button>
      </div>
      
      <div className="read">
        <h1>Read</h1>
        <input type="text" placeholder="Product Search..."
        onChange={(e) => {
          setReadProductID(e.target.value)
        }}></input>

        <button onClick={readItem}> Search </button>
        {productStatusList.map((val) => {
          return (
            <div>
          <h1>Product ID : {val.productid}</h1>
          <p>Quantity: {val.quantity}</p>
          <p>Wholesale cost: {val.wholesalecost}</p>
          <p>Sale price: {val.saleprice}</p>
          <p>Supplier ID: {val.supplierid}</p>

          <button onClick={() => {deleteItem(val.productid)}}>Delete</button>

          <input type="text" id="updateInput" onChange={(e)=> {
            setUpdateProductQuantity(e.target.value)
          }}></input>
          <button onCLick={()=> {updateItem(val.productid)}}>Update</button>
          </div>
          );
        })}
      </div>
      

      </div>
  );
}

export default App;
