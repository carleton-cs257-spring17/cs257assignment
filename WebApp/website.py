#!/usr/bin/env python3
'''
    website.py
    Yanhan Lyu, Lucy Wu, 15 May 2016
    This is the Flask app for the
    "search Carleton events to add to calendar" API and website. The API offers
    JSON access to the data, while the website (at
    route '/') offers end-user browsing of the data.
'''
import sys
import flask
import json

import psycopg2

app = flask.Flask(__name__, static_folder='static', template_folder='templates')

@app.route('/') 
def get_main_page():
    ''' This is the only route intended for human users '''
    return flask.render_template('homepage.html')

@app.route('/searchresults') 
def get_search_page():
    ''' This is the only route intended for human users '''
    return flask.render_template('searchpage.html')

if __name__ == '__main__':
    if len(sys.argv) != 3:
        print('Usage: {0} host port'.format(sys.argv[0]), file=sys.stderr)
        exit()

    host = sys.argv[1]
    port = sys.argv[2]
    app.run(host=host, port=port)