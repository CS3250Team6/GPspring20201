
var mysql = require('mysql');

var connection = mysql.createConnection({
    host: "localhost",
    user: "root",
    password: "password",
    port: "3306",
    database: "cruddatabase"
})

/*
// create
connection.connect(function(err) {
    if (err) {
        throw err
    } else {
        console.log("connected");
    }
        var insert = "INSERT INTO movie_reviews (movieName, movieReview) Values ('apple', 'tree')";
        connection.query(insert, function (err, result) {
        if(err) throw err;
        console.log("1 record inserted");
    });
});
*/

/*
// delete
connection.connect(function(err) {
    if (err) {
        throw err
    } else {
        console.log("connected");
    }
        var remove = "DELETE FROM movie_reviews WHERE movieName = 'duck'";
        connection.query(remove, function (err, result) {
        if(err) throw err;
        console.log("1 record removed");
    });
  });
  */

  // update
  connection.connect(function(err) {
    if (err) {
        throw err
    } else {
        console.log("connected");
    }
        var update = "UPDATE movie_reviews SET movieReview = 'banana slurp' WHERE movieName = 'banana'";
        connection.query(update, function (err, result) {
        if(err) throw err;
        console.log("1 record updated");
    });
  });
