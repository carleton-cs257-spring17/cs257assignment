/*
 *  books-config.js
 *  Jeff Ondich, 25 April 2017
 *
 *  Configuration file for the books & authors web application
 *  for Carleton CS257, Spring Term 2017.
 */

// Set this to match the base URL at which your books_api.py is listening.
var eventList[] = null;
function onButton() {
    console.log("Button Clicked");
    var checkedValue[] = null; 
    var inputString = null;
    var date = null;
    var eventListDate[];
    var eventListKeyword[];
    var eventListDepartment[];
    var count = 0;
    var inputElements = document.getElementsByClassName('departmentCheckbox');
    var date = document.getElementById("myDate").value; 
    var newDate = null;
    for character in date{
      if (character != '-'){
        newDate += character;
      }
    }
    for(var i=0; inputElements[i]; ++i){
      if(inputElements[i].checked){
           checkedValue[count] = inputElements[i].value;
           count++;
      }
    }
    inputString =  document.getElementById('input');
    if (inputString.length != 0){
      var url = api_base_url + 'events/keyword/'+inputString;
      xmlHttpRequest = new XMLHttpRequest();
      xmlHttpRequest.open('get', url);
      xmlHttpRequest.onreadystatechange = function() {
        if (xmlHttpRequest.readyState == 4 && xmlHttpRequest.status == 200) { 
            eventListKeyword = keywordCallBack(xmlHttpRequest.responseText);
        } 
    };
      window.location.href = '/searchpage';
    } else if (checkedValue.size != 0){
      for department in checkedValue{
        var url = api_base_url + 'events/department/'+department;
        xmlHttpRequest = new XMLHttpRequest();
        xmlHttpRequest.open('get', url);
        xmlHttpRequest.onreadystatechange = function() {
          if (xmlHttpRequest.readyState == 4 && xmlHttpRequest.status == 200) { 
              var tempEventList = departmentCallBack(xmlHttpRequest.responseText);
          } 
      };
        for events in tempEventList{
          eventListDepartment.add(events);
        } 
    }else if (newDate.length != 0){
      var url = api_base_url + 'events/date/'+newDate;
        xmlHttpRequest = new XMLHttpRequest();
        xmlHttpRequest.open('get', url);
        xmlHttpRequest.onreadystatechange = function() {
          if (xmlHttpRequest.readyState == 4 && xmlHttpRequest.status == 200) { 
              eventListDate = departmentCallBack(xmlHttpRequest.responseText);
          } 
      };    
    }
    if (checkedValue.size != 0 && newDate.length != 0 && inputString.length != 0){
      for events in eventListDate{
        if (eventListKeyword.contains(events) && eventListDepartment.contains(events)){
          eventList.add(events);
        } 
      }
      window.location.href = '/searchpage';
    } else if (checkedValue.size == 0 && newDate.length != 0 && inputString.length != 0){
      for events in eventListDate{
        if (eventListKeyword.contains(events)){
          eventList.add(events);
        } 
      }
      window.location.href = '/searchpage';
    } else if (checkedValue.size != 0 && newDate.length == 0 && inputString.length != 0){
      for events in eventListDepartment{
        if (eventListKeyword.contains(events)){
          eventList.add(events);
        } 
      }
    } else if (checkedValue.size != 0 && newDate.length != 0 && inputString.length == 0){
      for events in eventListDepartment{
        if (eventListDate.contains(events)){
          eventList.add(events);
        } 
      }
      window.location.href = '/searchpage';
    }else if (checkedValue.size != 0 && newDate.length == 0 && inputString.length == 0){
        eventList = eventListDepartment; 
        window.location.href = '/searchpage';
    }else if (checkedValue.size == 0 && newDate.length != 0 && inputString.length == 0){
        eventList = eventListDate;
        window.location.href = '/searchpage';
    }else if (checkedValue.size == 0 && newDate.length == 0 && inputString.length != 0){
        eventList = eventListKeyword;
        window.location.href = '/searchpage';
    } else {
      location.reload();
    }
    makeEventList();
    console.log("Entered makeEventList");
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

