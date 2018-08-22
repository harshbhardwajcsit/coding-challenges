const express = require('express');
const router = express.Router();
const db= require('/config/dbConnection').connection;

// Response handling
const response = {
  status: 200,
  data: [],
  message: null
};


router.post('/save',function (request,response) {

});

//exposed API's within the Application
module.exports = router;

