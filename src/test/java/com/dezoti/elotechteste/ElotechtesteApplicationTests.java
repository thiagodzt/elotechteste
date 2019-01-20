package com.dezoti.elotechteste;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;

import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.dezoti.elotechteste.domain.ContatoPessoa;
import com.dezoti.elotechteste.domain.Pessoa;
import com.dezoti.elotechteste.services.ContatoPessoaService;
import com.dezoti.elotechteste.services.PessoaService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ElotechtesteApplicationTests {
	
	@Autowired
	private PessoaService pessoaService;
	
	@Autowired
	private ContatoPessoaService contatoService;

	@Test
	public void testPessoa() throws Exception {
		/************************************* Montando Cenário ***************************************************/
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		
		Pessoa pessoa1 = new Pessoa(null, "Jose da Silva", new Long(95019374), format.parse("29/10/1987"));
		Pessoa pessoa2 = new Pessoa(null, "Maria de Souza", new Long(105982148), format.parse("05/01/1970"));
		
		ContatoPessoa contato1 = new ContatoPessoa(null, "Thiago Dezoti", pessoa1);
		ContatoPessoa contato2 = new ContatoPessoa(null, "João da Rocha", pessoa1);
		ContatoPessoa contato3 = new ContatoPessoa(null, "Gilberto Alves", pessoa1);
		ContatoPessoa contato4 = new ContatoPessoa(null, "Fernanda Souza", pessoa2);
		
		pessoa1.getContatos().addAll(Arrays.asList(contato1, contato2, contato3));
		pessoa2.getContatos().addAll(Arrays.asList(contato4));

		pessoaService.insert(pessoa1);
		pessoaService.insert(pessoa2);	
		contatoService.insert(contato1);
		contatoService.insert(contato2);
		contatoService.insert(contato3);
		contatoService.insert(contato4);
		
		/******************************************* Testes ***************************************************/
		
		pessoa1 = pessoaService.find(1);
		pessoa2 = pessoaService.find(2);
		
		assertThat(pessoa1.getId(), is(1));
		assertThat(pessoa1.getNome(), is("Jose da Silva"));
		assertThat(pessoa2.getId(), is(2));
		assertThat(pessoa2.getNome(), is("Maria de Souza"));
		
		pessoa2.setNome("Maria de Souza Silva");
		pessoaService.update(pessoa1);
		
		assertThat(pessoa1.getId(), is(1));
		assertThat(pessoa1.getNome(), is("Jose da Silva"));
		assertThat(pessoa2.getId(), is(2));
		assertThat(pessoa2.getNome(), is("Maria de Souza Silva"));

		try {
			pessoa1 = pessoaService.find(3);
			fail();
		} catch (Exception e) {
			assertThat(e.getMessage(), is("Objeto não encontrado! Id 3, Tipo: com.dezoti.elotechteste.domain.Pessoa"));
		}
	}	
}

