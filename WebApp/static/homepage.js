/*
 *  books-config.js
 *  Jeff Ondich, 25 April 2017
 *
 *  Configuration file for the books & authors web application
 *  for Carleton CS257, Spring Term 2017.
 */

// Set this to match the base URL at which your books_api.py is listening.

function onButton() {
  //console.log("Button Clicked");
  var checkedValue = []; 
  var inputString = "";
  var newDate = "";
  var date = "";
  var count = 0;
  var inputElements = document.getElementsByClassName('departmentCheckbox');
  var date = document.getElementById("myDate").value; 
  for (var i = 0, len = date.length; i < len; i++) {
    if (date.charAt(i) != '-'){
      newDate += date.charAt(i)
    }
  }
  //console.log(newDate);
  for(var i=0; inputElements[i]; ++i){
    if(inputElements[i].checked){
        //console.log("add checked value");
         checkedValue[count] = inputElements[i].value;
         localStorage.setItem(count, inputElements[i].value);
         count++;
         console.log(localStorage.getItem(count));
    }
  }
  inputString =  document.getElementById('input').value;
  localStorage.setItem("input", inputString);
  localStorage.setItem("date", newDate);
  localStorage.setItem('departmentLength', checkedValue.length);



  //console.log("Input String: ", inputString);

  // if (inputString.length != 0){
  //   var url = api_base_url+"keyword/"+inputString;
  //   xmlHttpRequest = new XMLHttpRequest();
  //   xmlHttpRequest.open('get', url);
  //   //console.log("here!!!!!!!");
    //xmlHttpRequest.onreadystatechange = function() {
      //console.log("here!!!!!!!");
      // console.log(xmlHttpRequest.readyState);
      // console.log(xmlHttpRequest.status);
      // console.log(url);
      // if (xmlHttpRequest.readyState == 4 && xmlHttpRequest.status == 200) { 
      //     callback(xmlHttpRequest.responseText);
      //   } 
      // }; 
  //   xmlHttpRequest.send(null);
  // } 


  // if (checkedValue.length != 0){
  //   var department_url = api_base_url + 'department/';
  //   for (i in checkedValue) {
  //     xmlHttpRequest = new XMLHttpRequest();
  //     url = department_url+checkedValue[i];
  //     console.log("department", url);
  //     xmlHttpRequest.open('get', url);
  //     var tempEventList = [];
  //     xmlHttpRequest.onreadystatechange = function() {
  //       if (xmlHttpRequest.readyState == 4 && xmlHttpRequest.status == 200) { 
  //         //console.log("here!!!!!!!!dep!!!!!!");
  //         tempEventList = JSON.parse(xmlHttpRequest.responseText);
  //         //console.log("temp!!!"+xmlHttpRequest.responseText);
  //       } 
  //     };
  //     xmlHttpRequest.send(null);
  //     for (events in tempEventList){
  //       eventListDepartment.add(tempEventList[events]);
  //       //console.log("dep!!!"+eventListDepartment);
  //     }
  //   }

  // }
  // console.log("key!!!!!!!"+eventListKeyword);

  // if (newDate.length != 0){
  //   var url = api_base_url + 'date/'+newDate;
  //   xmlHttpRequest = new XMLHttpRequest();
  //   xmlHttpRequest.open('get', url);
  //   xmlHttpRequest.onreadystatechange = function() {
  //     if (xmlHttpRequest.readyState == 4 && xmlHttpRequest.status == 200) { 
  //         eventListDate = JSON.parse(xmlHttpRequest.responseText);
  //     } 
  //   };
  //   xmlHttpRequest.send(null);
  //   //console.log("date url: ", url);   
  // }
  // console.log(inputString.length, checkedValue.length, checkedValue.length);
  // if (checkedValue.length != 0 && newDate.length != 0 && inputString.length != 0){
  //   for (var index = 0; index < eventListDate.length; index++){
  //     if (eventListKeyword.contains(eventListDate[index]) && eventListDepartment.contains(eventListDate[index])){
  //       eventList.add(eventListDate[index]);
  //     } 
  //   }

  // } else if (checkedValue.length == 0 && newDate.length != 0 && inputString.length != 0){
  //   for (var index = 0; index < eventListDate.length; index++){
  //     if (eventListKeyword.contains(eventListDate[index])){
  //       eventList.add(eventListDate[index]);
  //     } 
  //   }

  // } else if (checkedValue.length != 0 && newDate.length == 0 && inputString.length != 0){
  //   for (var index = 0; index < eventListDepartment.length; index++){
  //     if (eventListKeyword.contains(eventListDepartment[index])){
  //       eventList.add(eventListDepartment[index]);
  //     } 
  //   }

  // } else if (checkedValue.length != 0 && newDate.length != 0 && inputString.length == 0){
  //   for (var index = 0; index < eventListDepartment.length; index++){
  //     if (eventListDate.contains(eventListDepartment[index])){
  //       eventList.add(eventListDepartment[index]);
  //     } 
  //   }
  // } else if (checkedValue.length != 0 && newDate.length == 0 && inputString.length == 0){
  //     eventList = eventListDepartment; 
  // } else if (checkedValue.length == 0 && newDate.length != 0 && inputString.length == 0){
  //     eventList = eventListDate;
  // } else if (checkedValue.length == 0 && newDate.length == 0 && inputString.length != 0){
  //     console.log("wherel111111"); 
  //     eventList = eventListKeyword;
  //     console.log("eventList", eventListKeyword);
  // } else {
  //   location.reload();
  // }  
  //window.location.href='/searchresults';
  window.location.href='/searchresults';
  //passparameter();
  
}

// function saveKeyword(responseText){
//   eventListKeyword = JSON.parse(responseText);
//   var body = '';
//   window.location.href='/searchresults';
//   body = "<input class = 'departmentCheckbox' type='checkbox' name='department' value='Music' />"
//   var resultsListElement = child.document.getElementById('eventsBox');
//   resultsListElement.innerHTML = body;
// }



