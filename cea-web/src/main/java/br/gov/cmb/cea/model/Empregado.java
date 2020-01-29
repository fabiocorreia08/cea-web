package br.gov.cmb.cea.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="empregado")
public class Empregado {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name="nome")
	private String nome;
	
	@Column(name="matricula")
	private String matricula;
	
	@Column(name="inicioFerias")
	private String inicioFerias;
	
	@Column(name="fimFerias")
	private String fimFerias;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public String getInicioFerias() {
		return inicioFerias;
	}

	public void setInicioFerias(String inicioFerias) {
		this.inicioFerias = inicioFerias;
	}

	public String getFimFerias() {
		return fimFerias;
	}

	public void setFimFerias(String fimFerias) {
		this.fimFerias = fimFerias;
	}
	
}
