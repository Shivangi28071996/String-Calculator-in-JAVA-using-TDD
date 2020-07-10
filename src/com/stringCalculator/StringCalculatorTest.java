package com.stringCalculator;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class StringCalculatorTest {

	@Test
	public void noNumberAddTest() {
		StringCalculator sc = new StringCalculator();
		int result = sc.Add("");
		assertEquals(0,result);
	}
	
	@Test
	public void oneNumberAddTest() {
		StringCalculator sc = new StringCalculator();
		int result = sc.Add("1");
		assertEquals(1,result);
	}
	
	@Test
	public void twoNumberAddTest() {
		StringCalculator sc = new StringCalculator();
		int result = sc.Add("1,2");
		assertEquals(3,result);
	}
	
	@Test
	public void unknownNumbersAddTest() {
		StringCalculator sc = new StringCalculator();
		int result = sc.Add("1,2,3,4,5");
		assertEquals(15,result);
	}
	
	@Test
	public void newLineAddTest() {
		StringCalculator sc = new StringCalculator();
		int result = sc.Add("1\n2,3");
		assertEquals(6,result);
	}
	
	@Test
	public void differentDelimeterAddTest() {
		StringCalculator sc = new StringCalculator();
		int result = sc.Add("//:,;\n1;2,3:5,1");
		assertEquals(12,result);
	}
	
}
