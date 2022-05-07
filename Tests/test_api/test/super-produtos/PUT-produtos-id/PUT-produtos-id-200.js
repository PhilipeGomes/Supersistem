const chai = require("chai"),
    chaiHttp = require('chai-http');
const expect = chai.expect;
const should = chai.should();
const variables = require('../../../atributes/variables');
const constants = require('../../../atributes/constants');
const config = require('../../../config/request_body/request_body_post_produtos_success')
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
    afterEach("Deleting created 'produtos'", async function (){
        chai.request(host)
            .delete('/produtos/'+ variables.produtos.created_id_to_update + '/deletar')
            .end(function(err, res){
                expect(err).to.be.null;
                expect(res.statusCode).to.be.equal(200)
            })
    })
    it("PUT /produtos/id - 200 success - Edit inseted product", function (done){
        chai.request(host)
            .put('/produtos/'+ variables.produtos.created_id_to_update + '/editar')
            .send(config.edit_produto_request_body)
            .end(function(err, res){
                expect(err).to.be.null;
                expect(res.statusCode).to.be.equal(200)
                done()
            })
    })
    it("PUT /produtos/id - 200 success - Edit inseted product - Not sending paramiter(nome)", function (done){
        chai.request(host)
            .put('/produtos/'+ variables.produtos.created_id_to_update + '/editar')
            .send(config.edit_produto_request_body_not_sending_paramiter)
            .end(function(err, res){
                expect(err).to.be.null;
                expect(res.statusCode).to.be.equal(200)
                done()
            })
    })
}