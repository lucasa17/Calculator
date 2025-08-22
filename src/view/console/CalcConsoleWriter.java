package view.console;

import model.Calc;

public class CalcConsoleWriter {
	private Calc calculator;
	
	public CalcConsoleWriter(Calc calculator) {
		if(calculator == null) {
			throw new IllegalArgumentException("É necessário uma instância válida de Calc");
		}
		this.calculator = calculator;
	}
	
	public void writer() {
		for (String calculations : calculator.getLastOperations()) {
            System.out.println(calculations);
        }	
	}
}
