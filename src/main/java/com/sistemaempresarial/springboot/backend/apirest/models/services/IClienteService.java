package com.sistemaempresarial.springboot.backend.apirest.models.services;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.sistemaempresarial.springboot.backend.apirest.models.entity.Cliente;
import com.sistemaempresarial.springboot.backend.apirest.models.entity.Fatura;
import com.sistemaempresarial.springboot.backend.apirest.models.entity.Produto;
import com.sistemaempresarial.springboot.backend.apirest.models.entity.Regiao;

public interface IClienteService {
	public List<Cliente> findAll();

	public Page<Cliente> findAll(Pageable pageable);
	
	public Cliente findById(Long id);
	
	public Cliente save(Cliente cliente);
	
	public void delete(Long id);
	
	public List<Regiao> findAllRegioes();

	public Fatura findFaturaById(Long id);
	
	public Fatura saveFatura(Fatura fatura);
	
	public void deleteFatura(Long id);
	
	public List<Produto> findProdutoByNome(String term);
	
}
