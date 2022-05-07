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
    before("Creating 'protudo' to delete", async function(){
        chai.request(host)
            .post('/produtos')
            .send(config.valid_produto_request_body)
            .end(function(err, res){
                expect(err).to.be.null;
                expect(res.statusCode).to.be.equal(200)
                variables.produtos.created_id_to_delete = res.body.id
            })
    })
    it("DELETE /produtos/id - 200 success - Delete created product", function (done){
        chai.request(host)
            .delete('/produtos/'+ variables.produtos.created_id_to_delete + '/deletar')
            .end(function(err, res){
                expect(err).to.be.null;
                expect(res.statusCode).to.be.equal(200)
                done()
            })
    })
}