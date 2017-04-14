#!/usr/bin/env python3
'''
    api_test.py
    Yanhan Lyu, Lucy Wu, 12 April 2016
    
    Retrieve results from an HTTP-based API, which can list all countries
    ,search for the countries based on language, and list the information 
    about a specific country by its official name or partial name.
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

def get_all():
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
        if type(name) != type(''):
            raise Exception('name has wrong type: "{0}"'.format(text))
        result_list.append({'name': name})

    return result_list

def get_country_by_name(name):
    '''
    Return the information about a specific country. The information includes its official name,
    its region, its native language represented in its language and its population.
    Raises exceptions on network connection errors and on data
    format errors.
    '''
    base_url = 'https://restcountries.eu/rest/v2/name/{0}'
    url = base_url.format(name)
    data_from_server = urllib.request.urlopen(url).read()
    string_from_server = data_from_server.decode('utf-8')
    countries_list = json.loads(string_from_server)
    result_list = []
    for country_list in countries_list:
        name = country_list['name']
        region = country_list['region']
        languages = country_list['languages']
        for languageExpression in languages:
            language = languageExpression['nativeName']
        population = country_list['population']
        if type(name) != type(''):
            raise Exception('name has wrong type: "{0}"'.format(name))
        if type(region) != type(''):
            raise Exception('region has wrong type: "{0}"'.format(region))
        if type(population) != type(0):
            raise Exception('population has wrong type: "{0}"'.format(population))
        if type(language) != type(''):
            raise Exception('language has wrong type: "{0}"'.format(language))
        result_list.append({'name':name, 'region':region, 'language': language, 'population': population})
    return result_list
    

def main(args):
    '''
    If action is language, then we search for the countries by language. If action is list, we 
    list all the countries in the world. if the action is name, we search for the country which
    has this name as its official name or partial name.
    '''
    if (args.action == 'language'):
        countries = get_country_by_language(args.language)
        for country in countries:
            name = country['name']
            region = country['region']
            print('{0} {1}'.format(name, region))
    elif (args.action == 'list'):
        names = get_all();
        for name in names:
            name_1 = name['name']
            print('{0}'.format(name_1))
    elif (args.action == 'name'):
        countries = get_country_by_name(args.name)
        for country in countries:
            name = country['name']
            region = country['region']
            language = country['language']
            population = country['population']
            print('The official name: {0}'.format(name))
            print('the region: {0}'.format(region))
            print('native name for their language: {0}'.format(language))
            print('population: {0}'.format(population))



if __name__ == '__main__':
    # Use argparse to parse my command line
    parser = argparse.ArgumentParser(description='Search for countries!')

    parser.add_argument('action',
                        help = 'Acions to perform ("list" or "language" or "name". list means list all the countries in the world\
                            , language means search for the countries by a specific language, name means search for the countries by\
                            name)',
                        choices = ['list', 'language', 'name'])
   
    parser.add_argument('-language',
                        metavar ='--language',
                        help='The language you want to search by',
                        required = False)
    parser.add_argument('-name',
                        metavar ='--name',
                        help='The name of country you want to search by, it can be official name or partial name',
                        required = False)
    # make sure that we have enough arguments
    args = parser.parse_args()
    if args.action == 'language' and args.language is None:
        parser.error("You need to input the language you want to search by.")
    if args.action == 'name' and args.name is None:
        parser.error("You need to input the country name you want to search by.")
    main(args)
