import fetch from 'node-fetch';

async function logMovies() {
  const divContent = document.querySelector("#game-square");

  console.log(divContent.textContent.replaceAll("123456789", "0"));

  const response = await fetch("http://localhost:8080/api/getSolvedBoard?board=%5B%5B%220%22%2C%220%22%2C%220%22%2C%220%22%2C%220%22%2C%228%22%2C%220%22%2C%225%22%2C%220%22%5D%2C%5B%220%22%2C%220%22%2C%220%22%2C%220%22%2C%220%22%2C%220%22%2C%229%22%2C%226%22%2C%220%22%5D%2C%5B%220%22%2C%220%22%2C%226%22%2C%220%22%2C%225%22%2C%220%22%2C%220%22%2C%224%22%2C%220%22%5D%2C%5B%228%22%2C%227%22%2C%220%22%2C%221%22%2C%222%22%2C%220%22%2C%220%22%2C%220%22%2C%220%22%5D%2C%5B%220%22%2C%223%22%2C%220%22%2C%220%22%2C%220%22%2C%227%22%2C%220%22%2C%220%22%2C%229%22%5D%2C%5B%220%22%2C%220%22%2C%220%22%2C%229%22%2C%226%22%2C%223%22%2C%220%22%2C%220%22%2C%228%22%5D%2C%5B%220%22%2C%224%22%2C%220%22%2C%225%22%2C%223%22%2C%220%22%2C%227%22%2C%228%22%2C%220%22%5D%2C%5B%227%22%2C%220%22%2C%228%22%2C%220%22%2C%221%22%2C%220%22%2C%223%22%2C%220%22%2C%220%22%5D%2C%5B%220%22%2C%225%22%2C%220%22%2C%220%22%2C%228%22%2C%220%22%2C%224%22%2C%220%22%2C%222%22%5D%5D");
  const board = await response.json();
  console.log(board);
}

logMovies();


/*

// Select the input element with the id "p1"
var input;
var board = "";
var sudokuArray = new Array(9);
for (var i = 0; i < 9; i++) {
  sudokuArray[i] = new Array(9);
}

console.log("Executing script...");

    // Wait for the DOM content to fully load
    document.addEventListener('DOMContentLoaded', function() {

// Check if the input element is found before trying to access its content
for (var i = 1; i < 82; i++) {
    var p = "#p" + i;
    input = document.querySelector(p);
    if (input) {
        // Access and print the value of the input element
        if (input.value.trim() === "") {
            //console.log("Input is empty");
            board += "0";
        } else {
            //console.log(`Input value: ${input.value}`);
            board += input.value;
        }
    } else {
        console.log(`Input element with id ${p} not found.`);
    }
}

console.log(board);

var counter = 0;

for (var i = 0; i <= 8; i++){
    for (var j = 0; j <= 8; j++){
        sudokuArray[i][j] = board.charAt(counter);
        counter++;
    }
}

console.log(sudokuArray);

var sudokuArrayUrl = encodeURIComponent(JSON.stringify(sudokuArray));
console.log(sudokuArrayUrl);

fetch("http://localhost:8080/api/getSolvedBoard?board=" + sudokuArray)
            .then(response => response.json())
            .then(board => console.log(board))
            .catch(error => console.error(error));
    });
*/ 
