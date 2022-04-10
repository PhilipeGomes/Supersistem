const chai = require("chai"),
    chaiHttp = require('chai-http');
const expect = chai.expect;
const should = chai.should();
const variables = require('../../../atributes/variables');
const constants = require('../../../atributes/constants');
const config = require('../../../config/request_body/request_body_post_produtos_200')
chai.use(chaiHttp)

const host = constants.global_variables.super_api

module.exports = function (){
    after("Geting inserted product id", function(done){
        chai.request(host)
            .get('/produtos')
            .end(function(err, res){
                expect(err).to.be.null;
                expect(res.statusCode).to.be.equal(200)
                res.body.content.forEach(element => {
                   // let product =
                });
                done()
            })
    })

    it("POST /produtos - 200 success - Valid 'Produto'", function (done){
        chai.request(host)
            .post('/produtos')
            .send(config.valid_produto_request_body)
            .end(function(err, res){
                expect(err).to.be.null;
                expect(res.statusCode).to.be.equal(200)
                console.log(res.body)
                done()
            })
    })


}