const chai = require("chai"),
    chaiHttp = require('chai-http');
const expect = chai.expect;
const should = chai.should();
const variables = require('../../../atributes/variables');
const constants = require('../../../atributes/constants');
chai.use(chaiHttp)

const host = constants.global_variables.super_api

module.exports = function (){
    it("DELETE /produtos/id - 200 success - Delete created product", function (done){
        chai.request(host)
            .get('/produtos/'+ variables.produtos.created_id + '/deletar')
            .end(function(err, res){
                expect(err).to.be.null;
                expect(res.statusCode).to.be.equal(200)
                done()
            })
    })
}