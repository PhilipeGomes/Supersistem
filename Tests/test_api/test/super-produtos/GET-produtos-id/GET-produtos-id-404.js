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
    afterEach("Creating 'protudo' to try delete twoice", async function (){
        let res = await chai.request(host)
        .post('/produtos')
        .send(config.valid_produto_request_body)
        expect(res.statusCode).to.be.equal(200)
        variables.produtos.created_id_to_delete = res.body.id

        let res2 = await chai.request(host)
            .delete('/produtos/'+ variables.produtos.created_id_to_delete + '/deletar')
            variables.produtos.deleted_produtc = variables.produtos.created_id_to_delete
            expect(res2.statusCode).to.be.equal(200)
    })
    it("GET /produtos/id - 404 Not found - Inexistent id", function (done){
        chai.request(host)
            .get('/produtos/'+ variables.produtos.inexistent_id)
            .end(function(err, res){
                expect(err).to.be.null;
                expect(res.statusCode).to.be.equal(404)
                done()
            })
    })
    it("GET /produtos/id - 404 Not found - Deleted 'Produto'", function (done){
        chai.request(host)
            .get('/produtos/'+ variables.produtos.deleted_produtc)
            .end(function(err, res){
                expect(err).to.be.null;
                expect(res.statusCode).to.be.equal(404)
                done()
            })
    })
}