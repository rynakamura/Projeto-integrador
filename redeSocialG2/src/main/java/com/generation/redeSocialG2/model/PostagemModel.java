package com.generation.redeSocialG2.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table( name = "tb_postagem")
public class PostagemModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@NotNull
	@Size (min = 0, max = 255)
	private String titulo;

	@NotNull
	@Size (max = 1000)
	private String descricao;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date data_postagem = new java.sql.Date(System.currentTimeMillis());

	@NotNull
	private String link_video;
	
	/*tema_id
	 * usuario_id */
	
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Date getData_postagem() {
		return data_postagem;
	}

	public void setData_postagem(Date data_postagem) {
		this.data_postagem = data_postagem;
	}

	public String getLink_video() {
		return link_video;
	}

	public void setLink_video(String link_video) {
		this.link_video = link_video;
	}
	
}
