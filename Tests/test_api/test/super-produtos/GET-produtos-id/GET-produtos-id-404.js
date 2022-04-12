const chai = require("chai"),
    chaiHttp = require('chai-http');
const expect = chai.expect;
const should = chai.should();
const variables = require('../../../atributes/variables');
const constants = require('../../../atributes/constants');
chai.use(chaiHttp)

const host = constants.global_variables.super_api

module.exports = function (){
    it("GET /produtos/id - 404 Not found - Inexistent id", function (done){
        chai.request(host)
            .get('/produtos/'+ variables.produtos.inexistent_id)
            .end(function(err, res){
                expect(err).to.be.null;
                console.log(res.body)
                expect(res.statusCode).to.be.equal(404)
                done()
            })
    })
    it("GET /produtos/id - 404 Not found - Deleted 'Produto'", function (done){
        chai.request(host)
            .get('/produtos/'+9)
            .end(function(err, res){
                expect(err).to.be.null;
                expect(res.statusCode).to.be.equal(404)
                done()
            })
    })
}