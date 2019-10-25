package com.sistemaempresarial.springboot.backend.apirest.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.sistemaempresarial.springboot.backend.apirest.models.entity.Fatura;
import com.sistemaempresarial.springboot.backend.apirest.models.entity.Produto;
import com.sistemaempresarial.springboot.backend.apirest.models.services.IClienteService;

@CrossOrigin(origins = {"http://localhost:4200", "*"})
@RestController
@RequestMapping("/api")
public class FaturaRestController {
	
	@Autowired
	private IClienteService clienteService;
	
	@Secured({"ROLE_ADMIN","ROLE_USER"})
	@GetMapping("/faturas/{id}")
	@ResponseStatus(HttpStatus.OK)
	public Fatura show(@PathVariable Long id) {
		return clienteService.findFaturaById(id);
	}
	
	@Secured({"ROLE_ADMIN"})
	@DeleteMapping("/faturas/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		clienteService.deleteFatura(id);
	}
	
	@Secured({"ROLE_ADMIN"})
	@GetMapping("/faturas/filtrar-produtos/{term}")
	@ResponseStatus(HttpStatus.OK)
	public List<Produto> filtrarProdutos(@PathVariable String term){
		return clienteService.findProdutoByNome(term);
	}
	
	@Secured({"ROLE_ADMIN"})
	@PostMapping("/faturas")
	@ResponseStatus(HttpStatus.CREATED)
	public Fatura criar(@RequestBody Fatura fatura) {
		return clienteService.saveFatura(fatura);
	}
}
