package com.dezoti.elotechteste.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dezoti.elotechteste.domain.Pessoa;
import com.dezoti.elotechteste.repositories.PessoaRepository;
import com.dezoti.elotechteste.services.exceptions.ObjectNotFoundException;

@Service
public class PessoaService {

	@Autowired
	private PessoaRepository repo;
		
	public Pessoa find(Integer id) {
		Pessoa obj = repo.findOne(id);
		if (obj==null) {
			throw new ObjectNotFoundException("Objeto não encontrado! Id " + id + ", Tipo: " + Pessoa.class.getName() + ".");
		}
		return obj;
	}
	
	public List<Pessoa> list() {
		return repo.findAll();
	}
}
