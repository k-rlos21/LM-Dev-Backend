package com.loyalty.prueba.algoritmo.implementation;

import com.loyalty.prueba.algoritmo.model.IVerifyExpression;
import com.loyalty.prueba.algoritmo.pojo.AlgoritmoRequest;

public abstract class VerifyExpressionAbstract implements IVerifyExpression<AlgoritmoRequest,Integer>{
	
	abstract boolean notNegative(AlgoritmoRequest request);
	
	abstract boolean notParentesis(AlgoritmoRequest request);
	
}
