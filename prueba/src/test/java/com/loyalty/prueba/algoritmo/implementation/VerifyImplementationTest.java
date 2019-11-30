package com.loyalty.prueba.algoritmo.implementation;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.mockito.Mockito;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.loyalty.prueba.algoritmo.pojo.AlgoritmoRequest;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class VerifyImplementationTest extends Mockito{
	
	@Test
	public void VerifyExpressionImplementationSuccess() {
		
		VerifyExpressionImplementation implementation = new VerifyExpressionImplementation();
		
		Integer valid = implementation.verify(validRequestMock());
		
		assertTrue(valid==1);
		
	}
	
	@Test
	public void VerifyExpressionImplementationError() {
		
		VerifyExpressionImplementation implementation = new VerifyExpressionImplementation();
		
		Integer valid = implementation.verify(null);
		
		assertTrue(valid==0);
	}
	
	public AlgoritmoRequest validRequestMock() {
		
		AlgoritmoRequest request = null;
		
		try {
			
			request = new ObjectMapper().readValue("{\r\n" + 
					"  \"exp\": \"1+2*4\"\r\n" + 
					"}",new TypeReference<AlgoritmoRequest>() {});
			
		}catch(Exception e) {
			int linea = 0;
			String method = "VerifyExpressionImplementation : validRequestMock";

			if (e.getStackTrace().length > 0) {
				linea = e.getStackTrace()[0].getLineNumber();
				method = e.getStackTrace()[0].getMethodName();
			}
			log.error("Microservicio evaluate-svc: error: {}  en linea: {} en metodo: {}", e, linea, method);
		}
		
		return request;
	}
	
	public AlgoritmoRequest invalidRequestMock() {
		
		AlgoritmoRequest request = null;
		
		try {
			
			request = new ObjectMapper().readValue("{\r\n" + 
					"  \"exp\": \"-1+(2+4)\"\r\n" + 
					"}",new TypeReference<AlgoritmoRequest>() {});
			
		}catch(Exception e) {
			int linea = 0;
			String method = "VerifyExpressionImplementation : invalidRequestMock";

			if (e.getStackTrace().length > 0) {
				linea = e.getStackTrace()[0].getLineNumber();
				method = e.getStackTrace()[0].getMethodName();
			}
			log.error("Microservicio evaluate-svc: error: {}  en linea: {} en metodo: {}", e, linea, method);
		}
		
		return request;
	}

}
