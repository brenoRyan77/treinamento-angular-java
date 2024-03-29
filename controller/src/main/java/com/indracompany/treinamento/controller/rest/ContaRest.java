package com.indracompany.treinamento.controller.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.indracompany.treinamento.exception.AplicacaoException;
import com.indracompany.treinamento.model.dto.DepositoDTO;
import com.indracompany.treinamento.model.dto.SaqueDTO;
import com.indracompany.treinamento.model.entity.Conta;
import com.indracompany.treinamento.model.service.ContaService;

@RestController
@RequestMapping("rest/contas")
public class ContaRest extends GenericCrudRest<Conta, Long, ContaService>{
	
	
	@Autowired
	private ContaService contaService;
	
	@RequestMapping(value = "/consultar-saldo/{agencia}/{conta}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResponseEntity<Double> consultaSaldo(final @PathVariable String agencia,
			  @PathVariable String conta) throws AplicacaoException {
		  
		Double saldo = contaService.consultarSaldo(agencia, conta);
		
		return new ResponseEntity<>(saldo,HttpStatus.OK);
	}
	@PostMapping("/deposito")
	public ResponseEntity<Void> depositar(@RequestBody DepositoDTO dto) {
		contaService.depositar(dto);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@PostMapping("/saque")
	public ResponseEntity<Void> saque(@RequestBody SaqueDTO saque) {
		contaService.sacar(saque);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	
	
}
