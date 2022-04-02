package com.ufrpe.superSystem.servico;

import java.time.Instant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ufrpe.superSystem.dto.PedidoDTO;
import com.ufrpe.superSystem.modelos.Pedido;
import com.ufrpe.superSystem.modelos.StatusPedido;
import com.ufrpe.superSystem.repositorio.PedidoRepositorio;

@Service
@Transactional
public class PedidoServico {
	
	//como o framework ja tem um gerenciador de depedencia pra gente essa anotação da conta de instanciar os objetos para chamar os metodos da interface
	@Autowired
	private PedidoRepositorio pedidoRepositorio;
	
	@Transactional(readOnly = true)
	public Page<PedidoDTO> buscarTodos(Pageable pageable) {				
		Page<Pedido> resultado = pedidoRepositorio.findAll(pageable);
	    return resultado.map(res -> new PedidoDTO(res));
	}
	
	@Transactional(readOnly=true)
	public PedidoDTO buscarPeloId(Long id){
		Pedido resultado = pedidoRepositorio.findById(id).get();
		PedidoDTO dto = new PedidoDTO(resultado);
		return dto;
	}
	
	public void deletar(Long id) {
		pedidoRepositorio.deleteById(id);
	}
	
	public PedidoDTO salvar(PedidoDTO pedidoDTO) {
		Pedido pedido = new Pedido(null, pedidoDTO.getTotal(), Instant.now(),
		pedidoDTO.getCliente(), pedidoDTO.getVendedor(), StatusPedido.PAGAMENTOPENDENTE);
		pedido.setCliente(pedidoDTO.getCliente());
		
		pedido = pedidoRepositorio.saveAndFlush(pedido);
		return new PedidoDTO(pedido);
	}
	
}