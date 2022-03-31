import requests
from bs4 import BeautifulSoup


urls = ["https://www.bompreco.com.br/carnes-e-embutidos","https://www.bompreco.com.br/bebidas","https://www.bompreco.com.br/frios-e-laticinios","https://www.bompreco.com.br/limpeza","https://www.bompreco.com.br/beleza-higiene-e-saude","https://www.bompreco.com.br/hortifruti","https://www.bompreco.com.br/mercearia","https://www.bompreco.com.br/pet-shop"]



def procurar(url):
    for n in range(5):
        r = requests.get(url + "?page={p}".format(p=n))
        soup = BeautifulSoup(r.content, 'html.parser')


        produtos = soup.find_all("article", class_ = "vtex-product-summary-2-x-element pointer pt3 pb4 flex flex-column h-100")

        produtosNome = soup.find_all("span", class_= "vtex-product-summary-2-x-productBrand vtex-product-summary-2-x-brandName t-body")
        produtosPreco = soup.find_all("span", class_= "vtex-productShowCasePrice")
        for item in produtos:
            nome = item.find("span", class_= "vtex-product-summary-2-x-productBrand vtex-product-summary-2-x-brandName t-body").get_text()
            preco = item.find("span", class_= "vtex-productShowCasePrice").get_text()
            qtd = nome.split()[-1]
            print(nome + "Preco " + preco + " Quantidade " + qtd)

for link in urls:
    procurar(link)