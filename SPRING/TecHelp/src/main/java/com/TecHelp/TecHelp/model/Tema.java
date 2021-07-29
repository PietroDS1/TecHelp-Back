package com.TecHelp.TecHelp.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import com.sun.istack.NotNull;

@Entity
@Table(name = "tb_Tema")
public class Tema {
	
	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@NotNull
	@Size(min = 5, max = 255)
	private String frontEnd;
	
	@NotNull
	@Size(min = 5, max = 255)
	private String backEnd;
	
	@NotNull
	@Size(min = 5, max = 255)
	private String fullStack;

	@NotNull
	@Size(min = 5, max = 255)
	private String bancoDeDados;
	

	@NotNull
	@Size(min = 5, max = 255)
	private String basico;
	
	//----------------------------------ENCAPSULAMENTO------------------------------------
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFrontEnd() {
		return frontEnd;
	}

	public void setFrontEnd(String frontEnd) {
		this.frontEnd = frontEnd;
	}

	public String getBackEnd() {
		return backEnd;
	}

	public void setBackEnd(String backEnd) {
		this.backEnd = backEnd;
	}

	public String getFullStack() {
		return fullStack;
	}

	public void setFullStack(String fullStack) {
		this.fullStack = fullStack;
	}
	public String getBancoDeDados() {
		return bancoDeDados;
	}

	public void setBancoDeDados(String bancoDeDados) {
		this.bancoDeDados = bancoDeDados;
	}

	public String getBasico() {
		return basico;
	}

	public void setBasico(String basico) {
		this.basico = basico;
	}
}
