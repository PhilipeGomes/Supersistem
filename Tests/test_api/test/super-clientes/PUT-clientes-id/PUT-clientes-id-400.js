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
    beforeEach("Creating 'protudo' to update", async function(){
        let res = await chai.request(host)
            .post('/clientes')
            .send(config.valid_cliente_request_body)
            expect(res.statusCode).to.be.equal(200)
            variables.clientes.created_id_to_update = res.body.id
    })
    afterEach("Deleting created 'clientes'", async function (){
        let res = await chai.request(host)
            .delete('/clientes/'+ variables.clientes.created_id_to_update + '/deletar')
            expect(res.statusCode).to.be.equal(200)
    })
    it("PUT /clientes/id - 400 success - Invalid edit inseted client(valor)", function (done){
        chai.request(host)
            .put('/clientes/'+ variables.clientes.created_id_to_update + '/editar')
            .send(config.invalid_edit_cliente_request_body)
            .end(function(err, res){
                expect(err).to.be.null;
                expect(res.statusCode).to.be.equal(400)
                done()
            })
    })
}