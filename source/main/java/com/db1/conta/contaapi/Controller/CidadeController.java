package com.db1.conta.contaapi.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.db1.conta.contaapi.domain.dto.CidadeResponseDTO;
import com.db1.conta.contaapi.service.CidadeService;

@RestController
@RequestMapping("/api/cidades")
public class CidadeController {
	
	@Autowired
	private CidadeService cidadeService;
	
	@GetMapping("/todas-cidades")
	public List<CidadeResponseDTO> todasCidades(){
		return cidadeService.findAll();
	}
	
	@GetMapping
	public CidadeResponseDTO cidadePorNome(@RequestParam("nome")String nome){
		return cidadeService.findByNameJava8(nome);
	}

	
	@GetMapping("Id")
	public CidadeResponseDTO cidadePorId(@PathVariable("Id")Long id){
		return cidadeService.cidadePorId(id);
	}
	
	
}























