/*
 *  searchpage.js
 *  Lucy Wu, 25 April 2017
 *
 */

  function makeEventList(){

    console.log("input"+localStorage.getItem("input"));
    console.log("date"+localStorage.getItem("date"));
    console.log("department"+localStorage.getItem("department"));
      var body = "";
      body = "<p>"+inputString;
    // for (var k = 0; k < eventList.length; k++) {
    //   body += "<input class = 'eventCheckbox' type='checkbox'";
    //   body += " name='eventCheckbox" + k.toString() + "'";
    //   body += " value=" + eventList[k] + ">";
    //   body += "name: " + eventList[k][name] + "location: " + eventList[k][location] + "date_time: " + eventList[k][date_time] + "department: " + eventList[k][department];
    // }
    var resultsListElement = document.getElementById('eventsBox');
    resultsListElement.innerHTML = "<input class = 'eventCheckbox' type='checkbox'>";
    // console.log("resultsListElement" + resultsListElement);
}









