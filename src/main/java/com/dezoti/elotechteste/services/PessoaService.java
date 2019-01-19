package com.dezoti.elotechteste.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dezoti.elotechteste.domain.Pessoa;
import com.dezoti.elotechteste.repositories.PessoaRepository;

@Service
public class PessoaService {

	@Autowired
	private PessoaRepository repo;
		
	public Pessoa find(Integer id) {
		Pessoa obj = repo.findOne(id);
		return obj;
	}
}
