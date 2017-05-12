/*
 *  books-config.js
 *  Jeff Ondich, 25 April 2017
 *
 *  Configuration file for the books & authors web application
 *  for Carleton CS257, Spring Term 2017.
 */

// Set this to match the base URL at which your books_api.py is listening.
var eventList = [];
function onButton() {
    //console.log("Button Clicked");
    var checkedValue = []; 
    var inputString = null;
    var date = null;
    var eventListDate = [];
    var eventListKeyword = [];
    var eventListDepartment = [];
    var count = 0;
    var inputElements = document.getElementsByClassName('departmentCheckbox');
    var date = document.getElementById("myDate").value; 
    var newDate = null;
    for (var i = 0, len = date.length; i < len; i++) {
      if (date.charAt(i) != '-'){
        newDate += date.charAt(i)
      }
    }
    console.log(newDate);
    for(var i=0; inputElements[i]; ++i){
      if(inputElements[i].checked){
          //console.log("add checked value");
           checkedValue[count] = inputElements[i].value;
           count++;
      }
    }

    //console.log("Checked Vaue: ", checkedValue);

    inputString =  document.getElementById('input').value;

    //console.log("Input String: ", inputString);

    if (inputString != null){
      var url = api_base_url + 'keyword/'+inputString;
      xmlHttpRequest = new XMLHttpRequest();
      xmlHttpRequest.open('get', url);
      xmlHttpRequest.onreadystatechange = function() {
        if (xmlHttpRequest.readyState == 4 && xmlHttpRequest.status == 200) { 
            eventListKeyword = keywordCallBack(xmlHttpRequest.responseText);
        } 
    };
      //console.log("keyword url: ", url);
    } 

    if (checkedValue != null){
      var url = api_base_url + 'department/';
      for (i in checkedValue) {

        //console.log("checkedValue.length + department/", checkedValue.length);
        if (i == 0) {
          var url = url + checkedValue[i];
        } else {
          var url = url + "&" + checkedValue[i];
        }
        
        xmlHttpRequest = new XMLHttpRequest();
        xmlHttpRequest.open('get', url);

        var tempEventList = [];

        xmlHttpRequest.onreadystatechange = function() {
        if (xmlHttpRequest.readyState == 4 && xmlHttpRequest.status == 200) { 
          tempEventList = departmentCallBack(xmlHttpRequest.responseText);
        } 
      };

      //console.log("department url: ", url);

      //console.log("tempEventList: ", tempEventList);

        for (events in tempEventList){
          eventListDepartment.add(tempEventList[events]);
        } 
      }
    }

    //console.log("keyword list: " + eventListKeyword);
    //console.log("department list: " + eventListDepartment);

    if (newDate != null){
      var url = api_base_url + 'date/'+newDate;
        xmlHttpRequest = new XMLHttpRequest();
        xmlHttpRequest.open('get', url);
        xmlHttpRequest.onreadystatechange = function() {
          if (xmlHttpRequest.readyState == 4 && xmlHttpRequest.status == 200) { 
              eventListDate = departmentCallBack(xmlHttpRequest.responseText);
          } 
      };
      //console.log("date url: ", url);   
    }



    if (checkedValue != null && newDate != null && inputString != null){
      for (var index = 0; index < eventList.length, index++){
        if (eventListKeyword.contains(eventListDate[index]) && eventListDepartment.contains(eventListDate[index])){
          eventList.add(eventListDate[index]);
        } 
      }
       window.location.href = webpage_base_url + 'searchpage';
    } else if (checkedValue == null && newDate != null && inputString != null){
      for (var index = 0; index < eventListDate.length; index++){
        if (eventListKeyword.contains(eventListDate[index])){
          eventList.add(eventListDate[index]);
        } 
      }
       window.location.href = webpage_base_url + 'searchpage';
    } else if (checkedValue != null && newDate == null && inputString != null){
      for (var index = 0; index < eventListDepartment.length; index++){
        if (eventListKeyword.contains(eventListDepartment[index])){
          eventList.add(eventListDepartment[index]);
        } 
      }
       window.location.href = webpage_base_url + 'searchpage';
    } else if (checkedValue != null && newDate != null && inputString == null){
      for (var index = 0; index < eventListDepartment.length; index++){
        if (eventListDate.contains(eventListDepartment[index])){
          eventList.add(eventListDepartment[index]);
        } 
      }
       window.location.href = webpage_base_url + 'searchpage';
    } else if (checkedValue != null && newDate == null && inputString == null){
        eventList = eventListDepartment; 
         window.location.href = webpage_base_url + 'searchpage';
    } else if (checkedValue == null && newDate != null && inputString == null){
        eventList = eventListDate;
         window.location.href = webpage_base_url + 'searchpage';
    } else if (checkedValue == null && newDate == null && inputString != null){
        eventList = eventListKeyword;
        console.log("eventList", eventList);   
         window.location.href = webpage_base_url + 'searchpage';
    } else {
      location.reload();
    }
    makeEventList();
    //console.log("Entered makeEventList");
  }

function keywordCallBack(responseText){
  var eventList = JSON.parse(responseText);
  return eventList;
}

function departmentCallBack(responseText){
  var eventList = JSON.parse(responseText);
  return eventList;
}

function dateCallBack(responseText){
  var eventList = JSON.parse(responseText);
  return eventList;
}

