package br.com.toffoli.controllers;

import java.util.concurrent.atomic.AtomicLong;

//import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import br.com.toffoli.converters.NumberConverter;
import br.com.toffoli.exceptions.UnsupportedMathOperationException;
import br.com.toffoli.math.SimpleMath;

@RestController
public class MathController {

	//private final AtomicLong counter = new AtomicLong();
	private SimpleMath math = new SimpleMath();
	
	@GetMapping("/sum/{numberOne}/{numberTwo}")
	public Double sum(@PathVariable(value = "numberOne") String numberOne,
			          @PathVariable(value = "numberTwo") String numberTwo
			          )throws Exception{
		if (!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo)) {
			throw new UnsupportedMathOperationException("Please set a numeric value!");
		}
	
		return math.sum(NumberConverter.convertToDouble(numberOne), NumberConverter.convertToDouble(numberTwo));
	}
	
	@GetMapping("/sub/{numberOne}/{numberTwo}")
	private Double sub(@PathVariable(value = "numberOne") String numberOne,
			           @PathVariable(value = "numberTwo") String numberTwo
			           )throws Exception{
		if (!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo)) {
			throw new UnsupportedMathOperationException("Please set a numeric value!");
		}
		
		return math.sub(NumberConverter.convertToDouble(numberOne), NumberConverter.convertToDouble(numberTwo));
	}

	@GetMapping("/mult/{numberOne}/{numberTwo}")
	private Double mult(@PathVariable(value = "numberOne") String numberOne,
			           @PathVariable(value = "numberTwo") String numberTwo
			           )throws Exception{
		if (!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo)) {
			throw new UnsupportedMathOperationException("Please set a numeric value!");
		}
		
		return math.mult(NumberConverter.convertToDouble(numberOne), NumberConverter.convertToDouble(numberTwo));
	}
	
	@GetMapping("/div/{numberOne}/{numberTwo}")
	private Double div(@PathVariable(value = "numberOne") String numberOne,
			           @PathVariable(value = "numberTwo") String numberTwo
			           )throws Exception{
		if (!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo)) {
			throw new UnsupportedMathOperationException("Please set a numeric value!");
		}
		if(numberTwo.equals("0")) {throw new UnsupportedMathOperationException("The divisor cannot be zero!");}
		return math.div(NumberConverter.convertToDouble(numberOne), NumberConverter.convertToDouble(numberTwo));
	}
	
	@GetMapping("/mean/{numberOne}/{numberTwo}")
	private Double mean(@PathVariable(value = "numberOne") String numberOne,
			           @PathVariable(value = "numberTwo") String numberTwo
			           )throws Exception{
		if (!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo)) {
			throw new UnsupportedMathOperationException("Please set a numeric value!");
		}
		
		return math.mean(NumberConverter.convertToDouble(numberOne), NumberConverter.convertToDouble(numberTwo));
	}
	
	@GetMapping("/sqrt/{number}")
	private Double sqrt(@PathVariable(value = "number") String number
			           )throws Exception{
		if (!NumberConverter.isNumeric(number)) {
			throw new UnsupportedMathOperationException("Please set a numeric value!");
		}
		Double doubleNumber = NumberConverter.convertToDouble(number);
		
		if(doubleNumber < 0) {throw new UnsupportedMathOperationException("Value cannot be negative");}
		
		return math.sqrt(doubleNumber);
	}
	
}
