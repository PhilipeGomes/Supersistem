const chai = require("chai"),
    chaiHttp = require('chai-http');
const expect = chai.expect;
const should = chai.should();
const variables = require('../../../atributes/variables');
const constants = require('../../../atributes/constants');
const config = require('../../../config/request_body/request_body_post_clientes_success')
chai.use(chaiHttp)

const host = constants.global_variables.super_api

module.exports = function (){
    afterEach("Getting inserted 'cliente'", async function (){
        let res = await chai.request(host)
            .get('/clientes/'+ variables.clientes.created_id)
            expect(res.statusCode).to.be.equal(200)
            expect(res.body.id).to.be.equal(variables.clientes.created_id)
            expect(res.body.nome).to.be.equal(config.valid_cliente_request_body.nome)
            expect(res.body.cpf).to.be.equal(config.valid_cliente_request_body.cpf)
            expect(res.body.telefone).to.be.equal(config.valid_cliente_request_body.telefone)
            expect(res.body.email).to.be.equal(config.valid_cliente_request_body.email)

        let res2 = await chai.request(host)
            .delete('/clientes/'+ variables.clientes.created_id + '/deletar')
            expect(res2.statusCode).to.be.equal(200)
    })
    it("POST /clientes - 200 success - Valid 'Cliente'", function (done){
        chai.request(host)
            .post('/clientes')
            .send(config.valid_cliente_request_body)
            .end(function(err, res){
                expect(err).to.be.null;
                expect(res.statusCode).to.be.equal(200)
                variables.clientes.created_id = res.body.id
                done()
            })
    })


}