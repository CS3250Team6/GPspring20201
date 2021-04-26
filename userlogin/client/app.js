import React, { useState } from "react";
import Axios from "axios";
import './App.css';

function App() {
  // 2 constants that allow a user to register
  const [usernameReg, setUsernameReg] = useState('');
  const [passwordReg, setPasswordReg] = useState('');
  const [locationReg, setLocationReg] = useState('');

    // 2 constants that check if the user exists
    const [username, setUsername] = useState('');
    const [password, setPassword] = useState('');

    // const to check user status
    const [loginStatus, setLoginStatus] = useState('')

  // function to send the data from the front end to 
  // the back end
  const register = () => {
    // here we pass an object which contains 2 properties
    // the const usernameReg, and the const passwordReg
    Axios.post("http://localhost:3001/register", { 
      // these 2 will be used on the back end
      username: usernameReg, 
      password: passwordReg, 
      location: locationReg,
      // here we make a promise and pass it response
      // then console.log the response so we can see
      // if there is an error
    }).then((response) => {
        console.log(response);
    });
  };

  const login = () => {
    // here we pass an object which contains 2 properties
    // the const usernameReg, and the const passwordReg
    Axios.post("http://localhost:3001/login", { 
      // these 2 will be used on the back end
      username: username, 
      password: password, 
      // here we make a promise and pass it response
      // then console.log the response so we can see
      // if there is an error
    }).then((response) => {
        if (response.data.message) {
          setLoginStatus(response.data.message)
        } else {
          setLoginStatus(response.data[0].username);

        }
        console.log(response.data);
    });
  };

  return (
    <div className="App">
      <div className="registration">
      <h1>Registration</h1>
      <label>Username</label>
      <input 
      type="text" 
      onChange={(e) => {
      setUsernameReg(e.target.value);
      }}
      ></input>
      <label>Password </label>
      <input 
      type="text" 
      onChange={(e) => {
      setPasswordReg(e.target.value);
      }}
      ></input>
      <label>Location</label>
      <input
      type="text"
      onChange={(e) => {
        setLocationReg(e.target.value);
      }}
      ></input>
      {/* 
      set onclick for this button to call the 
      register const function
       */}
      <button onClick={register}> Register </button>
      </div>



      <div className="login">
      <h1>login</h1>
      <input type="text" placeholder="Username..." 
      onChange={(e) => {
      setUsername(e.target.value);
      }}
      ></input>
      <input type="password" placeholder="Password..." 
      onChange={(e) => {
      setPassword(e.target.value);
      }}></input>
      <button onClick={login}> Login </button>
      </div>

      <h1>{loginStatus}</h1>
    </div>
  );
}

export default App;

