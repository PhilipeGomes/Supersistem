let get_produtos_200 = require('../test/super-produtos/GET-produtos/GET-produtos-200')
let get_produtos_id_200 = require('../test/super-produtos/GET-produtos-id/GET-produtos-id-200')
let get_produtos_id_404 = require('../test/super-produtos/GET-produtos-id/GET-produtos-id-404')
let get_produtos_id_400 = require('../test/super-produtos/GET-produtos-id/GET-produtos-id-400')
let post_produtos_200 = require('../test/super-produtos/POST-produtos/POST-produtos-200')


describe("Supersystem Tests", function(){
     this.timeout(0)
    
    //Produtos
    //POST produtos
    //describe('post-produto-200', post_produtos_200)

    //GET produtos
    describe('get-produto-200', get_produtos_200)

    //GET produtos-id
    describe('get-produto-id-200', get_produtos_id_200)
    describe('get-produto-id-404', get_produtos_id_404)
    describe('get-produto-id-400', get_produtos_id_400)

    //DELETE produtos-id
})