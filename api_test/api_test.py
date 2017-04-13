#!/usr/bin/env python3
'''
    api_test.py
    Yanhan Lyu, 12 April 2016
    
    Retrieve results from an HTTP-based API, which can list all countries
    and search for the countries based on language
'''

import sys
import argparse
import json
import urllib.request

def get_country_by_language(language):
    '''
    Return a list of countries that speak a specific language. The language should 
    be in the form of ISO 639-1 Language Code.
    Raises exceptions on network connection errors and on data
    format errors.
    '''
    base_url = 'https://restcountries.eu/rest/v2/lang/{0}'
    url = base_url.format(language)
    data_from_server = urllib.request.urlopen(url).read()
    string_from_server = data_from_server.decode('utf-8')
    countries_list = json.loads(string_from_server)
    result_list = []
    for country_list in countries_list:
        name = country_list["name"]
        region = country_list['region']
        if type(name) != type(''):
            raise Exception('name has wrong type: "{0}"'.format(name))
        if type(region) != type(''):
            raise Exception('region has wrong type: "{0}"'.format(region))
        result_list.append({'name':name, 'region':region})
    return result_list

def get_All():
    '''
    Return a list of all countries in the world.
    Raises exceptions on network connection errors and on data
    format errors.
    '''
    base_url = 'https://restcountries.eu/rest/v2/all'
    url = base_url
    data_from_server = urllib.request.urlopen(url).read()
    string_from_server = data_from_server.decode('utf-8')
    countries_list = json.loads(string_from_server)
    result_list = []
    for country_list in countries_list:
        name = country_list["name"]
        #print(name)
        if type(name) != type(''):
            raise Exception('name has wrong type: "{0}"'.format(text))
        result_list.append({'name': name})

    return result_list

def main(args):
    if (args.action == 'language'):
        root_words = get_country_by_language(args.language)
        for root_word in root_words:
            name = root_word['name']
            region = root_word['region']
            print('{0} {1}'.format(name, region))
    elif (args.action == 'list'):
        names = get_All();
        for name in names:
            name_1 = name['name']
            print('{0}'.format(name_1))


if __name__ == '__main__':
    # When I use argparse to parse my command line, I usually
    # put the argparse setup here in the global code, and then
    # call a function called main to do the actual work of
    # the program.
    parser = argparse.ArgumentParser(description='Search for countries!')

    parser.add_argument('action',
                        metavar = 'action',
                        help = 'actions to perform ("list all the countries in the world" or "By language")',
                        choices = ['list', 'language'])

    parser.add_argument('language',
                        metavar='language',
                        help='The language you want to search by')


    args = parser.parse_args()
    main(args)
