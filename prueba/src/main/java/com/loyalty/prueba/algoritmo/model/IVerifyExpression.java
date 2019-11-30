package com.loyalty.prueba.algoritmo.model;

@FunctionalInterface
public interface IVerifyExpression<I,O> {
	
	public O verify(I request);

}
