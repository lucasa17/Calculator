package model;

import java.util.List;
import java.util.ArrayList;

public class Calc {
	
	List<String> lastOperations = new ArrayList<>();
			
	public List<String> getLastOperations() {
		return lastOperations;
	}
	
	public void addition(double num1, double num2) {
	    String preListing = String.format("%.2f + %.2f = %.2f", num1, num2, num1+num2);
	    lastOperations.add(preListing);
	}
	
	public void subtraction(double num1, double num2) {
	    String preListing = String.format("%.2f - %.2f = %.2f", num1, num2, num1-num2);
	    lastOperations.add(preListing);
	}
	
	public void division(double num1, double num2) {
		validateDivision(num2);
	    String preListing = String.format("%.2f / %.2f = %.2f", num1, num2, num1/num2);
	    lastOperations.add(preListing);
	}
	
	public void multiplication(double num1, double num2) {
	    String preListing = String.format("%.2f * %.2f = %.2f", num1, num2, num1*num2);
	    lastOperations.add(preListing);
	}
	
	private void validateDivision(double num2) {
		if(num2 == 0) {
			throw new IllegalArgumentException("O segundo valor da divisão não pode ser igual a zero");
		}
	}
}
