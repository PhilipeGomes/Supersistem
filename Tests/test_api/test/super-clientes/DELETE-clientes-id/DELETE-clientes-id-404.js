const chai = require("chai"),
    chaiHttp = require('chai-http');
const expect = chai.expect;
const should = chai.should();
const variables = require('../../../atributes/variables');
const constants = require('../../../atributes/constants');
const config = require('../../../config/request_body/request_body_post_clientes_success')
chai.use(chaiHttp)

const host = constants.global_variables.super_api

module.exports = function (){
    it("DELETE /clientes/id - 404 - Delete inexistent 'cliente'", function (done){
        chai.request(host)
            .delete('/clientes/'+ variables.clientes.inexistent_id + '/deletar')
            .end(function(err, res){
                expect(err).to.be.null;
                expect(res.statusCode).to.be.equal(404)
                done()
            })
    })
}