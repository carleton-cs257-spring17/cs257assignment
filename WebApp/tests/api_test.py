'''
eventCalender.py
@author Yanhan Lyu, Lucy Wu
Writing unittests for testing API query. We have 5 parts of tests for 5 queries respectively. 
'''
from unittest import TestCase
import unittest
import eventCalender
import urllib.request
import json

class TestEventCalender(TestCase):
    def setUp(self):
        self.event_calendar = eventCalender.EventCalender()

    def tearDown(self):
        pass

    # Test 1 on if events/department/<department>/ would return
    # a list of all events of the department(s) specified
    # where the events are in the form of dictionaries,
    # and each dictionary contains the name, date_time, location, department
    # of an event as its keys

    # Test if the returned type is a list
    def test_department_results_type(self):
        url = 'http://localhost:5000/events/department/Music/'
        json_text = urllib.request.urlopen(url).read()
        json_text = json_text.decode('utf-8')
        python_object = json.loads(json_text)
        self.assertTrue(isinstance(python_object, list))


    # Test if the first item in the list is a dictionary

    def test_department_event_type(self):
        url = 'http://localhost:5000/events/department/Music/'
        json_text = urllib.request.urlopen(url).read()
        json_text = json_text.decode('utf-8')
        python_object = json.loads(json_text)
        self.assertTrue(len(python_object) == 0 or isinstance(python_object[0], dict))

    # Test if all the events are in the department specified
    def test_department_event_department(self):
        url = 'http://localhost:5000/events/department/Music/'
        json_text = urllib.request.urlopen(url).read()
        json_text = json_text.decode('utf-8')
        event_list = json.loads(json_text)
        for event in event_list:
            # assert that the event's department is Music
            self.assertEqual(event["department", "Music"])


    # Test 2 on if events/date/<date>/ would return
    # a list of all events of the date specified
    # where the events are in the form of dictionaries,
    # and each dictionary contains the name, date_time, location, department
    # of an event as its keys

    # Test if the returned type is a list

    def test_date_results_type(self):
        url = 'http://localhost:5000/events/date/2017-05-25/'
        json_text = urllib.request.urlopen(url).read()
        json_text = json_text.decode('utf-8')
        python_object = json.loads(json_text)
        self.assertTrue(isinstance(python_object, list))


    # Test if the first item in the list is a dictionary
    def test_date_event_type(self):
        url = 'http://localhost:5000/events/date/2017-05-25/'
        json_text = urllib.request.urlopen(url).read()
        json_text = json_text.decode('utf-8')
        python_object = json.loads(json_text)
        self.assertTrue(len(python_object) == 0 or isinstance(python_object[0], dict))

    # Test if all the events are in the date specified
    def test_date_event_date(self):
        url = 'http://localhost:5000/events/date/2017-05-25/'
        json_text = urllib.request.urlopen(url).read()
        json_text = json_text.decode('utf-8')
        event_list = json.loads(json_text)
        for event in event_list:
            # assert that the event's date is 2017-05-25
            self.assertEqual(event["date_time"].split("T")[0], "2017-05-25")

    # Test 3 on if events/date/department/<date>/<department>/ would return
    # a list of all events of the date and department specified
    # where the events are in the form of dictionaries,
    # and each dictionary contains the name, date_time, location, department
    # of an event as its keys


    # Test if the returned tyoe is a list
    def test_date_dep_results_type(self):
        url = 'http://localhost:5000/events/date/department/2017-05-25/ComputerScience'
        json_text = urllib.request.urlopen(url).read()
        json_text = json_text.decode('utf-8')
        python_object = json.loads(json_text)
        self.assertTrue(isinstance(python_object, list))


    # Test if the first item in the list is a dictionary

    def test_date_dep_event_type(self):
        url = 'http://localhost:5000/events/date/department/2017-05-25/ComputerScience'
        json_text = urllib.request.urlopen(url).read()
        json_text = json_text.decode('utf-8')
        python_object = json.loads(json_text)
        self.assertTrue(len(python_object) == 0 or isinstance(python_object[0], dict))

    # Test if all the events are in the date and department specified
    def test_date_dep_event_date_dep(self):
        url = 'http://localhost:5000/events/date/department/2017-05-25/ComputerScience'
        json_text = urllib.request.open(url).read()
        json_text = json_text.decode('utf-8')
        event_list = json.loads(json_text)
        for event in event_list:
            # assert that the event's date is 2017-05-25 and department is Computer Science
            self.assertEqual((event["date_time"].split("T")[0], event["department"]),
                                 ('2017-05-25', "Computer Science"))

    # Test 4 on if /events/date/number_of_departments/department/<date>/<number_of_departments>/<department1 & department 2 & department3…...>
    # would return a list of all events of the date and departments specified
    # where the events are in the form of dictionaries,
    # and each dictionary contains the name, date_time, location, department
    # of an event as its keys
    
    # Search events by date with multiple departments
    # Case 1: Test if all the events are in the given date 
    def test_date_deps_event_date_deps(self):
        url = 'http://localhost:5000/events/date/number_of_departments/department/2017-05-25/2/Geology&Music'
        json_text = urllib.request.urlopen(url).read()
        json_text = json_text.decode('utf-8')
        event_list = json.loads(json_text)
        for event in event_list:
            # assert that the event's date is 2017-05-25 and department is either Geology or Music
            self.assertTrue(event["date_time"].split("T")[0] == "2017-05-25")

    # Case 2: Test if all the events are in the given department departments
    def test_department_event_departments(self):
        url = 'http://localhost:5000/events/date/number_of_departments/department/2017-05-25/2/EnvironmentalStudies&PoliticalScience'
        json_text = urllib.request.urlopen(url).read()
        json_text = json_text.decode('utf-8')
        event_list = json.loads(json_text)

        for event in event_list:
            # assert that the event's department is either
            # Environmental Studies or Political Science
            self.assertTrue(
                event['department'] == "Environmental Studies" or event['department'] == "Political Science")

    # Test 5 on if events/all would return
    # a list of all events sorted by date
    # where the events are in the form of dictionaries,
    # and each dictionary contains the name, date_time, location, department
    # of an event as its keys

    # Test if the returned type is a list

    def test_event_sort_date_results_type(self):
        url = 'http://localhost:5000/events/all'
        json_text = urllib.request.urlopen(url).read()
        json_text = json_text.decode('utf-8')
        python_object = json.loads(json_text)
        self.assertTrue(isinstance(python_object, list))


    # Test if the first item in the list is a dictionary

    def test_event_sort_date_type(self):
        url = 'http://localhost:5000/events/all'
        json_text = urllib.request.urlopen(url).read()
        json_text = json_text.decode('utf-8')
        python_object = json.loads(json_text)
        self.assertTrue(len(python_object) == 0 or isinstance(python_object[0], dict))

    # Test if the events are sorted by date

    def test_event_sort_date_correct(self):
        url = 'http://localhost:5000/events/all'
        json_text = urllib.request.urlopen(url).read()
        json_text = json_text.decode('utf-8')
        event_list = json.loads(json_text)
        date_list_to_be_sorted = []
        date_list_returned = []
        for event in event_list:
            date_parsed = ""
            date_parsed_list = event["date_time"].split("-", "T", ":")
            for date in date_parsed_list:
                date_parsed += date
            date_list_to_be_sorted.append(date_parsed)
            date_list_returned.append(date_parsed)
        date_list_to_be_sorted.sort()
        self.assertEqual(date_list_returned, date_list_to_be_sorted)


if __name__ == '__main__':
    unittest.main()
