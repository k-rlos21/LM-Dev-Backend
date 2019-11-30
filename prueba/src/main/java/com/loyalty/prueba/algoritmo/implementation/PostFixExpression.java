package com.loyalty.prueba.algoritmo.implementation;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import org.springframework.stereotype.Service;

import com.loyalty.prueba.algoritmo.model.IPostFixExpression;
import com.loyalty.prueba.algoritmo.pojo.AlgoritmoRequest;
import com.loyalty.prueba.algoritmo.pojo.Operador;

import lombok.extern.slf4j.Slf4j;

@Service("PostFixExpression")
@Slf4j
public class PostFixExpression implements IPostFixExpression{

	@Override
	public String postFixExpression(AlgoritmoRequest request) {
		
		String postFixExpression = null;
		
		Stack<String> outputStack = null;
		
		Stack<String> operatorStack = null;
		
		List<Operador> operadores = null;
		
		String cadena = null;

		try {
			
			operadores = operatorsList();
			
			cadena = request.getExp();
			
			for (int i=0;i<cadena.length();i++) {
				String element = Character.toString(cadena.charAt(i));
				
				for (int j=0;i<operadores.size();j++) {
					if(element!=operadores.get(j).getValue()) {
						outputStack.push(element);
					}else {
						operatorStack.push(element);
					}
				}
				
			}
			
		}catch(Exception e) {
			int linea = 0;
			String method = "PostFixExpression : postFixExpression";

			if (e.getStackTrace().length > 0) {
				linea = e.getStackTrace()[0].getLineNumber();
				method = e.getStackTrace()[0].getMethodName();
			}
			log.error("Microservicio evaluate-svc: error: {}  en linea: {} en metodo: {}", e, linea, method);
		}
		return postFixExpression;
	}
	
	private List<Operador> operatorsList(){
		
		List<Operador> operadores = new ArrayList<>();
		
		Operador operador1 = new Operador();
		operador1.setValue("+");
		operador1.setPrecedence(1);
		
		Operador operador2 = new Operador();
		operador2.setValue("-");
		operador2.setPrecedence(1);
		
		Operador operador3 = new Operador();
		operador3.setValue("*");
		operador3.setPrecedence(2);
		
		Operador operador4 = new Operador();
		operador4.setValue("/");
		operador4.setPrecedence(2);
		
		operadores.add(operador1);
		operadores.add(operador2);
		operadores.add(operador3);
		
		operadores.add(operador4);
		
		return operadores;
	}

}
