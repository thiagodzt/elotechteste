package com.dezoti.elotechteste.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Past;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class Pessoa implements Serializable {	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@NotEmpty(message="Campo Obrigatório")
	@Length(min=5, max=80, message="Tamanho deve ser entre 5 e 80 caracteres")
	private String nome;
	
	@Column(unique=true)
	private Long rg;
	
	@Past
	@JsonFormat(pattern="dd/MM/yyyy")
	@Column(name="data_nascimento")
	private Date dataNascimento;
	
	@OneToMany(mappedBy="pessoa", cascade=CascadeType.ALL)
	private List<ContatoPessoa> contatos = new ArrayList<>();
	
	public Pessoa() {
	}

	public Pessoa(Integer id, String nome, Long rg, Date dataNascimento) {
		super();
		this.id = id;
		this.nome = nome;
		this.rg = rg;
		this.dataNascimento = dataNascimento;
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Long getRg() {
		return rg;
	}

	public void setRg(Long rg) {
		this.rg = rg;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public List<ContatoPessoa> getContatos() {
		return contatos;
	}

	public void setContatos(List<ContatoPessoa> contatos) {
		this.contatos = contatos;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pessoa other = (Pessoa) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}		
}
