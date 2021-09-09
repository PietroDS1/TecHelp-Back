package com.TecHelp.TecHelp.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "tb_resposta")

public class Resposta {

		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private long id;

		private String imagem;

		@NotBlank
		@Size(min = 2, max = 500)
		private String comentario;
		
		@ManyToOne
		@JsonIgnoreProperties("resposta")
		private Forum forum;
		
		@ManyToOne
		@JsonIgnoreProperties("resposta")
		private Usuario usuario ;
		
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

		public String getComentario() {
			return comentario;
		}

		public void setComentario(String comentario) {
			this.comentario = comentario;
		}

		public Forum getForum() {
			return forum;
		}

		public void setForum(Forum forum) {
			this.forum = forum;
		}

		public Usuario getUsuario() {
			return usuario;
		}

		public void setUsuario(Usuario usuario) {
			this.usuario = usuario;
		}
		
}
