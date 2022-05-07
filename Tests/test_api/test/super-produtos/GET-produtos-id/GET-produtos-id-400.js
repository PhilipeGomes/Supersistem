const chai = require("chai"),
    chaiHttp = require('chai-http');
const expect = chai.expect;
const should = chai.should();
const variables = require('../../../atributes/variables');
const constants = require('../../../atributes/constants');
chai.use(chaiHttp)

const host = constants.global_variables.super_api

module.exports = function (){
    it("GET /produtos/id - 400 Bad request - String id", function (done){
        chai.request(host)
            .get('/produtos/'+ variables.produtos.string_id)
            .end(function(err, res){
                expect(err).to.be.null;
                expect(res.statusCode).to.be.equal(400)
                done()
            })
    })
    it("GET /produtos/id - 400 Bad request - null id", function (done){
        chai.request(host)
            .get('/produtos/'+ null)
            .end(function(err, res){
                expect(err).to.be.null;
                expect(res.statusCode).to.be.equal(400)
                done()
            })
    })
    it("GET /produtos/id - 400 Bad request - NaN id", function (done){
        chai.request(host)
            .get('/produtos/'+ NaN)
            .end(function(err, res){
                expect(err).to.be.null;
                expect(res.statusCode).to.be.equal(400)
                done()
            })
    })
    it("GET /produtos/id - 400 Bad request - Boolean id", function (done){
        chai.request(host)
            .get('/produtos/'+ false)
            .end(function(err, res){
                expect(err).to.be.null;
                expect(res.statusCode).to.be.equal(400)
                done()
            })
    })
}