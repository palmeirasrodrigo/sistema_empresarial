package com.sistemaempresarial.springboot.backend.apirest.controllers;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.dao.DataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.sistemaempresarial.springboot.backend.apirest.models.entity.Cliente;
import com.sistemaempresarial.springboot.backend.apirest.models.entity.Regiao;
import com.sistemaempresarial.springboot.backend.apirest.models.services.IClienteService;
import com.sistemaempresarial.springboot.backend.apirest.models.services.IUploadFileService;

@CrossOrigin(origins = { "http://localhost:4200", "*"})
@RestController
@RequestMapping("/api")
public class ClienteRestController {

	@Autowired
	private IClienteService clienteService;
	
	@Autowired
	private IUploadFileService uploadService;
	

	@GetMapping("/clientes")
	public List<Cliente> index() {
		return clienteService.findAll();
	}
	
	@GetMapping("/clientes/page/{page}")
	public Page<Cliente> index(@PathVariable Integer page) {
		Pageable pageable = PageRequest.of(page, 4);
		return clienteService.findAll(pageable);
	}

	@Secured({"ROLE_ADMIN","ROLE_USER"})
	@GetMapping("/clientes/{id}")
	public ResponseEntity<?> show(@PathVariable Long id) {
		Cliente cliente = null;
		Map<String, Object> response = new HashMap<>();

		try {
			cliente = clienteService.findById(id);
		} catch (DataAccessException e) {
			response.put("mensagem", "Erro ao realizar consulta no banco de dados");
			response.put("erro", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		if (cliente == null) {
			response.put("mensagem", "O cliente ID:".concat(id.toString().concat(" não existe na base de dados!")));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(cliente, HttpStatus.OK);
	}
	
	@Secured("ROLE_ADMIN")
	@PostMapping("/clientes")
	public ResponseEntity<?> create(@Valid @RequestBody Cliente cliente, BindingResult result) {
		Cliente clienteNew = null;
		Map<String, Object> response = new HashMap<>();

		if (result.hasErrors()) {

			List<String> errors = result.getFieldErrors().stream()
					.map(err -> "O campo '" + err.getField() + "' " + err.getDefaultMessage())
					.collect(Collectors.toList());

			response.put("errors", errors);
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
		}

		try {
			clienteNew = clienteService.save(cliente);
		} catch (DataAccessException e) {
			response.put("mensagem", "Erro ao realizar o insert no banco de dados");
			response.put("erro", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		response.put("mensagem", "O cliente foi criado com exito");
		response.put("cliente", clienteNew);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
	}

	@Secured("ROLE_ADMIN")
	@PutMapping("/clientes/{id}")
	public ResponseEntity<?> update(@Valid @RequestBody Cliente cliente, BindingResult result, @PathVariable Long id) {
		Cliente clienteAtual = clienteService.findById(id);
		Cliente clienteAtualizado = null;

		Map<String, Object> response = new HashMap<>();
		
		if (result.hasErrors()) {

			List<String> errors = result.getFieldErrors().stream()
					.map(err -> "O campo '" + err.getField() + "' " + err.getDefaultMessage())
					.collect(Collectors.toList());

			response.put("errors", errors);
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
		}

		if (clienteAtual == null) {
			response.put("mensagem", "Erro: não pode editar o cliente ID:"
					.concat(id.toString().concat(" não existe na base de dados!")));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}

		try {
			clienteAtual.setNome(cliente.getNome());
			clienteAtual.setSobrenome(cliente.getSobrenome());
			clienteAtual.setEmail(cliente.getEmail());
			clienteAtual.setCreateAt(cliente.getCreateAt());
			clienteAtual.setRegiao(cliente.getRegiao());
			
			clienteAtualizado = clienteService.save(clienteAtual);

		} catch (DataAccessException e) {
			response.put("mensagem", "Erro ao atualizar o cliente no banco de dados");
			response.put("erro", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		response.put("mensagem", "O cliente foi atualizado com exito");
		response.put("cliente", clienteAtualizado);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
	}

	@Secured("ROLE_ADMIN")
	@DeleteMapping("/clientes/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id) {
		Map<String, Object> response = new HashMap<>();
		try {
			Cliente cliente = clienteService.findById(id);

			String nomeFotoAnterior = cliente.getFoto();
			
			uploadService.eliminar(nomeFotoAnterior);

			clienteService.delete(id);
		} catch (DataAccessException e) {
			response.put("mensagem", "Erro ao deletar o cliente no banco de dados");
			response.put("erro", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		response.put("mensagem", "O cliente foi deletado com exito");
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);

	}
	
	@Secured({"ROLE_ADMIN","ROLE_USER"})
	@PostMapping("/clientes/upload")
	public ResponseEntity<?>update(@RequestParam("arquivo") MultipartFile arquivo, @RequestParam("id") Long id	){
		Map<String, Object> response = new HashMap<>();

		Cliente cliente = clienteService.findById(id);
		
		if(!arquivo.isEmpty()) {
			
			String nomeArquivo = null;

			try {
				nomeArquivo = uploadService.guardar(arquivo);
			} catch (IOException e) {
				response.put("mensagem", "Erro ao subir a imagem ");
				response.put("erro", e.getMessage().concat(": ").concat(e.getCause().getMessage()));
				return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);

			}
			
			String nomeFotoAnterior = cliente.getFoto();
			uploadService.eliminar(nomeFotoAnterior);
			
			
			cliente.setFoto(nomeArquivo);
			
			clienteService.save(cliente);
			
			response.put("cliente", cliente);
			response.put("mensagem", "A imagem foi carregada com sucesso: " + nomeArquivo);
		}
		
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);

	}
	
	@GetMapping("/uploads/img/{nomeFoto:.+}")
	public ResponseEntity<Resource> verFoto(@PathVariable String nomeFoto){

		Resource recurso = null;
		
		try {
			recurso = uploadService.carregar(nomeFoto);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		HttpHeaders cabecera = new HttpHeaders();
		cabecera.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + recurso.getFilename() + "\"");
		
		return new ResponseEntity<Resource>(recurso, cabecera, HttpStatus.OK);
	}
	
	@Secured("ROLE_ADMIN")
	@GetMapping("/clientes/regioes")
	public List<Regiao> listarRegioes() {
		return clienteService.findAllRegioes();
	}
}
