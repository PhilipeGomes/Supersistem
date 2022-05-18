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
    before("Creating 'cliente' to delete", async function(){
        let res = await chai.request(host)
            .post('/clientes')
            .send(config.valid_cliente_request_body)
            expect(res.statusCode).to.be.equal(200)
            variables.clientes.created_id_to_delete = res.body.id
            
    })
    it("DELETE /clientes/id - 200 success - Delete created client", function (done){
        chai.request(host)
            .delete('/clientes/'+ variables.clientes.created_id_to_delete + '/deletar')
            .end(function(err, res){
                expect(err).to.be.null;
                expect(res.statusCode).to.be.equal(200)
                done()
            })
    })
}