package com.sistemaempresarial.springboot.backend.apirest.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.sistemaempresarial.springboot.backend.apirest.models.entity.Fatura;

public interface IFaturaDao extends CrudRepository<Fatura, Long>{

}
