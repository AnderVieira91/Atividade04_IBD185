package br.gov.sp.fatec.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.gov.sp.fatec.model.Computador;
import br.gov.sp.fatec.repository.ComputadorRepository;

@Service("computadorService")
public class ComputadorServiceImp implements ComputadorService {

	@Autowired
	private ComputadorRepository computadorRepo;

	public Computador salvarComputador(Computador computador) {
		return computadorRepo.save(computador);
	}

	public List<Computador> buscarTodos() {
		List<Computador> computadores = new ArrayList<Computador>();
		for (Computador c : computadorRepo.findAll()) {
			computadores.add(c);
		}
		return computadores;
	}

	public List<Computador> buscarPorProcessador(String processador) {
		List<Computador> computadores = new ArrayList<Computador>();
		for (Computador c : computadorRepo.findByProcessadorIgnoreCaseContaining(processador)) {
			computadores.add(c);
		}
		return computadores;
	}

	public Computador buscarComputador(Long id) {
		Computador computador = computadorRepo.findById(id);
		return computador;
	}

	public ComputadorRepository getComputadorRepo() {
		return computadorRepo;
	}

	public void setComputadorRepo(ComputadorRepository computadorRepo) {
		this.computadorRepo = computadorRepo;
	}

}
