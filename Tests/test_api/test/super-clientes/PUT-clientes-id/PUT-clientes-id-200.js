const chai = require("chai"),
    chaiHttp = require('chai-http');
const expect = chai.expect;
const should = chai.should();
const variables = require('../../../atributes/variables');
const constants = require('../../../atributes/constants');
const config = require('../../../config/request_body/request_body_post_clientes_success')
const config2 = require('../../../config/request_body/request_body_put_clientes_success')

chai.use(chaiHttp)

const host = constants.global_variables.super_api

module.exports = function (){
    beforeEach("Creating 'cliente' to update", async function(){
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
    it("PUT /clientes/id - 200 success - Edit inseted product", function (done){
        chai.request(host)
            .put('/clientes/'+ variables.clientes.created_id_to_update + '/editar')
            .send(config2.edit_cliente_request_body)
            .end(function(err, res){
                expect(err).to.be.null;
                expect(res.statusCode).to.be.equal(200)
                done()
            })
    })
    it("PUT /clientes/id - 200 success - Edit inseted product - Not sending paramiter(nome)", function (done){
        chai.request(host)
            .put('/clientes/'+ variables.clientes.created_id_to_update + '/editar')
            .send(config2.edit_cliente_request_body_not_sending_paramiter)
            .end(function(err, res){
                expect(err).to.be.null;
                expect(res.statusCode).to.be.equal(200)
                done()
            })
    })
}