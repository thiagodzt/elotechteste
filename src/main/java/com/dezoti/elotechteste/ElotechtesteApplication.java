package com.dezoti.elotechteste;

import java.util.Arrays;
import java.util.GregorianCalendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.dezoti.elotechteste.domain.ContatoPessoa;
import com.dezoti.elotechteste.domain.Pessoa;
import com.dezoti.elotechteste.repositories.ContatoPessoaRepository;
import com.dezoti.elotechteste.repositories.PessoaRepository;

@SpringBootApplication
public class ElotechtesteApplication implements CommandLineRunner{

	@Autowired
	private PessoaRepository pessoaRepository;
	
	@Autowired
	private ContatoPessoaRepository contatoRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(ElotechtesteApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		//Instanciar os objetos e incluir no Banco para Teste
		Pessoa pessoa1 = new Pessoa(null, "Jose da Silva", new Long(95019374), new GregorianCalendar(1987, 9, 29).getTime());
		Pessoa pessoa2 = new Pessoa(null, "Maria de Souza", new Long(105982148), new GregorianCalendar(1970, 0, 05).getTime());
		
		ContatoPessoa contato1 = new ContatoPessoa(null, "Thiago", pessoa1);
		ContatoPessoa contato2 = new ContatoPessoa(null, "João", pessoa1);
		ContatoPessoa contato3 = new ContatoPessoa(null, "Gilberto", pessoa1);
		ContatoPessoa contato4 = new ContatoPessoa(null, "Fernanda", pessoa2);
		
		pessoa1.getContatos().addAll(Arrays.asList(contato1, contato2, contato3));
		pessoa2.getContatos().addAll(Arrays.asList(contato4));
		
		pessoaRepository.save(Arrays.asList(pessoa1,pessoa2));	
		contatoRepository.save(Arrays.asList(contato1, contato2, contato3, contato4));
	}

}

