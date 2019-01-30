package com.dezoti.elotechteste.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dezoti.elotechteste.domain.ContatoPessoa;
import com.dezoti.elotechteste.domain.Pessoa;
import com.dezoti.elotechteste.repositories.ContatoPessoaRepository;
import com.dezoti.elotechteste.repositories.PessoaRepository;
import com.dezoti.elotechteste.services.exceptions.ObjectNotFoundException;

@Service
public class PessoaService {

	@Autowired
	private PessoaRepository repo;
		
	@Autowired
	private ContatoPessoaRepository repoContato;
		
	public Pessoa find(Integer id) {
		Pessoa obj = repo.findOne(id);
		if (obj==null) {
			throw new ObjectNotFoundException("Objeto não encontrado! Id " + id + ", Tipo: " + Pessoa.class.getName());
		}
		return obj;
	}
	
	public List<Pessoa> findAll() {
		return repo.findAll();
	}
	
	@Transactional
	public Pessoa insert(Pessoa obj) {
		obj.setId(null);
		obj = repo.save(obj);
		List<ContatoPessoa> contatos = new ArrayList<>();
		for(ContatoPessoa c : obj.getContatos()) {
			c.setPessoa(obj);
			contatos.add(c);
		}
		repoContato.save(contatos);
		return obj;
	}
	
	public Pessoa update(Pessoa obj) {
		find(obj.getId());
		return repo.save(obj);
	}
	
	public void delete(Integer id) {
		find(id);
		repo.delete(id);
	}
}
