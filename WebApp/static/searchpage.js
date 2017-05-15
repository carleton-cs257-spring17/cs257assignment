/*
 *  searchpage.js
 *  Lucy Wu, 25 April 2017
 *
 */
var body = "";
  function makeEventList(){
    var keyword = localStorage.getItem("input");
    var date = localStorage.getItem("date");
    var departmentLength = localStorage.getItem("departmentLength");
    //resultsListElement.innerHTML = "<input class = 'eventCheckbox' type='checkbox'>";
    var url = "";
    // console.log("resultsListElement" + resultsListElement);
    if (keyword.length != 0 && date.length != 0 && departmentLength != 0){

        for (var index = 0; index < departmentLength; index++){
            url = api_base_url + "keyword/date/department/"+keyword+"/"+date+"/"+localStorage.getItem(index);
            console.log(url);
            xmlHttpRequest = new XMLHttpRequest();
            xmlHttpRequest.open('get', url);
            xmlHttpRequest.onreadystatechange = function() {
                if (this.readyState == 4 && this.status == 200) { 
                    callback(this.responseText);
                }
            }; 
            xmlHttpRequest.send(null);
        }
    } else if (keyword.length != 0 && date.length != 0 && departmentLength == 0){
        console.log("2");
        url = api_base_url + "keyword/date/"+keyword+"/"+date;
        console.log(url);
        xmlHttpRequest = new XMLHttpRequest();
        xmlHttpRequest.open('get', url);
        xmlHttpRequest.onreadystatechange = function() {
            if (xmlHttpRequest.readyState == 4 && xmlHttpRequest.status == 200) { 
                callback(xmlHttpRequest.responseText);
            } 
        }; 
        xmlHttpRequest.send(null);
    } else if (keyword.length != 0 && date.length == 0 && departmentLength != 0){
        console.log("3");
        for (var index = 0; index < departmentLength; index++){
            url = api_base_url + "keyword/department/"+keyword+"/"+localStorage.getItem(index);
            console.log(url);
            xmlHttpRequest = new XMLHttpRequest();
            xmlHttpRequest.open('get', url);
            xmlHttpRequest.onreadystatechange = function() {
                if (this.readyState == 4 && this.status == 200) { 
                    callback(this.responseText);
                }
            }; 
            xmlHttpRequest.send(null);
        }
        
    }else if (keyword.length == 0 && date.length != 0 && departmentLength != 0){
        console.log("4");
        for (var index = 0; index < departmentLength; index++){
            url = api_base_url + "date/department/"+date+"/"+localStorage.getItem(index);
            console.log(url);
            xmlHttpRequest = new XMLHttpRequest();
            xmlHttpRequest.open('get', url);
            xmlHttpRequest.onreadystatechange = function() {
                if (this.readyState == 4 && this.status == 200) { 
                    callback(this.responseText);
                } 
            }; 
            xmlHttpRequest.send(null);
        }
    } else if (keyword.length != 0 && date.length == 0 && departmentLength == 0){
        console.log("5");
        url = api_base_url + "keyword/"+keyword;
        console.log(url);
        xmlHttpRequest = new XMLHttpRequest();
            xmlHttpRequest.open('get', url);
            xmlHttpRequest.onreadystatechange = function() {
                if (xmlHttpRequest.readyState == 4 && xmlHttpRequest.status == 200) { 
                    callback(xmlHttpRequest.responseText);
                } 
            }; 
        xmlHttpRequest.send(null);
    } else if (keyword.length == 0 && date.length != 0 && departmentLength == 0){
        console.log("6");
        url = api_base_url + "date/"+date;
        console.log(url);
        xmlHttpRequest = new XMLHttpRequest();
            xmlHttpRequest.open('get', url);
            xmlHttpRequest.onreadystatechange = function() {
                if (xmlHttpRequest.readyState == 4 && xmlHttpRequest.status == 200) { 
                    callback(xmlHttpRequest.responseText);
                } 
            }; 
        xmlHttpRequest.send(null);
    } else if (keyword.length == 0 && date.length == 0 && departmentLength != 0){
        console.log("7");
        //var xhr = [];
        //console.log("departmentLength");
        for (var index = 0; index < departmentLength; index++){
            url = api_base_url + "department/"+localStorage.getItem(index);
            console.log(url);
            xmlHttpRequest = new XMLHttpRequest();
            xmlHttpRequest.open('get', url);
            xmlHttpRequest.onreadystatechange = function() {
                if (this.readyState == 4 && this.status == 200) { 
                    callback(this.responseText);
                } 
            }; 
            xmlHttpRequest.send(null);
        }
        
    } else {
        console.log("8");
        alert("Please give us some information")
    }
}


function callback(responseText){
    console.log(responseText);
    var eventList = JSON.parse(responseText);
    var resultsListElement = document.getElementById('eventsBox');
    console.log(resultsListElement);
    var body = resultsListElement.innerHTML;
    for (var k = 0; k < eventList.length; k++) {
        body += "<input class = 'eventCheckbox' type='checkbox' style= 'display: block'" + " value = '"+eventList[k]['name']+"'>";
        body += "<label style='color:black'>"+eventList[k]['department']+": "+eventList[k]['name']+" location: "+eventList[k]['location']+ " time: "+eventList[k]['date_time']+"</label>"
    }
    resultsListElement.innerHTML = body;
    console.log(body);

}

function onEventsButtonWishList(){
    console.log("clicked");
    var inputElements = document.getElementsByClassName('eventCheckbox');
    var body = '';
    for(var i=0; inputElements[i]; ++i){
        if(inputElements[i].checked){
            console.log("here");
            body += "<input class = 'eventCheckbox' type='checkbox' style= 'display: table'" + "value = '"+inputElements[i].value+"'>";
            body += "<span style='color:black'>"+inputElements[i].value+"</span>"
        }
    }
    var resultsListElement = document.getElementById('listBox');
    resultsListElement.innerHTML = body;
}









