import random
import json
import requests
from bs4 import BeautifulSoup

todosProdutos = [] #Vai receber os produto no seguinte formato: nome, preço, peso e qtd em estoque


urls = ["https://www.bompreco.com.br/carnes-e-embutidos","https://www.bompreco.com.br/bebidas","https://www.bompreco.com.br/frios-e-laticinios","https://www.bompreco.com.br/limpeza","https://www.bompreco.com.br/beleza-higiene-e-saude","https://www.bompreco.com.br/hortifruti","https://www.bompreco.com.br/mercearia","https://www.bompreco.com.br/pet-shop"]

def escrever_json(dados):
    with open('produtos.json', 'w', encoding='utf8') as f:
        json.dump(dados, f, ensure_ascii=False, sort_keys=True, indent=4, separators=(',', ':'))

def ler_json(arq_json):
    with open(arq_json, 'r', encoding='utf8') as f:
        return json.load(f)


def procurar(url):
    for n in range(5):
        r = requests.get(url + "?page={p}".format(p=n))
        soup = BeautifulSoup(r.content, 'html.parser')


        produtos = soup.find_all("article", class_ = "vtex-product-summary-2-x-element pointer pt3 pb4 flex flex-column h-100")

        produtosNome = soup.find_all("span", class_= "vtex-product-summary-2-x-productBrand vtex-product-summary-2-x-brandName t-body")
        produtosPreco = soup.find_all("span", class_= "vtex-productShowCasePrice")
        for item in produtos:
            produto = []
            nome = item.find("span", class_= "vtex-product-summary-2-x-productBrand vtex-product-summary-2-x-brandName t-body").get_text()
            preco = item.find("span", class_= "vtex-productShowCasePrice").get_text()
            preco = str(preco).replace('\xa0','')
            img = item.find("img", class_="vtex-product-summary-2-x-imageNormal vtex-product-summary-2-x-image").get('src')
            #print(img)
            qtd = nome.split()[-1]
            qtdEstoque = random.randint(0,100)
            produto.append(nome)
            produto.append(preco)
            produto.append(qtd)
            produto.append(qtdEstoque)
            produto.append(img)
            todosProdutos.append(produto)
            print(produto)
    #         print(nome + "Preco " + preco + " Quantidade " + qtd+"Quantidade em Estoque",qtdEstoque)
cont = 1
for link in urls:
    procurar(link)
    print('Leu o link',cont)
    cont+=1
print(todosProdutos)
escrever_json(todosProdutos)
