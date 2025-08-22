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
		System.out.println("1 - Soma\t2 - Subtração\t3 - Divisão\t4 - Multiplicação\t5 - Histórico\t6 - Limpar histórico\t7 - Sair");
		System.out.print("Escolha uma opção: ");
		int option = scanner.nextInt();
		double num1, num2;
		switch(option) {
			case 1:
				num1 = setValue(1);
				num2 = setValue(2);
				writeOperation(calculator.addition(num1, num2));
				return true;
			case 2:
				num1 = setValue(1);
				num2 = setValue(2);
				writeOperation(calculator.subtraction(num1, num2));
				return true;
			case 3:
				num1 = setValue(1);
				num2 = setValue(2);
				writeOperation(calculator.division(num1, num2));
				return true;
			case 4:
				num1 = setValue(1);
				num2 = setValue(2);
				writeOperation(calculator.multiplication(num1, num2));
				return true;
			case 5: 
				writeLastOperations();
				return true;
			case 6:
				calculator.clearLastOperations();
				System.out.println("\nO histórico foi limpo.\n");
				return true;
			case 7:
				System.out.println("\nSaindo...");
				return false;
			default:
				System.out.println("Opção inválida");
				return true;
		}
	}
	
	private double setValue(int amount) {
		System.out.print("Valor "+ amount +": ");
		double number = scanner.nextDouble();
		return number;
	}
	
	private void writeOperation(double operation) {
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
