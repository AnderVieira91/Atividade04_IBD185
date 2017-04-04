package br.gov.sp.fatec.web.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;

import br.gov.sp.fatec.model.Computador;
import br.gov.sp.fatec.service.ComputadorService;
import br.gov.sp.fatec.view.View;

@RestController
@RequestMapping(value = "/computador")
public class ComputadorController {

	@Autowired
	private ComputadorService computadorService;

	@RequestMapping(value = "/buscar/{id}")
	@JsonView(View.Comum.class)
	public ResponseEntity<Computador> buscarComputador(@PathVariable("id") Long id) {
		return new ResponseEntity<Computador>(computadorService.buscarComputador(id), HttpStatus.OK);
	}

	@RequestMapping(value = "/buscar/todos")
	@JsonView(View.Comum.class)
	public ResponseEntity<List<Computador>> buscarTodos() {
		return new ResponseEntity<List<Computador>>(computadorService.buscarTodos(), HttpStatus.OK);
	}

	@RequestMapping(value = "/getById")
	@JsonView(View.Tudo.class)
	public ResponseEntity<Computador> get(@RequestParam(value = "id", defaultValue = "1") Long id) {
		Computador computador = computadorService.buscarComputador(id);
		if (computador == null) {
			return new ResponseEntity<Computador>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Computador>(computador, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/buscar/processador/{processador}")
	@JsonView(View.Comum.class)
	public ResponseEntity<List<Computador>> buscarPorProcessador(@PathVariable("processador") String processador) {
		return new ResponseEntity<List<Computador>>(computadorService.buscarPorProcessador(processador), HttpStatus.OK);

	}



	@RequestMapping(value = "/salvar", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	@JsonView(View.Tudo.class)
	@ResponseStatus(HttpStatus.CREATED)
	public Computador salvarComputador(@RequestBody Computador computador, HttpServletRequest request,
			HttpServletResponse response) {
		computador = computadorService.salvarComputador(computador);
		response.addHeader("Location", request.getServerName() + ":" + request.getServerPort()
				+ request.getContextPath() + "/computador/getById?id=" + computador.getId());
		return computador;
	}

	public ComputadorService getComputadorService() {
		return computadorService;
	}

	public void setComputadorService(ComputadorService computadorService) {
		this.computadorService = computadorService;
	}

}
