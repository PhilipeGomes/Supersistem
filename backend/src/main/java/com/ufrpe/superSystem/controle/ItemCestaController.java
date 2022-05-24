package com.ufrpe.superSystem.controle;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ufrpe.superSystem.dto.ProdutoDTO;
import com.ufrpe.superSystem.dto.UsuarioDTO;
import com.ufrpe.superSystem.modelos.ItemCesta;
import com.ufrpe.superSystem.modelos.ItemCestaPK;
import com.ufrpe.superSystem.modelos.Produto;
import com.ufrpe.superSystem.modelos.Usuario;
import com.ufrpe.superSystem.servico.ItemCestaServico;
import com.ufrpe.superSystem.servico.ProdutoServico;
import com.ufrpe.superSystem.servico.UsuarioServico;

@RestController
@RequestMapping(value = "/cestas")
public class ItemCestaController {
	
	@Autowired
	private UsuarioServico userService;
	@Autowired
    private ProdutoServico productService;
	@Autowired
    private ItemCestaServico cartItemService;
	
	 @GetMapping("/usuarios/{id}/")
	    public ResponseEntity<List<ItemCesta>> buscarCestaUsuario (@PathVariable("id") Long id) {
	        System.out.println(userService.buscarPeloId(id).getItemCesta().size());
	        return new ResponseEntity<>(userService.buscarPeloId(id).getItemCesta(), HttpStatus.OK);
	    }

	    @PostMapping("/usuarios/{id}/add/{produtoId}")
	    public ResponseEntity<UsuarioDTO> addToUserCart (@PathVariable("id") Long id,
	                                               @PathVariable("produtoId") Long productId) {
	        UsuarioDTO user = userService.buscarPeloId(id);
	        ProdutoDTO product = productService.buscarPeloId(productId);

			ItemCesta cartItem = new ItemCesta(user, product, 1);
	        cartItemService.salvar(cartItem);

	        return new ResponseEntity<>(userService.buscarPeloId(id), HttpStatus.CREATED);
	    }

	    @PutMapping("/usuarios/{id}/update/{productId}")
	    public ResponseEntity<UsuarioDTO> updateCartItem (@PathVariable("id") Long id,
	                                                @PathVariable("productId") Long productId,
	                                                @RequestBody ItemCesta cartItem) {
	    	 UsuarioDTO user = userService.buscarPeloId(id);
		        ProdutoDTO product = productService.buscarPeloId(productId);

	        cartItem.setPk(new ItemCestaPK(user, product));
	        cartItemService.atualizar(cartItem);

	        return new ResponseEntity<>(userService.buscarPeloId(id), HttpStatus.OK);
	    }

	    @DeleteMapping("/users/{id}/remove/{productId}")
	    public ResponseEntity<UsuarioDTO> removeFromUserCart (@PathVariable("id") Long id,
	                                                    @PathVariable("productId") Long productId) {
	        cartItemService.deletar(id, productId);

	        return new ResponseEntity<>(userService.buscarPeloId(id), HttpStatus.OK);
	    }
	    
	    @GetMapping("/cart-items/{id}/{productId}")
	    public ResponseEntity<ItemCesta> buscarItem (@PathVariable("id") Long id,
	                                                 @PathVariable("productId") Long productId) {
	        return ResponseEntity.ok(cartItemService.buscarPeloId(id, productId));
	    }


}
