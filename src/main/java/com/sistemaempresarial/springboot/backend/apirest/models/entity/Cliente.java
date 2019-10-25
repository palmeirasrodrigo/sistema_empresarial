package com.sistemaempresarial.springboot.backend.apirest.models.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
//import javax.persistence.Temporal;
//import javax.persistence.TemporalType;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "clientes")
public class Cliente implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotEmpty
	@Size(min = 4, max = 15)
	@Column(nullable = false)
	private String nome;
	
	@NotEmpty
	private String sobrenome;
	
	@NotEmpty(message = "você deixou sem preencher!")
	@Email
	@Column(nullable = false, unique = true)
	private String email;
	
	//@Temporal(TemporalType.DATE)
	@NotNull(message = "Nao pode deixar vazio!")
	@Column(name = "create_at")
	private Date createAt;
	
	private String foto;
	
	@NotNull(message = "A região não pode ser vazia")
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "regiao_id")
	@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
	private Regiao regiao;
	
	@JsonIgnoreProperties(value= {"cliente", "hibernateLazyInitializer","handler"}, allowSetters = true)
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "cliente", cascade = CascadeType.ALL)
	private List<Fatura> faturas;
		
	public Cliente() {
		this.faturas = new ArrayList<>();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getCreateAt() {
		return createAt;
	}

	public void setCreateAt(Date createAt) {
		this.createAt = createAt;
	}

	
	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}


	public Regiao getRegiao() {
		return regiao;
	}

	public void setRegiao(Regiao regiao) {
		this.regiao = regiao;
	}

	public List<Fatura> getFaturas() {
		return faturas;
	}

	public void setFaturas(List<Fatura> faturas) {
		this.faturas = faturas;
	}




	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	

}
