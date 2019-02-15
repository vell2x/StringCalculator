package testing;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class StringCalculatorTesting {

	@Test
	void addEmpty0() {
		String results = StringCalculator.add("");
		
		assertEquals("0", results);
	}
	
	@Test
	void addOneElement0() {
		String results = StringCalculator.add("15");
		
		assertEquals("15.0", results);
	}
	
	@Test
	void addTwoElements0() {
		String results = StringCalculator.add("177.0, 34");
		
		assertEquals("211.0", results);
	}
	
	@Test
	void addThreeElements3() {
		String results = StringCalculator.add("3.2,7,0");
		
		assertEquals("10.2", results);
	}
	
	@Test
	void addMultipleStrings0() {
		String results = StringCalculator.add("10,20,30,40");
		
		assertEquals("100.0", results);
	}
	
	@Test
	void addMultipleStrings1() {
		String results = StringCalculator.add("10,20,30,40,50,10.1,30.4");
		
		assertEquals("190.5", results);
	}
	
	@Test
	void addMultipleStrings2() {
		String results = StringCalculator.add("10,20,30,40,50,10.1,30.4,67.9,123.987,65,789,102.887");
		
		assertEquals("1339.274", results);
	}
	
	@Test
	void newlineAsSeparator0() {
		String results = StringCalculator.add("10,20\n30,40");
		
		assertEquals("100.0", results);
	}
	
	@Test
	void newlineAsSeparator1() {
		String results = StringCalculator.add("10,20\n,30,40");
		
		assertEquals("Invalid number expected", results);
	}
	
	@Test
	void customSeparators0() {
		String results = StringCalculator.add("//|\\n1|2|3");
		
		assertEquals("6.0", results);
	}
	
	@Test
	void customSeparators1() {
		String results = StringCalculator.add("//sep\\n2sep3");
		
		assertEquals("5.0", results);
	}
	
	@Test
	void customSeparators2() {
		String results = StringCalculator.add("//|\\n1|2,3");
		
		assertEquals("Invalid number expected", results);
	}
}
