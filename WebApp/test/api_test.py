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
    ini_url = 'http://thacker.mathcs.carleton.edu:5223'
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
        url = ini_url + '/events/department/Music/'
        json_text = urllib.request.urlopen(url).read()
        json_text = json_text.decode('utf-8')
        python_object = json.loads(json_text)
        self.assertTrue(isinstance(python_object, list))


    # Test if the first item in the list is a dictionary

    def test_department_event_type(self):
        url = ini_url + '/events/department/Music/'
        json_text = urllib.request.urlopen(url).read()
        json_text = json_text.decode('utf-8')
        python_object = json.loads(json_text)
        self.assertTrue(len(python_object) == 0 or isinstance(python_object[0], dict))

    # Test if all the events are in the department specified
    def test_department_event_department(self):
        url = ini_url + '/events/department/Music/'
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
        url = ini_url + '/events/date/20170525/'
        json_text = urllib.request.urlopen(url).read()
        json_text = json_text.decode('utf-8')
        python_object = json.loads(json_text)
        self.assertTrue(isinstance(python_object, list))


    # Test if the first item in the list is a dictionary
    def test_date_event_type(self):
        url = ini_url + '/events/date/20170525/'
        json_text = urllib.request.urlopen(url).read()
        json_text = json_text.decode('utf-8')
        python_object = json.loads(json_text)
        self.assertTrue(len(python_object) == 0 or isinstance(python_object[0], dict))

    # Test if all the events are in the date specified
    def test_date_event_date(self):
        url = ini_url + '/events/date/20170525/'
        json_text = urllib.request.urlopen(url).read()
        json_text = json_text.decode('utf-8')
        event_list = json.loads(json_text)
        for event in event_list:
            # assert that the event's date is 2017-05-25
            self.assertEqual(event["date_time"].split("T")[0], "20170525")

    # Test 3 on if events/department/date/<department>/<date>/ would return
    # a list of all events of the date and department specified
    # where the events are in the form of dictionaries,
    # and each dictionary contains the name, date_time, location, department
    # of an event as its keys


    # Test if the returned tyoe is a list
    def test_date_dep_results_type(self):
        url = ini_url + '/events/department/date/ComputerScience/20170525/'
        json_text = urllib.request.urlopen(url).read()
        json_text = json_text.decode('utf-8')
        python_object = json.loads(json_text)
        self.assertTrue(isinstance(python_object, list))


    # Test if the first item in the list is a dictionary

    def test_date_dep_event_type(self):
        url = ini_url + '//events/department/date/ComputerScience/20170525/'
        json_text = urllib.request.urlopen(url).read()
        json_text = json_text.decode('utf-8')
        python_object = json.loads(json_text)
        self.assertTrue(len(python_object) == 0 or isinstance(python_object[0], dict))

    # Test if all the events are in the date and department specified
    def test_date_dep_event_date_dep(self):
        url = ini_url + '/events/department/date/ComputerScience/20170525/'
        json_text = urllib.request.open(url).read()
        json_text = json_text.decode('utf-8')
        event_list = json.loads(json_text)
        for event in event_list:
            # assert that the event's date is 2017-05-25 and department is Computer Science
            self.assertEqual((event["date_time"].split("T")[0], event["department"]),
                                 ('20170525', "Computer Science"))


    # Test 4 on if events/all would return
    # a list of all events sorted by date
    # where the events are in the form of dictionaries,
    # and each dictionary contains the name, date_time, location, department
    # of an event as its keys

    # Test if the returned type is a list

    def test_event_sort_date_results_type(self):
        url = ini_url + '/events/all'
        json_text = urllib.request.urlopen(url).read()
        json_text = json_text.decode('utf-8')
        python_object = json.loads(json_text)
        self.assertTrue(isinstance(python_object, list))


    # Test if the first item in the list is a dictionary

    def test_event_sort_date_type(self):
        url = ini_url + '/events/all'
        json_text = urllib.request.urlopen(url).read()
        json_text = json_text.decode('utf-8')
        python_object = json.loads(json_text)
        self.assertTrue(len(python_object) == 0 or isinstance(python_object[0], dict))

    # Test if the events are sorted by date

    def test_event_sort_date_correct(self):
        url = ini_url + '/events/all'
        json_text = urllib.request.urlopen(url).read()
        json_text = json_text.decode('utf-8')
        event_list = json.loads(json_text)
        date_list_to_be_sorted = []
        date_list_returned = []
        for event in event_list:
            date_parsed = ['date']
            date_list_to_be_sorted.append(date_parsed)
            date_list_returned.append(date_parsed)
        date_list_to_be_sorted.sort()
        self.assertEqual(date_list_returned, date_list_to_be_sorted)


if __name__ == '__main__':
    unittest.main()
