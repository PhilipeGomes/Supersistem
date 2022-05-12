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
    afterEach("Getting inserted 'produto'", async function (){
        let res = await chai.request(host)
            .get('/produtos/'+ variables.produtos.created_id)
            expect(res.statusCode).to.be.equal(200)
            expect(res.body.id).to.be.equal(variables.produtos.created_id)
            expect(res.body.nome).to.be.equal(config.valid_produto_request_body.nome)
            expect(res.body.valor).to.be.equal(config.valid_produto_request_body.valor)
            expect(res.body.marca).to.be.equal(config.valid_produto_request_body.marca)
            expect(res.body.imgUrl).to.be.equal(config.valid_produto_request_body.imgUrl)
            expect(res.body.descricao).to.be.equal(config.valid_produto_request_body.descricao)
            expect(res.body.undVenda).to.be.equal(config.valid_produto_request_body.undVenda)
           
        let res2 = await chai.request(host)
            .delete('/produtos/'+ variables.produtos.created_id + '/deletar')
            expect(res2.statusCode).to.be.equal(200)
    })
    it("POST /produtos - 200 success - Valid 'Produto'", function (done){
        chai.request(host)
            .post('/produtos')
            .send(config.valid_produto_request_body)
            .end(function(err, res){
                expect(err).to.be.null;
                expect(res.statusCode).to.be.equal(200)
                variables.produtos.created_id = res.body.id
                done()
            })
    })


}