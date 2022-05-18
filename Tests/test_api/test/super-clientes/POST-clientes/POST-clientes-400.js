const chai = require("chai"),
    chaiHttp = require('chai-http');
const expect = chai.expect;
const should = chai.should();
const variables = require('../../../atributes/variables');
const constants = require('../../../atributes/constants');
const config = require('../../../config/request_body/request_body_post_clientes_error')
chai.use(chaiHttp)

const host = constants.global_variables.super_api

module.exports = function (){
    after("deleting invalid 'clientes'", async function (){
        variables.clientes.invalids_posts_requests_ids_to_delete.forEach(element => {
            chai.request(host)
                .delete('/clientes/'+ element + '/deletar')
                .end(function(err, res){
                    expect(err).to.be.null;
                    expect(res.statusCode).to.be.equal(200)
                })
        });
    })
    it("POST /clientes - 400 bad request - Invalid 'cliente' - missig paramiter(valor)", function (done){
        chai.request(host)
            .post('/clientes')
            .send(config.invalid_cliente_request_body_missing_paramiter)
            .end(function(err, res){
                expect(err).to.be.null;
                if (res.statusCode==200) {
                    variables.clientes.invalids_posts_requests_ids_to_delete.push(res.body.id)
                }
                expect(res.statusCode).to.be.equal(400)
            })
    })
    it("POST /clientes - 400 bad request - Invalid 'cliente' - invalid paramiter(valor)", function (done){
        chai.request(host)
            .post('/clientes')
            .send(config.invalid_cliente_request_body_invalid_paramiter)
            .end(function(err, res){
                expect(err).to.be.null;
                if (res.statusCode==200) {
                    variables.clientes.invalids_posts_requests_ids_to_delete.push(res.body.id)
                }
                expect(res.statusCode).to.be.equal(400)
                done()
            })
    })
    it("POST /clientes - 400 bad request - Invalid 'cliente' - Null paramiter(valor)", function (done){
        chai.request(host)
            .post('/clientes')
            .send(config.invalid_cliente_request_body_null_paramiter)
            .end(function(err, res){
                expect(err).to.be.null;
                if (res.statusCode==200) {
                    variables.clientes.invalids_posts_requests_ids_to_delete.push(res.body.id)
                }
                expect(res.statusCode).to.be.equal(400)
                done()
            })
    })
    it("POST /clientes - 400 bad request - Invalid 'cliente' request - Wrong paramiter name (name)", function (done){
        chai.request(host)
            .post('/clientes')
            .send(config.invalid_cliente_request_body_wrong_paramiter_name)
            .end(function(err, res){
                expect(err).to.be.null;
                if (res.statusCode==200) {
                    variables.clientes.invalids_posts_requests_ids_to_delete.push(res.body.id)
                }
                expect(res.statusCode).to.be.equal(400)
                done()
            })
    })
    it("POST /clientes - 400 bad request - Invalid 'cliente' request - Blank space (name)", function (done){
        chai.request(host)
            .post('/clientes')
            .send(config.invalid_cliente_request_body_blank_space)
            .end(function(err, res){
                expect(err).to.be.null;
                if (res.statusCode==200) {
                    variables.clientes.invalids_posts_requests_ids_to_delete.push(res.body.id)
                }
                expect(res.statusCode).to.be.equal(400)
                done()
            })
    })
    it("POST /clientes - 400 bad request - Invalid 'cliente' request - Empty paramiter (name)", function (done){
        chai.request(host)
            .post('/clientes')
            .send(config.invalid_cliente_request_body_empty_paramiter)
            .end(function(err, res){
                expect(err).to.be.null;
                if (res.statusCode==200) {
                    variables.clientes.invalids_posts_requests_ids_to_delete.push(res.body.id)
                }
                expect(res.statusCode).to.be.equal(400)
                done()
            })
    })

}