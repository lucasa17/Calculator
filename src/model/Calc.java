package model;

import java.util.List;
import java.util.ArrayList;

public class Calc {
	
	List<String> historico = new ArrayList<>();
			
	public List<String> getHistorico() {
		return historico;
	}
	
	public String addition(double num1, double num2) {
	    String preListing = String.format("%.2f + %.2f = %.2f", num1, num2, num1+num2);
		historico.add(preListing);
		
		return preListing;
	}
	
	public String subtraction(double num1, double num2) {
	    String preListing = String.format("%.2f - %.2f = %.2f", num1, num2, num1-num2);
		historico.add(preListing);
		
		return preListing;
	}
	
	public String division(double num1, double num2) {
		validateDivision(num2);
	    String preListing = String.format("%.2f / %.2f = %.2f", num1, num2, num1/num2);
		historico.add(preListing);
		
		return preListing;
	}
	
	public String multiplication(double num1, double num2) {
	    String preListing = String.format("%.2f * %.2f = %.2f", num1, num2, num1*num2);
		historico.add(preListing);
		
		return preListing;
	}
	
	private void validateDivision(double num2) {
		if(num2 == 0) {
			throw new IllegalArgumentException("O segundo valor da divisão não pode ser igual a zero");
		}
	}
}
