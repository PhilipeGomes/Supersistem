const chai = require("chai"),
    chaiHttp = require('chai-http');
const expect = chai.expect;
const should = chai.should();
const variables = require('../../../atributes/variables');
const constants = require('../../../atributes/constants');
const config = require('../../../config/response_body/response_body_get_produtos_id_success')

chai.use(chaiHttp)

const host = constants.global_variables.super_api

module.exports = function (){
    it("GET /produtos/id - 200 success - Content existence validation (Unit)", function (done){
        chai.request(host)
            .get('/produtos/'+ variables.produtos.valid_id)
            .end(function(err, res){
                expect(err).to.be.null;
                expect(res.statusCode).to.be.equal(200)
                expect(res.body.id).to.be.equal(config.valid_produto_id_1_response_bod.id)
                expect(res.body.nome).to.be.equal(config.valid_produto_id_1_response_bod.nome)
                expect(res.body.valor).to.be.equal(config.valid_produto_id_1_response_bod.valor)
                expect(res.body.marca).to.be.equal(config.valid_produto_id_1_response_bod.marca)
                expect(res.body.imgUrl).to.be.equal(config.valid_produto_id_1_response_bod.imgUrl)
                expect(res.body.descricao).to.be.equal(config.valid_produto_id_1_response_bod.descricao)
                expect(res.body.undVenda).to.be.equal(config.valid_produto_id_1_response_bod.undVenda)
                done()
            })
    })
}