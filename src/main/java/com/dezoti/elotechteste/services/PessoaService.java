package com.dezoti.elotechteste.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dezoti.elotechteste.domain.Pessoa;
import com.dezoti.elotechteste.repositories.PessoaRepository;

@Service
public class PessoaService {

	@Autowired
	private PessoaRepository repo;
		
	public Pessoa find(Integer id) {
		return (Pessoa)repo.findOne(id);
	}
	
	public List<Pessoa> list() {
		return repo.findAll();
	}
}
