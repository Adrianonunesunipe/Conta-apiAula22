
	
package com.db1.conta.contaapi.domain.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.springframework.util.Assert;


@Entity
@Table(name = "agencia")
	public class Agencia {
		
		
		private Long id;
		
		private String numero;
		
		private String digito;
		
		private Cidade cidade;
		
		public Agencia (String numero , String digito, Cidade cidade){
			Assert.hasText(numero, "Numero é Obrigatório");
			Assert.hasText(digito, "Digito é Obrigatório");
			Assert.notNull(cidade ,"Cidade é Obrigatório" );
			this.numero = numero;
			this.digito = digito;
			this.cidade = cidade;
		
		}	
		
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		public Long getId(){
			return id;

		}
		@Column(name = "numero", length = 5, nullable = false, unique = true)
		public String getNumero(){
			return numero;
	}
		@Column(name = "digito", length = 1, nullable = false)
		public String getDigito(){
			return digito;
			
	}
		@ManyToOne
		@JoinColumn(name = "cidade_Id", nullable = false)
		public Cidade getCidade(){
			return cidade;
		}
		
}
		
