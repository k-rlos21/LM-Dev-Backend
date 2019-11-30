package com.loyalty.prueba.algoritmo.process;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.loyalty.prueba.algoritmo.model.IVerifyExpression;
import com.loyalty.prueba.algoritmo.pojo.AlgoritmoErrorResponse;
import com.loyalty.prueba.algoritmo.pojo.AlgoritmoRequest;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class AlgoritmoProcess {
	
	private IVerifyExpression<AlgoritmoRequest,Integer> verifyExpression;
	
	@Autowired
	public AlgoritmoProcess(@Qualifier("VerifyExpressionImplementation")IVerifyExpression<AlgoritmoRequest,Integer> verifyExpression) {
		this.verifyExpression = verifyExpression;
	}
	
	public ResponseEntity<?> evaluate(AlgoritmoRequest request){
		
		Integer validExpression = 0;
		
		try {
			
			validExpression = verifyExpression.verify(request);
			
			if(validExpression!=1) {
				
				AlgoritmoErrorResponse errorResponse = new AlgoritmoErrorResponse();
				errorResponse.setMessage("The Expression "+request.getExp()+ " is invalid");
				
				return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
			}
			
		}catch(Exception e) {
			int linea = 0;
			String method = "AlgoritmoProcess : evaluate";

			if (e.getStackTrace().length > 0) {
				linea = e.getStackTrace()[0].getLineNumber();
				method = e.getStackTrace()[0].getMethodName();
			}
			log.error("Microservicio evaluate-svc: error: {}  en linea: {} en metodo: {}", e, linea, method);
			
			AlgoritmoErrorResponse errorResponse = new AlgoritmoErrorResponse();
			errorResponse.setMessage("Some error occurred while processing the expression");
			
			return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return new ResponseEntity<>(null, HttpStatus.OK);
	}
}
