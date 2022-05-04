const chai = require("chai"),
    chaiHttp = require('chai-http');
const expect = chai.expect;
const should = chai.should();
const constants = require('../../../atributes/constants');
const config = require('../../../config/request_body/request_body_post_produtos_success')
const variables = require('../../../atributes/variables');
chai.use(chaiHttp)

const host = constants.global_variables.super_api

module.exports = function (){
    beforeEach("Creating 'protudo' to update", async function(){
        chai.request(host)
            .post('/produtos')
            .send(config.valid_produto_request_body)
            .end(function(err, res){
                expect(err).to.be.null;
                expect(res.statusCode).to.be.equal(200)
                variables.produtos.created_id_to_update = res.body.id
            })
    })
    it("GET /produtos - 200 success - Content existence validation (List)", function (done){
        chai.request(host)
            .get('/produtos')
            .end(function(err, res){
                expect(err).to.be.null;
                expect(res.statusCode).to.be.equal(200)
                res.body.content.forEach(element => {
                    should.exist(element.id, "Expected 'id' not exist")
                    should.exist(element.nome, "Expected 'nome' not exist")
                    should.exist(element.valor, "Expected 'valor' not exist")
                    should.exist(element.marca, "Expected 'marca' not exist")
                    should.exist(element.imgUrl, "Expected 'imgUrl' not exist")
                    should.exist(element.descricao, "Expected 'descrição' not exist")
                    should.exist(element.undVenda, "Expected 'undVenda' not exist")
                });
                done()
            })
    })
}