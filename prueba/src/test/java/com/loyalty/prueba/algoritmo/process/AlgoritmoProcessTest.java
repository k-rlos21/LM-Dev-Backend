package com.loyalty.prueba.algoritmo.process;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.loyalty.prueba.algoritmo.model.IVerifyExpression;
import com.loyalty.prueba.algoritmo.pojo.AlgoritmoRequest;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class AlgoritmoProcessTest extends Mockito{
	
	@Test
	public void algoritmoProcessSuccess() {
		
		IVerifyExpression<AlgoritmoRequest,Integer> verifyExpression = mock(IVerifyExpression.class);
		
		AlgoritmoProcess algoritmoProcess = new AlgoritmoProcess(verifyExpression);
		when(verifyExpression.verify(any())).thenReturn(1);
		
		ResponseEntity<?> response = algoritmoProcess.evaluate(validRequestMock());
		
		assertTrue(response.getStatusCode()==HttpStatus.OK &&(response.getBody())==null );
	}
	
	/*@Test
	public void algoritmoProcessError() {
		
		IVerifyExpression<AlgoritmoRequest,Integer> verifyExpression = mock(IVerifyExpression.class);
		
		AlgoritmoProcess algoritmoProcess = new AlgoritmoProcess(verifyExpression);
		when(verifyExpression.verify(any())).thenReturn(1);
		
		ResponseEntity<?> response = algoritmoProcess.evaluate(null);
		
		assertTrue(response.getStatusCode()==HttpStatus.INTERNAL_SERVER_ERROR &&(response.getBody())!=null );
		
	}*/
	
	
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

}
