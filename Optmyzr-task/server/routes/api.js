const express = require('express');
const router = express.Router();
const MongoClient = require('mongodb').MongoClient;
const ObjectID = require('mongodb').ObjectID;

// Connect
const connection = (closure) => {
  return MongoClient.connect('mongodb://localhost:27017/publication-service', (err, db) => {
    if (err) return console.log(err);
    closure(db);
  });
};

// Error handling
const sendError = (err, res) => {
  response.status = 501;
  response.message = typeof err === 'object' ? err.message : err;
  res.status(501).json(response);
};

// Response handling
let response = {
  status: 200,
  data: [],
  message: null
};


router.get('/login',(req,res)=>{

  res.send('this is test1');
});

router.get('/test2',(req,res)=>{
  res.send("this is test 2");
});

//exposed API's within the Application
module.exports = router;


