package com.db1.conta.contaapi.Reposytory;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;

import com.db1.conta.contaapi.domain.entity.Agencia;
import com.db1.conta.contaapi.domain.entity.Cidade;
import com.db1.conta.contaapi.domain.entity.Estado;

public interface AgenciaRepository extends JpaRepository<Agencia, Long>{
	
Cidade findByNome(String nome);
	
	List<Agencia> findByCidadeEstado(Estado estado);


}
