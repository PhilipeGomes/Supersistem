const chai = require("chai"),
    chaiHttp = require('chai-http');
const expect = chai.expect;
const should = chai.should();
const variables = require('../../../atributes/variables');
const constants = require('../../../atributes/constants');
const config = require('../../../config/request_body/request_body_post_produtos_error')
chai.use(chaiHttp)

const host = constants.global_variables.super_api

module.exports = function (){
    after("deleting invalid 'produtos'", async function (){
        variables.produtos.invalids_posts_requests_ids_to_delete.forEach(element => {
            chai.request(host)
                .delete('/produtos/'+ element + '/deletar')
                .end(function(err, res){
                    expect(err).to.be.null;
                    expect(res.statusCode).to.be.equal(200)
                })
        });
    })
    it("POST /produtos - 400 bad request - Invalid 'Produto' - missig paramiter(valor)", function (done){
        chai.request(host)
            .post('/produtos')
            .send(config.invalid_produto_request_body_missing_paramiter)
            .end(function(err, res){
                expect(err).to.be.null;
                if (res.statusCode==200) {
                    variables.produtos.invalids_posts_requests_ids_to_delete.push(res.body.id)
                }
                expect(res.statusCode).to.be.equal(400)
            })
    })
    it("POST /produtos - 400 bad request - Invalid 'Produto' - invalid paramiter(valor)", function (done){
        chai.request(host)
            .post('/produtos')
            .send(config.invalid_produto_request_body_invalid_paramiter)
            .end(function(err, res){
                expect(err).to.be.null;
                if (res.statusCode==200) {
                    variables.produtos.invalids_posts_requests_ids_to_delete.push(res.body.id)
                }
                expect(res.statusCode).to.be.equal(400)
                done()
            })
    })
    it("POST /produtos - 400 bad request - Invalid 'Produto' - Null paramiter(valor)", function (done){
        chai.request(host)
            .post('/produtos')
            .send(config.invalid_produto_request_body_null_paramiter)
            .end(function(err, res){
                expect(err).to.be.null;
                if (res.statusCode==200) {
                    variables.produtos.invalids_posts_requests_ids_to_delete.push(res.body.id)
                }
                expect(res.statusCode).to.be.equal(400)
                done()
            })
    })
    it("POST /produtos - 400 bad request - Invalid 'Produto' request - Wrong paramiter name (name)", function (done){
        chai.request(host)
            .post('/produtos')
            .send(config.invalid_produto_request_body_wrong_paramiter_name)
            .end(function(err, res){
                expect(err).to.be.null;
                if (res.statusCode==200) {
                    variables.produtos.invalids_posts_requests_ids_to_delete.push(res.body.id)
                }
                expect(res.statusCode).to.be.equal(400)
                done()
            })
    })

}