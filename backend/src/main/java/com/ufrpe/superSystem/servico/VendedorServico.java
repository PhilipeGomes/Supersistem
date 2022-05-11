package com.ufrpe.superSystem.servico;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ufrpe.superSystem.dto.VendedorDTO;
import com.ufrpe.superSystem.modelos.Vendedor;
import com.ufrpe.superSystem.repositorio.VendedorRepositorio;

@Service
@Transactional
public class VendedorServico {
	
	//como o framework ja tem um gerenciador de depedencia pra gente essa anotação da conta de instanciar os objetos para chamar os metodos da interface
	@Autowired
	private VendedorRepositorio vendedorRepositorio;
	
	@Transactional(readOnly = true)
	public Page<VendedorDTO> buscarTodos(Pageable pageable) {		
		Page<Vendedor> resultado = vendedorRepositorio.findAll(pageable);
	    return resultado.map(res -> new VendedorDTO(res));
	}
	
//	@Transactional(readOnly=true)
//	public VendedorDTO buscarPeloId(Long id){
//		Vendedor resultado = vendedorRepositorio.findById(id).get();
//		VendedorDTO dto = new VendedorDTO(resultado);
//		return dto;
//	}
	
	public void deletar(Long id) {
		vendedorRepositorio.deleteById(id);
	}
	
	public VendedorDTO salvar(VendedorDTO vendedorDTO) {
		Vendedor vendedor = new Vendedor();
//		vendedor.setNome(vendedorDTO.getNome());

		
		vendedorRepositorio.save(vendedor);
		return new VendedorDTO(vendedor);
	}
	
}