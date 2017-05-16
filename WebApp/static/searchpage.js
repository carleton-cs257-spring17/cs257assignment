/*
 *  searchpage.js
 *  Yanhan Lyu, Lucy Wu, 15 May 2017
 *
 */
var body = "";

// Function that would take in the data passed by homepage
// and create list of event checkboxes in the left lower block of searchpage
function makeEventList(){

    // Get data stored by homepage earlier
    var keyword = localStorage.getItem("input");
    var date = localStorage.getItem("date");
    var departmentLength = localStorage.getItem("departmentLength");
    
    var url = "";
    
    // Check 8 cases of if any of the three of the input is not enterd
    // and call api correspondingly

    // Case 1: all three input are entered
    if (keyword.length != 0 && date.length != 0 && departmentLength != 0){

        for (var index = 0; index < departmentLength; index++){

            // Set appropirate url to call api
            url = api_base_url + "keyword/date/department/"+keyword+"/"+date+"/"+localStorage.getItem(index);

            xmlHttpRequest = new XMLHttpRequest();
            xmlHttpRequest.open('get', url);
            xmlHttpRequest.onreadystatechange = function() {
                if (this.readyState == 4 && this.status == 200) { 
                    callback(this.responseText);
                }
            }; 
            xmlHttpRequest.send(null);
        }
    } 

    // Case 2: missing department input
    else if (keyword.length != 0 && date.length != 0 && departmentLength == 0){

        // Set appropirate url to call api
        url = api_base_url + "keyword/date/"+keyword+"/"+date;

        xmlHttpRequest = new XMLHttpRequest();
        xmlHttpRequest.open('get', url);
        xmlHttpRequest.onreadystatechange = function() {
            if (xmlHttpRequest.readyState == 4 && xmlHttpRequest.status == 200) { 
                callback(xmlHttpRequest.responseText);
            } 
        }; 
        xmlHttpRequest.send(null);
    } 

    // Case 3: missing date input
    else if (keyword.length != 0 && date.length == 0 && departmentLength != 0){
        for (var index = 0; index < departmentLength; index++){

            // Set appropirate url to call api
            url = api_base_url + "keyword/department/"+keyword+"/"+localStorage.getItem(index);

            xmlHttpRequest = new XMLHttpRequest();
            xmlHttpRequest.open('get', url);
            xmlHttpRequest.onreadystatechange = function() {
                if (this.readyState == 4 && this.status == 200) { 
                    callback(this.responseText);
                }
            }; 
            xmlHttpRequest.send(null);
        }
        
    }

    // Case 4: missing keyword input
    else if (keyword.length == 0 && date.length != 0 && departmentLength != 0){
        for (var index = 0; index < departmentLength; index++){

            // Set appropirate url to call api
            url = api_base_url + "date/department/"+date+"/"+localStorage.getItem(index);

            xmlHttpRequest = new XMLHttpRequest();
            xmlHttpRequest.open('get', url);
            xmlHttpRequest.onreadystatechange = function() {
                if (this.readyState == 4 && this.status == 200) { 
                    callback(this.responseText);
                } 
            }; 
            xmlHttpRequest.send(null);
        }
    } 

    // Case 5: missing date input and department input
    else if (keyword.length != 0 && date.length == 0 && departmentLength == 0){
        // Set appropirate url to call api
        url = api_base_url + "keyword/"+keyword;

        xmlHttpRequest = new XMLHttpRequest();
            xmlHttpRequest.open('get', url);
            xmlHttpRequest.onreadystatechange = function() {
                if (xmlHttpRequest.readyState == 4 && xmlHttpRequest.status == 200) { 
                    callback(xmlHttpRequest.responseText);
                } 
            }; 
        xmlHttpRequest.send(null);
    } 

    // Case 6: missing keyword input and department input
    else if (keyword.length == 0 && date.length != 0 && departmentLength == 0){

        // Set appropirate url to call api
        url = api_base_url + "date/"+date;

        xmlHttpRequest = new XMLHttpRequest();
            xmlHttpRequest.open('get', url);
            xmlHttpRequest.onreadystatechange = function() {
                if (xmlHttpRequest.readyState == 4 && xmlHttpRequest.status == 200) { 
                    callback(xmlHttpRequest.responseText);
                } 
            }; 
        xmlHttpRequest.send(null);
    } 

    // Case 7: missing keyword input and date input
    else if (keyword.length == 0 && date.length == 0 && departmentLength != 0){
        
        for (var index = 0; index < departmentLength; index++){

            // Set appropirate url to call api
            url = api_base_url + "department/"+localStorage.getItem(index);

            xmlHttpRequest = new XMLHttpRequest();
            xmlHttpRequest.open('get', url);
            xmlHttpRequest.onreadystatechange = function() {
                if (this.readyState == 4 && this.status == 200) { 
                    callback(this.responseText);
                } 
            }; 
            xmlHttpRequest.send(null);
        }
        
    } 

    // Case 8: missing all three input
    else {
        alert("Please give us some information")
    }
}


// Function that takes in the JSON object
// and parse it to add text in html file
// to create checkboxes for events
function callback(responseText){

    //parse JSON object into js object
    var eventList = JSON.parse(responseText);
    var resultsListElement = document.getElementById('eventsBox');
    var body = resultsListElement.innerHTML;


    for (var k = 0; k < eventList.length; k++) {
        body += "<input class = 'eventCheckbox' type='checkbox' style= 'display: block'" + " value = '"+eventList[k]['name']+"'>";
        body += "<label style='color:black'>"+eventList[k]['department']+": "+eventList[k]['name']+", location: "+eventList[k]['location']+ ", time: "+eventList[k]['date_time']+"</label>"
    }
    resultsListElement.innerHTML = body;

}

// Function gets called when "ADD TO WISHLIST" button is clicked
// It would add the events checked on the left block area to right block area
function onEventsButtonWishList(){
    var inputElements = document.getElementsByClassName('eventCheckbox');
    var body = '';
    for(var i=0; inputElements[i]; ++i){
        if(inputElements[i].checked){
            body += "<input class = 'wishCheckbox' type='checkbox' style= 'display: table'" + "value = '"+inputElements[i].value+"'>";
            body += "<span style='color:black, size:1.2rem'>"+inputElements[i].value+"</span>"
        }
    }
    var resultsListElement = document.getElementById('listBox');
    resultsListElement.innerHTML = body;
}

// Function gets called when "ADD TO GOOGLE CALENDAR" button is clicked
// It would take the searchopage to google calendar page to add the event
function onCalender(){
    var inputElements = document.getElementsByClassName('wishCheckbox');
    for(var i=0; inputElements[i]; ++i){
        if(inputElements[i].checked){
            window.open(
              "http://www.google.com/calendar/event?action=TEMPLATE&text="+inputElements[i].value,
              '_blank' // <- This is what makes it open in a new window.
            );
        }
    }
}









