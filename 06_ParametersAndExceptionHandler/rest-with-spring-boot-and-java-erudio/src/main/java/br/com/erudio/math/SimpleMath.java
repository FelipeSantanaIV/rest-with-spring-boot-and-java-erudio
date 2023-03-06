package br.com.erudio.math;

public class SimpleMath {

	// Soma dos valores A + A
	public Double sum(Double numberOne, Double numberTwo) {
		return numberOne + numberTwo;
	}

	// Subtração dos valores A - A
	public Double sub(Double numberOne, Double numberTwo) {
		return numberOne - numberTwo;
	}

	public Double mult(Double numberOne, Double numberTwo) {
		return numberOne * numberTwo;
	}

	// Divisão dos valores A / A
	public Double div(Double numberOne, Double numberTwo) {
		return numberOne / numberTwo;
	}

	// Média dos valores de 5 números
	public Double med(Double numberOne, Double numberTwo, Double numberThree, Double numberFour, Double numberFive) {
		return (numberOne + numberTwo + numberThree + numberFour + numberFive) / 5;
	}

	// Raiz quadrada de A
	public Double quad(Double numberOne){
		return Math.sqrt(numberOne) ;
	}
}
