

const express = require('express');
const app = express();
const path = require('path');
console.log("Enter http://127.0.0.1/ to view the webpage")
app.use(express.static('public')); 
app.get('/', (req, res) => {
  res.sendFile(path.join(__dirname, 'public', 'index.html'));
});

app.listen(80, () => {
  console.log('Server is running on port 80');
});
