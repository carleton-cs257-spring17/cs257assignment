'''
Yanhan Lyu, Lucy Wu. Convert jason to csv
'''
import csv
import re

def convertDate(date):
    date = date.split("&")
    if date[1].find("january") != -1:
        month = "01"
    elif date[1].find("february") != -1:
        month = "02"
    elif date[1].find("march") != -1:
        month = "03"
    elif date[1].find("april") != -1:
        month = "04"
    elif date[1].find("may") != -1:
        month = "05"
    elif date[1].find("june") != -1:
        month = "06"
    elif date[1].find("july") != -1:
        month = "07"
    elif date[1].find("august") != -1:
        month = "08"
    elif date[1].find("sepetember") != -1:
        month = "09"
    elif date[1].find("cctober") != -1:
        month = "10"
    elif date[1].find("november") != -1:
        month = "11"
    else:
        month = "12"
    day = ""
    for char in date[1]:
        if char in "1234567890":
            day += char
    if len(day) == 1:
        day = "0"+str(day)
    return str(date[2])+month+day

def main():
    x = eval(open("eventsDict.txt").read())
    f = csv.writer(open("events.csv", "w"))
    e = csv.writer(open("departments.csv", "w"))
    e.writerow(["id", "name"])
    f.writerow(["id","name", "location", "time", "date", "date_time","department_id"])

    countEvent = 1
    countMajor = 1
    for key, value in x.items():
        departmentName = key.replace(" ","")
        for key1, value1 in value.items():
            event = key1
            date = convertDate(value1["date"].replace(",","&").replace(" ","").lower()).replace(" ","")
            time = value1["time"].replace(" ","")
            date_time = str(date+"&"+time)
            location = value1["location"]
            countEvent = countEvent+1
            f.writerow([countEvent,event,location,time,date,date_time,countMajor])
        e.writerow([countMajor, departmentName])
        countMajor = countMajor+1

main()

