const chai = require("chai"),
    chaiHttp = require('chai-http');
const expect = chai.expect;
const should = chai.should();
const variables = require('../../../atributes/variables');
const constants = require('../../../atributes/constants');
chai.use(chaiHttp)

const host = constants.global_variables.super_api

module.exports = function (){
    it("GET /produtos/id - 200 success - Content existence validation (Unit)", function (done){
        chai.request(host)
            .get('/produtos/'+ variables.produtos.valid_id)
            .end(function(err, res){
                expect(err).to.be.null;
                expect(res.statusCode).to.be.equal(200)
                expect(res.body.id).to.be.equal(variables.produtos.valid_id)
                should.exist(res.body.nome, "Expected 'nome' not exist")
                should.exist(res.body.valor, "Expected 'valor' not exist")
                should.exist(res.body.marca, "Expected 'marca' not exist")
                should.exist(res.body.imgUrl, "Expected 'imgUrl' not exist")
                should.exist(res.body.descricao, "Expected 'descrição' not exist")
                should.exist(res.body.undVenda, "Expected 'undVenda' not exist")
                done()
            })
    })
}