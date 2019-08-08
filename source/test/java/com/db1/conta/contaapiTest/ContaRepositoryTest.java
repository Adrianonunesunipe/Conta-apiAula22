package com.db1.conta.contaapiTest;

import org.junit.After;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.db1.conta.contaapi.Reposytory.AgenciaRepository;
import com.db1.conta.contaapi.Reposytory.CidadeRepository;
import com.db1.conta.contaapi.Reposytory.ClienteRepository;
import com.db1.conta.contaapi.Reposytory.ContaRepository;
import com.db1.conta.contaapi.domain.entity.Agencia;
import com.db1.conta.contaapi.domain.entity.Cidade;
import com.db1.conta.contaapi.domain.entity.Cliente;
import com.db1.conta.contaapi.domain.entity.Conta;
import com.db1.conta.contaapi.domain.entity.Estado;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ContaRepositoryTest {
	
		@Autowired
		private ContaRepository contaRepository;
	
		@Autowired
		private AgenciaRepository agenciaRepository;
	
		@Autowired
		private CidadeRepository cidadeRepository;
	
		@Autowired
		private ClienteRepository clienteRepository;
		
		@After
		public void afterTest() {
//		contaRepository.deleteAll();
//		agenciaRepository.deleteAll();
//		clienteRepository.deleteAll();
//		cidadeRepository.deleteAll();
	}
	
		@Test
		public void deveSalvarUmaConta() {
		Cidade cidade = cidadeRepository.save(new Cidade("Maringá", Estado.PR));
		Agencia agencia = agenciaRepository.save(new Agencia("123456", "1", cidade));
		Cliente cliente = clienteRepository.save(new Cliente("Cliente Nome", "99999999999"));
		
		Conta conta = new Conta ("1234567890", agencia, cliente);
		
		Conta contaSalva = contaRepository.save(conta);
		
		Assert.assertEquals(conta.getnumero(), contaSalva.getnumero());
		Assert.assertNotNull(contaSalva.getId());
	}
	
		@Test
		public void deveSalvarUmaContaEUmHistorico() {
		Cidade cidade = cidadeRepository.save(new Cidade("Maringá", Estado.PR));
		Agencia agencia = agenciaRepository.save(new Agencia("123456", "1", cidade));
		Cliente cliente = clienteRepository.save(new Cliente("Cliente Nome", "99999999999"));
		
		Conta conta = new Conta ("1234567890", agencia, cliente);
		conta.depositar(10.0);
		Conta contaSalva = contaRepository.save(conta);
		
		Assert.assertEquals(conta.getnumero(), contaSalva.getnumero());
		Assert.assertNotNull(contaSalva.getId());
		Assert.assertEquals(1,contaSalva.getHistorico().size());
	}
}
	
	
