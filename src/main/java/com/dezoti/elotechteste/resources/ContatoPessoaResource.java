 package com.dezoti.elotechteste.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.dezoti.elotechteste.domain.ContatoPessoa;
import com.dezoti.elotechteste.services.ContatoPessoaService;

@RestController
@RequestMapping(value="/contatos")
public class ContatoPessoaResource {
	
	@Autowired
	private ContatoPessoaService service;

	@RequestMapping(method=RequestMethod.GET)
	public List<ContatoPessoa> list() {
		return service.list();
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable Integer id) {		
		ContatoPessoa obj = service.find(id);		
		
		return ResponseEntity.ok().body(obj);
	}
	
}
