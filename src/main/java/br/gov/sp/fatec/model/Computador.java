package br.gov.sp.fatec.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonView;

import br.gov.sp.fatec.view.View;

@Entity
@Table(name = "COM_COMPUTADOR")
public class Computador {
	
	@Id
	@GeneratedValue(generator = "increment")
	@GenericGenerator(name = "increment", strategy = "increment")
	@JsonView({View.Tudo.class})
	@Column(name = "COM_ID")
	private Long id;
	
	@Column(name = "COM_MARCA", unique = false, length = 30, nullable = false)
	@JsonView({View.Tudo.class, View.Comum.class})
	private String marca;
	
	@Column(name = "COM_PROCESSADOR", unique = false, length = 30, nullable = false)
	@JsonView({View.Tudo.class, View.Comum.class})
	private String processador;
	
	@Column(name = "COM_MEMORIA", unique = false, length = 30, nullable = false)
	@JsonView({View.Tudo.class, View.Comum.class})
	private String memoria;
	
	@Column(name = "COM_ARMAZENAMENTO", unique = false, length = 20, nullable = false)
	@JsonView({View.Tudo.class, View.Comum.class})
	private String armazenamento;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getProcessador() {
		return processador;
	}

	public void setProcessador(String processador) {
		this.processador = processador;
	}

	public String getMemoria() {
		return memoria;
	}

	public void setMemoria(String memoria) {
		this.memoria = memoria;
	}

	public String getArmazenamento() {
		return armazenamento;
	}

	public void setArmazenamento(String armazenamento) {
		this.armazenamento = armazenamento;
	}

}
