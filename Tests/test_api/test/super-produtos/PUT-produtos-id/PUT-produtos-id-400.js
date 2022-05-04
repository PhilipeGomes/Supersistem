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
    it("PUT /produtos/id - 400 success - Invalid edit inseted product(valor)", function (done){
        chai.request(host)
            .put('/produtos/'+ variables.produtos.created_id_to_update + '/editar')
            .send(config.invalid_edit_produto_request_body)
            .end(function(err, res){
                expect(err).to.be.null;
                expect(res.statusCode).to.be.equal(400)
                done()
            })
    })
}