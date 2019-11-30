package com.loyalty.prueba.algoritmo.implementation;

import org.springframework.stereotype.Service;

import com.loyalty.prueba.algoritmo.pojo.AlgoritmoRequest;

import lombok.extern.slf4j.Slf4j;

@Service("VerifyExpressionImplementation")
@Slf4j
public class VerifyExpressionImplementation extends VerifyExpressionAbstract{

	@Override
	public Integer verify(AlgoritmoRequest request) {
		
		Integer result = 0;
		boolean noNegativo = false;
		boolean noParentesis = false;
		
		try {
			
			noNegativo = notNegative(request);
			noParentesis = notParentesis(request);
			
			if(noNegativo&&noParentesis) {
				result = 1;
			}
			
		}catch(Exception e) {
			int linea = 0;
			String method = "VerifyExpressionImplementation : verify";

			if (e.getStackTrace().length > 0) {
				linea = e.getStackTrace()[0].getLineNumber();
				method = e.getStackTrace()[0].getMethodName();
			}
			log.error("Microservicio evaluate-svc: error: {}  en linea: {} en metodo: {}", e, linea, method);
			return 0;
		}
		
		return result;
	}

	@Override
	boolean notNegative(AlgoritmoRequest request) {
		
		String cadena = null;
		boolean result = false;
		
		try {
			cadena = request.getExp();
			
			if(!cadena.startsWith("-")) {
				result = true;
			}
			
		}catch(Exception e) {
			int linea = 0;
			String method = "VerifyExpressionImplementation : negative";

			if (e.getStackTrace().length > 0) {
				linea = e.getStackTrace()[0].getLineNumber();
				method = e.getStackTrace()[0].getMethodName();
			}
			log.error("Microservicio evaluate-svc: error: {}  en linea: {} en metodo: {}", e, linea, method);
			return false;
		}
		
		return result;
	}

	@Override
	boolean notParentesis(AlgoritmoRequest request) {
		
		String cadena = null;
		boolean result = false;
		
		try {
			
			cadena = request.getExp();
			
			if(!(cadena.contains("(")||cadena.contains(")"))) {
				result = true;
			}
			
		}catch(Exception e){
			int linea = 0;
			String method = "VerifyExpressionImplementation : parentesis";

			if (e.getStackTrace().length > 0) {
				linea = e.getStackTrace()[0].getLineNumber();
				method = e.getStackTrace()[0].getMethodName();
			}
			log.error("Microservicio evaluate-svc: error: {}  en linea: {} en metodo: {}", e, linea, method);
			return false;
		}
		return result;
	}

}
