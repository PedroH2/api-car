package com.example.demo.operation;

public class Operation {
	public int primeiro;
	public int segundo;

	public int getPrimeiro() {
		return primeiro;
	}

	public void setPrimeiro(int primeiro) {
		this.primeiro = primeiro;
	}

	public int getSegundo() {
		return segundo;
	}

	public void setSegundo(int segundo) {
		this.segundo = segundo;
	}
	public int soma(int primeiro, int segundo) {
		int result = primeiro + segundo;
		System.err.println(result);
		return result;
	}	
	public double sub(double primeiro, double segundo) {
		double result = primeiro - segundo;
		System.err.println(result);
		return result;
	}	
	public double mult(double primeiro, double segundo) {
		double result = primeiro * segundo;
		System.err.println(result);
		return result;
	}	
	public double div(double primeiro, double segundo)throws Exception {
		if(primeiro <= 0 || segundo <= 0) 
			throw new Exception("Não é possivel dividir por zero");
		double result = primeiro / segundo;
		System.err.println(result);
		return result;
	}	
}