package com.dezoti.elotechteste;

import java.text.SimpleDateFormat;
import java.util.Arrays;

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

		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		
		Pessoa pessoa1 = new Pessoa(null, "Jose da Silva", new Long(95019374), format.parse("29/10/1987"));
		Pessoa pessoa2 = new Pessoa(null, "Maria de Souza", new Long(105982148), format.parse("05/01/1970"));
		
		ContatoPessoa contato1 = new ContatoPessoa(null, "Thiago Dezoti", pessoa1);
		ContatoPessoa contato2 = new ContatoPessoa(null, "João da Rocha", pessoa1);
		ContatoPessoa contato3 = new ContatoPessoa(null, "Gilberto Alves", pessoa1);
		ContatoPessoa contato4 = new ContatoPessoa(null, "Fernanda Souza", pessoa2);
		
		pessoa1.getContatos().addAll(Arrays.asList(contato1, contato2, contato3));
		pessoa2.getContatos().addAll(Arrays.asList(contato4));
		
		pessoaRepository.save(Arrays.asList(pessoa1,pessoa2));	
		contatoRepository.save(Arrays.asList(contato1, contato2, contato3, contato4));
	}

}

