package com.loyalty.prueba.algoritmo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.loyalty.prueba.algoritmo.pojo.AlgoritmoRequest;
import com.loyalty.prueba.algoritmo.process.AlgoritmoProcess;

@RestController
@RequestMapping("/prueba")
public class AlgoritmoController {
	
	private AlgoritmoProcess algoritmoProcess;
	
	@Autowired
	public AlgoritmoController (AlgoritmoProcess algoritmoProcess) {
		this.algoritmoProcess = algoritmoProcess;
	}
	
	@PostMapping("/evaluate")
	public ResponseEntity<?> processOperation(@RequestBody AlgoritmoRequest request){
		
		return algoritmoProcess.evaluate(request);
	}

}
