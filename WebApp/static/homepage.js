/*
 *  searchpage.js
 *  Yanhan Lyu, Lucy Wu, 15 May 2017
 *
 */

// Function get called when the "Go!" button is clicked
// It would fetch the data entered by user
// and store the data for later use in searchpage
function onButton() {

  // Initializes variable for storage
  var checkedValue = []; 
  var newDate = "";
  var count = 0;

  // Get the department checked by the user
  var inputElements = document.getElementsByClassName('departmentCheckbox');

  // Get the date selected by the user
  var date = document.getElementById("myDate").value;

  // Get the keyword entered by the user
  var inputString =  document.getElementById('input').value;

  // Parse the date passed in and format it into desired format
  for (var i = 0, len = date.length; i < len; i++) {
    if (date.charAt(i) != '-'){
      newDate += date.charAt(i)
    }
  }
  
  // Store the department checked by the user
  for(var i=0; inputElements[i]; ++i){
    if(inputElements[i].checked){
         checkedValue[count] = inputElements[i].value;
         localStorage.setItem(count, inputElements[i].value);
         count++;
    }
  }

  // Store the data
  localStorage.setItem("input", inputString);
  localStorage.setItem("date", newDate);
  localStorage.setItem('departmentLength', checkedValue.length);
  
  // Direct the homepage to searchpage

  
}


