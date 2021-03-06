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
def get_events_by_department(department):
    '''
    Returns a list of all events of one specified department
    ordered by date then time
    '''
    query = '''SELECT events.name, events.location, events.date_time, departments.name
               FROM events,departments
               WHERE UPPER(departments.name) LIKE UPPER('%{0}%')
               AND events.department_id = departments.id
                ORDER BY events.date_time'''.format(department)

    events_list = []
    for row in _fetch_all_rows_for_query(query):
        event = {'name':row[0], 'location':row[1],
                  'date_time':row[2], 'department':row[3]}
        events_list.append(event)

    return json.dumps(events_list)

@app.route('/events/date/<date>/')
def get_events_by_date(date):
    '''
    Returns a list of all events on a specified date ordered in time.
    '''
    query = '''SELECT events.name, events.location, events.date_time, departments.name
               FROM events,departments
               WHERE UPPER(events.date) LIKE UPPER('%{0}%')
               AND events.department_id = departments.id
                ORDER BY events.time'''.format(date)

    events_list = []
    for row in _fetch_all_rows_for_query(query):
        event = {'name':row[0], 'location':row[1],
                  'date_time':row[2], 'department':row[3]}
        events_list.append(event)

    return json.dumps(events_list)
@app.route('/events/keyword/<keyword>')
def get_events_by_keyword(keyword):
    '''
    Returns a list of events searched by keywords.
    '''
    query = '''SELECT events.name, events.location, events.date_time, departments.name
               FROM events,departments
               WHERE UPPER(events.name) LIKE UPPER('%{0}%')
               AND events.department_id = departments.id
                ORDER BY events.time'''.format(keyword)

    events_list = []
    for row in _fetch_all_rows_for_query(query):
        event = {'name':row[0], 'location':row[1],
                  'date_time':row[2], 'department':row[3]}
        events_list.append(event)
    return json.dumps(events_list)


@app.route('/events/date/department/<date>/<department>/')
def get_events_by_date_department(date, department):
    '''
    Returns a list of all events on a specified date of a specified department on a specified date
    '''
    query = '''SELECT events.name, events.location, events.date_time, departments.name
               FROM events,departments
               WHERE UPPER(events.date) LIKE UPPER('%{0}%')
               AND UPPER(departments.name) LIKE UPPER('%{1}%')
               AND events.department_id = departments.id
                ORDER BY events.time'''.format(date, department)

    events_list = []
    for row in _fetch_all_rows_for_query(query):
        event = {'name':row[0], 'location':row[1],
                  'date_time':row[2], 'department':row[3]}
        events_list.append(event)

    return json.dumps(events_list)

@app.route('/events/keyword/department/<keyword>/<department>/')
def get_events_by_keyword_department(keyword, department):
    '''
    Returns a list of all events of a specified department of a specified keyword.
    The events would be ordered in time.
    '''
    query = '''SELECT events.name, events.location, events.date_time, departments.name
               FROM events,departments
               WHERE UPPER(events.name) LIKE UPPER('%{0}%')
               AND UPPER(departments.name) LIKE UPPER('%{1}%')
               AND events.department_id = departments.id
                ORDER BY events.time'''.format(keyword, department)

    events_list = []
    for row in _fetch_all_rows_for_query(query):
        event = {'name':row[0], 'location':row[1],
                  'date_time':row[2], 'department':row[3]}
        events_list.append(event)

    return json.dumps(events_list)

@app.route('/events/keyword/date/<keyword>/<date>/')
def get_events_by_keyword_date(keyword, date):
    '''
    Returns a list of all events on a specified date of a specified keyword.
    The events would be ordered in time.
    '''
    query = '''SELECT events.name, events.location, events.date_time, departments.name
               FROM events,departments
               WHERE UPPER(events.name) LIKE UPPER('%{0}%')
               AND UPPER(events.date) LIKE UPPER('%{1}%')
               AND events.department_id = departments.id
                ORDER BY events.time'''.format(keyword, date)

    events_list = []
    for row in _fetch_all_rows_for_query(query):
        event = {'name':row[0], 'location':row[1],
                  'date_time':row[2], 'department':row[3]}
        events_list.append(event)

    return json.dumps(events_list)

@app.route('/events/keyword/date/department/<keyword>/<date>/<department>')
def get_events_by_date_keyword_department(keyword, date, department):
    '''
    Returns a list of all events on a specified date, of a specified separtment using 
    a specified keyword.
    The events would be ordered in time.
    '''
    query = '''SELECT events.name, events.location, events.date_time, departments.name
               FROM events,departments
               WHERE UPPER(events.name) LIKE UPPER('%{0}%')
               AND UPPER(events.date) LIKE UPPER('%{1}%')
               AND UPPER(departments.name) LIKE UPPER('%{2}%')
               AND events.department_id = departments.id
                ORDER BY events.time'''.format(keyword, date,department)

    events_list = []
    for row in _fetch_all_rows_for_query(query):
        event = {'name':row[0], 'location':row[1],
                  'date_time':row[2], 'department':row[3]}
        events_list.append(event)

    return json.dumps(events_list)


@app.route('/events/')
def get_events():
    '''
    Returns a list of all events.
    '''
    query = '''SELECT events.name, events.location, events.date_time, departments.name
               FROM events,departments
                WHERE events.department_id = departments.id
                ORDER BY events.time'''

    events_list = []
    for row in _fetch_all_rows_for_query(query):
        event = {'name':row[0], 'location':row[1],
                  'date_time':row[2], 'department':row[3]}
        events_list.append(event)

    return json.dumps(events_list)


@app.route('/help')
def help():
    '''
    help information
    '''
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
    app.run(host=host, port=int(port), debug=True)

