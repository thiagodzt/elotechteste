package com.dezoti.elotechteste.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dezoti.elotechteste.domain.ContatoPessoa;
import com.dezoti.elotechteste.repositories.ContatoPessoaRepository;
import com.dezoti.elotechteste.services.exceptions.ObjectNotFoundException;

@Service
public class ContatoPessoaService {

	@Autowired
	private ContatoPessoaRepository repo;
		
	public ContatoPessoa find(Integer id) {
		ContatoPessoa obj = repo.findOne(id);
		if (obj==null) {
			throw new ObjectNotFoundException("Objeto não encontrado! Id " + id + ", Tipo: " + ContatoPessoa.class.getName() + ".");
		}
		return obj;
	}
	
	public List<ContatoPessoa> list() {
		return repo.findAll();
	}
	
	public ContatoPessoa insert(ContatoPessoa obj) {
		obj.setId(null);
		return repo.save(obj);
	}
	
	public ContatoPessoa update(ContatoPessoa obj) {
		find(obj.getId());
		return repo.save(obj);
	}
	
	public void delete(Integer id) {
		find(id);
		repo.delete(id);
	}
}