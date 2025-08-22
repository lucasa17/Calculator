package model;

import java.util.List;
import java.util.ArrayList;

public class Calc {
	
	private List<String> lastOperations = new ArrayList<>();
			
	public List<String> getLastOperations() {
		List<String> copyLastOperations = new ArrayList<>();
		
		for(String operation : lastOperations) {
			copyLastOperations.add(operation);
		}
		
		return copyLastOperations;
	}
	
	public double addition(double num1, double num2) {
		double result = num1+num2;
		saveOperation(num1, num2, "+", result);
	    return result;
	}
	
	public double subtraction(double num1, double num2) {
		double result = num1-num2;
		saveOperation(num1, num2, "-", result);
	    return result;
	}
	
	public double division(double num1, double num2) {
		validateDivision(num1, num2);
		double result = num1/num2;
		saveOperation(num1, num2, "/", result);
	    return result;
	}
	
	public double multiplication(double num1, double num2) {
		double result = num1*num2;
		saveOperation(num1, num2, "*", result);
	    return result;
	}
	
	public void clearLastOperations() {
		lastOperations.clear();
	}
	
	public void saveOperation(double num1, double num2, String operation, double result) {
		String preListing = String.format("%.2f %s %.2f = %.2f", num1, operation, num2, result);
	    lastOperations.add(preListing);
	}
	
	private void validateDivision(double num1, double num2) {
		if(num1 <= 0) {
			throw new IllegalArgumentException("Na divisão o numerador deve ser maior ou igual a zero");
		}
		if(num2 <= 0) {
			throw new IllegalArgumentException("Na divisão o denominador deve ser maior ou igual a zero");
		}
	}
}
