const chai = require("chai"),
    chaiHttp = require('chai-http');
const expect = chai.expect;
const should = chai.should();
const variables = require('../../../atributes/variables');
const constants = require('../../../atributes/constants');
const config = require('../../../config/response_body/response_body_get_clientes_id_success')
chai.use(chaiHttp)

const host = constants.global_variables.super_api

module.exports = function (){
    it("GET /clientes/id - 200 success - Content existence validation (Unit)", function (done){
        chai.request(host)
            .get('/clientes/'+ variables.clientes.valid_id)
            .end(function(err, res){
                expect(err).to.be.null;
                expect(res.statusCode).to.be.equal(200)
                expect(res.body.id).to.be.equal(variables.clientes.valid_id)
                expect(res.body.nome).to.be.equal(config.valid_cliente_id_1_response_body.nome)
                expect(res.body.cpf).to.be.equal(config.valid_cliente_id_1_response_body.cpf)
                expect(res.body.telefone).to.be.equal(config.valid_cliente_id_1_response_body.telefone)
                expect(res.body.email).to.be.equal(config.valid_cliente_id_1_response_body.email)
                done()
            })
    })
}