/*
 *  searchpage.js
 *  Lucy Wu, 25 April 2017
 *
 */

function makeEventList(){
  var body = '';
  for (var k = 0; k < eventList.length; k++) {
    body += "<input class = 'eventCheckbox' type='checkbox'";
    body += " name='eventCheckbox" + k.toString() + "'";
    body += " value=" + eventList[k] + ">";
    body += "name: " + eventList[k][name] + "location: " + eventList[k][location] + "date_time: " + eventList[k][date_time] + "department: " + eventList[k][department];
  }
  var resultsListElement = document.getElementById('eventCheckbox');
  console.log("resultsListElement" + resultsListElement);
  resultsListElement.innerHTML = body;
}


