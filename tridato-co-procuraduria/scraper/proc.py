import requests
from bs4 import BeautifulSoup
import lxml
import logging
import urllib3
import json
from flask import Flask
from flask import jsonify
import base64
app = Flask(__name__)



urllib3.disable_warnings(urllib3.exceptions.InsecureRequestWarning)

url = "https://www.procuraduria.gov.co/CertWEB/Certificado.aspx"



class Citizen:
    def __init__(self, id, names ):
        self.id = id
        self.names = names  ## array of first1, first2, last1, last2
        self.data = ''
    def __str__(self):
        return self.id + ' - ' + ' '.join(self.names) + '\n' + self.data
    def set_data(self, pData):
        self.data = pData

colombian_documents = { 'cc':1, 'ce': 5, 'pep': 0, 'nit': 2 }

# The id parameter is a colombian dni number
# The doc_type parameter is the id type x -> ['cc','ce','pep','nit']
@app.route('/<doc_type>/<id>')
def get_Procuraduria_data(doc_type, id):
    assert(doc_type in colombian_documents.keys())
    print("received request" , doc_type , id)
    id_type_code = colombian_documents[doc_type]
    querystring = {"tpo":"1"}
    payload = "__EVENTTARGET=&__EVENTARGUMENT=&__VIEWSTATE=%2FwEPDwUJLTU5NTU5MDcyDxYCHgpJZFByZWd1bnRhBQIxMhYCAgMPZBYMAgEPDxYCHgRUZXh0BRhDb25zdWx0YSBkZSBhbnRlY2VkZW50ZXNkZAINDxYCHgdWaXNpYmxlaBYEAgEPZBYCAgEPEGRkFgFmZAIDD2QWAgIBDxBkZBYAZAIPDw8WAh8BBRPCvyBDdWFudG8gZXMgMyBYIDU%2FZGQCGA8PFgIfAmhkZAIgDw8WAh8BBUZGZWNoYSBkZSBjb25zdWx0YTogbWFydGVzLCBhYnJpbCAyNCwgMjAxOCAtIEhvcmEgZGUgY29uc3VsdGE6IDE3OjMxOjI1ZGQCJA8PFgIfAQUHVi4wLjAuNGRkGAEFHl9fQ29udHJvbHNSZXF1aXJlUG9zdEJhY2tLZXlfXxYBBQxJbWFnZUJ1dHRvbjGxgeZltQgvtQybWlWZyhOnpy04EQ%3D%3D&__VIEWSTATEGENERATOR=D8335CE7&__EVENTVALIDATION=%2FwEWCgLnzoOMAQL8kK%2BTAQLwkOOQAQLvkOOQAQLxkOOQAQL0kOOQAQK8zP8SAtLCmdMIAsimk6ECApWrsq8IUoT4aKqh6YKfYP6EFhMzRlU23s8%3D&ddlTipoID={}&txtNumID={}&txtRespuestaPregunta=15&btnConsultar=Consultar"
    headers = {
        'origin': "https://www.procuraduria.gov.co",
        'upgrade-insecure-requests': "1",
        'content-type': "application/x-www-form-urlencoded",
        'user-agent': "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_13_4) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/65.0.3325.181 Safari/537.36",
        'x-devtools-emulate-network-conditions-client-id': "716DB6B99597F4E84484A7BC4ACED43D",
        'accept': "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8",
        'referer': "https://www.procuraduria.gov.co/CertWEB/Certificado.aspx?tpo=1",
        'accept-encoding': "gzip, deflate, br",
        'accept-language': "es-ES,es;q=0.9,en;q=0.8,fr;q=0.7,gl;q=0.6",
        'cookie': "_ga=GA1.3.1502412555.1524521156; ASP.NET_SessionId=3arqtt553cwsug554elums3o",
        'cache-control': "no-cache",
        'postman-token': "0bbd6a30-b035-f904-ab2c-5e2c54391f5a"
        }
    try:
        response = requests.request("POST", url, data = payload.format(id_type_code, id) , headers=headers, params=querystring, verify=False)
    except Exception as e:
        print('Error when making request', e)
        print(e.__doc__)
        print(e.message)

    # BeautifulSoup object where we can query on the DOM tree
    soup = BeautifulSoup(response.text, 'lxml')
    print(response.text)
    # Get array with first and last names
    names = [x.get_text() for x in soup.findAll("div", class_="datosConsultado")[0].findAll('span')]
    assert(len(names) > 2)
    # Filter '' from the names (not all have 2 first names)
    names  = list(filter(lambda x: x is not '', names))


    print(' '.join(names), end='')

    query_citizen = Citizen(id, names)

    criminal_data = soup.findAll('div', class_='SeccionAnt')

    query_citizen.set_data( ''.join([*[ str(x) for x in criminal_data]]))

    return jsonify(id=query_citizen.id ,
                   name=query_citizen.names,
                   data=base64.b64encode(bytes(query_citizen.data, 'utf-8')).decode('utf-8'))

@app.route("/")
def heartbeat():
    return 'Alive'

app.run(host='0.0.0.0')
