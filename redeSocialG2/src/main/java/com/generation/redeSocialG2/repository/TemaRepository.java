package com.generation.redeSocialG2.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.generation.redeSocialG2.model.TemaModel;

@Repository
public interface TemaRepository extends JpaRepository<TemaModel, Long>{
	public List<TemaModel> findAllByMateriaContainingIgnoreCase(String materia);
	
	public List<TemaModel> findAllByAnoConteudoContainingIgnoreCase(String anoConteudo);
}
