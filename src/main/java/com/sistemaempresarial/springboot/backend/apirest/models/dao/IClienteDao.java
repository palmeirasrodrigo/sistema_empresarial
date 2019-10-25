package com.sistemaempresarial.springboot.backend.apirest.models.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.sistemaempresarial.springboot.backend.apirest.models.entity.Cliente;
import com.sistemaempresarial.springboot.backend.apirest.models.entity.Regiao;

public interface IClienteDao extends JpaRepository<Cliente, Long>{
	
	@Query("from Regiao")
	public List<Regiao> findAllRegioes();
}
