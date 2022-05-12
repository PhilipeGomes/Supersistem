const chai = require("chai"),
    chaiHttp = require('chai-http');
const expect = chai.expect;
const should = chai.should();
const constants = require('../../../atributes/constants');
const variables = require('../../../atributes/variables');
chai.use(chaiHttp)

const host = constants.global_variables.super_api

module.exports = function (){
    it("GET /clientes - 200 success - Content existence validation (List)", function (done){
        chai.request(host)
            .get('/clientes')
            .end(function(err, res){
                expect(err).to.be.null;
                expect(res.statusCode).to.be.equal(200)
                res.body.content.forEach(element => {
                    should.exist(element.id, "Expected 'id' not exist")
                    should.exist(element.nome, "Expected 'nome' not exist")
                    should.exist(element.cpf, "Expected 'cpf' not exist")
                    should.exist(element.telefone, "Expected 'telefone' not exist")
                    should.exist(element.email, "Expected 'email' not exist")
                });
                done()
            })
    })
}