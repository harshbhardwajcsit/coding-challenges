var mysql = require('mysql');

var connection = mysql.createConnection({
  host     : 'ejmnaxgcfbhzfpefcedo52kzd4@speckle-umbrella-21.iam.gserviceaccount.com',
  user     : 'harsh',
  password : 'harsh',
  database : 'DesignedTshirts'
});

connection.connect();

exports.connection = connection;
