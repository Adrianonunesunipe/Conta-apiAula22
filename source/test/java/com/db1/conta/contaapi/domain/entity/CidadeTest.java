package com.db1.conta.contaapi.domain.entity;

import org.junit.Assert;
import org.junit.Test;

public class CidadeTest {
	
	@Test
	
	public void deveRetornarNomeObrigatorio(){
		String menssagem = null;
		try{
		Cidade cidade = new Cidade(null, Estado.AC);
		}catch (Exception e){
			menssagem = e.getMessage();
		}
		Assert.assertEquals("Estado é Obrigatório", menssagem);
	}
	
	@Test
	
	public void deveRetornar(){
		String menssagem = null;
		try{
		Cidade cidade = new Cidade(null, Estado.AC);
		}catch (Exception e){
			menssagem = e.getMessage();
		}
		Assert.assertEquals("Estado é Obrigatório", menssagem);

	}
}