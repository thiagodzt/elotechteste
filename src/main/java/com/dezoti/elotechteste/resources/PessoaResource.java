 package com.dezoti.elotechteste.resources;

import java.util.ArrayList;
import java.util.GregorianCalendar;
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
				
		Pessoa pessoa1 = new Pessoa(1, "Jose da Silva", new Long(95019374), new GregorianCalendar(1987, 9, 29).getTime());
		Pessoa pessoa2 = new Pessoa(2, "Maria de Souza", new Long(105982148), new GregorianCalendar(1970, 0, 05).getTime());
		
		List<Pessoa> lista = new ArrayList<>();
		
		lista.add(pessoa1);
		lista.add(pessoa2);
		
		return lista;
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable Integer id) {		
		Pessoa obj = service.find(id);		
		
		return ResponseEntity.ok().body(obj);
	}
	
}
