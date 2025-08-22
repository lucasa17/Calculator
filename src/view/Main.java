package view;

import model.Calc;
import view.console.CalcConsoleWriter;

public class Main {

	public static void main(String[] args) {
		Calc calculator = new Calc();
		CalcConsoleWriter calcConsoleWriter = new CalcConsoleWriter(calculator);
		
		while(calcConsoleWriter.menu()){
		}
	}
}
