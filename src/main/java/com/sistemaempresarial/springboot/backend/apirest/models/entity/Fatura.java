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
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "faturas")
public class Fatura implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String descricao;

	private String observacao;

	//@Temporal(TemporalType.DATE)
	@Column(name = "create_at")
	private Date createAt;

	@JsonIgnoreProperties(value={"faturas", "hibernateLazyInitializer","handler"},allowSetters = true )
	@ManyToOne(fetch = FetchType.LAZY)
	private Cliente cliente;

	@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "fatura_id")
	private List<ItemFatura> itens;

	@PrePersist
	public void prePersist() {
		this.createAt = new Date();
	}

	public Fatura() {
		itens = new ArrayList<>();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public Date getCreateAt() {
		return createAt;
	}

	public void setCreateAt(Date createAt) {
		this.createAt = createAt;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public List<ItemFatura> getItens() {
		return itens;
	}

	public void setItens(List<ItemFatura> itens) {
		this.itens = itens;
	}
	
	public Double getTotal(){
		Double total = 0.00;
		for(ItemFatura item: itens) {
			total += item.getImporte();
		}
		return total;
	}

	private static final long serialVersionUID = 1L;

}
