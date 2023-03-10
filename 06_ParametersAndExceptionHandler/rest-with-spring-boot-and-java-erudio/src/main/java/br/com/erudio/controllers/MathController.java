package br.com.erudio.controllers;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.erudio.converts.NumberConverter;
import br.com.erudio.exceptions.UnsupportedMathOperationExceptiom;
import br.com.erudio.math.SimpleMath;

@RestController
public class MathController {

	private final AtomicLong counter = new AtomicLong();

	private SimpleMath math = new SimpleMath();

	// Soma dos valores A + A
	@RequestMapping(value = "/sum/{numberOne}/{numberTwo}", method = RequestMethod.GET)
	public Double sum(@PathVariable(value = "numberOne") String numberOne,
			@PathVariable(value = "numberTwo") String numberTwo) throws Exception {

		if (!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo)) {
			throw new UnsupportedMathOperationExceptiom("Por favor colocar um número válido.");
		}
		return math.sum(NumberConverter.convertToDouble(numberOne), NumberConverter.convertToDouble(numberTwo));
	}

	// Subtração dos valores A - A
	@RequestMapping(value = "/sub/{numberOne}/{numberTwo}", method = RequestMethod.GET)
	public Double sub(@PathVariable(value = "numberOne") String numberOne,
			@PathVariable(value = "numberTwo") String numberTwo) throws Exception {

		if (!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo)) {
			throw new UnsupportedMathOperationExceptiom("Por favor colocar um número válido.");
		}
		return math.sub(NumberConverter.convertToDouble(numberOne), NumberConverter.convertToDouble(numberTwo));
	}

	// Multiplicação dos valores A * A
	@RequestMapping(value = "/mult/{numberOne}/{numberTwo}", method = RequestMethod.GET)
	public Double mult(@PathVariable(value = "numberOne") String numberOne,
			@PathVariable(value = "numberTwo") String numberTwo) throws Exception {

		if (!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo)) {
			throw new UnsupportedMathOperationExceptiom("Por favor colocar um número válido.");
		}
		return math.mult(NumberConverter.convertToDouble(numberOne), NumberConverter.convertToDouble(numberTwo));
	}

	// Divisão dos valores A / A
	@RequestMapping(value = "/div/{numberOne}/{numberTwo}", method = RequestMethod.GET)
	public Double div(@PathVariable(value = "numberOne") String numberOne,
			@PathVariable(value = "numberTwo") String numberTwo) throws Exception {

		if (!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo)) {
			throw new UnsupportedMathOperationExceptiom("Por favor colocar um número válido.");
		}
		return math.div(NumberConverter.convertToDouble(numberOne), NumberConverter.convertToDouble(numberTwo));
	}

	// Média dos valores de 5 números
	@RequestMapping(value = "/med/{numberOne}/{numberTwo}/{numberThree}"
			+ "/{numberFour}/{numberFive}", method = RequestMethod.GET)
	public Double med(@PathVariable(value = "numberOne") String numberOne,
			@PathVariable(value = "numberTwo") String numberTwo,
			@PathVariable(value = "numberThree") String numberThree,
			@PathVariable(value = "numberFour") String numberFour,
			@PathVariable(value = "numberFive") String numberFive) throws Exception {

		if (!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo)
				|| !NumberConverter.isNumeric(numberThree) || !NumberConverter.isNumeric(numberFour)
				|| !NumberConverter.isNumeric(numberFive)) {
			throw new UnsupportedMathOperationExceptiom("Por favor colocar um número válido.");
		}
		return math.med(NumberConverter.convertToDouble(numberOne), NumberConverter.convertToDouble(numberTwo),
				NumberConverter.convertToDouble(numberThree), NumberConverter.convertToDouble(numberFour),
				NumberConverter.convertToDouble(numberFive));
	}

	// Raiz quadrada de A
	@RequestMapping(value = "/quad/{numberOne}", method = RequestMethod.GET)
	public Double quad(@PathVariable(value = "numberOne") String numberOne) throws Exception {

		if (!NumberConverter.isNumeric(numberOne)) {
			throw new UnsupportedMathOperationExceptiom("Por favor colocar um número válido.");
		}
		return math.quad(NumberConverter.convertToDouble(numberOne));
	}
}
