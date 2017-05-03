'''
    api.py
    Lucy Wu, Yanhan Lyu, 2 May 2016

    Simple Flask API used in the sample web app for
    CS 257, Spring 2016-2017. This is the Flask app for the
    "books and authors" API only. There's a separate Flask app
    for the books/authors website.
'''
import sys
import flask
import json
import config
import psycopg2
import urllib

app = flask.Flask(__name__, static_folder='static', template_folder='templates')

def _fetch_all_rows_for_query(query):
    '''
    Returns a list of rows obtained from the eventcalendar database
    by the specified SQL query. If the query fails for any reason,
    an empty list is returned.
    '''
    try:
        connection = psycopg2.connect(database=config.database, user=config.user, password=config.password)
    except Exception as e:
        print('Connection error:', e, file=sys.stderr)
        return []

    rows = []
    try:
        cursor = connection.cursor()
        cursor.execute(query)
        rows = cursor.fetchall()
    except Exception as e:
        print('Error querying database:', e, file=sys.stderr)

    connection.close()
    return rows

@app.route('/events/department/<department>/') 
def get_events_by_department(department_selected):
    '''
    Returns a list of all events of one specified department
    ordered by date then time
    See get_event_by_id below 
    for description of the author resource representation.
    '''
    query = '''SELECT events.name, events.location, events.date_time, departments.name
               FROM events,departments ORDER BY events.date_time
               WHERE '{0}' = department.date
               AND events.department_id = departments.id'''.format(department_selected)

    events_list = []
    for row in _fetch_all_rows_for_query(query):
        event = {'name':row[0], 'location':row[1],
                  'date_time':row[2], 'department':row[3]}
        events_list.append(event)

    return json.dumps(events_list)


@app.route('/events/date/<date>/')
def get_events_by_date(date_selected):
    '''
    Returns a list of all events on a specified date ordered in time.
    See get_event_by_id below for description of the event resource representation.
    '''
    query = '''SELECT events.name, events.location, events.date_time, departments.name
               FROM events,departments ORDER BY events.time
               WHERE '{0}' = events.date
               AND events.department_id = departments.id'''.format(date_selected)

    events_list = []
    for row in _fetch_all_rows_for_query(query):
        event = {'name':row[0], 'location':row[1],
                  'date_time':row[2], 'department':row[3]}
        events_list.append(event)

    return json.dumps(events_list)


@app.route('/events/date/department/<date>/<department>/')
def get_events_by_date_department(date_selected, department_selected):
    '''
    Returns a list of all events on a specified date of a specified department.
    The events would be ordered in time.
    See get_event_by_id below for description of the event resource representation.
    '''
    query = '''SELECT events.name, events.location, events.date_time, departments.name
               FROM events,departments ORDER BY events.time
               WHERE '{0}' = events.date
               AND '{1}' = departments.name
               AND events.department_id = departments.id'''.format(date_selected, department_selected)

    events_list = []
    for row in _fetch_all_rows_for_query(query):
        event = {'name':row[0], 'location':row[1],
                  'date_time':row[2], 'department':row[3]}
        events_list.append(event)

    return json.dumps(events_list)


@app.route('/help')
def help():
    rule_list = []
    for rule in app.url_map.iter_rules():
        rule_text = rule.rule.replace('<', '&lt;').replace('>', '&gt;')
        rule_list.append(rule_text)
    return json.dumps(rule_list)

if __name__ == '__main__':
    if len(sys.argv) != 3:
        print('Usage: {0} host port'.format(sys.argv[0]), file=sys.stderr)
        exit()

    host = sys.argv[1]
    port = sys.argv[2]
    app.run(host=host, port=port)

