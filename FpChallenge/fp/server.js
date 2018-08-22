const express = require('express');
const app = express();
const bodyParser = require('body-parser');

// file for routing API
const api = require('./server/routes/api');

// API location
app.use('/api', api);

// allowing CORS

app.use(function(req, res, next) {
  res.header("Access-Control-Allow-Origin", "*");
  res.header("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept");
  res.header('Access-Control-Allow-Methods', 'GET, POST, OPTIONS, PUT, PATCH, DELETE');
  // res.header('Access-Control-Allow-Credentials', true);
  next();
});



// Parsers
app.use(bodyParser.json());
app.use(bodyParser.urlencoded({ extended: false}));

app.use(express.static(__dirname + '/dist'));
app.listen(process.env.PORT || 8080, function () {
  console.log("Server is up and running");
});

