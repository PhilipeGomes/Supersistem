package com.ufrpe.superSystem.servico;

import java.util.ArrayList;
import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ufrpe.superSystem.dto.PedidoDTO;
import com.ufrpe.superSystem.modelos.Pedido;
import com.ufrpe.superSystem.repositorio.PedidoRepositorio;

@Service
@Transactional
public class PedidoServico {
	
	//como o framework ja tem um gerenciador de depedencia pra gente essa anotação da conta de instanciar os objetos para chamar os metodos da interface
	@Autowired
	private PedidoRepositorio pedidoRepositorio;
	
	@Transactional(readOnly=true)
	public List<PedidoDTO> buscarTodos(){
		List <Pedido> resultado = pedidoRepositorio.findAll();
		List<PedidoDTO> lista = new ArrayList<PedidoDTO>();
		resultado.forEach(x -> lista.add(new PedidoDTO(x)));
		return lista;
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
		Pedido pedido = new Pedido();
		pedido.setCliente(pedidoDTO.getCliente());

		
		pedidoRepositorio.save(pedido);
		return new PedidoDTO(pedido);
	}
	
}