package br.gov.sp.fatec.service;

import java.util.List;

import br.gov.sp.fatec.model.Computador;

public interface ComputadorService {
	
	public Computador salvarComputador(Computador computador);
	public List<Computador> buscarTodos();
	public Computador buscarComputador(Long id);
	public List<Computador> buscarPorProcessador(String processador);

}
