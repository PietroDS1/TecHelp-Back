package com.TecHelp.TecHelp.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table( name = "tb_forum")

public class Forum {	
		
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private long id;
		
		private String imagem;
		
		@NotBlank
		@Size(min = 5, max = 50)
		private String titulo;
		
		@NotBlank
		@Size(min = 5, max = 1000)
		private String publicacao;
		
		@ManyToOne
		@JsonIgnoreProperties("forum")
		private Usuario usuario;
		
		@OneToMany(mappedBy = "forum", cascade = CascadeType.REMOVE)
		@JsonIgnoreProperties("forum")
		private List<Resposta> resposta;
		
		//----------------------------------ENCAPSULAMENTO------------------------------------

		public long getId() {
			return id;
		}

		public void setId(long id) {
			this.id = id;
		}

		public String getImagem() {
			return imagem;
		}

		public void setImagem(String imagem) {
			this.imagem = imagem;
		}

		public String getTitulo() {
			return titulo;
		}

		public void setTitulo(String titulo) {
			this.titulo = titulo;
		}

		public String getPublicacao() {
			return publicacao;
		}

		public void setPublicacao(String publicacao) {
			this.publicacao = publicacao;
		}

		public Usuario getUsuario() {
			return usuario;
		}

		public void setUsuario(Usuario usuario) {
			this.usuario = usuario;
		}

		public List<Resposta> getResposta() {
			return resposta;
		}

		public void setResposta(List<Resposta> resposta) {
			this.resposta = resposta;
		}
		
		
		
		
		
		


		

		
	
}
