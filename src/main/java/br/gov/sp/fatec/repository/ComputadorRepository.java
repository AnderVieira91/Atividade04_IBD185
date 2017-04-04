package br.gov.sp.fatec.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import br.gov.sp.fatec.model.Computador;

public interface ComputadorRepository extends CrudRepository<Computador, Long>{
	
	public Computador findById(Long id);
	
	public List<Computador> findByProcessadorIgnoreCaseContaining(String processador);

}
