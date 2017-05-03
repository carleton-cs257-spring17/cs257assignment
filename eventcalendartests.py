import unittest
import eventcalendar

class EventCalendarTests(unittest.TestCase):
	def setUp(self):
		self.event_calendar = eventcalendar.EventCalendar(100)

	def tearDown(self):
		pass

	def test_get_events(self):
		if self.assertisinstance(eventcalendar.get_events(), dict):
			print("Get events succeeded");
		else:
			print("Get evetns failed");

	# Test if the list returned by sort_major_event_date is sorted by date
	# sort_major_event_date should return a list contained tuples of event id and date
	# where the first item is event id and second item is date
	# and the tuples are sorted by date
	def test_sort_major_event_date(self):
		returned_list = eventcalendar.sort_major_event_date("Mathematics and Statistics");
		date_list_to_be_sorted = [];
		date_list_returned = [];
		for item in returned_list:
			date_list_to_be_sorted.append(item[1]);
			date_list_returned.append(item[1]);
			date_list_to_  be_sorted.sort();

		if self.assertEqual(date_list_returned, date_list_to_be_sorted):
			print("Sort events of major by date succeeded");
		else:
			print("Sort events of major by date failed");


	# Test if the list returned by searchevent_major only return
	# events of the major being entered
	# searchevent_major should return a list contained tuples of event id and major
	# where the first item is event id and second item is major
	def test_searchevent_major(self):
		returned_list = eventcalendar.searchevent_major("Mathematics and Statistics", "Environmental Studies");
		major_set_to_be_compared = set(["Mathematics and Statistics", "Environmental Studies"]);
		major_set_returned = [];
		for item in returned_list:
			major_set_returned.append(item[1]);
		major_set_returned = set(major_set_returned);

	if self.assertEqual(major_set_returned, major_set_to_be_compared):
			print("Search events by major succeeded");
		else:
			print("Search events by major failed");


	# Advance1 is a combined refine process that would do both
	# sort_major_event_date and searchevent_major
	# advance1 should return a list contained tuples of event id and date and major
	# where the first item is event id
	# the second item is date
	# the third item is major
	def test_advance1(self):
		returned_list = eventcalendar.searchevent_major("Political Science", "Music");
		date_list_to_be_sorted = [];
		date_list_returned = [];
		major_set_to_be_compared = set(["Political Science", "Music"]);
		major_set_returned = [];
		for item in returned_list:
			date_list_to_be_sorted.append(item[1]);
			date_list_returned.append(item[1]);
			date_list_to_be_sorted.sort();
			major_set_returned.append(item[2]);
		if self.assertEqual(date_list_returned, date_list_to_be_sorted):
			if self.assertEqual(major_set_returned, major_set_to_be_compared):
				print("Advance search 1 succeeded");
			else:
				print("Advance search 1 failed because of date sort error");
		else:
			print("Advance search 1 failed because of search by major error");





if __name__ == '__main__':
	unittest.main()