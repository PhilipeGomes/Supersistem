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
    afterEach("Creating 'cliente' to try delete twoice", async function (){
        let res = await chai.request(host)
        .post('/clientes')
        .send(config.valid_cliente_request_body)
        expect(res.statusCode).to.be.equal(200)
        variables.clientes.created_id_to_delete = res.body.id

        let res2 = await chai.request(host)
            .delete('/clientes/'+ variables.clientes.created_id_to_delete + '/deletar')
            variables.clientes.deleted_client = variables.clientes.created_id_to_delete
            expect(res2.statusCode).to.be.equal(200)
    })
    it("GET /clientes/id - 404 Not found - Inexistent id", function (done){
        chai.request(host)
            .get('/clientes/'+ variables.clientes.inexistent_id)
            .end(function(err, res){
                expect(err).to.be.null;
                expect(res.statusCode).to.be.equal(404)
                done()
            })
    })
    it("GET /clientes/id - 404 Not found - Deleted 'Cliente'", function (done){
        chai.request(host)
            .get('/clientes/'+ variables.clientes.deleted_client)
            .end(function(err, res){
                expect(err).to.be.null;
                expect(res.statusCode).to.be.equal(404)
                done()
            })
    })
}