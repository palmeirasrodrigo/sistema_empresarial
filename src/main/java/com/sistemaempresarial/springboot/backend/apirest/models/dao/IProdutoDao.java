package com.sistemaempresarial.springboot.backend.apirest.models.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.sistemaempresarial.springboot.backend.apirest.models.entity.Produto;

public interface IProdutoDao extends CrudRepository<Produto, Long>{

	@Query("select p from Produto p where p.nome like %?1%")
	public List<Produto> findByNome(String term);
	
	//public List<Produto> findByNameContainingIgnoreCase(String term);

	//public List<Produto> findByNameStartingWithIgnoreCase(String term);

}
