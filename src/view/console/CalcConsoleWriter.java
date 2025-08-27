package view.console;

import java.util.Scanner;

import model.Calc;

public class CalcConsoleWriter {
	private Calc calculator;
	
	static Scanner scanner = new Scanner(System.in);
	
	public CalcConsoleWriter(Calc calculator) {
		if(calculator == null) {
			throw new IllegalArgumentException("É necessário uma instância válida de Calc");
		}
		this.calculator = calculator;
	}
	
	public boolean menu() {
		System.out.println("Menu:");
		System.out.println("1 - Soma\n2 - Subtração\n3 - Divisão\n4 - Multiplicação\n"
				+ "5 - Resto da divisão\n6 - Fatorial\n"
				+ "7 - Decimal para Binário\n"
				+ "8 - Decimal para Hexadecimal\n9 - Soma Percentual\n"
				+ "10 - Subtrai Percentual\n11 - Porcentagem\n"
				+ "12 - Histórico\n13 - Limpar histórico\n0 - Sair\n");
		System.out.print("Escolha uma opção: ");
		int option = scanner.nextInt();
		double num1, num2;
		switch(option) {
			case 1:
				num1 = setValue(1);
				num2 = setValue(2);
				writeOperation(calculator.addition(num1, num2));
				break;
			case 2:
				num1 = setValue(1);
				num2 = setValue(2);
				writeOperation(calculator.subtraction(num1, num2));
				break;
			case 3:
				num1 = setValue(1);
				num2 = setValue(2);
				writeOperation(calculator.division(num1, num2));
				break;
			case 4:
				num1 = setValue(1);
				num2 = setValue(2);
				writeOperation(calculator.multiplication(num1, num2));
				break;
			case 5:
				num1 = setValue(1);
				num2 = setValue(2);
				writeOperation(calculator.residual(num1, num2));
				break;
			case 6:
				num1 = setValue(1);
				writeOperation(calculator.factorial(num1));
				break;
			case 7:
				num1 = setValue(1);
				writeOperation(calculator.decimalToBinary(num1));
				break;
			case 8:
				num1 = setValue(1);
				writeOperation(calculator.decimalToHexadecimal(num1));
				break;
			case 9:
				num1 = setValuePercentage(0);
				num2 = setValuePercentage(1);
				writeOperation(calculator.additionPercentage(num1, num2));
				break;
			case 10:
				num1 = setValuePercentage(0);
				num2 = setValuePercentage(1);
				writeOperation(calculator.subtractionPercentage(num1, num2));
				break;
			case 11:
				num1 = setValuePercentage(0);
				num2 = setValuePercentage(1);
				writeOperation(calculator.percentageOf(num1, num2));
				break;
			case 12: 
				writeLastOperations();			
				break;
			case 13:
				calculator.clearLastOperations();
				System.out.println("\nO histórico foi limpo.\n");
				break;
			case 0:
				System.out.println("\nSaindo...");
				return false;
			default:
				System.out.println("Opção inválida");
				break;
		}
		return true;

	}
	
	private double setValue(int amount) {
		System.out.print("Valor "+ amount +": ");
		double value = scanner.nextDouble();
		return value;
	}
	private double setValuePercentage(int amount) {
		double value;
		if(amount == 1) {
			System.out.print("Porcentagem: ");
			value = scanner.nextDouble();
		}
		else {
			System.out.print("Valor: ");
			value = scanner.nextDouble();
		}
		return value;
	}
	
	private void writeOperation(double operation) {
		System.out.println("Resultado: "+operation);
		System.out.println();
	}
	private void writeOperation(String operation) {
		System.out.println("Resultado: "+operation);
		System.out.println();
	}
	
	private void writeLastOperations() {
		System.out.println("\nHistórico de operações: ");
		for (String calculations : calculator.getLastOperations()) {
            System.out.println(calculations);
        }	
		System.out.println();
	}
}
