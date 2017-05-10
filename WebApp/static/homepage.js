/*
 *  books-config.js
 *  Jeff Ondich, 25 April 2017
 *
 *  Configuration file for the books & authors web application
 *  for Carleton CS257, Spring Term 2017.
 */

// Set this to match the base URL at which your books_api.py is listening.
var checkvalue[]; 
var inputString; 
function onButton() {
    checkedValue = null; 
    var count = 0;
    var inputElements = document.getElementsByClassName('departmentCheckbox');
    for(var i=0; inputElements[i]; ++i){
          if(inputElements[i].checked){
               checkedValue[count] = inputElements[i].value;
               count++;
          }
    }
    inputString =  document.getElementById('input');
}

