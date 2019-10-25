package com.sistemaempresarial.springboot.backend.apirest.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sistemaempresarial.springboot.backend.apirest.models.dao.IClienteDao;
import com.sistemaempresarial.springboot.backend.apirest.models.dao.IFaturaDao;
import com.sistemaempresarial.springboot.backend.apirest.models.dao.IProdutoDao;
import com.sistemaempresarial.springboot.backend.apirest.models.entity.Cliente;
import com.sistemaempresarial.springboot.backend.apirest.models.entity.Fatura;
import com.sistemaempresarial.springboot.backend.apirest.models.entity.Produto;
import com.sistemaempresarial.springboot.backend.apirest.models.entity.Regiao;

@Service
public class ClienteServiveImpl implements IClienteService{

	@Autowired
	private IClienteDao clienteDao;
	
	@Autowired
	private IFaturaDao faturaDao;
	
	@Autowired
	private IProdutoDao produtoDao;
	
	@Override
	@Transactional(readOnly = true)
	public List<Cliente> findAll() {

			return (List<Cliente>) clienteDao.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Page<Cliente> findAll(Pageable pageable) {
		return clienteDao.findAll(pageable);
	}

	@Override
	@Transactional(readOnly = true)
	public Cliente findById(Long id) {
		return clienteDao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public Cliente save(Cliente cliente) {
		return clienteDao.save(cliente);
	}

	@Override
	@Transactional
	public void delete(Long id) {
		clienteDao.deleteById(id);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Regiao> findAllRegioes() {
		return clienteDao.findAllRegioes();

	}

	@Override
	@Transactional(readOnly = true)
	public Fatura findFaturaById(Long id) {
		return faturaDao.findById(id).orElse(null) ;
	}

	@Override
	@Transactional
	public Fatura saveFatura(Fatura fatura) {
		return faturaDao.save(fatura);
	}

	@Override
	@Transactional
	public void deleteFatura(Long id) {
		faturaDao.deleteById(id);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Produto> findProdutoByNome(String term) {
		return produtoDao.findByNome(term);
	}

	
	
	
}
