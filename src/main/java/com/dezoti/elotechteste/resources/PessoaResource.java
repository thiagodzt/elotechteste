 package com.dezoti.elotechteste.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.dezoti.elotechteste.domain.Pessoa;
import com.dezoti.elotechteste.services.PessoaService;

@RestController
@RequestMapping(value="/pessoas")
public class PessoaResource {
	
	@Autowired
	private PessoaService service;

	@RequestMapping(method=RequestMethod.GET)
	public List<Pessoa> list() {
		return service.list();
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable Integer id) {		
		Pessoa obj = service.find(id);		
		
		return ResponseEntity.ok().body(obj);
	}
	
}
