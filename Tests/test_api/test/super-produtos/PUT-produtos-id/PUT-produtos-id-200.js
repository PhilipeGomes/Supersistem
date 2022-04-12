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
    it("PUT /produtos/id - 200 success - Edit inseted product", function (done){
        chai.request(host)
            .put('/produtos/'+ variables.produtos.created_id + '/editar')
            .send(config.Edit_produto_request_body)
            .end(function(err, res){
                expect(err).to.be.null;
                //expect(res.statusCode).to.be.equal(200)
                console.log(res.body)
                done()
            })
    })
}