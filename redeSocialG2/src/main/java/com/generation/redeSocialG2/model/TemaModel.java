package com.generation.redeSocialG2.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "tb_tema")
public class TemaModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@NotNull
	@Size(max=100)
	private String materia;
	
	
	@NotNull
	@Size(max=50)
	private String anoConteudo;
	
	@NotNull
	@Size(max=1000)
	private String descricao;
	
	@OneToMany (mappedBy = "tema",cascade = CascadeType.ALL)
	@JsonIgnoreProperties ("tema")	
	private List<PostagemModel> postagem;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getMateria() {
		return materia;
	}

	public void setMateria(String materia) {
		this.materia = materia;
	}

	public String getAnoConteudo() {
		return anoConteudo;
	}

	public void setAnoConteudo(String anoConteudo) {
		this.anoConteudo = anoConteudo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public List<PostagemModel> getPostagem() {
		return postagem;
	}

	public void setPostagem(List<PostagemModel> postagem) {
		this.postagem = postagem;
	}
	
}
