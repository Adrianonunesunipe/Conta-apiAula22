package com.db1.conta.contaapi.domain.entity;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

public class AgenciaTest {
	
	@Test
	
	public void deveRetornarNumeroDaAgenciaObrigatorio(){
		
		Cidade cidade = Mockito.mock(Cidade.class);
		String menssage = null;
		try{
			Agencia agencia = new Agencia (null,"1",cidade);
		}catch (Exception e){
			menssage = e.getMessage();
		}
		Assert.assertEquals("Numero é Obrigatório.", menssage);
		
	}

	@Test

	public void deveRetornarDigitoDaAgenciaObrigatorio(){
	
	Cidade cidade = Mockito.mock(Cidade.class);
	String menssage = null;
	try{
		Agencia agencia = new Agencia ("123456",null,cidade);
	}catch (Exception e){
		menssage = e.getMessage();
	}
	Assert.assertEquals("Digito é Obrigatório.", menssage);
}
	@Test

	public void deveRetornarCidadeObrigatorio(){
	
	Cidade cidade = Mockito.mock(Cidade.class);
	String menssage = null;
	try{
		Agencia agencia = new Agencia ("654321","10",null);
	}catch (Exception e){
		menssage = e.getMessage();
	}
	Assert.assertEquals("Cidade é Obrigatório.", menssage);
}
	
	@Test

	public void deveRetornarException(){
	
	Cidade cidade = Mockito.mock(Cidade.class);
	Agencia agencia = null;
	String menssage = null;
	try{
		agencia = new Agencia ("654321","10",cidade);
	}catch (Exception e){
		menssage = e.getMessage();
	}
	
	Assert.assertNull(menssage);
	Assert.assertEquals("654321", agencia.getNumero());
	Assert.assertEquals("10", agencia.getDigito());
	Assert.assertEquals(cidade, agencia.getCidade());
}
	
}




























