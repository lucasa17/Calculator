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
		double result = num1 + num2;
		saveOperation(num1, num2, "+", result);
	    return result;
	}
	
	public double subtraction(double num1, double num2) {
		double result = num1 - num2;
		saveOperation(num1, num2, "-", result);
	    return result;
	}
	
	public double division(double num1, double num2) {
		validateDivision(num1, num2);
		double result = num1 / num2;
		saveOperation(num1, num2, "/", result);
	    return result;
	}
	
	public double multiplication(double num1, double num2) {
		double result = num1 * num2;
		saveOperation(num1, num2, "*", result);
	    return result;
	}
	
	public double residual(double num1, double num2) {
		double result = num1 % num2;
		saveOperation(num1, num2, "Resto de ", " /", result);
		return result;
	}
	
	public double factorial(double num1) {
	    validatePositiveNumber(num1);
	    double result = calculateFactorial(num1); 
	    saveOperation(num1, "!", result);
	    return result;
	}
	private double calculateFactorial(double num) {
	    if (num == 0 || num == 1) {
	        return 1;
	    }
	    return num * calculateFactorial(num - 1);
	}
	
	public String decimalToBinary(double num1) {
		validatePositiveNumber(num1);
		int intNum1 = (int) Math.round(num1);

	    saveOperation(num1, "em Binário", decimalToBinaryRecursion(intNum1));
		return decimalToBinaryRecursion(intNum1);
	 }
	private String decimalToBinaryRecursion(int num1) {
		String binaryValue = "";
		if (num1 == 0 || num1 == 1) {
			binaryValue = "" + num1;
		} else {
			binaryValue = binaryValue + decimalToBinaryRecursion(num1 / 2) + num1 % 2;
		}
		return binaryValue;
	}
	
	public String decimalToHexadecimal(double num1) {
		validatePositiveNumber(num1);
		int intNum1 = (int) Math.round(num1);
		
		saveOperation(intNum1, "em Hexadecimal", decimalToHexRecursion(intNum1));
		return decimalToHexRecursion(intNum1);
	}

	private String decimalToHexRecursion(int num1) {
		if (num1 == 0)
			return "0";

		char[] hexChars = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F' };

		int remainder = num1 % 16;
		String hex = decimalToHexRecursion(num1 / 16);

		if (hex.equals("0"))
			return String.valueOf(hexChars[remainder]);
		else
			return hex + hexChars[remainder];
	}
	
	public double additionPercentage(double value, double percentage) {
		double result = value + (value * (percentage/100)) ;
		saveOperation(percentage, value, "+", "%", result);
		return result;
	}
	
	public double subtractionPercentage(double value, double percentage) {
		double result = value - (value * (percentage/100)) ;
		saveOperation(percentage, value, "-", "%", result);
		return result;
	}
	
	public double percentageOf(double value, double percentage) {
		double result = value * (percentage/100) ;
		saveOperation(percentage, value, "", "%", result);
		return result;
	}
	
	public void clearLastOperations() {
		lastOperations.clear();
	}
	
	private void saveOperation(double num1, double num2, String operation, double result) {
		String preListing = String.format("%.2f %s %.2f = %.2f", num1, operation, num2, result);
	    lastOperations.add(preListing);
	}
	private void saveOperation(double num1, String operation, double result) {
		String preListing = String.format("%.2f%s = %.2f", num1, operation, result);
	    lastOperations.add(preListing);
	}
	private void saveOperation(double num1, String operation, String result) {
		String preListing = String.format("%.2f %s = %s", num1, operation, result);
	    lastOperations.add(preListing);
	}
	private void saveOperation(double num1, double num2, String operation, String operation2, double result) {
		String preListing = String.format("%s%.2f%s %.2f = %.2f", operation , num1, operation2, num2, result);
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
	private void validatePositiveNumber(double num1) {
		if(num1 < 0) {
			throw new IllegalArgumentException("Valor deve ser maior que zero");
		}
	}
}
