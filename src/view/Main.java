package view;

import model.Calc;
import view.console.CalcConsoleWriter;

public class Main {

	public static void main(String[] args) {
		Calc calculator = new Calc();
		
		calculator.addition(2,3);
		calculator.subtraction(1,1);
		calculator.division(4,2);
		calculator.multiplication(2,5);
		
		CalcConsoleWriter calcConsoleWriter = new CalcConsoleWriter(calculator);
		calcConsoleWriter.writer();
	}
}
