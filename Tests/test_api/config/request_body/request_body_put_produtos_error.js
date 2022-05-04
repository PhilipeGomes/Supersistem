const variables = require('../../../atributes/variables');

module.exports = {
    "invalid_edit_produto_request_body": {
        "id": variables.produtos.created_id,
        "nome": "Produto Automation Test (edited)",
        "valor": 'invalid',
        "qtdEstoque": 11,
        "marca": "AUTO (edited)",
        "imgUrl": "https://raw.githubusercontent.com/devsuperior/dscatalog-resources/master/backend/img/1-big.jpg",
        "descricao": "Produto criado para testes (edited)",
        "undVenda": "1Und"
    }
}